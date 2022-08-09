package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class MapDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("what is java ?");
		

		// creating answer
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("java us programing langauge");
		answer.setQuestion(q1);

		// creating a second answer
		// creating answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(33);
		answer1.setAnswer("with the help of java we can create software");
		answer.setQuestion(q1);

		// creating a third answer
		// creating answer
		Answer answer2 = new Answer();
		answer2.setAnswerId(363);
		answer2.setAnswer("java has a differant type of frameworks");
		answer.setQuestion(q1);
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		q1.setAnswer(list);
		// .......
		/*
		 * //............................ q1.setAnswer(answer);
		 */
	/*	// creating second question
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("what is Collection framework ?");

		/*
		 * //creating second answer Answer answer1=new Answer();
		 * answer1.setAnswerId(344); answer1.setAnswer("API to work with java");
		 * 
		 * //..... answer1.setQuestion(q2);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * //................... q2.setAnswer(answer1);
		 * 
		 * 
		 * //session for save method
		 */
		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();

		s.save(q1);
		s.save(answer);
		s.save(answer1);
		s.save(answer2);
		tx.commit();
		// fetching....
		/*
		 * Question newQ=(Question)s.get(Question.class, 242);
		 * System.out.println(newQ.getQuestion());
		 * System.out.println(newQ.getAnswer().getAnswer()); s.close();
		 */

		factory.close();
	}
}
