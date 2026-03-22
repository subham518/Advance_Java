package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Update {
	public static void main(String[] args) {
		String value;
		int eid;
		double esal;
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
			System.out.print("Enter emple id:");
			value = br.readLine();
			eid=Integer.parseInt(value);
			System.out.print("Enter emple new salary:");
			value = br.readLine();
			esal=Double.parseDouble(value);
			int count=0;
			System.out.println("Do you want to change name also? (yes/no)");
			String choice=br.readLine();

            if (choice.equalsIgnoreCase("yes")) {
                System.out.print("Enter employee new name: ");
                value = br.readLine();
                count = stmt.executeUpdate(
                        "UPDATE emple SET esal=" + esal +
                        ", ename='" + value + "' WHERE eno=" + eid
                );
            } else if (choice.equalsIgnoreCase("no")) {

                count = stmt.executeUpdate(
                        "UPDATE emple SET esal=" + esal +
                        " WHERE eno=" + eid
                );
            }
			if(count > 0) {
				System.out.println(count + "row Update Successfully");
			}else {
				System.out.println("No record found");
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}