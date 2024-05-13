package class_student.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import class_student.dao.CourseDAO;
import class_student.entities.Course;
@Repository
public class CourseDAOImpl implements CourseDAO{
@Autowired
private SessionFactory sessionFactory;

	@Override
	public List<Course> getCourses() {
		Session openSession = sessionFactory.openSession();
		try {
			List list = openSession.createQuery("from Course").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			openSession.close();
			
		}
		return null;
	}

}
