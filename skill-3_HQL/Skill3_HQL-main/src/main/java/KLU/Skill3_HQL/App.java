package KLU.Skill3_HQL;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        /* ================= INSERT ================= *//*
        Transaction tx = session.beginTransaction();

        Product p = new Product();
        p.setId(111);
        p.setName("Laptop");
        p.setCategory("Electronics");
        p.setPrice(55000);
        p.setQuantity(10);

        session.save(p);
        tx.commit();
        System.out.println("Product Inserted Successfully");

        /* ================= RETRIEVE ================= */
        Product p1 = session.find(Product.class, 101);
        System.out.println("Retrieved Product: " + p1.getName());

       
        Transaction tx2 = session.beginTransaction();
        Product p2 = session.find(Product.class, 101);
        p2.setPrice(52000);
        p2.setQuantity(12);
        session.update(p2);
        tx2.commit();
        System.out.println("Product Updated Successfully");

      
        Transaction tx3 = session.beginTransaction();
        Product p3 = session.find(Product.class, 105);
        if (p3 != null) {
            session.delete(p3);
        }
        tx3.commit();
        System.out.println("Product Deleted Successfully");

      
        String hqlAsc = "FROM Product p ORDER BY p.name ASC";
        List<Product> productsAsc = session.createQuery(hqlAsc, Product.class).list();
        for (Product pr : productsAsc) {
            System.out.println(pr.getId() + " " + pr.getName());
        }

        String hqlDesc = "FROM Product p ORDER BY p.name DESC";
        List<Product> productsDesc = session.createQuery(hqlDesc, Product.class).list();
        for (Product pr : productsDesc) {
            System.out.println(pr.getId() + " " + pr.getName());
        }

    
        Query<Product> q1 = session.createQuery("from Product", Product.class);
        q1.setFirstResult(0);
        q1.setMaxResults(3);
        List<Product> firstThree = q1.list();
        System.out.println("First 3 Products:");
        for (Product pr : firstThree) {
            System.out.println(pr.getName());
        }

        Query<Product> q2 = session.createQuery("from Product", Product.class);
        q2.setFirstResult(3);
        q2.setMaxResults(3);
        List<Product> nextThree = q2.list();
        System.out.println("Next 3 Products:");
        for (Product pr : nextThree) {
            System.out.println(pr.getName());
        }

       
        Query<Long> totalQuery =
                session.createQuery("select count(p.id) from Product p", Long.class);
        System.out.println("Total Products: " + totalQuery.uniqueResult());

        Query<Object[]> groupQuery =
                session.createQuery("select p.category, count(p.id) from Product p group by p.category",
                        Object[].class);
        List<Object[]> results = groupQuery.list();
        for (Object[] row : results) {
            System.out.println("Category: " + row[0] + " Count: " + row[1]);
        }

        Query<Object[]> minMaxQuery =
                session.createQuery("select min(p.price), max(p.price) from Product p", Object[].class);
        Object[] minMax = minMaxQuery.uniqueResult();
        System.out.println("Min Price: " + minMax[0]);
        System.out.println("Max Price: " + minMax[1]);

     
        Query<Product> likeQuery =
                session.createQuery("from Product p where p.name like 'L%'", Product.class);
        List<Product> likeResults = likeQuery.list();
        for (Product pr : likeResults) {
            System.out.println("Product starting with L: " + pr.getName());
        }

        session.close();
        factory.close();
    }
}
