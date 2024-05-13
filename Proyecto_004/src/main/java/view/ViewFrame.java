package view;

import javax.swing.*;
import java.awt.*;

public class ViewFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private PeopleFrame personPanel;
	private SchedulesFrame schedulePanel;
    private SubjectsFrame subjectPanel;
    private JTabbedPane tabbedPane;

    public ViewFrame(String title) {
        super(title);
        
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void vtn() {
    	setLayout(new BorderLayout());


        personPanel = new PeopleFrame();
        schedulePanel = new SchedulesFrame();
        subjectPanel = new SubjectsFrame();
        

        
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("People", personPanel);
        tabbedPane.addTab("Schedules", schedulePanel);
        tabbedPane.addTab("Subjects", subjectPanel);
        

        add(tabbedPane, BorderLayout.CENTER);

    }

}
