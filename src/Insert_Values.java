import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert_Values {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Values");
		int sId=sc.nextInt();
		String sName=sc.next();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","localdb","localDB");
			PreparedStatement stmt=con.prepareStatement("Insert into student values(?,?)");
			stmt.setInt(1,sId);
			stmt.setString(2,sName);
			int i=stmt.executeUpdate();
			System.out.println("Values Inserted");
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
