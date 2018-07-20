package fr.eni.clinique.ihm.client;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TestEcransClt {

	public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable(){

			
			@Override
			public void run (){
//				EcranAjoutClient ecranclt = new EcranAjoutClient ();
				EcranClients ecranclt = new EcranClients();
				ecranclt.setSize(new Dimension(500,500));
				ecranclt.setVisible(true);
				
				ecranclt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			});
		}
	}


