/**
 * @author LZD		2018/01/29
 */
/*
 * statement和PreparedStatement时间效率对比
 * 使用Statement需要传入100条SQL语句，
 * 而使用PreparedStatement则只需要传入1条预编译的SQL，
 * 然后100次为该PreparedStatement的参数赋值即可
 */
package statement;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class statement {
	
	//数据库驱动
	private static final String driver = "com.mysql.jdbc.Driver";
	//链接数据库的url地址
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_first?useUnicode=true&characterEncoding=UTF-8";
	//登录的用户名及密码
	private static final String username = "root";
	private static final String password = "1219";
	
	//静态代码块加载驱动
	static {
		try {
			Class.forName(driver);
			System.out.println("已成功加载驱动");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Statement耗时
	public void insertUseStatement() throws Exception {
		long start = System.currentTimeMillis();
		try (
			//获得数据库连接
			Connection conn = (Connection) DriverManager.getConnection(url,
							username,password);
			//获得执行SQL语句对象Statement
			Statement stmt = (Statement) conn.createStatement())
		{
			for(int i = 0;i < 100;i++) {
				stmt.executeUpdate("insert into student values("
							+ "null, 'aaa" + i + "',90)" );
			}
			System.out.println("Statement费时：" + 
						(System.currentTimeMillis() - start));

			//关闭资源
			stmt.close();
			conn.close();
		}
	}
	
	//PreparedStatement耗时
	public void insertUsePrepare() throws Exception {
		long start = System.currentTimeMillis();
		try (
				//获得数据库连接
				Connection conn = (Connection) DriverManager.getConnection(url,
								username,password);
				/*
				 * 获得执行SQL语句对象Statement
				 * 使用占位符?为参数
				 */
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(
						"insert into student values(null, ?, 90)"))
		{
			for(int i = 0;i < 100;i++) {
				//设置参数
				pstmt.setString(1, "aaa" + i);
				pstmt.executeUpdate();
			}
			System.out.println("PreparedStatement费时：" + 
					(System.currentTimeMillis() - start));
			
			//关闭资源
			pstmt.close();
			conn.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		statement s = new statement();
		s.insertUseStatement();
		s.insertUsePrepare();
	}
}