package connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.People;
import models.Teacher;
import models.Schedules;
import models.Student;
import models.Subjects;

public class HibernateConnection {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	
	 private static SessionFactory buildSessionFactory() {
	        try {
	            Configuration config = new Configuration();
	            config.configure("hibernate.cfg.xml");

	            config.addAnnotatedClass(Teacher.class);
	            config.addAnnotatedClass(Student.class);
	            config.addAnnotatedClass(Schedules.class);
	            config.addAnnotatedClass(Subjects.class);
	            ;

	            return config.buildSessionFactory();
	        } catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

	    public static Session getSession() {
	        return sessionFactory.openSession();
	    }

	    public static void shutdown() {
	        sessionFactory.close();
	    }

}
