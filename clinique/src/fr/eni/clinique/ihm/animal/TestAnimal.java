package fr.eni.clinique.ihm.animal;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eni.clinique.bll.BLLException;

public class TestAnimal {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				EcranAnimaux monEcran;
				try {
					monEcran = new EcranAnimaux();
					monEcran.setSize(new Dimension(600, 400));
					monEcran.setVisible(true);

					monEcran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		});

	}

}
