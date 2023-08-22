package org.jsp.userspringapp.controller;

import java.util.Scanner;

import org.jsp.userspringapp.dao.UserDao;
import org.jsp.userspringapp.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserController {
	static Scanner sc=new Scanner(System.in);
	static UserDao dao;
	
	static {
		ApplicationContext context=new AnnotationConfigApplicationContext("org.jsp");
		dao = context.getBean(UserDao.class);
	}
	public static void main(String[] args) {
		System.out.println("1.Save User");
		System.out.println("2.update User");
		System.out.println("3.Verify user by phone and password");
		System.out.println("4.Verify user by Email and password");
		System.out.println("5.Verify user by id and password");
		int choice =sc.nextInt();
		switch (choice) {
		case 1:{
			save();
			break;
		}
		case 2:{
			update();
			break;
		}
		}	
	}
	public static void save() {
	System.out.println("Enter name,phone,email, and password");
	String name=sc.next();
	long phone=sc.nextLong();
	String email=sc.next();
	String password=sc.next();
	User u=new User();
	u.setName(name);
	u.setPhone(phone);
	u.setEmail(email);
	u.setPassword(password);
	u=dao.saveUser(u);
	System.out.println("User saved with Id:"+u.getId());
	}
	public static void update() {
		
	}
}

