package edu.ustc.highfly.Dao.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接工具类
 *
 */
public class DBUtils {
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
	
	//	防止在外部被实例化
	private DBUtils(){}
	
	static {
		Properties pro = new Properties();
		try {
			//	读取/src/MySQL.properties 文件内容
			pro.load(DBUtils.class.getResourceAsStream("/MySQL.properties"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		url = pro.getProperty("url");
		user = pro.getProperty("user");
		password = pro.getProperty("password");
		driver = pro.getProperty("driver");
//		System.out.println(driver);
		try {
			Class.forName(driver);
//			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	/**
	 * 建立数据库连接，并将连接返回
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException se) {
			se.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return conn;
	}
	
	/**
	 * 关闭连接的所有资源
	 * @param rs
	 * @param sm
	 * @param conn
	 */
	public static void close(ResultSet rs, Statement sm, Connection conn) {
		try {
			if(rs != null)			rs.close();
			if(sm != null)		sm.close();
			if(conn != null)	conn.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
