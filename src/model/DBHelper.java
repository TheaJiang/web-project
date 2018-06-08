package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	private Connection conn;
	private Statement stmt;
	
	private static final String driverName="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306";
//	private static final String sDropDB="drop database if exists userdb";
//	private static final String sCreateDB="create database userdb if not exists";
	private static final String sUseDB="use userdb";
//	private static final String sDropTb="drop table if exists user";
//	private static final String sCreateTb="create table user (account varchar(20),password varchar(20))";
//	private static final String sInsert="insert into user values('admin','123456')";
	
	public DBHelper(){
		try{
			Class.forName(driverName);
			conn=DriverManager.getConnection(url, "root", "root");
			
			stmt=conn.createStatement();
			stmt.execute(sUseDB);
			
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}
	
	public Boolean Query(User user) throws SQLException{
		ResultSet rs=null;
		rs=stmt.executeQuery("select * from user where account='"+user.getAccount()+"' and password='"+user.getPassword()+"'");
		return rs.next();
	}

}
