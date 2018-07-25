package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class testJtableClient extends JFrame {
	 public testJtableClient() {
	        
	 
	        setTitle("Clients Clinique");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        JTable tableau = new JTable(new ModeleTableClient("Spe"));
	        //Permet d'ordrer sur en-tête colonne
	        tableau.setAutoCreateRowSorter(true);
	 
	        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
	        pack();
	    }
	 
	    public static void main(String[] args) {
	        new testJtableClient().setVisible(true);  
	    }
   
}
