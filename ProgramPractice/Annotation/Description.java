/**
 * @author LZD		2018/03/12
 */
/*
 * һ��ע��@Description�Ķ���
 */
package Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// ������
@Target({ElementType.METHOD, ElementType.TYPE})
/*
 * ����ʱ��(��Ϊ���֣�SOURCE��CLASS��RUNTIME)
 * ��Ϊ��ʹ�÷������ע�⣬ֻ������ʱ�Ĳſ��Կ��õ�ע������Ľ����
 * ����������ʱ����SOURCE����CLASS����������ʱ�ڶ�Ӧ��ʧ��
 */
@Retention(RetentionPolicy.RUNTIME)
/*
 * ע��ļ̳У��и�ע��ͱ����̳е�ʱ��Ѹ����ע��Ҳ�̳й����ˣ�
 * ����֤�����̳�ֻ��̳и������ϵ�ע�⣬������̳з����ϵ�ע��
 */
@Inherited
@Documented
public @interface Description {

	String value();
}
