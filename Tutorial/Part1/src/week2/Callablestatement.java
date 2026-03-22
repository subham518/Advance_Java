package week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.Types;

public class Callablestatement {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);

        // Befor executing make the procedures in server level(cmd).
        //in parameter
//        CallableStatement cs =  con.prepareCall("{call addEmployee(?,?,?)}");
//        cs.setInt(1,105);
//        cs.setString(2,"josh");
//        cs.setDouble(3,45999);
//        cs.execute();
//        System.out.println("Employee added.");

        //out parameter
//        CallableStatement cs =  con.prepareCall("{call getEmployee(?,?)}");
//        cs.setInt(1,105);
//        cs.registerOutParameter(2, Types.DOUBLE);
//        cs.execute();
//        double salary = cs.getDouble(2);
//        System.out.println("Salary is:"+ salary);

        //in-out parameter
        CallableStatement cs = con.prepareCall("{call updateSalary(?,?)}");
        cs.setInt(1,105);
        cs.setDouble(2,79999);
        cs.registerOutParameter(2,Types.DOUBLE);
        cs.execute();
        System.out.println("Updated Salary: "+ cs.getDouble(2));
        con.close();
    }
}