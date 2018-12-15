package com.anyi;

import org.junit.Test;

import com.anyi.cglibproxy.CglibStudentProxy;
import com.anyi.jdkproxy.ProxyFactory;
import com.anyi.staticproxy.StaticPersonProxy;
import com.anyi.target.Person;
import com.anyi.target.Student;
import com.anyi.target.impl.PersonImpl;

public class Test1 {

	@Test
	public void testStaticProxy() {
		PersonImpl personImpl = new PersonImpl();
		StaticPersonProxy staticPersonProxy = new StaticPersonProxy();
		staticPersonProxy.setPerson(personImpl);
		staticPersonProxy.print();
	}
	
	@Test
	public void testJdkPersonProxy() {
		Person personImpl = new PersonImpl();
		
		ProxyFactory proxyFactory = new ProxyFactory(personImpl);
		Person proxyInstance = (Person)proxyFactory.getProxyInstance();
		System.out.println(proxyInstance.getClass());
		
		proxyInstance.print();
		
		System.out.println("-------method2--------");
		Integer incres = proxyInstance.incres(5);
		System.out.println(incres);
	}
	
	
	@Test
	public void testCglibStudentProxy() {
		Student student = new Student();
		CglibStudentProxy proxy = new CglibStudentProxy(student);
		Student instance = (Student)proxy.getInstance();
		instance.study();
	}
}
