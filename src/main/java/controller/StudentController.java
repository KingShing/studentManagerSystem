package controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Student;
import service.IStudentService;


@Controller
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping(value="/students.do")
	public @ResponseBody List<Student> listAllStu(){
		List<Student> list = studentService.getAllStudents();
		return list;
	}
	
	@RequestMapping(value="/likeStudent.do")
	public @ResponseBody List<Student> likeStudent(String idOrName){
		System.out.println("idOrName"+idOrName);
		return studentService.getStudentsByIdOrName(idOrName);
	}
	
	
	@RequestMapping(value="/student.do")
	public @ResponseBody Student getStuById(String id){
		Student s  = null;
		if(StringUtils.isNumeric(id)) {
			 s = studentService.getStudentById(Integer.parseInt(id));
		}
		return s;
	}
	
	@RequestMapping(value="/studentPrototype.do")
	public @ResponseBody Student getStuPrototype(){
		Student s  = new Student();	
		return s;
	}
	
	@RequestMapping(value="/addStudent.do")
	public String addStudent(Student student,HttpServletRequest request)throws IOException{
		System.out.println(student);
		if(student==null)
			return "redirect:home.html";	
				//保存数据库的路径
				String sqlPath = null; 
				//定义文件保存的本地路径
			    String localPath = "/Users/yejincheng/Downloads/tomcatVirtualHome/";
			    //定义 文件名
			    String filename=null; 
			    if(!student.getPicture().isEmpty()){ 
			        String uuid = UUID.randomUUID().toString().replaceAll("-","");  
			        String contentType=student.getPicture().getContentType();  
			        String suffixName=contentType.substring(contentType.indexOf("/")+1);
			        filename=uuid+"."+suffixName; 
			        System.out.println(filename);
			        //文件保存路径
			        student.getPicture().transferTo(new File(localPath+filename)); 
			    }
				  sqlPath = "/images/"+filename;
			      System.out.println(sqlPath);
			      student.setImage(sqlPath);
			      System.out.println(student);
			      boolean b = studentService.addStudent(student);
			      System.out.println("[add操作]:add学生:"+b);		
			      return "redirect:home.html";	
	}
		
	
	@RequestMapping(value="/updateStudent.do")
	public String updateStudent(Student student,HttpServletRequest request) throws  IOException{

		//保存数据库的路径
		String sqlPath = null; 
		
		//定义文件保存的本地路径
	    String localPath = "/Users/yejincheng/Downloads/tomcatVirtualHome/";
	    //定义 文件名
	    String filename=null; 
	    if(!student.getPicture().isEmpty()){ 
	        String uuid = UUID.randomUUID().toString().replaceAll("-","");  
	        
	        String contentType=student.getPicture().getContentType();  
	        
	        String suffixName=contentType.substring(contentType.indexOf("/")+1);
	       
	        filename=uuid+"."+suffixName; 
	        System.out.println(filename);
	       
	        //文件保存路径
	        student.getPicture().transferTo(new File(localPath+filename)); 
	    }
	
		  sqlPath = "/images/"+filename;
	      System.out.println(sqlPath);
	      student.setImage(sqlPath);
	      System.out.println(student);
		boolean b = studentService.updateStudent(student);
		System.out.println("[修改操作]:修改学生:"+b);		
		
		return "redirect:home.html";
	}
		
	
	
	@RequestMapping(value="/delStudent.do")
	public  void deleteStu(String id,HttpServletResponse response){
		String res = "error";
		PrintWriter writer = null;
		if(StringUtils.isNumeric(id)) {
			if(studentService.removeStudentById(Integer.parseInt(id)))
				res = "success";
		}
		try {
			writer = response.getWriter();
			writer.write(res);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			writer.close();			
		}		
		System.out.println("[删除操作]:删除id为"+id+"的学生:"+res);		
	}
	
}
 