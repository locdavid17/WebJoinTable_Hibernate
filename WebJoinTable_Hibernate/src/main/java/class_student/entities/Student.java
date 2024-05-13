package class_student.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Students")
public class Student {
@Id
@Column(name="StudentId")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer studentId;
@Column(name="StudentName")
private String studentName;
@Column(name="Gender")
private Boolean gender;
@Column(name="Email")
private String email;
@Column(name="DateOfBirth")
private Date dateofBirth;
@Column(name="Address")
private String address;
@Column(name="PhoneNumber")
private String phoneNumber;

@ManyToOne
@JoinColumn(name="CouId",referencedColumnName = "CouId")
private Course course;
public Student() {
	// TODO Auto-generated constructor stub
}
public Student(Integer studentId, String studentName, Boolean gender, String email, Date dateofBirth, String address,
		String phoneNumber) {
	super();
	this.studentId = studentId;
	this.studentName = studentName;
	this.gender = gender;
	this.email = email;
	this.dateofBirth = dateofBirth;
	this.address = address;
	this.phoneNumber = phoneNumber;
}
public Integer getStudentId() {
	return studentId;
}
public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public Boolean getGender() {
	return gender;
}
public void setGender(Boolean gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getDateofBirth() {
	return dateofBirth;
}
public void setDateofBirth(Date dateofBirth) {
	this.dateofBirth = dateofBirth;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}


}
