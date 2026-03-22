package week2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Statement;

public class Batchprocessing {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);

//        Statement stmt = con.createStatement();
//        stmt.addBatch("insert into emp values(4,'amit',53000)");
//        stmt.addBatch("insert into emp values(5,'ymir',98000)");
//        stmt.addBatch("insert into emp values(6,'eren',45000)");
//        stmt.addBatch("insert into emp values(7,'maki',47000)");
//        stmt.addBatch("insert into emp values(8,'light',66000)");
//        int[] results = stmt.executeBatch();
//        stmt.close();

        // using preparedStatement
        String sql = "insert into emp values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

//        ps.setInt(1,4);
//        ps.setString(2,"rahul");
//        ps.setDouble(3,400000);
//        ps.addBatch();
//        ps.setInt(1,5);
//        ps.setString(2,"ravi");
//        ps.setDouble(3,400050);
//        ps.addBatch();

          // using loop
//        for (int i = 5 ; i<= 9; i++){
//            ps.setInt(1,i);
//            ps.setString(2,"rahul");
//            ps.setDouble(3,400000 + i*20);
//            ps.addBatch();
//        }

        int[] results = ps.executeBatch();
        System.out.println("Batch Executed.");
        System.out.println("Inserted " + results.length + " rows.");

        ps.close();
        con.close();

    }
}