package ec.edu.uce.Proyecto_004;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Schedules;
import models.Student;
import models.Subjects;
import models.Teacher;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Teacher.class);
        configuration.addAnnotatedClass(Subjects.class);
        configuration.addAnnotatedClass(Schedules.class);
        
        // Create Session Factory and auto-close with try-with-resources.
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
 
            Session session = sessionFactory.openSession();
 
            Student student = new Student();
            student.setId(2);
            student.setName("Marco");
            student.setLastname("Cedeño");
            student.setAge(19);
  
            
            Teacher teacher = new Teacher();
            teacher.setId(3);
            teacher.setName("Andres");
            teacher.setLastname("Cueva");
            teacher.setAge(20);
            
            Subjects subjects = new Subjects();
            subjects.setId(13);
            subjects.setName("sociales");
            subjects.setDescription("Clase avanzada de sociales");
            subjects.setLevel(1);
            
            Schedules schedules = new Schedules();
            schedules.setId(13);
            schedules.setIdStudent(1);
            schedules.setIdTeacher(2);
            schedules.setStar_time(1);
            schedules.setEnd_time(1);
            schedules.setDay("");

            
            session.beginTransaction();
            session.persist(student); 
            session.persist(teacher); 
            session.persist(subjects); 
            session.persist(schedules); 
            session.getTransaction().commit();
 

        }
    }
}
