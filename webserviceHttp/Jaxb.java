package com.webserviceHttp;

import javax.xml.bind.JAXBException;

import com.webserviceutility.SampleUtil;

public class Jaxb {
	public static void main(String[] args) throws JAXBException, Exception {
		// String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER";

		// Person person = new Person();
		// person.setAge(30);
		/*
		 * person.setId(2); person.setName("anu");
		 * System.out.println(person.toString()); JAXBContext jaxbcontext =
		 * JAXBContext.newInstance(Person.class); Marshaller marsheller =
		 * jaxbcontext.createMarshaller(); //
		 * marsheller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 * marsheller.marshal(person, System.out);
		 * 
		 * System.out.println("+++++++++++++++++++=================");
		 */

		Client c = new Client();
		c.setAge(30);
		c.setId(2);
		c.setName("anu");
		System.out.println("============anu========");
		/*
		 * JAXBContext jaxbcontext = JAXBContext.newInstance(client.class);
		 * System.out.println("++++++++++++++++"); Marshaller marshaller =
		 * jaxbcontext.createMarshaller();
		 * marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
		 * marshaller.marshal(c, System.out);
		 */

		String xmlstr = SampleUtil.javaobjecttoxml(c);
		System.out.println(xmlstr);
	}
}
