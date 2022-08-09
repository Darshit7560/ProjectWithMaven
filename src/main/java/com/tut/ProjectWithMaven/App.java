package com.tut.ProjectWithMaven;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)  throws IOException{
		System.out.println("project started");

		// sessionfactory is a one type of interface shoe object creation is not
		// possible show we createw a object of an configuration...
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		/*
		 * Configuration cfg=new Configuration(); 
		 * cfg.configure();
		 *  SessionFactory factory=cfg.buildSessionFactory();
		 */
		// creating student
		Student st = new Student();
		st.setId(102);
		st.setName("abvvbc");
		st.setCity("DELfyuyHI");
		System.out.println(st);
		
		//creating object of address class
		
		Address ad=new Address();
		ad.setStreet("street 1");
		ad.setCity("DELJI");
		ad.setOpen(true);
		ad.setAddedDate( new Date());
		ad.setX(1234.34);
		
		//reading image
		
		/*
		FileInputStream fis=new FileInputStream("src/main/java/image2.png");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		*/
		
	
     	Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done..");

	}
}
