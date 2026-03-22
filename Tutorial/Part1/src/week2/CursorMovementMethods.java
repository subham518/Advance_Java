package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class CursorMovementMethods {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY
                    ResultSet.CONCUR_UPDATABLE
            );
            ResultSet rs=stmt.executeQuery("select * from student");

//            String createTable = "CREATE TABLE student (" +
//                    "id INT PRIMARY KEY, " +
//                    "name VARCHAR(50))";
//            stmt.executeUpdate(createTable);
//            System.out.println("Table 'student' is ready.");

//            PreparedStatement psmt = con.prepareStatement("insert into student (id, name) values (?, ?)");
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//            System.out.println("--- Enter details for 5 students ---");

//            for (int i = 1; i <= 5; i++) {
//                System.out.println("\nStudent " + i + ":");
//
//                System.out.print("Enter Student ID: ");
//                int id = Integer.parseInt(br.readLine());
//
//                System.out.print("Enter Student Name: ");
//                String name = br.readLine();
//
//                psmt.setInt(1, id);
//                psmt.setString(2, name);
//
//                psmt.executeUpdate();
//                System.out.println("Record inserted successfully.");
//            }
//            while(rs.next()) {
//                int sid=rs.getInt(1);
//                String sname=rs.getString(2);
//                System.out.println("student id:"+sid);
//                System.out.println("student name:"+sname);
//                System.out.println();
//            }
//            rs.next();

//            System.out.println("Current Row (1st): " + rs.getInt("id") + " " + rs.getString("name"));
//
//            // Move to the last row
//            rs.last();
//            System.out.println("Last Row: " + rs.getInt("id") + " " + rs.getString("name"));
//
//            // Move to a specific row number (e.g., the 3rd row)
//            if (rs.absolute(3)) {
//                System.out.println("Absolute Row 3: " + rs.getInt("id") + " " + rs.getString("name"));
//            }
//
//            // Move relative to the current position (e.g., 1 row backward from row 3)
//            if (rs.relative(-1)) {
//                System.out.println("Relative -1 (Row 2): " + rs.getInt("id") + " " + rs.getString("name"));
//            }
//
//            // Move back to the very first row using rs.first()
//            rs.first();
//            System.out.println("First Row: " + rs.getInt("id") + " " + rs.getString("name"));


//            rs.last();
//            System.out.println("student id:" + rs.getInt("id") + "\n" + "studnet name:" + rs.getString("name"));
//            System.out.println();
//
//            while(rs.previous()){
//                int sid=rs.getInt(1);
//               String sname=rs.getString(2);
//                System.out.println("student id:"+sid);
//                System.out.println("student name:"+sname);
//              System.out.println();
//            }

            // --- 1. UPDATE a Row ---
//            if (rs.first()) {
//                System.out.println("Updating first student's name to 'New Name'...");
//                rs.updateString("name", "New Name");
//                rs.updateRow();
//                System.out.println("Update successful. New name is: " + rs.getString("name"));
//            }
//
            // --- 2. DELETE a Row ---
//            // We are still on the first row after the update
//            System.out.println("Deleting the current (first) row...");
//            rs.deleteRow();
//            System.out.println("Deletion successful.");


//             --- 3. INSERT a Row ---
//            System.out.println("Inserting a new student record ");
//            rs.moveToInsertRow(); // Move cursor to a special buffer row
//            rs.updateInt("id", 1);
//            rs.updateString("name", "subham");
//            rs.insertRow(); // Insert the buffered row into the database
//            rs.moveToCurrentRow(); // Return the cursor to where it was before the insert
//            System.out.println("Insertion successful.");
//            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
