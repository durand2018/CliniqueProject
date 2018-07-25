package fr.eni.clinique.ihm.animal;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TestAnimal {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				EcranAnimaux monEcran = new EcranAnimaux();
				monEcran.setSize(new Dimension(600, 400));
				monEcran.setVisible(true);

				monEcran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

		});

	}

}
