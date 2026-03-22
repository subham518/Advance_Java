package week1;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JDBC_Select {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/subhamdb",
                    "root",
                    "local@subham123"
            );
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");
//            System.out.println(rs);
//            System.out.println(rs.next());
            while(rs.next()) {
                int eid=rs.getInt(1);
                String ename=rs.getString(2);
                double esal=rs.getDouble(3);
                System.out.println("emple id:"+eid);
                System.out.println("emple ename:"+ename);
                System.out.println("emple esal:"+esal);
                System.out.println();
            }
            con.close();
        }catch(Exception e) {
            System.out.println();
        }
    }

}