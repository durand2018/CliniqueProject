package fr.eni.clinique.ihm.client;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
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
				
//				EcranClients ecranClt = new EcranClients();
//				ecranClt.setSize(new Dimension(1000,600));
//				ecranClt.setVisible(true);
//				ecranClt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				EcranRechercheClient ecranFind = new EcranRechercheClient();
				
				
				
				ecranFind.setSize(new Dimension(700,300));
				ecranFind.setVisible(true);
				ecranFind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				}
			});
		}
	}


