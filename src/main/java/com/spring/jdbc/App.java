package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("My App Started....");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

		// The following way works but industry standards aren't followed.
//		// we need to get the JdbcTemplate obj from spring-jdbc
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
//
//		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
//		// insert query
//		String query = "insert into student(id,name,city) values(?,?,?)";
//
//		// fire query
//		int noOfRowsAffected = template.update(query, 23, "ali", "Knl");
//		int noOfRowsAffected = template.update(query, 34, "abdul", "Hyd");
//		System.out.println("No of rows affected : " + noOfRowsAffected);

		// INSERT Operation using SpringJDBC
		// The following way does same as above but follows industry standards.
//		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//		Student student1 = new Student();
//		student1.setId(48);
//		student1.setName("jubbi");
//		student1.setCity("Bom");
//
//		int noOfRowsAffected = studentDao.insert(student1);
//		System.out.println("No of rows affected : " + noOfRowsAffected);

		// UPDATE Operation using SpringJDBC
//		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//		Student student1 = new Student();
//		student1.setId(43);
//		student1.setName("Syed");
//		student1.setCity("Hyd");
//
//		int noOfRowsAffected = studentDao.modify(student1);
//		System.out.println("No of rows affected : " + noOfRowsAffected);

		// DELETE Operation using SpringJDBC
//		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//		int noOfRowsAffected = studentDao.delete(34);
//		System.out.println("No of rows affected : " + noOfRowsAffected);

		// SELECT Operation using SpringJDBC
//		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//		Student s1 = studentDao.getStudent(12);
//		System.out.println(s1);
//		Student s2 = studentDao.getStudent(23);
//		System.out.println(s2);

		// SELECT Operation using SpringJDBC
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		List<Student> students = studentDao.getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
