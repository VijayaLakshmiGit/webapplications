package com.webserviceHttp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Xmldata {

	public static void main(String[] args) {
		Client cl = new Client();
		cl.setId(1);
		cl.setAge(30);
		cl.setName("anusha");
		System.out.println(cl.getAge());

		try {
			JAXBContext jaxbcontext = JAXBContext.newInstance(Client.class);
			Marshaller marshel = jaxbcontext.createMarshaller();
			marshel.marshal(cl, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
