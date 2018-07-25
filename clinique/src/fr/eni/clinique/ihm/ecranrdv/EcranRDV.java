/**
 * 
 */
package fr.eni.clinique.ihm.ecranrdv;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import fr.eni.clinique.bll.AgendaMger;
import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.ihm.gestionpersonnel.ModeleDynamique;

/**
 * Classe en charge de
 * @author frimajou2018
 * @date 23 juil. 2018 - 14:11:42
 * clinique - Version 1.0
 */
@SuppressWarnings("serial")
public class EcranRDV extends JFrame {
	
	private JComboBox<String> combClient, combAnimal, combVeto;
	private JLabel jlClient,jlAnimal,jlVeto,jlDate,jlH;
	private JButton btnAjoutClient, btnAjoutAnimal,btnValider,btnSupprimer;
	private AnimalMger mgr;
	private JPanel panelPour, panelPar, PanelQuand,panelTable,
					panelBtn,panelFinal;
	
	public EcranRDV() {
		super("prise rdv");
		try {
			mgr = AnimalMger.getInstance();
		} catch (BLLException e) {
			e.printStackTrace();
			System.out.println("Aucun animal à afficher !");
		}

		initIHM();
	}
	
	private void initIHM() {
		
		panelPour = new JPanel();
		panelPar = new JPanel();
		PanelQuand = new JPanel();
		panelTable = new JPanel();
		panelBtn = new JPanel();
		panelFinal = new JPanel();
		panelPour.setOpaque(true);
		panelPour.setLayout(new FlowLayout());
	//	GridBagConstraints gbc = new GridBagConstraints();
		panelPour.add(combClient);
		this.setContentPane(panelPour);
	}
//		
//		
//		panelPour.add(combClient);
//		panelPour.add(jlAnimal);
//		panelPour.add(combAnimal);
//		panelPour.add(btnAjoutClient);
//		panelPour.add(btnAjoutAnimal);
		
//***************************************************panelPour*******
// client
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		gbc.insets = new Insets(5, 5, 5, 5);
//		panelPour.add(getJlClient());
		
//		gbc.gridx = 0;
//		gbc.gridy = 1;
	
		
		




	public JComboBox<String> getCombClient() {
		combClient = new JComboBox<String>();
		combClient.addItem("nom");
		return combClient;
	}
//	public JComboBox<String> getCombAnimal() {
//		combAnimal = new JComboBox<String>();
//		combAnimal.setPreferredSize(new Dimension(50, 20));
//		combAnimal.addItem("Animal");
//		return combAnimal;
//	}
//	public JComboBox<String> getCombVeto() {
//		combVeto = new JComboBox<String>();
//		combVeto.setPreferredSize(new Dimension(50, 20));
//		combVeto.addItem("veterinaire");
//		return combVeto;
//	}
	public JLabel getJlClient() {
		if (jlClient == null) {
			jlClient = new JLabel("Client");
		}
		return jlClient;
	}
//	public JLabel getJlAnimal() {
//		if (jlAnimal == null) {
//			jlAnimal = new JLabel("Animal");
//		}
//		return jlAnimal;
//	}
//	public JLabel getJlVeto() {
//		if (jlVeto == null) {
//			jlVeto = new JLabel("Veterinaire");
//		}
//		return jlVeto;
//	}
//	public JLabel getJlDate() {
//		if (jlDate == null) {
//			jlDate = new JLabel("Date");
//		}
//		return jlDate;
//	}
//	public JLabel getJlH() {
//		if (jlH == null) {
//			jlH = new JLabel("H");
//		}
//		
//		return jlH;
//	}
//	public JButton getBtnAjoutClient() {
//		if (btnAjoutClient == null) {
//			btnAjoutClient = new JButton("+");
//		}
//		return btnAjoutClient;
//	}
//	public JButton getBtnAjoutAnimal() {
//		if (btnAjoutAnimal == null) {
//			btnAjoutAnimal = new JButton("+");
//		}
//		return btnAjoutAnimal;
//	}
//	public JButton getBtnValider() {
//		if (btnValider == null) {
//			btnValider = new JButton("Valider");
//		}
//		return btnValider;
//	}
//	public JButton getBtnSupprimer() {
//		if (btnValider == null) {
//			btnValider = new JButton("Supprimer");
//		}
//		return btnSupprimer;
//	}
	

}