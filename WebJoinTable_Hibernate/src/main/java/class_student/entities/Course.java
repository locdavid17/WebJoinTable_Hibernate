package class_student.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Courses")
public class Course {
@Id
@Column(name="CouId")
private String couId;
@Column(name="CourseName")
private String courseName;
@Column(name="CourseDescription")
private String courseText;
@Column(name="Credits")
private Integer creDits;


@OneToMany(mappedBy = "course")
private Set<Student> listStudents;


public Course() {
	// TODO Auto-generated constructor stub
}


public Course(String couId, String courseName, String courseText, Integer creDits) {
	super();
	this.couId = couId;
	this.courseName = courseName;
	this.courseText = courseText;
	this.creDits = creDits;
}


public String getCouId() {
	return couId;
}


public void setCouId(String couId) {
	this.couId = couId;
}


public String getCourseName() {
	return courseName;
}


public void setCourseName(String courseName) {
	this.courseName = courseName;
}


public String getCourseText() {
	return courseText;
}


public void setCourseText(String courseText) {
	this.courseText = courseText;
}


public Integer getCreDits() {
	return creDits;
}


public void setCreDits(Integer creDits) {
	this.creDits = creDits;
}


public Set<Student> getListStudents() {
	return listStudents;
}


public void setListStudents(Set<Student> listStudents) {
	this.listStudents = listStudents;
}




}
