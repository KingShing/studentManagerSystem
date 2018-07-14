package service.studentServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentDao;
import pojo.Student;
import service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao; 
	
	
	public List<Student> getAllStudents() {
		return studentDao.getAllStudent();
	}
	
	
	public boolean updateStudent(Student student) {
		//检查要修改的学生是否存在
		if(studentDao.getStudentById(student.getId())==null)
			return false;
		return studentDao.updateStudentById(student);
	}
	
	
	public boolean addStudent(Student student) {
		//检查学生是否存在
		if(studentDao.getStudentById(student.getId())==null) 
			return studentDao.addStudent(student);	//不存在-->add		
			return false;//存在 -->false
	}
	
	public boolean removeStudentById(int id) {
		if(studentDao.getStudentById(id)==null) 
			return false; //找不到学生,无法删除,-->false
		return studentDao.removeStudentById(id); 
	}
	
	
	
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

}
