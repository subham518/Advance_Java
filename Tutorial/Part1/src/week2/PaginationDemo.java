package week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PaginationDemo {
    public static void main(String[] args) throws Exception  {

        int pageSize = 3;
        int pageNumber = 2;

        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);

        Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        ResultSet rs=stmt.executeQuery("select id,name from student");

        int startRow = (pageNumber -1) * pageSize + 1;

        if(rs.absolute(startRow)){
            int count = 0;
            do {
                System.out.println(
                        rs.getInt("id") + " " + rs.getString("name")
                );
                count++;
            }while (rs.next() && count< pageSize);
        }


        con.close();
    }
}