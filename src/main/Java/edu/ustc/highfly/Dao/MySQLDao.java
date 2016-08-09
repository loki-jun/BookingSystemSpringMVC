package edu.ustc.highfly.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.ustc.highfly.Dao.Util.DBUtils;


/**
 * 数据库测试文件，与网站后端逻辑无关
 *
 */
public class MySQLDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Connection conn = null;
			String sql = "select * from user";
//			conn = DriverManager.getConnection(url, user, password);
			conn = DBUtils.getConnection();
//			System.out.println(conn);
			Statement s;
			try {
				s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString("name") + " " + rs.getString("password"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			String email = "yusingh@mail.ustc.edu.cn";
//			String password = "678";
//			User u = new User(email, password);
//			UserDao ud = new UserDaoImpl();
//			ud.add(u);
//			System.out.println(u);
	}

}
