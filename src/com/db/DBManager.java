package com.db;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;

public class DBManager {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	
	static final String USER = "root";
	static final String PASS = "123456";
	
	private static DBManager per = null;
	private Connection con = null;
	private Statement stmt = null;
	
	private DBManager(){
		
	}
	
	public static DBManager createInstance(){
		if(per == null){
			per = new DBManager();
			per.initDB();
		}
		return per;
	}
	
	public void initDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void connectDB(){
		System.out.println("connection");
		try{
			con = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = (Statement) con.createStatement();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//System.out.println("");
	}
	
	public void closeDB() {
        System.out.println("Close connection to database..");
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Close connection successful");
    }
	
	public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}
