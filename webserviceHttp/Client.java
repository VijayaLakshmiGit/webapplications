package com.webserviceHttp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {

	// TODO Auto-generated method stub
	int id;
	String name;
	int age;

	private void sysout() {
		// TODO Auto-generated method stub

	}

	public Client() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "client [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
