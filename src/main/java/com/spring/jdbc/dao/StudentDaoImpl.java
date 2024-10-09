package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";

		// fire query
		int n = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return n;
	}

	@Override
	public int modify(Student student) {
		// update query
		String query = "UPDATE student SET name=?, city=? WHERE id=?";
		int n = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());

		return n;
	}

	@Override
	public int delete(int StudentId) {
		// delete query
		String query = "DELETE FROM student WHERE id=?";
		int n = this.jdbcTemplate.update(query, StudentId);

		return n;
	}

	@Override
	public Student getStudent(int studentId) {
		// select query (for single student data)
		String query = "SELECT * FROM student WHERE id=?";

		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);

		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		// select query for all students data
		String query = "SELECT * FROM student";

		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

}
