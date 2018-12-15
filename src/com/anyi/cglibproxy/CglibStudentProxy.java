package com.anyi.cglibproxy;

import java.lang.reflect.Method;

import com.anyi.target.Student;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibStudentProxy implements MethodInterceptor{
	//注入目标对象
	private Student student;
	public CglibStudentProxy(Student student) {
		this.student = student;
	}

	//给目标对象创建一个代理对象
	public Object getInstance() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(student.getClass());
		enhancer.setCallback(this);
		//创建子类
		Object create = enhancer.create();
		return create;
	}
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("proxy start .....");
		Object invoke = arg1.invoke(student, arg2);
		System.out.println("proxy end ...");
		return invoke;
	}

}
