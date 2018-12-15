package com.anyi.staticproxy;

import com.anyi.target.Person;

public class StaticPersonProxy implements Person {

	//注入目标对象
	private Person person;
	public void setPerson(Person person) {
		this.person =person;
	}
	
	
	@Override
	public void print() {
		System.out.println("proxy start ...");
		person.print();
		System.out.println("proxy end ....");

	}


	@Override
	public Integer incres(int i) {
		return person.incres(i);
	}

}
