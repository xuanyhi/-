package com.anyi.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.anyi.target.Person;

public class ProxyFactory {
	private Person person;
	public ProxyFactory(Person person) {
		this.person = person;
	}
	
	public Object getProxyInstance() {
		Object newProxyInstance = Proxy.newProxyInstance(person.getClass().getClassLoader(), 
				person.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("proxy start。。。");
						
						Object invoke = method.invoke(person, args);
						System.out.println("proxy end ...");
						if(invoke==null) {
							System.out.println("return :null");
						}else {
							System.out.println("return :"+invoke.toString());
						}
						return invoke;
					}
				});
		return newProxyInstance;
	}
}
