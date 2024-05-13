package view;

import connection.HibernateConnection;
import javax.swing.*;
import controller.*;
import models.Teacher;
import models.Schedules;
import models.Student;
import models.Subjects;

import java.awt.event.*;

public class SchedulesFrame extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton createButton;
	private JButton readButton;
	private JButton updateButton;
	private JButton deleteButton;

	private int id;
	private Student student;
	private Teacher teacher;
	private String start_time;
	private String end_time;
	private String day;

	private Schedules schedule = new Schedules();
	private CSchedules cSchedule = new CSchedules(HibernateConnection.getSessionFactory());

	public SchedulesFrame() {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(Box.createHorizontalGlue());
		
		createButton = new JButton("Create");
		readButton = new JButton("Read");
		updateButton = new JButton("Update");
		deleteButton = new JButton("Delete");

		add(createButton);
		add(readButton);
		add(updateButton);
		add(deleteButton);
		add(Box.createHorizontalGlue());


		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String input = JOptionPane.showInputDialog(
						"Para el horario porfavor ingrese ID, hora inicio, final y el dia:");

				String[] parts = input.split(",");

				if (parts.length >= 4) {
					id = Integer.parseInt(parts[0].trim());
					start_time = parts[1].trim();
					end_time = parts[2].trim();
					day = parts[3].trim();

					schedule.setId(id);
					schedule.setIdTeacher(WIDTH);
					schedule.setIdStudent(id);
					schedule.setStar_time(ABORT);
					schedule.setEnd_time(ABORT);
					schedule.setDay(day);

					cSchedule.create(schedule);
					JOptionPane.showMessageDialog(null, 
							"Felicitaciones el horario fue creado exito");

				} else {
		
					JOptionPane.showMessageDialog(null,
							"\"ERROR!!.");
				}

			}
		});

		readButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				day = JOptionPane.showInputDialog(" Porfavor Ingrese su nombre");

				cSchedule.read(schedule, day);

			}
		});

		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(JOptionPane.showInputDialog
						("Porfavor ingrese su ID"));
				String input = JOptionPane
						.showInputDialog
						("Porfavor ingrese su nuevo tiempo de inicio, final y dia:");

				String[] parts = input.split(",");

				if (parts.length >= 3) {
					
					start_time = parts[0].trim();
					end_time = parts[1].trim();
					day = parts[2].trim();

					schedule.setStar_time(id);
					schedule.setEnd_time(id);
					schedule.setDay(day);

					cSchedule.update(schedule, id);

				}

			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(JOptionPane.showInputDialog
						("Porfavor ingrese su ID"));

				cSchedule.delete(schedule, id);
			}
		});
	}
}
