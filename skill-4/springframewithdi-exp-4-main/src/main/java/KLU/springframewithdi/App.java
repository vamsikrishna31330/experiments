package KLU.springframewithdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	Employee empbean=context .getBean("emp",Employee.class);
    	empbean.display();
    	System.out.println(empbean);
    	System.out.println(empbean.getId());
    	System.out.println(empbean.getName());

    	//Employee obj = new Employee();
    	//obj.display();
    	
    	
        System.out.println("Hello World!");
    }
}
