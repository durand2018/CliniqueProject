package fr.eni.clinique.ihm.client;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TestEcransClt {

	public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable(){

			
			@Override
			public void run (){
//				EcranAjoutClient ecranAjclt = new EcranAjoutClient ();
//				ecranAjclt.setSize(new Dimension(500,600));
//				ecranAjclt.setVisible(true);
//				ecranAjclt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				EcranClients ecranClt = new EcranClients();
				ecranClt.setSize(new Dimension(1000,600));
				ecranClt.setVisible(true);
				ecranClt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				}
			});
		}
	}


