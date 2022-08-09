package com.tut.ProjectWithMaven;

import java.io.IOException;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Emdemo 
{
  public static void main(String[] args)  {
	  SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Student Student1=new Student();
		Student1.setId(14134);
		Student1.setName("durgesh");
		Student1.setCity("luckhnow");
		
		
		Student Student2=new Student();
		Student2.setId(14234);
		Student2.setName("ravi");
		Student2.setCity("delhi");
		
		Certificate certificate=new Certificate();
		certificate.setCourse("android");
		certificate.setDuration("2 month");
		
		Certificate certificate1=new Certificate();
		certificate1.setCourse("hibernate");
		certificate1.setDuration("5 month");
		
		Session s = factory.openSession();
	    org.hibernate.Transaction tx=s.beginTransaction();
		
		s.save(Student1);
		s.save(Student2);
	
		tx.commit();
		s.close();
		factory.close();
}
}
