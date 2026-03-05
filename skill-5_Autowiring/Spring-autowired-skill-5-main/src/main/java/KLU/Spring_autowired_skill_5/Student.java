package KLU.Spring_autowired_skill_5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 1330;
    private String name = "vamsi";
    private String gender = "male";

    @Autowired
    private Course course;

    public void display() {
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("Gender       : " + gender);
        System.out.println("Course       : " + course);
    }
}