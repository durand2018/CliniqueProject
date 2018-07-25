/**
 * 
 */
package fr.eni.clinique.ihm;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * Classe en charge de
 * 
 * @author jdurand2018
 * @date 25 juil. 2018 - 15:28:15 clinique - Version 1.0
 */
public class MiseEnPage {

	/**
	 * Skin Nimbus pour l'IHM
	 * 
	 * @param
	 * @return 
	 */
	public static void getMiseEnPage() {
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
	}
	
}
