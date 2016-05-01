import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Numbers {

	public static void main(String[] args) throws SQLException {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","");
			Statement stmt = conn.createStatement();
			
			String sql;
			for(int i=1;i<=100;i++){
				sql = "insert into number values(" + i + "," + i*10 + ")";
				stmt.executeUpdate(sql);
			}
			
			String sql2 = "Select * from number";
			
			ResultSet rs = stmt.executeQuery(sql2);
			
			System.out.print("Number ID\t");
			System.out.println("Number");
			while(rs.next()){
				System.out.print(rs.getInt(1) + "\t\t");
				System.out.println(rs.getInt(2));
			}
			
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
