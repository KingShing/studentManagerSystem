package studentManagerSystem;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.Student;
import service.IStudentService;


//使用junit4进行测试
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class Mytest extends AbstractJUnit4SpringContextTests{
	

	@Autowired
	private IStudentService studentService;
	
	@Test
	public void t1() throws Exception {

		List<Student> allStudents = studentService.getAllStudents();
		for (Student s : allStudents) {
			System.out.println(s);
		}
	}

}
