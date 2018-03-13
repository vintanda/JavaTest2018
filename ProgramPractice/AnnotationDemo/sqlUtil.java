package AnnotationDemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// ����һ��������
public class sqlUtil {
	
	// �õ���ѯ���(����Object����ʹquery�����ʺϸ������Ͷ����ע�����)
	public static String query(Object f) {
		
		StringBuilder builder = new StringBuilder();
		
		// 1. ��ȡ������
		Class c = f.getClass();
		
		/*
		 *  2. �Ƿ����Tableע�⣬��������ھͷ���null��������ھͻ��ע���ֵ(��ǰ�������Ǳ���)
		 *  isAnnotationPresent(��<? extends Annotation> annotationClass)
		 *  	�����Ԫ���� ����ָ�����͵�ע�ͣ��򷵻�true�����򷵻�false�� (API)
		 */
		// 2.1 �ж��Ƿ������Ҫ��ע��
		boolean fIsExist = c.isAnnotationPresent(Table.class);
		if(!fIsExist) {
			return null;
		}
		
		// 2.2 ��ȡ�������
		// ��Ҫ��ȡ��Ķ���
		Table t = (Table) c.getAnnotation(Table.class);
		// Ȼ��ͨ���ö����ȡ�������(ֵ)
		String tableName = t.value();
		
		// 3.��һ��SQL���ƴ�ӣ�ƴ�ӱ���
		builder.append("SELECT * FROM ").append(tableName).append(" WHERE 1 = 1");
		
		// 4.���������ֶε�ֵ
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			// 4.1 �õ��ֶ�����ֵ
			boolean fieldIsExist = field.isAnnotationPresent(Column.class);
			if(!fieldIsExist) {
				continue;
			}
			// 4.1.1 ��ȡColumn����ͨ��getAnnotation��ȡ
			Column column = field.getAnnotation(Column.class);
			// 4.1.2 ��ȡ�ֶ�����ͨ��Column�����ȡ
			String conlumnName = column.value();
			// 4.1.3 ��ȡ��Ӧ��ֵ
			// field.getName()��ȡ����Field�ֶε�����
			String fieldName = field.getName();
			
			// ƴ�ӳ�����
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase()
								+ fieldName.substring(1);
			
			// ʹ��getMethod���û�ȡ����Method����
			Method method;
			Object fieldValue = null;
			try {
				method = c.getMethod(getMethodName);
				// ��ȡ�ֶε�ֵ
				fieldValue = method.invoke(f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 5.�ڶ���ƴ�ӣ�ƴ�Ӳ�ѯ����
			
			if(fieldValue instanceof Integer && fieldValue.equals(0)) {
				continue;
			} else if(fieldValue instanceof Integer) {
				builder.append(" AND ").append(conlumnName).append(" = ").append(fieldValue);
			} else if(fieldValue instanceof String) {
				// column��String���͵��������Ҫ��ֵ������ + ������
				// column�ǰ������ֵʱ��Ӧ��ʹ��in���в�ѯ����Ҫ��ֵsplitȻ�����ÿ��ֵ
				if(((String) fieldValue).contains(",")) {
					String[] values = ((String) fieldValue).split(",");
					builder.append(" AND ").append(conlumnName).append(" IN(");
					for (String string : values) {
						builder.append("'").append(string).append("'").append(",");
					}
					builder.deleteCharAt(builder.length()-1);
					builder.append(")");
				} else {
					builder.append(" AND ").append(conlumnName).append(" = ")
									.append("'").append(fieldValue).append("'");
				}
			}
		}
		
		return builder.toString();
	}
}
