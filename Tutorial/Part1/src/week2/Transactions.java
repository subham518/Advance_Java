package week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Transactions {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            con.setAutoCommit(false);

            String sql = "insert into emp values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 4);
            ps.setString(2, "rahul");
            ps.setDouble(3, 400000);
            ps.addBatch();

            ps.setInt(1, 5);
            ps.setString(2, "ravi");
            ps.setDouble(3, 400050);
            ps.addBatch();

            int[] results = ps.executeBatch();
            System.out.println("Batch Executed.");
            System.out.println("Inserted " + results.length + " rows.");

            con.setAutoCommit(true);

            ps.close();
            con.close();
        } catch (Exception e){
            try{
                System.out.println("Error occoured, rolling back!!");
                Connection con = DriverManager.getConnection(url, user, password);

                con.rollback();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}