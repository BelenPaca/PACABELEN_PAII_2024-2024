package controller;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import models.ISchedules;
import models.Schedules;

public class CSchedules implements ISchedules {
	private SessionFactory sessionFactory;

	public CSchedules(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(Schedules schedule) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			session.persist(schedule);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Schedules read(Schedules schedules, String day) {
	    try (Session session = sessionFactory.openSession()) {
	        session.beginTransaction();
	        Query query = session.createQuery("FROM Schedules WHERE day = :day");
	        query.setParameter("day", day);
	        List<Schedules> schedul = query.list();     
	        session.getTransaction().commit();
	        session.close();
	        
	        if (schedul.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "LO SENTIMOS EL HORARIO NO SE ENCUENTRA EN LA DB");
	            return null;
	        } else {
	            StringBuilder message = new StringBuilder();
	            message.append("HORARIOS ENCONTRADOS CON EXITO: ").append(schedul.size()).append("\n");
	            for (Schedules s : schedul) {
	                message.append("HORARIO ENCONTRADO: ").append(s).append("\n");
	            }
	            JOptionPane.showMessageDialog(null, message.toString());
	            return schedul.get(0); // Devolver el primer horario encontrado
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return schedules; 
	}
	

	@Override
	public void update(Schedules schedules, int id_schedules) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			schedules.setId(id_schedules);
			session.update(schedules);
			session.getTransaction().commit();
			session.close();
			JOptionPane.showMessageDialog(null, 
					"EL HORARIO SE ACTUALIZO CON EXITO");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Schedules schedules, int id_schedules) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			schedules.setId(id_schedules);
			session.delete(schedules);
			session.getTransaction().commit();
			session.close();
			JOptionPane.showMessageDialog(null, 
					"EIMINACION EXITOSA");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
