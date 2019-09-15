package com.hxs.web.tools;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbHelper {
	private static Connection conn = null;
	private static ComboPooledDataSource datasource=null;
	
	static {
		
		datasource= new ComboPooledDataSource("myc3p0");
			
	}
	public static Connection getConn(){
		try {
			conn=datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return conn;
	}
	
	
	public static QueryRunner getQueryRunner(){
		 QueryRunner  queryrunner=new  QueryRunner(datasource);
		return  queryrunner;
	}

	public static void main(String[] args) {
		System.out.println(getQueryRunner() );

	}
	public static void colseConn(ResultSet result,PreparedStatement state,Connection conn)
	{
		try
		{
			if(null !=result)
			{
				result.close();
			}
			
			if(null !=state)
			{
				state.close();
			}
			if(null !=conn)
			{
				conn.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
}
