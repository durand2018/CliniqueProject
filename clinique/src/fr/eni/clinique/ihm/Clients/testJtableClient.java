package fr.eni.clinique.ihm.Clients;

import java.awt.BorderLayout;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class testJtableClient extends JFrame {
	 public testJtableClient() {
	        
	 
	        setTitle("Clients Clinique");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        JTable tableau = new JTable(new ModeleTableClient());
	 
	        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	        pack();
	    }
	 
	    public static void main(String[] args) {
	        new testJtableClient().setVisible(true);  
	    }
   
}
