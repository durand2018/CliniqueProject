/**
 * 
 */
package fr.eni.clinique.ihm.ecranrdv;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.ihm.gestionpersonnel.EcranGestion;

/**
 * Classe en charge de l'affichage de l'ecran
 * @author frimajou2018
 * @date 23 juil. 2018 - 14:11:58
 * clinique - Version 1.0
 */
public class TestEcranRdv {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

		
		@Override
		public void run (){
			
		
			EcranRDV ecranRDV = new EcranRDV();
			
			ecranRDV.setVisible(true);
		
			}
	
		});
	}

}
