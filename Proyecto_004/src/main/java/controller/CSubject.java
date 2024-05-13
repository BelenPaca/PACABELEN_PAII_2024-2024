package controller;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import models.ISubject;
import models.Subjects;

public class CSubject implements ISubject{
	
	private SessionFactory sessionFactory;

	public CSubject(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(Subjects subject) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.persist(subject);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Subjects read(Subjects subject, String name) {
		try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();
	        Query query = session.createQuery(
	        		"NOMBRE DE LA MATERIA = :NOMBRE");
	        query.setParameter("NOMBRE", name);
	        List<Subjects> subjects = query.list();	     
	        
	        session.getTransaction().commit();
	        session.close();
	        if (subjects.isEmpty()) {
	        	JOptionPane.showMessageDialog(null, 
	        			"LO SENTIMOS LA MATERIA NO SE ENCUENTRA EN LA DB");
	        	return null;
	        } else {
	        	for (Subjects s : subjects) {
	        		JOptionPane.showMessageDialog(null, 
	        				"MATERIAS ENCONTRAS CON EXITO: " + subjects.size() +
	        				"\nMATERIA ENCONTRADA" + s);	
				}
	            
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return subject; 
	}

	@Override
	public void update(Subjects subject, int id) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			subject.setId(id);
			session.update(subject);
			session.getTransaction().commit();
			session.close();
			JOptionPane.showMessageDialog(null, 
					"LA MATERIA SE ACTUALIZO CON EXITO");

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void delete(Subjects subject, int id) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			subject.setId(id);
			session.delete(subject);
			session.getTransaction().commit();
			session.close();
			JOptionPane.showMessageDialog(null,
					"EIMINACION EXITOSA");

		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
