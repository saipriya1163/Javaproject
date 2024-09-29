package classes;

import interfaces.I_Person;

public class Person implements I_Person {
	String name;
	int age;
	String address;
	public Person(String name,int age,String address) {
		this.name=name;
		this.age=age;
		this.address=address;
	}
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
		
	}
}

