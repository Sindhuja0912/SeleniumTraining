package training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.*; 


class DBExample{  
	public static void main(String args[]){  
		try{ 





			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/test","root","");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from admin");  
			while(rs.next())  
				System.out.println(rs.getObject(1) +"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  
}  
