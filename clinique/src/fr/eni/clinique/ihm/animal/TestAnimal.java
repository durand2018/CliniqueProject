package fr.eni.clinique.ihm.animal;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import fr.eni.clinique.bll.BLLException;

public class TestAnimal {

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}

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
