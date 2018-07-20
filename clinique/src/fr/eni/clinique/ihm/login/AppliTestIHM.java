package fr.eni.clinique.ihm.login;


import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

public class AppliTestIHM {

		public static void main(String[] args) throws Throwable, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
			SwingUtilities.invokeLater(new Runnable(){

			
			@Override
			public void run (){
				EcranLogin ecranLogin = new EcranLogin ();
				ecranLogin.setSize(new Dimension(500,250));
				ecranLogin.setVisible(true);
				
				ecranLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			});
		}
	}
