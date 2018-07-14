package dao;

import java.util.List;

import pojo.Student;
import pojo.conditionQuery.ConditionStudent;

public interface StudentDao {
	
	/**
	 * 根据id获取一个学生的信息
	 * @param id
	 * @return  student
	 */
	public Student getStudentById(int id);
	
	/**
	 *  获取所有学生
	 * @return List<Student>
	 */
	public List<Student> getAllStudent();
	
	/**
	 *  修改一个学生的信息
	 * @param student
	 * @return
	 */
	public boolean updateStudentById(Student student);
	
	/**
	 * 删除一个学生
	 * @param id
	 * @return boolean
	 */
	public boolean removeStudentById(int id );
	
	
	/**
	 *  添加一个学生
	 * @param student
	 * @return boolean
	 */
	public boolean addStudent(Student student);
	
	
	//-----------模糊查询--------------------
	/**
	 *  根据name查询
	 * @param Name
	 * @return
	 */
	public List<Student> getStudentsByName(String Name);
		
	/**
	 *  ConditionStudent 条件查询
	 * @param conditionStudent
	 * @return
	 */
	public List<Student> getStudentsByCondition(ConditionStudent conditionStudent);
}
