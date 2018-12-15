package com.anyi.target.impl;

import com.anyi.target.Person;

public class PersonImpl implements Person {

	@Override
	public void print() {
		System.out.println("xuanyi nice");
	}

	@Override
	public Integer incres(int i) {
		i++;
		return i;
	}

}
