/**
 * @author LZD		2018/03/13
 */
/*
 * 
 */
package AnnotationDemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		// �������ò�ѯ����
		Filter f1 = new Filter();
		f1.setAmount(20);
		
		Filter f2 = new Filter();
		f2.setLeader("001, 002, 003");
		f2.setCity("����");
		
		Filter f3 = new Filter();
		f3.setDeptName("������");
		
		// �õ���ѯ���
		String sql1 = sqlUtil.query(f1);
		String sql2 = sqlUtil.query(f2);
		String sql3 = sqlUtil.query(f3);
		
		// ���SQL���
		System.out.println("sql1: " + sql1);
		System.out.println("sql2: " + sql2);
		System.out.println("sql3: " + sql3);
		
		System.out.println("=================================== �ָ��� @ _ @ ==========================================");
		
		// �������ò�ѯ����
		Filter2 f21 = new Filter2();
		f21.setAge(21);
		
		Filter2 f22 = new Filter2();
		f22.setUserName("sun");
		f22.setCity("�人, �ɶ�, ����, ����");
		
		Filter2 f23 = new Filter2();
		f23.setId(04151062);
		
		// �õ���ѯ���
		String sql21 = sqlUtil.query(f21);
		String sql22 = sqlUtil.query(f22);
		String sql23 = sqlUtil.query(f23);
		
		// ���SQL���
		System.out.println("sql21: " + sql21);
		System.out.println("sql22: " + sql22);
		System.out.println("sql23: " + sql23);

	}
	
}
