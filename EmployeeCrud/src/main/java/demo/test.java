package demo;

import org.hibernate.cfg.Configuration;

import org.hibernate.*;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try 
        {
        	Configuration con = new Configuration().configure();
        	SessionFactory sf = con.buildSessionFactory();
        	Session s = sf.openSession();
        	Transaction t = s.beginTransaction();
        	Employee ob1 = new Employee();
        	ob1.setEno(101);
        	ob1.setEname("Tejesh");
        	ob1.setEsal(1000000);
        	//Saving the object  as a row in db table
        	s.persist(ob1);//s.save(ob1);
        	t.commit();
         }
        catch(Exception e) {
        	
        }
	}

}
