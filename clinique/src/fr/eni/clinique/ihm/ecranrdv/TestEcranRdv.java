/**
 * 
 */
package fr.eni.clinique.ihm.ecranrdv;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import fr.eni.clinique.bll.BLLException;

/**
 * Classe en charge de l'affichage de l'ecran
 * @author frimajou2018
 * @date 23 juil. 2018 - 14:11:58
 * clinique - Version 1.0
 */
public class TestEcranRdv {

	public static void main(String[] args) throws Throwable, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		SwingUtilities.invokeLater(new Runnable(){

		
		@Override
		public void run (){
			
		
			EcranRDV ecranRDV = null;
			try {
				ecranRDV = new EcranRDV ();
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ecranRDV.setSize(new Dimension(1000,500));
			ecranRDV.setVisible(true);
			ecranRDV.pack();
			ecranRDV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
	
		});
	}

}
