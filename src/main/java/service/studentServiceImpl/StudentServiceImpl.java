package service.studentServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.StudentDao;
import pojo.Student;
import service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentDao studentDao; 
	
	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudent();
	}
	
	@Override
	public boolean updateStudent(Student student) {
		//检查要修改的学生是否存在
		if(student.getId()==null||studentDao.getStudentById(student.getId())==null)
			return false;
		return studentDao.updateStudentById(student);
	}
	
	@Override
	public boolean addStudent(Student student) {
		//检查学生是否存在
		if(student.getId()==null||studentDao.getStudentById(student.getId())==null) 
			return studentDao.addStudent(student);	//不存在-->add		
			return false;//存在 -->false
	}
	@Override
	public Student removeStudentById(int id) {
		Student s  = studentDao.getStudentById(id);
		if(s!=null) 
			studentDao.removeStudentById(id); 
		return s ;
	}
	
	
	@Override
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}


	@Override
	public List<Student> getStudentsByIdOrName(String idOrName) {
		List<Student> list = new ArrayList<>();
		if(StringUtils.isNumeric(idOrName)) { //id
			list.add(getStudentById(Integer.parseInt(idOrName)));
			return list;
		}else {// name
			return studentDao.getStudentsByName(idOrName);
		}
	}

}
