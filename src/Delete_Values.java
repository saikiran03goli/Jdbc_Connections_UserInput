import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete_Values {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Values");
		int id=sc.nextInt();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","localDB","localDB");
			PreparedStatement stmt=con.prepareStatement("delete from student where sId=?");
			stmt.setInt(1, id);
			int i=stmt.executeUpdate();
			System.out.println("Deleted");
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
