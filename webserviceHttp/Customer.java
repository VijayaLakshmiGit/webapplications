package com.webserviceHttp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CUSTOMER")
@XmlType(propOrder = { "id", "firstname", "lastname", "street", "city" })
public class Customer {
	int id;
	String firstname;
	String lastname;
	String street;
	String city;

	public Customer() {
		super();
	}

	public int getId() {
		return id;
	}

	@XmlElement(name = "ID")
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	@XmlElement(name = "FIRSTNAME")
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@XmlElement(name = "LASTNAME")
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	@XmlElement(name = "STREET")
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	@XmlElement(name = "CITY")
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", street=" + street
				+ ", city=" + city + "]";
	}

}
