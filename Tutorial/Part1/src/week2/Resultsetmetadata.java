package week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Resultsetmetadata  {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from emp");

//        java.sql.ResultSetMetaData rsmd = rs.getMetaData();
        ResultSetMetaData rsmd = rs.getMetaData();

        // to get column count
        int cols = rsmd.getColumnCount();
        System.out.println("Total Columns:" + cols + "\n");

        // print column names
        for (int i = 1; i <= rsmd.getColumnCount(); i++){
            System.out.print(rsmd.getColumnName(i)+ "\n");
        }
        System.out.println("\n");

        //print full table dynamically

        // column data types
        for (int i = 1; i <= rsmd.getColumnCount(); i++){
            System.out.print(
                    rsmd.getColumnName(i) + "->" + rsmd.getColumnTypeName(i) + ".\n"
            );
        }

    }

//    private int getColumnCount() {
//    }
}