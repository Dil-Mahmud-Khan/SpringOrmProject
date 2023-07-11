package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	//insert/save student
	public int insert(Student student) {
		Integer i=(Integer) this.hibernateTemplate.save(student);
		return i;
	}

	//read or fetch single row data
	public Student getStudent(int studentId) {
		return this.hibernateTemplate.get(Student.class,studentId);
	}
	
	
	//read or fetch multiple data
	public List<Student> getAllStudents(){
		return this.hibernateTemplate.loadAll(Student.class);
	}
	
	
	//delete data
	@Transactional
	public void delete(int studentId) {
		this.hibernateTemplate.delete(this.hibernateTemplate.get(Student.class,studentId));
	}
	
	//update data
	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(Student.class);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}

