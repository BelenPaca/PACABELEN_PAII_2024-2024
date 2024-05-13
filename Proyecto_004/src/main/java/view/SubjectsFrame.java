package view;

import connection.HibernateConnection;
import javax.persistence.Column;
import javax.swing.*;

import controller.*;
import models.Student;
import models.Subjects;

import java.awt.event.*;

public class SubjectsFrame extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton createButton;
    private JButton readButton;
    private JButton updateButton;
    private JButton deleteButton;
    
    private int id;
	private String name;
	private String description;
	private int level;
    private Subjects subjects = new Subjects();
    private CSubject cSubject = new CSubject(HibernateConnection.getSessionFactory());

    public SubjectsFrame() {
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
					String input = JOptionPane
							.showInputDialog
							("Para la asignatura porfavor ingrese el ID, nombre, descripcion y el nivel:");

					String[] parts = input.split(",");

					if (parts.length >= 4) {
						id = Integer.parseInt(parts[0].trim());
						name = parts[1].trim();
						description = parts[2].trim();
						level = Integer.parseInt(parts[3].trim());

						subjects.setId(id);
						subjects.setName(name);
						subjects.setDescription(description);;
						subjects.setLevel(level);

						cSubject.create(subjects);
						JOptionPane.showMessageDialog(null,
								"LA CREACION DE ESTUDIANTE SE REALIZO CON EXITO");

					} else {
						
						JOptionPane.showMessageDialog(null,
								"ERROR!! Ingrese el campo requerido separados por comas.");
					}
				
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	name = JOptionPane.showInputDialog("Porfavor ingrese su nombre");

				cSubject.read(subjects, name);
            	
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int id = Integer.parseInt(JOptionPane.showInputDialog("	Porfavor ingrese su ID"));
				String input = JOptionPane
						.showInputDialog("Porfavor Ingrese su ID, nombre, apellido y edad:");

				String[] parts = input.split(",");

				if (parts.length >= 3) {
					name = parts[0].trim();
					description = parts[1].trim();
					level = Integer.parseInt(parts[2].trim());

					subjects.setId(id);
					subjects.setName(name);
					subjects.setDescription(description);
					subjects.setLevel(level);

					cSubject.update(subjects, id);

				}
            		
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int id = Integer.parseInt(JOptionPane.showInputDialog("Porfavor ingrese su ID"));

				cSubject.delete(subjects, id);
            }
        });
    }
}