package fr.eni.clinique.ihm.animal;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


@SuppressWarnings("serial")
public class testJtableAnimaux extends JFrame {
	
	public static void main(String[] args) {
        new testJtableAnimaux().setVisible(true);  
    }
	
	public testJtableAnimaux(){
		setTitle("Animaux Clinique");
		JTable tabAnimaux = new JTable(new ModeleTableAnimaux());
		getContentPane().add(new JScrollPane(tabAnimaux),BorderLayout.CENTER);
		pack();
	}

}
