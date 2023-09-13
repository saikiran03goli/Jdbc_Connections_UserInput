import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Select_Values {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Value");
		int id=sc.nextInt();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","localDB","localDB");
			PreparedStatement stmt=con.prepareStatement("select sName from student where sId=?");
			stmt.setInt(1,id);
			ResultSet i=stmt.executeQuery();
			while(i.next()) {
				String name=i.getString("sName");
				System.out.println(name);
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
