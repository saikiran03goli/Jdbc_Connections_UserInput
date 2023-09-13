import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update_Values {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Values");
		int id=sc.nextInt();
		String name=sc.next();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","localDb","localDb");
			PreparedStatement stmt=con.prepareStatement("update  student set sName=? where sId=?");
			stmt.setString(1,name);
			stmt.setInt(2,id);
			int i=stmt.executeUpdate();
			System.out.println("Updated");
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
