/**
 * @author LZD		2018/03/13
 */
/*
 * 一个Bean类，将类和字段使用注解获取实例对象的信息并使用Test类将信息组织成SQL查询语句
 */
package AnnotationDemo;

@Table("department")
public class Filter {

	@Column("id")
	private int id;
	
	@Column("deptName")
	private String deptName;
	
	@Column("leader")
	private String leader;
	
	@Column("amount")
	private int amount;
	
	@Column("city")
	private String city;
	
	@Column("email")
	private String email;
	
	@Column("mobile")
	private String mobile;
	
	
	// getters & setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
