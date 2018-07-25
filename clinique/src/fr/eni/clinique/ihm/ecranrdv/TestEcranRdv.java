/**
 * 
 */
package fr.eni.clinique.ihm.ecranrdv;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import fr.eni.clinique.bll.BLLException;

/**
 * Classe en charge de l'affichage de l'ecran
 * 
 * @author frimajou2018
 * @date 23 juil. 2018 - 14:11:58 clinique - Version 1.0
 */
public class TestEcranRdv {

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

				EcranRDV ecranRDV = new EcranRDV();
				ecranRDV.setSize(new Dimension(1024, 768));
				ecranRDV.setVisible(true);

				ecranRDV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				ecranRDV.setVisible(true);

			}

		});
	}
}
