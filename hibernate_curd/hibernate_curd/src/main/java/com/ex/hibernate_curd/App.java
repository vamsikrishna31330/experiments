package com.ex.hibernate_curd;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Hello world!
 */
public class App {
	 public static void main(String[] args) {
	        System.out.println("Hello World!");
	        
	       
	        Configuration config = new Configuration();
	        
	        config.configure("hibernate.cfg.xml");
	        
	        SessionFactory factory = config.buildSessionFactory();
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	       Employee e =new Employee();
	        e.setId(11);
	        e.setFn("ashista");
	        e.setLn("tunga");
	        e.setBranch("CSE");
	        session.save(e);
	        tx.commit();
	        System.out.println("Record Inserted Successfully");

	        
	        
	        //Retrieve
	        
	        Employee e1 = session.find(Employee.class,1);
	        System.out.println("Record retrieved Successfully"+ " " +e1.getFn());
	        
	        
	     // update
	        Employee e2 = session.find(Employee.class,3);
	        e2.setLn("s");
	        e2.setBranch("ECE");
	        session.update(e2);
	       Transaction tnx = session.beginTransaction();
	        tnx.commit();
	       System.out.println("Record Updated Successfully");
	        
	      //delete
	        Employee e3 = session.find(Employee.class,9);
	        session.delete(e3);
	        Transaction trnx = session.beginTransaction();
	        trnx.commit();
	        System.out.println("Record Deleted Successfully");
	        
	        
// Named & Positional Parameters, Aggregate Functions, Sorting & Paging, HQL Vs HCQL
	         String hqlAsc = "FROM Employee e ORDER BY e.fn ASC"; 
	        List<Employee> employeesAsc = session.createQuery(hqlAsc, Employee.class).list(); 
	        for(Employee emp : employeesAsc)
	        { 
	          System.out.println(emp.getId() + " " + emp.getFn() + " " + emp.getLn() + " " + emp.getBranch()); 
	        }
	        
	        String hqlDesc = "FROM Employee e ORDER BY e.fn DESC"; 
	        List<Employee> employeesDesc = session.createQuery(hqlDesc, Employee.class).list(); 
	        for(Employee emp : employeesDesc)
	        { 
	          System.out.println(emp.getId() + " " + emp.getFn() + " " + emp.getLn() + " " + emp.getBranch()); 
	        }
	        
	         Query<Employee> query1 = session.createQuery("from Employee", Employee.class); 
	        query1.setFirstResult(0); // starting row (0 = first record) 
	        query1.setMaxResults(3); // number of records to fetch 
	        List<Employee> firstThree = query1.list(); 
	        System.out.println("First 3 Employees:"); for(Employee emp : firstThree) 
	        { 
	          System.out.println(emp.getId() + " " + emp.getFn() + " " + emp.getLn() + " " + emp.getBranch()); 
	        } 
	        
	        
	     // Next 3 Employees 
	        
	         Query<Employee> query2 = session.createQuery("from Employee", Employee.class); 
	        query2.setFirstResult(3); // skip first 3 records 
	        query2.setMaxResults(3); // fetch next 3 records 
	        List<Employee> nextThree = query2.list(); 
	        System.out.println("Next 3 Employees:"); 
	        for(Employee emp : nextThree) 
	        { 
	          System.out.println(emp.getId() + " " + emp.getFn() + " " + emp.getLn() + " " + emp.getBranch()); 
	        }
	        
	        Query<Long> q1 = session.createQuery("select count(e.id) from Employee e", Long.class); 
	        Long totalEmployees = q1.uniqueResult(); 
	        System.out.println("Total Employees: " + totalEmployees);
	        
	        Query<Long> q2 = session.createQuery("select count(e.id) from Employee e where e.Branch = 'ECE'", Long.class); 
	        Long eceCount = q2.uniqueResult(); 
	        System.out.println("Employees in ECE: " + eceCount);
	        
	         Query<Object[]> q3 = session.createQuery("select e.Branch, count(e.id) from Employee e group by e.Branch", Object[].class); 
	        List<Object[]> results = q3.list(); 
	        System.out.println("Employee count grouped by Branch:"); 
	        for(Object[] row : results) 
	        { 
	          System.out.println("Branch: " + row[0] + " | Count: " + row[1]); 
	        }
	        
	        
	        Query<Object[]> q4 = session.createQuery("select min(e.id), max(e.id) from Employee e", Object[].class); 
	        Object[] minMax = q4.uniqueResult(); System.out.println("Minimum EmpId: " + minMax[0]); 
	        System.out.println("Maximum EmpId: " + minMax[1]);
	        session.close();
	        
	        // HQL query using GROUP BY
	       Query<Object[]> q7 = session.createQuery("select e.Branch, count(e.id) from Employee e group by e.Branch", Object[].class); 
	        List<Object[]> result1 = q7.list(); 
	        System.out.println("Employee count grouped by Branch:"); 
	        for(Object[] row : result1) 
	        { 
	          System.out.println("Branch: " + row[0] + " | Count: " + row[1]); 
	        }
	        
	        // HQL query using WHERE to filter employee within a name range
	        Query<Employee> q8 = session.createQuery( "from Employee e where e.ln between 's' and 'v'", Employee.class ); 
	        List<Employee> empl = q8.list(); 
	        System.out.println("Employees with ln between s and v:"); 
	        for(Employee emp : empl) 
	        { 
	          System.out.println(emp.getId() + " " + emp.getFn() + " " + emp.getLn() + " " + emp.getBranch()); 
	        }
	       // HQL queries using LIKE
	        Query<Employee> q9a = session.createQuery( "from Employee e where e.fn like 's%'", Employee.class ); 
	        List<Employee> results1 = q9a.list(); 
	        System.out.println("Employees with fn starting with 'S':"); 
	        for(Employee emp : results1) 
	        { 
	          System.out.println(emp.getId() + " " + emp.getFn()); 
	        }
	        
	        Query<Employee> q9b = session.createQuery( "from Employee e where e.fn like '%a'", Employee.class ); 
	        List<Employee> result2 = q9b.list(); 
	        System.out.println("Employees with fn ending with 'a':"); 
	        for(Employee emp : result2) 
	        { 
	          System.out.println(emp.getId() + " " + emp.getFn()); 
	        }
	        
	 }       
}
