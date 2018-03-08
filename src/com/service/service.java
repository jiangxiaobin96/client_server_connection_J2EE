package com.service;

import java.sql.ResultSet;

import com.db.DBManager;

public class service {
	
	public String serviceList(){
		//ArrayList<String> comList = new ArrayList<>();
		String com = "";
		String sqll = "select name,password from a";
		DBManager sql = DBManager.createInstance();
		sql.connectDB();
		
		try{
			ResultSet rs = sql.executeQuery(sqll);
			while (rs.next()) {
				String comm = rs.getString("name");
				System.out.println(comm);
				com = com + comm + ";";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		sql.closeDB();
		return com;
	}
}
