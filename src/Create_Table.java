import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Create_Table {

	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","localDB","localDB");
		Statement stmt=con.createStatement();
		int i=stmt.executeUpdate("create table student (sId number(10) , sName varchar2(30))");
		System.out.println("Created");
		con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
