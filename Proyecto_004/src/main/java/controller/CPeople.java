package controller;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import models.IPeople;
import models.People;

public class CPeople implements IPeople{
	
	private SessionFactory sessionFactory;

	public CPeople(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(People people) {
		
			try (Session session = sessionFactory.openSession()) {
				session.beginTransaction();
				session.persist(people);
				session.getTransaction().commit();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void update(People people, int id) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			people.setId(id);
			session.saveOrUpdate(people);
			session.getTransaction().commit();
			session.close();
			JOptionPane.showMessageDialog(null,
					"CORRECTA ACTUALIZACION");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(People people, int id) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			people.setId(id);
			session.delete(people);
			session.getTransaction().commit();
			session.close();
			JOptionPane.showMessageDialog(null, 
					"ELIMINACION EXITOSA");

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public <T> T read(Class<T> r, String name) {
		T result = null;
		try (Session session = sessionFactory.openSession()) {
		
			Query query = session.createQuery("FROM " + r.getSimpleName() +
					" CUAL ES TU NOMBRE = :NOMBRE");
			query.setParameter("NOMBRE", name);
			List<T> entities = query.list();

			if (entities.isEmpty()) {
				JOptionPane.showMessageDialog(null, 
						"LO SENTIMOS, LA PERSONA NO SE ENCUENTR EN LA DB");
			} else {
				for (T entity : entities) {
					JOptionPane.showMessageDialog(null, 
							"N° DE PERSONAS: " + 
					entities.size() + "\nLA PERSONA FUE ENCONTRA CON EXITO" + entity);				
					result = entity;
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; 

}
		
	}
