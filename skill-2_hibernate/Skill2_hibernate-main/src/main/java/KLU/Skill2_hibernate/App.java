package KLU.Skill2_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        // ================= INSERT =================
        Transaction tx = session.beginTransaction();

        Product p = new Product();
        p.setId(161);
        p.setName("tab");
        p.setDescription("laptop hp");
        p.setPrice(50000);
        p.setQuantity(5);

        session.persist(p);
        tx.commit();
        System.out.println("Product Inserted Successfully");

        // ================= RETRIEVE =================
       /*session.beginTransaction();
        Product p1 = session.find(Product.class, 111);
        System.out.println("Product Retrieved Successfully : " + p1.getName());
        session.getTransaction().commit();

        // ================= UPDATE =================
        Transaction tnx = session.beginTransaction();
        Product p2 = session.find(Product.class, 111);
        p2.setPrice(80000);
        p2.setQuantity(8);
        tnx.commit();
        System.out.println("Product Updated Successfully");

        // ================= DELETE =================
        /*Transaction trnx = session.beginTransaction();
        Product p3 = session.find(Product.class, 111);
        session.delete(p3);
        trnx.commit();
        System.out.println("Product Deleted Successfully");

        session.close();
        factory.close();*/
    }
}
