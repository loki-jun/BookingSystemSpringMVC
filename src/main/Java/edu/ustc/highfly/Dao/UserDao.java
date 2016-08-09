package edu.ustc.highfly.Dao;

import org.springframework.stereotype.Component;

import edu.ustc.highfly.Model.User;

/**
 * 针对User对象的数据操作接口
 *
 */
@Component
public interface UserDao {
	public void add(User u);
	
	public void updateById(User u, int id);
	
	public void updateByStudentId(User u, String studentId);
	
	public void updateByName(User u, String name);
	
	public void updateByEmail(User u, String email);
	
	public void remove(User u);
	
	public User getUserById(int id);
	
	public User getUserByStudentId(String studentId);
	
	public User getUserByName(String name);
	
	public User getUserByEmail(String email);
}
