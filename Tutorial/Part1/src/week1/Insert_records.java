package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_records {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url,user,password);

            PreparedStatement psmt = con.prepareStatement("insert into emp values (?, ?, ?)");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true){

                System.out.println("Enter Emp No:");
                int eno = Integer.parseInt(br.readLine());

                System.out.println("Enter Emp Name:");
                String name = br.readLine();

                System.out.println("Enter Emp Salary:");
                double sal = Double.parseDouble(br.readLine());

                psmt.setInt(1,eno);
                psmt.setString(2,name);
                psmt.setDouble(3,sal);

                int count = psmt.executeUpdate();

                System.out.println(count + "Record Inserted Successfully");

                System.out.print("Do you wnat to insert more records? (y/n): ");
                String choice = br.readLine();

                if (choice.equalsIgnoreCase("n")){
                    break;
                }
            }

            con.close();

        } catch (ClassNotFoundException | SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}