package edu.ustc.highfly.Model;

/**
 * 用户对象，用于保存在server端的用户信息
 *
 */
public class User {
	
	private String studentId;
	private String name;
	private String password;
	private String email;
	private String gender;
	private int age;
	private int personal_credit;
	private String profile;
	
	public User() {}
	
	public User(String email, String password) {
		this.studentId = null;
		this.name = null;
		this.password = password;
		this.email = email;
		this.gender = null;
		this.age = 0;
		this.personal_credit = 5;
		this.profile = "USTCer";
	}
	
	
	public String getStudent_id() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPersonal_credit() {
		return personal_credit;
	}
	public void setPersonal_credit(int personal_credit) {
		this.personal_credit = personal_credit;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		return "User [student_id=" + studentId + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", gender=" + gender + ", age=" + age + ", personal_credit=" + personal_credit + ", profile="
				+ profile + "]";
	}
}
