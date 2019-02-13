package com.gouqi.service;


import com.trtjk.beans.Student;
import com.trtjk.dao.IStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
	private IStudentDao dao;
	
	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void addStudent(Student student) {
		dao.insertStudent(student);
	}

}
