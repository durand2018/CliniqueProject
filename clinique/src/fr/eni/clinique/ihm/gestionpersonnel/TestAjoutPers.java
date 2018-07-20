package fr.eni.clinique.ihm.gestionpersonnel;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

public class TestAjoutPers {

		public static void main(String[] args) throws Throwable, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
			SwingUtilities.invokeLater(new Runnable(){

			
			@Override
			public void run (){
				EcranAjoutPers ecranAjout = new EcranAjoutPers ();
				ecranAjout.setSize(new Dimension(800,600));
				ecranAjout.setVisible(true);
				
				
				
				}
			});
		

		}

	}