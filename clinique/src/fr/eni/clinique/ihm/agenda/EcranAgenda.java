/**
 * 
 */
package fr.eni.clinique.ihm.agenda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eni.clinique.ihm.MiseEnPage;

/**
 * Classe en charge de
 * 
 * @author jdurand2018
 * @date 25 juil. 2018 - 16:32:35 clinique - Version 1.0
 */
@SuppressWarnings("serial")
public class EcranAgenda extends JFrame {

	private JPanel panelFinal, panelTable;
	private JLabel labelTravaux;

	public EcranAgenda() {
		super("Agenda");
		MiseEnPage.getMiseEnPage();

		initIHM();
	}

	private void initIHM() {
		panelFinal = new JPanel();
		panelFinal.setOpaque(true);
		panelFinal.setLayout(new BorderLayout());
		panelFinal.setBackground(Color.lightGray);
		
		panelFinal.add(getPanelTable(), BorderLayout.CENTER);

		// Lancer la fenêtre
		 this.setContentPane(panelFinal);
	}

	public Component getPanelTable() {
		panelTable = new JPanel();
		panelTable.setBackground(Color.lightGray);
		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("travaux_infos.jpg"));
		labelTravaux = new JLabel(image);
		panelTable.add(labelTravaux);

		return panelTable;

	}

}
