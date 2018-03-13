package AnnotationDemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 定义一个工具类
public class sqlUtil {
	
	// 得到查询语句(传入Object类型使query方法适合更多类型对象的注解解析)
	public static String query(Object f) {
		
		StringBuilder builder = new StringBuilder();
		
		// 1. 获取类类型
		Class c = f.getClass();
		
		/*
		 *  2. 是否存在Table注解，如果不存在就返回null，如果存在就获得注解的值(当前案例下是表名)
		 *  isAnnotationPresent(类<? extends Annotation> annotationClass)
		 *  	如果此元素上 存在指定类型的注释，则返回true，否则返回false。 (API)
		 */
		// 2.1 判断是否存在想要的注解
		boolean fIsExist = c.isAnnotationPresent(Table.class);
		if(!fIsExist) {
			return null;
		}
		
		// 2.2 获取表的名字
		// 先要获取表的对象
		Table t = (Table) c.getAnnotation(Table.class);
		// 然后通过该对象获取表的名字(值)
		String tableName = t.value();
		
		// 3.第一次SQL语句拼接：拼接表名
		builder.append("SELECT * FROM ").append(tableName).append(" WHERE 1 = 1");
		
		// 4.遍历所有字段的值
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			// 4.1 拿到字段名和值
			boolean fieldIsExist = field.isAnnotationPresent(Column.class);
			if(!fieldIsExist) {
				continue;
			}
			// 4.1.1 获取Column对象，通过getAnnotation获取
			Column column = field.getAnnotation(Column.class);
			// 4.1.2 获取字段名，通过Column对象获取
			String conlumnName = column.value();
			// 4.1.3 获取对应的值
			// field.getName()获取的是Field字段的名称
			String fieldName = field.getName();
			
			// 拼接出方法
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase()
								+ fieldName.substring(1);
			
			// 使用getMethod调用获取方法Method对象
			Method method;
			Object fieldValue = null;
			try {
				method = c.getMethod(getMethodName);
				// 获取字段的值
				fieldValue = method.invoke(f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 5.第二次拼接，拼接查询条件
			
			if(fieldValue instanceof Integer && fieldValue.equals(0)) {
				continue;
			} else if(fieldValue instanceof Integer) {
				builder.append(" AND ").append(conlumnName).append(" = ").append(fieldValue);
			} else if(fieldValue instanceof String) {
				// column是String类型的情况，需要在值的两侧 + 单引号
				// column是包含多个值时，应该使用in进行查询，需要将值split然后遍历每个值
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
