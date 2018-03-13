/**
 * @author LZD		2018/03/12
 */
/*
 * 一个注解@Description的定义
 */
package Annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 作用域
@Target({ElementType.METHOD, ElementType.TYPE})
/*
 * 作用时期(分为三种：SOURCE、CLASS和RUNTIME)
 * 因为是使用反射解析注解，只有运行时的才可以看得到注解解析的结果，
 * 无论是作用时期是SOURCE还是CLASS，它在运行时期都应消失了
 */
@Retention(RetentionPolicy.RUNTIME)
/*
 * 注解的继承，有该注解就表名继承的时候把父类的注解也继承过来了，
 * 案例证明，继承只会继承父类类上的注解，而不会继承方法上的注解
 */
@Inherited
@Documented
public @interface Description {

	String value();
}
