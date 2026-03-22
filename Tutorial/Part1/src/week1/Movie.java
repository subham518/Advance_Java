package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Movie {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String pass = "local@subham123";

        // Using try-with-resources to ensure auto-closing of connection
        try (Connection con = DriverManager.getConnection(url, user, pass);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement stmt = con.createStatement();

            // Mrat is now DOUBLE to support 9.8
            String sql = "CREATE TABLE IF NOT EXISTS movielist (" +
                    "Mno INT PRIMARY KEY, " +
                    "Mname VARCHAR(50), " +
                    "Mrat DOUBLE)";
            stmt.executeUpdate(sql);

            while (true) {
                System.out.println("\nMOVIE MENU:");
                System.out.println("1. Insert Movie");
                System.out.println("2. Update Movie Rating");
                System.out.println("3. Delete Movie");
                System.out.println("4. View Movies");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                String choiceStr = br.readLine();
                if (choiceStr == null) break;
                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1:
                        System.out.println("enter the movie no:");
                        int Mno = Integer.parseInt(br.readLine());

                        System.out.println("enter the movie name:");
                        String Mname = br.readLine();

                        System.out.println("enter the movie rat (e.g. 9.8):");
                        double Mrat = Double.parseDouble(br.readLine()); // Fixed for decimals

                        try (PreparedStatement psmt = con.prepareStatement("INSERT INTO movielist VALUES(?,?,?)")) {
                            psmt.setInt(1, Mno);
                            psmt.setString(2, Mname);
                            psmt.setDouble(3, Mrat); // Use setDouble
                            psmt.executeUpdate();
                            System.out.println("Insertion done!");
                        }
                        break;

                    case 2:
                        System.out.print("Enter movie no to update: ");
                        int upMno = Integer.parseInt(br.readLine());
                        System.out.print("Enter new rating: ");
                        double upMrat = Double.parseDouble(br.readLine());

                        try (PreparedStatement psUpdate = con.prepareStatement("UPDATE movielist SET Mrat=? WHERE Mno=?")) {
                            psUpdate.setDouble(1, upMrat);
                            psUpdate.setInt(2, upMno);
                            psUpdate.executeUpdate();
                            System.out.println("Movie updated successfully!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter movie no to delete: ");
                        int delMno = Integer.parseInt(br.readLine());

                        try (PreparedStatement psDelete = con.prepareStatement("DELETE FROM movielist WHERE Mno=?")) {
                            psDelete.setInt(1, delMno);
                            psDelete.executeUpdate();
                            System.out.println("Movie deleted successfully!");
                        }
                        break;

                    case 4:
                        try (ResultSet rs = stmt.executeQuery("SELECT * FROM movielist")) {
                            while (rs.next()) {
                                System.out.println("No: " + rs.getInt(1) +
                                        " | Name: " + rs.getString(2) +
                                        " | Rating: " + rs.getDouble(3));
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Closing connection and exiting...");
                        return; // try-with-resources handles con.close() automatically

                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


// TODO Auto-generated method stuff
