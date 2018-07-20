package fr.eni.clinique.ihm.gestionpersonnel;

import java.awt.BorderLayout;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class JTableBasiqueAvecPanel extends JFrame {
	 public JTableBasiqueAvecPanel() {
	        super();
	 
	        setTitle("Personnel Clinique");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        JTable tableau = new JTable(new ModeleDynamique());
	 
	        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

	        pack();
	    }
	 
	    public static void main(String[] args) {
	        new JTableBasiqueAvecPanel().setVisible(true);  
	    }
   
}
