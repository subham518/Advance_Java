package week1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Delete {
    public static void main(String[] args) {
        String value;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver load");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/subhamdb",
                    "root",
                    "local@subham123"
            );
            Statement stmt=con.createStatement();
            BufferedReader br=new BufferedReader(
                    new InputStreamReader(System.in));

            while (true) {
                System.out.println("Enter deletion emple id:");
                value = br.readLine();
                int eno=Integer.parseInt(value);
                int count=stmt.executeUpdate(
                        "delete from emple where eno=" +eno);
                if(count ==1) {
                    System.out.println(count + "row delete");
                }else {
                    System.out.println("No record delete");
                }
                System.out.println("Do you want to delete more record? (yes/no)");
                String choice=br.readLine();
                if (choice.equalsIgnoreCase("no")) {
                    break;
                }
            }
            con.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}