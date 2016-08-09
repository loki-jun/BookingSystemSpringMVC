package edu.ustc.highfly.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import edu.ustc.highfly.Dao.Util.DBUtils;
import edu.ustc.highfly.Model.User;
import edu.ustc.highfly.Dao.UserDao;

/**
 * 对UserDao接口的实现，包括了对数据的增删改查操作
 *
 */
@Component
public class UserDaoImpl implements UserDao {

	@Override
	/**
	 * 将用户对象添加到数据库中
	 * @param u 要添加的用户对象
	 */
	public void add(User u) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into user(student_id, name, password, email, gender, age, personal_credit, profile)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getStudent_id());
			ps.setString(2, u.getName());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getGender());
			ps.setInt(6, u.getAge());
			ps.setInt(7, u.getPersonal_credit());
			ps.setString(8, u.getProfile());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("注册失败");
		}finally {
			DBUtils.close(null, ps, conn);
		}
	}

	@Override
	public void updateByEmail(User u, String email) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update user " + "set student_id = ?, name = ?, password = ?, gender = ?, age = ?, personal_credit = ?, profile = ? "
				+ "where email = ?;";
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getStudent_id());
			ps.setString(2, u.getName());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getGender());
			ps.setInt(5, u.getAge());
			ps.setInt(6, u.getPersonal_credit());
			ps.setString(7, u.getProfile());
			ps.setString(8, email);
//			System.out.println(ps);
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("更新失败");
		}finally {
			DBUtils.close(null, ps, conn);
		}
	}
	
	@Override
	public void updateById(User u, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByStudentId(User u, String studentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByName(User u, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * 通过给定的ID得到用户信息，返回结果打包为一个User对象
	 * @param 	id 给定的ID
	 */
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		String sql = "select student_id, name, password, email, gender, age, personal_credit, profile from user where id=?;";
		
		try {
			conn = DBUtils.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        if(rs.next()){
	            u = new User();
	            u.setStudentId(rs.getString(1));
	            u.setName(rs.getString(2));
	            u.setPassword(rs.getString(3));
	            u.setEmail(rs.getString(4));
	            u.setGender(rs.getString(5));
	            u.setAge(rs.getInt(6));
	            u.setPersonal_credit(rs.getInt(7));
	            u.setProfile(rs.getString(8));
	        }
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("查询数据库失败");
			}finally {
				DBUtils.close(rs, ps, conn);
			}
			
	        return u;
	}

	@Override
	/**
	 * 通过给定的学号得到用户信息，返回结果打包为一个User对象
	 * @param 	studentId 给定的学号
	 */
	public User getUserByStudentId(String studentId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		String sql = "select student_id, name, password, email, gender, age, personal_credit, profile from user where student_id=?;";
		
		try {
			conn = DBUtils.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, studentId);
	        rs = ps.executeQuery();
	        if(rs.next()){
	            u = new User();
	            u.setStudentId(rs.getString(1));
	            u.setName(rs.getString(2));
	            u.setPassword(rs.getString(3));
	            u.setEmail(rs.getString(4));
	            u.setGender(rs.getString(5));
	            u.setAge(rs.getInt(6));
	            u.setPersonal_credit(rs.getInt(7));
	            u.setProfile(rs.getString(8));
	        }
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("查询数据库失败");
			}finally {
				DBUtils.close(rs, ps, conn);
			}
			
	        return u;
	}

	@Override
	/**
	 * 通过给定的用户名得到用户信息，返回结果打包为一个User对象
	 * @param 	name 给定的用户名
	 */
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		String sql = "select student_id, name, password, email, gender, age, personal_credit, profile from user where name=?;";
		
		try {
			conn = DBUtils.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, name);
	        rs = ps.executeQuery();
	        if(rs.next()){
	            u = new User();
	            u.setStudentId(rs.getString(1));
	            u.setName(rs.getString(2));
	            u.setPassword(rs.getString(3));
	            u.setEmail(rs.getString(4));
	            u.setGender(rs.getString(5));
	            u.setAge(rs.getInt(6));
	            u.setPersonal_credit(rs.getInt(7));
	            u.setProfile(rs.getString(8));
	        }
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("查询数据库失败");
			}finally {
				DBUtils.close(rs, ps, conn);
			}
			
	        return u;
	}

	@Override
	/**
	 * 通过给定的邮箱得到用户信息，返回结果打包为一个User对象
	 * @param 	email 给定的邮箱
	 */
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		String sql = "select student_id, name, password, email, gender, age, personal_credit, profile from user where email=?;";
		
		try {
		conn = DBUtils.getConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1, email);
        rs = ps.executeQuery();
        if(rs.next()){
            u = new User();
            u.setStudentId(rs.getString(1));
            u.setName(rs.getString(2));
            u.setPassword(rs.getString(3));
            u.setEmail(rs.getString(4));
            u.setGender(rs.getString(5));
            u.setAge(rs.getInt(6));
            u.setPersonal_credit(rs.getInt(7));
            u.setProfile(rs.getString(8));
        }
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("查询数据库失败");
		}finally {
			DBUtils.close(rs, ps, conn);
		}
		
        return u;
	}

	
	
}
