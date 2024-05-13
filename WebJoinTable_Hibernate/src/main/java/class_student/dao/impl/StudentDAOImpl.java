package class_student.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import class_student.dao.StudentDAO;
import class_student.entities.Student;
import net.bytebuddy.asm.Advice.Return;
@Repository
public class StudentDAOImpl implements StudentDAO{
	@Autowired
	private SessionFactory  sessionFactory;

	@Override
	public List<Student> getStudents() {
		Session openSession = sessionFactory.openSession();
		try {
			List list = openSession.createQuery("from Student").list();
			return list;
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
			openSession.close();
		}
		return null;
	}

	@Override
	public boolean InsertStudent(Student s) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(s);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean DeleteStudent(Integer studentId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getStudentById(studentId));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Student getStudentById(Integer studentId) {
		Session session = sessionFactory.openSession();
		try {
		  Student student = session.get(Student.class,studentId);
		  return student;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			session.close();
		}
		return null;
	}

	@Override
	public boolean UpdateStudent(Student s) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(s);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}


}
