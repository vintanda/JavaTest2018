/**
 * @author LZD		2018/03/13
 */
/*
 * 又是一个Bean类，与Filter功能相同，
 * 旨在证明相同的注解可以应用于不同的类
 */
package AnnotationDemo;

@Table("User")
public class Filter2 {

	@Column("id")
	private int id;
	
	@Column("userName")
	private String userName;
	
	@Column("age")
	private int age;
	
	@Column("city")
	private String city;
	
	@Column("mobile")
	private String mobile;
	
	@Column("email")
	private String email;
	

	// getters & setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
