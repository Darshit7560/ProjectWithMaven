package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {

		// get or load
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();

		Student student = (Student) session.load(Student.class, 102);
		System.out.println(student);
		
		/*
		Student student1 = (Student) session.get(Student.class, 103);
		System.out.println(student1);
		*/
		
		Address ad=(Address)session.get(Address.class, 1);
		System.out.println(ad.getCity());
		
		
       
		session.close();
		factory.close();

	}

}
