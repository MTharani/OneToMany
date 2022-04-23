package com.sample1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp {

	public static void main(String[] args)
	{
		Configuration con= new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Publisher.class);
		 ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		 SessionFactory factory= con.buildSessionFactory(reg);
		 Session session= factory.openSession();
		 Transaction t= session.beginTransaction();
		 
		 Book book1=new Book(9,"core java" ,"v.balagurusamy",500);
		 Book book2=new Book(10,"bigdata" ,"vani",900);
		 Book book3=new Book(11,"mysql" ,"harsh bothra",800);
		 Book book4=new Book(12,"spring","gosling",1000);
  Set<Book>booklist=new HashSet<Book>(Arrays.asList(book1,book2,book3,book4));
	Publisher pub=new Publisher();
	pub.setPublisherId(3);
	pub.setPublisherName("xyz publisher");
	pub.setBooklist(booklist);
	session.save(pub);
	t.commit();
	session.close();
	}


	}


