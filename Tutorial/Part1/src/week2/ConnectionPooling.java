package week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPooling {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";
        int maxConnections = 200; // Attempt to open 200 connections

        Class.forName("com.mysql.cj.jdbc.Driver");

        List<Connection> connections = new ArrayList<>();

        System.out.println("Attempting to open connections without closing them...");

        for (int i = 1; i <= maxConnections; i++) {
            try {
                // Open a new connection
                Connection con = DriverManager.getConnection(url, user, password);
                connections.add(con);
                System.out.println("Connection " + i + " opened successfully.");

                // CRITICAL: We are NOT closing the connection here. It remains open.

            } catch (SQLException e) {
                System.err.println("ERROR: Failed to open connection " + i);
                System.err.println("Reason: " + e.getMessage());
                System.err.println("\n**This demonstrates the need for connection pooling!**");
                break; // Stop the loop once we hit the limit
            }
        }

//         This program relies on the JVM terminating to close connections automatically.
//         In a long-running app, these connections would remain open forever.
    }
}


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        String url = "jdbc:mysql://localhost:3306/subhamdb";
//        String url1 = "jdbc:mysql://localhost:3306/testdb";
//        String user = "root";
//        String password = "local@subham123";
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        // for subhamdb
//        Connection con = DriverManager.getConnection(url, user, password);
//        Statement stmt=con.createStatement();
//        stmt.addBatch("insert into emp values(5,'amit',53000)");
//        int[] results = stmt.executeBatch();
//        System.out.println("Batch Executed.");
//        con.close();
//
//        //for testdb
//        Connection con1 = DriverManager.getConnection(url1, user, password);
//        Statement stmt1=con1.createStatement();
//        stmt1.addBatch("insert into Students (Name, Age, Grade) values ('Bobs', 18, 'B-')");
//        int[] results1 = stmt1.executeBatch();
//        System.out.println("Batch Executed.");
//        con1.close();
//
//    }
//}