package week1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connect{

    public static void main(String[] args){

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";

        System.out.println("Attempting to connect to the database...");

        try {
            //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url,user,password);

            // create statement
            Statement stmt = connection.createStatement();

            //create table
            String sql = "create table emp(" +
                    "eno int primary key,"+
                    "ename varchar(30),"+
                    "esal double"+
                    ")";

            // this method is used to store the query given
            stmt.executeUpdate(sql);

            System.out.println("Table emp created successfully!!");

            //close the connection
            connection.close();

        }catch (SQLException | ClassNotFoundException e) {
        System.err.println("Connection failed! Check your password and ensure MySQL Server is running.");
        e.printStackTrace();
        }
    }
}