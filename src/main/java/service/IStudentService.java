package service;

import java.util.List;

import pojo.Student;

public interface IStudentService {
	
	/**
	 *  获取所有学生
	 * @return List<Student>
	 */
	public List<Student> getAllStudents();
	
	/**
	 *  修改一个学生的信息
	 * @param student
	 * @return
	 */
	public boolean updateStudent(Student student);
	
	/**
	 *  添加一个学生
	 * @param student
	 * @return
	 */
	public boolean addStudent(Student student);
	
	/**
	 *  根据id删除一个学生
	 * @param id
	 * @return
	 */
	
	
	public Student removeStudentById(int id);
	/**
	 * 通过id获取一个学生信息 
	 */
	public Student getStudentById(int id);
	
	
	/**
	 * 根据id或者name查询学生
	 * @param idOrName
	 * @return
	 */
	public List<Student> getStudentsByIdOrName(String idOrName);
}
