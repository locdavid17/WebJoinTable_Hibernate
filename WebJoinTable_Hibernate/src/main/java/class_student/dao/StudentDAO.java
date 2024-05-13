package class_student.dao;

import java.util.List;

import class_student.entities.Student;

public interface StudentDAO {
public List<Student> getStudents();
public boolean InsertStudent(Student s);
public boolean DeleteStudent(Integer studentId);
public Student getStudentById(Integer studentId);
public boolean UpdateStudent(Student s);
}
