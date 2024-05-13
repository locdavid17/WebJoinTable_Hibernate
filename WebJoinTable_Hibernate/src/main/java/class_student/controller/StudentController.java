package class_student.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import class_student.dao.CourseDAO;
import class_student.dao.StudentDAO;
import class_student.entities.Course;
import class_student.entities.Student;
@Controller
public class StudentController {
@Autowired
private StudentDAO studentDAO;
@Autowired
private CourseDAO courseDAO;

@InitBinder
public void initBinder(WebDataBinder binder) {
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
}
//
@RequestMapping(value= {"/","/index"})
public String index(Model model) {
	List<Student> students = studentDAO.getStudents();
	model.addAttribute("list", students);
	return "index";
}
//
@RequestMapping(value= {"/admin"})
public String listStudent(Model model) {
	List<Student> students = studentDAO.getStudents();
	model.addAttribute("list", students);
	return "admin";
}
@RequestMapping("/courses")
public String courses(Model model) {
	List<Course> classes = courseDAO.getCourses();
	model.addAttribute("listClas", classes);
	
	Student s = new Student();
	model.addAttribute("s", s);
	return "courses";
}
//
@RequestMapping("/dkonline")
public String initInsertStudent(Model model) {
	List<Course> classes = courseDAO.getCourses();
	model.addAttribute("listClas", classes);
	
	Student s = new Student();
	model.addAttribute("s", s);
	return "dkonline";
}
@RequestMapping("/dkonline1")
public String dkonline1(Model model) {
	List<Course> classes = courseDAO.getCourses();
	model.addAttribute("listClas", classes);
	
	Student s = new Student();
	model.addAttribute("s", s);
	return "dkonline1";
}
//
@RequestMapping("/dkonline3")
public String dkonline3(Model model) {
	List<Course> classes = courseDAO.getCourses();
	model.addAttribute("listClas", classes);
	
	Student s = new Student();
	model.addAttribute("s", s);
	return "dkonline3";
}
//
@RequestMapping("/dkonline4")
public String dkonline4(Model model) {
	List<Course> classes = courseDAO.getCourses();
	model.addAttribute("listClas", classes);
	
	Student s = new Student();
	model.addAttribute("s", s);
	return "dkonline4";
}
//
@RequestMapping("/dkonline2")
public String dkonline2(Model model) {
	List<Course> classes = courseDAO.getCourses();
	model.addAttribute("listClas", classes);
	
	Student s = new Student();
	model.addAttribute("s", s);
	return "dkonline2";
}
//
@RequestMapping("/dkonline5")
public String dkonline5(Model model) {
	List<Course> classes = courseDAO.getCourses();
	model.addAttribute("listClas", classes);
	
	Student s = new Student();
	model.addAttribute("s", s);
	return "dkonline5";
}
//
@RequestMapping("/insertStudent")
public String insertStudent(@ModelAttribute("s")Student s, Model model) {
	      boolean bl = studentDAO.InsertStudent(s);
	if(bl) {
		model.addAttribute("succ", "Successfully !");
		List<Student> students = studentDAO.getStudents();
		model.addAttribute("list", students);
		return "dkonline0";
	}else {
		model.addAttribute("err", "Insert failed!");
		List<Course> classes = courseDAO.getCourses();
		model.addAttribute("listClas",classes);
		
		model.addAttribute("s",s);
		return "dkonline";
	}
}
//

@RequestMapping("/initUpdateStudent")
public String initUpdateStudent(@RequestParam("studentId")Integer s, Model model) {
	List<Course> classes = courseDAO.getCourses();
	model.addAttribute("listClas",classes);
	
	Student student = studentDAO.getStudentById(s);
	model.addAttribute("s",student);
	
	return "updateStudent";
	
}
@RequestMapping("/updateStudent")
public String updateStudent(@ModelAttribute("s")Student s, Model model) {
	boolean student = studentDAO.UpdateStudent(s);
	if(student) {
		model.addAttribute("succ","update Thành Công!");
		List<Student> students = studentDAO.getStudents();
		model.addAttribute("listClas",students);
		return "admin";
	}else {
		model.addAttribute("s",s);
		model.addAttribute("err","update Thất Bại!");	
		return "updateStudent";
	}
}

@RequestMapping("/deleteStudent")
public String deleteStudent(@RequestParam("studentId")Integer studentId, Model model) {
	boolean deleteStudent = studentDAO.DeleteStudent(studentId);
	if(deleteStudent) {
            model.addAttribute("succ","deleteSuccessFully!");
	}else {
		model.addAttribute("err","deleteFalied !");
	}
	List<Student> students = studentDAO.getStudents();
	model.addAttribute("list", students);
	return "listStudent";
}
}
