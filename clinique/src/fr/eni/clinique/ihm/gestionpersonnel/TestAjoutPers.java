package fr.eni.clinique.ihm.gestionpersonnel;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TestAjoutPers {

		public static void main(String[] args) throws Throwable{
			SwingUtilities.invokeLater(new Runnable(){

			
			@Override
			public void run (){
				EcranAjoutPers ecranAjout = new EcranAjoutPers ();
				ecranAjout.setPreferredSize(new Dimension(800,600));
				ecranAjout.setVisible(true);
				ecranAjout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				}
			});
		

		}

	}