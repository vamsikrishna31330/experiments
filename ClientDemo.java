package com.klef.fsad.exam;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.Date;

public class ClientDemo {
  public static void main(String[] args) {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    // Insert
    Session s1 = factory.openSession();
    s1.beginTransaction();
    Course c = new Course();
    c.setName("Java");
    c.setDescription("Core Java");
    c.setDate(new Date());
    c.setStatus("Active");
    s1.save(c);
    s1.getTransaction().commit();
    s1.close();
    System.out.println("Inserted ID: " + c.getId());

    // View
    Session s2 = factory.openSession();
    Course found = s2.get(Course.class, c.getId());
    System.out.println("Found: " + found);
    s2.close();

    factory.close();
  }
}
