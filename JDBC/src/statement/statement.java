/**
 * @author LZD		2018/01/29
 */
/*
 * statement��PreparedStatementʱ��Ч�ʶԱ�
 * ʹ��Statement��Ҫ����100��SQL��䣬
 * ��ʹ��PreparedStatement��ֻ��Ҫ����1��Ԥ�����SQL��
 * Ȼ��100��Ϊ��PreparedStatement�Ĳ�����ֵ����
 */
package statement;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class statement {
	
	//���ݿ�����
	private static final String driver = "com.mysql.jdbc.Driver";
	//�������ݿ��url��ַ
	private static final String url = "jdbc:mysql://localhost:3306/jdbc_first?useUnicode=true&characterEncoding=UTF-8";
	//��¼���û���������
	private static final String username = "root";
	private static final String password = "1219";
	
	//��̬������������
	static {
		try {
			Class.forName(driver);
			System.out.println("�ѳɹ���������");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Statement��ʱ
	public void insertUseStatement() throws Exception {
		long start = System.currentTimeMillis();
		try (
			//������ݿ�����
			Connection conn = (Connection) DriverManager.getConnection(url,
							username,password);
			//���ִ��SQL������Statement
			Statement stmt = (Statement) conn.createStatement())
		{
			for(int i = 0;i < 100;i++) {
				stmt.executeUpdate("insert into student values("
							+ "null, 'aaa" + i + "',90)" );
			}
			System.out.println("Statement��ʱ��" + 
						(System.currentTimeMillis() - start));

			//�ر���Դ
			stmt.close();
			conn.close();
		}
	}
	
	//PreparedStatement��ʱ
	public void insertUsePrepare() throws Exception {
		long start = System.currentTimeMillis();
		try (
				//������ݿ�����
				Connection conn = (Connection) DriverManager.getConnection(url,
								username,password);
				/*
				 * ���ִ��SQL������Statement
				 * ʹ��ռλ��?Ϊ����
				 */
				PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(
						"insert into student values(null, ?, 90)"))
		{
			for(int i = 0;i < 100;i++) {
				//���ò���
				pstmt.setString(1, "aaa" + i);
				pstmt.executeUpdate();
			}
			System.out.println("PreparedStatement��ʱ��" + 
					(System.currentTimeMillis() - start));
			
			//�ر���Դ
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