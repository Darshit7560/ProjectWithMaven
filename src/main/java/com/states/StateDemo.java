package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.ProjectWithMaven.Certificate;
import com.tut.ProjectWithMaven.Student;

public class StateDemo 
{
    public static void main(String[] args) 
    {
		//practicle of hibernate object states;
    	//transiant
    	//presistence
    	//detached
    	//remove
    	
    	System.out.println("Examples");
    	
    	SessionFactory f=new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
    	
    	//creating student object  //student :transient state
    	Student student=new Student();
    	student.setId(1414);
    	student.setName("ABC");
    	student.setCity("DELHI");
    	student.setCerti(new Certificate("java hibernate cource" ," 2 month"));
    	
    	// student(Object):persistance state
    	Session s=f.openSession();
    	Transaction tx=s.beginTransaction();
    	s.save(student);
    	student.setName("JHON");
    	
    	tx.commit();
    	
    	s.close();
    	//student : detached state
    	student.setName("SACHIN");
    	f.close();
	}
}
