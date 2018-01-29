/**
 * @author LZD		2018/01/29
 */
/*
 * ���ô洢����
 * ʹ��CallableStatement����
 * 1.���CallableStatement����
 * CallableStatement cstmt = (CallableStatement) conn.prepareCall("{call addPro(?, ?, ?)}");
 * 2.���Σ�
 * 		���룺cstmt.setInt(1, 3);
 * 		�����cstmt.registerOutParameter(3, Types.INTEGER);
 * 3.ִ�У�cstmt.execute();
 * 4.��ý��getXxx(n):cstmt.getInt(3); //n��ָ��n������
 */
package callableStatement;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

public class callableStatementTest {
	
	//���ݿ�����
	private static final String driver = "com.mysql.jdbc.Driver";
	//�������ݿ��url��ַ
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_first?useUnicode=true&characterEncoding=UTF-8";
	//��¼���û���������
	private static final String username = "root";
	private static final String password = "1219";
	
	static {
		try {
			Class.forName(driver);
			System.out.println("�ѳɹ���������");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void callProcedure() throws Exception {
		
		try {
			//��������
			Connection conn = (Connection) DriverManager.getConnection(url,
												username, password);
			
			//����CallableStatement����getʱ���е��õ�SQL���
			CallableStatement cstmt = (CallableStatement) conn.prepareCall(
											"{call addPro(?, ?, ?)}");
			
			//����
			//�������
			cstmt.setInt(1, 3);
			cstmt.setInt(2, 6);
			//�����������registerOutParameter()���в�����������
			cstmt.registerOutParameter(3, Types.INTEGER);
			
			//ִ��SQL���
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
