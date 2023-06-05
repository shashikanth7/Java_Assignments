package com.dal.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.dedalus.Model.MyModel;
import com.dal.util.MyDbConnection;
public class EmployeeDao {	
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	public void insertEmployee(MyModel st) {
		con =MyDbConnection.getMyconnection();
		try {	
			ps =con.prepareStatement("insert into dedaemp values(?,?)");
			ps.setInt(1, st.getE_num());
			ps.setString(2, st.getEname());
			int noofrows =ps.executeUpdate();
			System.out.println(noofrows + " got inserted into DB successfully!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public void showEmployee() {
		con =MyDbConnection.getMyconnection();
		try {
			stmt =con.createStatement();
			rs =stmt.executeQuery("select * from dedaemp");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	}
	////
	public void UpdateEmployee(MyModel st) {
		con = MyDbConnection.getMyconnection();
		try {
			System.out.println(st.getE_num()+"this from update");
		    ps = con.prepareStatement("update DEDAEMP set ename = ? where e_num = ?");
		    ps.setString(1, st.getEname());
		    ps.setInt(2, st.getE_num());
		    int noofrows = ps.executeUpdate();
		    System.out.println(noofrows + " rows updated in the DB successfully!");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
	///////
	public void DeletEmployee(MyModel st) {	
		con = MyDbConnection.getMyconnection();
		try {
			  System.out.println(st.getE_num()+"this from delet");
		    ps = con.prepareStatement("delete from DEDAEMP where e_num = ?");
		    ps.setInt(1, st.getE_num());
		    int noofrows = ps.executeUpdate();
		    System.out.println(noofrows + " rows deleted from the DB successfully!");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
	
	
	
	
}
