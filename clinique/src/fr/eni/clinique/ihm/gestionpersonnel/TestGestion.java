package fr.eni.clinique.ihm.gestionpersonnel;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

public class TestGestion {

	public static void main(String[] args)
			throws Throwable, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				EcranGestion EcranGestion = new EcranGestion();
				EcranGestion.setPreferredSize(new Dimension(800, 600));
				EcranGestion.setVisible(true);
				EcranGestion.pack();
				EcranGestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

		});
	}
}
