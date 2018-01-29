/**
 * @author LZD		2018/01/29
 */
/*
 * 调用存储过程
 * 使用CallableStatement对象
 * 1.获得CallableStatement对象：
 * CallableStatement cstmt = (CallableStatement) conn.prepareCall("{call addPro(?, ?, ?)}");
 * 2.传参：
 * 		输入：cstmt.setInt(1, 3);
 * 		输出：cstmt.registerOutParameter(3, Types.INTEGER);
 * 3.执行：cstmt.execute();
 * 4.获得结果getXxx(n):cstmt.getInt(3); //n是指第n个参数
 */
package callableStatement;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

public class callableStatementTest {
	
	//数据库驱动
	private static final String driver = "com.mysql.jdbc.Driver";
	//链接数据库的url地址
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_first?useUnicode=true&characterEncoding=UTF-8";
	//登录的用户名及密码
	private static final String username = "root";
	private static final String password = "1219";
	
	static {
		try {
			Class.forName(driver);
			System.out.println("已成功加载驱动");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void callProcedure() throws Exception {
		
		try {
			//创建连接
			Connection conn = (Connection) DriverManager.getConnection(url,
												username, password);
			
			//创建CallableStatement对象，get时带有调用的SQL语句
			CallableStatement cstmt = (CallableStatement) conn.prepareCall(
											"{call addPro(?, ?, ?)}");
			
			//传参
			//传入参数
			cstmt.setInt(1, 3);
			cstmt.setInt(2, 6);
			//输出参数需用registerOutParameter()进行参数类型设置
			cstmt.registerOutParameter(3, Types.INTEGER);
			
			//执行SQL语句
			cstmt.execute();
			
			System.out.println("3 + 6 = " + cstmt.getInt(3));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		callableStatementTest cstmtTest = new callableStatementTest();
		cstmtTest.callProcedure();
	}
}
