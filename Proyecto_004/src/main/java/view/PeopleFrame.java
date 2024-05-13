package view;

import javax.swing.*;

import connection.HibernateConnection;
import controller.CPeople;
import models.Teacher;
import models.Student;

import java.awt.event.*;

public class PeopleFrame extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton createButton;
	private JButton readButton;
	private JButton updateButton;
	private JButton deleteButton;

	private int id;
	private String name;
	private String lastname;
	private int age;

	private Student student = new Student();
	private Teacher teacher = new Teacher();

	public PeopleFrame() {
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

		CPeople cPeople = new CPeople(HibernateConnection.getSessionFactory());

		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input1 = Integer
						.parseInt(JOptionPane.showInputDialog
								("PERSONA QUE DESEA AÑADIR:\n 1,ESTUDIANTE \n2.PROFESOR"));

				if (input1 == 1) {
					String input = JOptionPane
							.showInputDialog
							("Porfavor Ingrese su ID, nombre, apellido y edad:");
					String[] parts = input.split(",");

					if (parts.length >= 4) {
						id = Integer.parseInt(parts[0].trim());
						name = parts[1].trim();
						lastname = parts[2].trim();
						age = Integer.parseInt(parts[3].trim());

						student.setId(id);
						student.setName(name);
						student.setLastname(lastname);
						student.setAge(age);

						cPeople.create(student);
						JOptionPane.showMessageDialog(null, 
								"LA CREACION DE ESTUDIANTE SE REALIZO CON EXITO");

					} else {
					
						JOptionPane.showMessageDialog(null,
								"ERROR!! Ingrese el campo requerido separados por comas.");
					}

				} else if (input1 == 2) {

					String input = JOptionPane
							.showInputDialog
							("Porfavor Ingrese su ID, nombre, apellido y edad:");

					String[] parts = input.split(",");

					if (parts.length >= 4) {
						id = Integer.parseInt(parts[0].trim());
						name = parts[1].trim();
						lastname = parts[2].trim();
						age = Integer.parseInt(parts[3].trim());

						teacher.setId(id);
						teacher.setName(name);
						teacher.setLastname(lastname);
						teacher.setAge(age);

						cPeople.create(teacher);
						JOptionPane.showMessageDialog(null, "LA CREACION DEL PROFESOR SE REALIZO CON EXITO");

					} else {
						JOptionPane.showMessageDialog(null,
								"ERROR!! Ingrese el campo requerido separados por comas.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERROR!!.");
				}

			}
		});

		readButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input1 = Integer.parseInt(JOptionPane.showInputDialog("USTED ES:\\n 1.ESTUDIANTE  \\n2.PROFESOR"));
				if (input1 == 1) {
					name = JOptionPane.showInputDialog("PORFAVOR INGRESE SU NOMBRE");

					cPeople.read(Student.class, name);

				} else if (input1 == 2) {
					name = JOptionPane.showInputDialog("PORFAVOR INGRESE SU NOMBRE");

					cPeople.read(Teacher.class, name);
				}

			}
		});

		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int in = Integer.parseInt(JOptionPane
						.showInputDialog
						("Si desea actualizar debe indicarnos si usted es :\\n 1.ESTUDIANT \\n2.PROFESOR"));

				if (in == 1) {
					int id = Integer.parseInt(JOptionPane.showInputDialog("Porfavor ingrese su ID"));
					String input = JOptionPane
							.showInputDialog
							("Porfavor Ingrese su ID, nombre, apellido y edad:");
					String[] parts = input.split(",");

					if (parts.length >= 3) {
						name = parts[0].trim();
						lastname = parts[1].trim();
						age = Integer.parseInt(parts[2].trim());

						student.setId(id);
						student.setName(name);
						student.setLastname(lastname);
						student.setAge(age);

						cPeople.update(student, id);

					}

				} else if (in == 2) {
					int id = Integer.parseInt(JOptionPane.showInputDialog("Porfavor ingrese su ID"));
					String input = JOptionPane
							.showInputDialog("Ingrese su nuevo nombre, apellido y edad:");

					String[] parts = input.split(",");

					if (parts.length >= 3) {
						name = parts[0].trim();
						lastname = parts[1].trim();
						age = Integer.parseInt(parts[2].trim());

						teacher.setId(id);
						teacher.setName(name);
						teacher.setLastname(lastname);
						teacher.setAge(age);

						cPeople.update(teacher, id);
					}

				}

			}
		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int in = Integer.parseInt(JOptionPane
						.showInputDialog
						("QUE CAMPO DESEA ELIMINAR:\\n 1.ESTUDIANTE \\n2.PROFESOR"));
				if(in == 1) {
					int id = Integer.parseInt(JOptionPane.showInputDialog
							("Porfavor Ingrese su ID"));
					cPeople.delete(student, id);
				}else if(in ==2) {
					int id = Integer.parseInt(JOptionPane.showInputDialog
							("Porfavor Ingrese su ID"));
					cPeople.delete(teacher, id);
				}
			}
		});
	}
}
