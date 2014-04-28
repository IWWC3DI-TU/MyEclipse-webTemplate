package com.gmcc.autotest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
public class DbManager {
	private static Logger Log = Logger.getLogger(Class.class.getName());
    public static Connection getConnection() {
            DbSet.init();
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection con=null;
			try {
				con = pool.getConnection();
			} catch (SQLException e) {
				Log.info(e.getMessage());
			}
            return con;
    }
    
    public static void main(String args[])
    {
    	Connection connection = DbManager.getConnection();
    	
    	String sql = "select * from test";//sql语句
    	
    	try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
		} 
    	
//    	Connection conn=DbManager.getConnection();
//    	String sql="select * from  user";
//    	try
//    	{
//    	PreparedStatement ps=conn.prepareStatement(sql);
//    	ResultSet rs=ps.executeQuery();
//    	while(rs.next())
//    	{
//    		System.out.println(rs.getString("username"));
//    	}
//    	}catch(Exception e)
//    	{
//    		Log.info(e.getMessage());
//    	}
    	
    	
//		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=aTest";
//		
//		String userName = "sa";
//		String userPwd = "3dlab@tju";
//		Connection dbConn;
//		
//		try {
//			Class.forName(driverName);
//			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
//			System.out.println("Connection Successful!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

    }
}