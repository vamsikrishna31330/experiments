package klu.JDBC;
import java.sql.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try
        {
          //1. Load the Driver
          Class.forName("com.mysql.cj.jdbc.Driver");
          //2. Connect to Database
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/S20","root","31330Vamsi@");
          //3.Create a Statement object
          Statement stmt=con.createStatement();
          //4. Sending Query to database
          String query="select * from Student";
          ResultSet rs=stmt.executeQuery(query);
          System.out.println("id" + "\t" + "Name" + "\t" +"Marks" );

          while(rs.next())
          {

            int a=rs.getInt(1);
            String b=rs.getString(2);
            int c=rs.getInt(3);     
            System.out.println(a+"\t"+b+"\t"+c + "\t");
          }   
          con.close();

        }
        catch(Exception e)
        {
          System.out.println("Exception occured");
        }
    }
}
