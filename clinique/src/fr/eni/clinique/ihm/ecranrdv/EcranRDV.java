/**
 * 
 */
package fr.eni.clinique.ihm.ecranrdv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import fr.eni.clinique.bll.AgendaMger;
import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsMger;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.client.EcranAjoutClient;
import fr.eni.clinique.ihm.client.EcranClients;
import fr.eni.clinique.ihm.gestionpersonnel.ModeleDynamique;

/**
 * Classe en charge de
 * 
 * @author frimajou2018
 * @date 23 juil. 2018 - 14:11:42 clinique - Version 1.0
 */
@SuppressWarnings("serial")
public class EcranRDV extends JFrame {

	private JComboBox<String> combClient, combAnimal, combVeto;
	private JLabel jlClient, jlAnimal, jlVeto, jlDate, jlH;
	private JButton btnAjoutClient, btnAjoutAnimal, btnValider, btnSupprimer;
	private AnimalMger mgr;
	private JPanel panelPour, panelPar, panelQuand, panelTable, panelBtn, panelFinal, panelNorth;

	public EcranRDV() {
		super("prise rdv");
		try {
			mgr = AnimalMger.getInstance();
		} catch (BLLException e) {
			e.printStackTrace();
			System.out.println("Aucun Client à afficher !");
		}

		initIHM();
	}

	private void initIHM() {

		// Panel Nord
		panelNorth = new JPanel();
		panelNorth.setLayout(new FlowLayout());
		panelNorth.setBackground(Color.GRAY);
		// Panel Final
		panelFinal = new JPanel();
		panelFinal.setOpaque(true);
		panelFinal.setLayout(new BorderLayout());
		panelFinal.setBackground(Color.lightGray);

		// Mise en place panel final
		panelNorth.add(getPanelPour());
		panelNorth.add(getPanelPar());
		panelNorth.add(getPanelQuand());
		panelFinal.add(panelNorth, BorderLayout.NORTH);
		panelFinal.add(getPanelTable(), BorderLayout.CENTER);
		panelFinal.add(getPanelBtn(), BorderLayout.SOUTH);
		this.setContentPane(panelFinal);
	}

	/**
	 * Fonction en charge du panel Quand
	 * 
	 * @retun le panel Quand
	 */
	public Component getPanelQuand() {
		GridBagConstraints gbc = new GridBagConstraints();
		panelQuand = new JPanel();
		panelQuand.setLayout(new GridBagLayout());
		panelQuand.setBackground(Color.lightGray);
		panelQuand.setPreferredSize(new Dimension(300, 150));
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelQuand.add(getJlDate(), gbc);
		gbc.gridy = 1;
		panelQuand.add(getJlH(), gbc);
		return panelQuand;
	}

	/**
	 * Fonction en charge du panel Par
	 * 
	 * @return le panel Par
	 */
	public Component getPanelPar() {
		GridBagConstraints gbc = new GridBagConstraints();
		panelPar = new JPanel();
		panelPar.setLayout(new GridBagLayout());
		panelPar.setBackground(Color.lightGray);
		panelPar.setPreferredSize(new Dimension(300, 150));
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelPar.add(getJlVeto(), gbc);
		gbc.gridy = 1;
		panelPar.add(getCombVeto(), gbc);
		return panelPar;
	}

	/**
	 * Fonction en charge du panel Pour
	 * 
	 * @param le
	 *            panel Pour
	 */
	public Component getPanelPour() {
		GridBagConstraints gbc = new GridBagConstraints();
		panelPour = new JPanel();
		panelPour.setLayout(new GridBagLayout());
		panelPour.setBackground(Color.lightGray);
		panelPour.setPreferredSize(new Dimension(300, 150));
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelPour.add(getJlClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelPour.add(getCombClient(), gbc);
		gbc.gridx = 1;
		gbc.gridx = 1;
		panelPour.add(getBtnAjoutClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelPour.add(getJlAnimal(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panelPour.add(getCombAnimal(), gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		panelPour.add(getBtnAjoutAnimal(), gbc);
		return panelPour;
	}

	public Component getPanelTable() {
		GridBagConstraints gbc = new GridBagConstraints();
		// panelTable.setLayout(new GridBagLayout());
		panelTable = new JPanel();
		panelTable.setBackground(Color.lightGray);
		panelTable.setPreferredSize(new Dimension(300, 150));

		return panelTable;

	}

	public Component getPanelBtn() {
		panelBtn = new JPanel();
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnValider());
		panelBtn.add(getBtnSupprimer());
		panelBtn.setBackground(Color.GRAY);
		return panelBtn;

	}

	public JComboBox<String> getCombClient() {
		combClient = new JComboBox<String>();
		combClient.addItem("Nom");
		combClient.setPreferredSize(new Dimension(200, 20));
		return combClient;
	}

	public JComboBox<String> getCombAnimal() {
		combAnimal = new JComboBox<String>();
		combAnimal.addItem("Animal");
		combAnimal.setPreferredSize(new Dimension(200, 20));
		return combAnimal;
	}

	public JComboBox<String> getCombVeto() {
		combVeto = new JComboBox<String>();
		combVeto.setPreferredSize(new Dimension(200, 20));
		combVeto.addItem("Veterinaire");
		return combVeto;
	}

	public JLabel getJlClient() {
		if (jlClient == null) {
			jlClient = new JLabel("Client");
		}
		return jlClient;
	}

	public JLabel getJlAnimal() {
		if (jlAnimal == null) {
			jlAnimal = new JLabel("Animal");
		}
		return jlAnimal;
	}

	public JLabel getJlVeto() {
		if (jlVeto == null) {
			jlVeto = new JLabel("Veterinaire");
		}
		return jlVeto;
	}

	public JLabel getJlDate() {
		if (jlDate == null) {
			jlDate = new JLabel("Date");
		}
		return jlDate;
	}

	public JLabel getJlH() {
		if (jlH == null) {
			jlH = new JLabel("Heure");
		}

		return jlH;
	}

	public JButton getBtnAjoutClient() {
		if (btnAjoutClient == null) {
			btnAjoutClient = new JButton("+");
		}
		return btnAjoutClient;
	}

	public JButton getBtnAjoutAnimal() {
		if (btnAjoutAnimal == null) {
			btnAjoutAnimal = new JButton("+");
		}
		return btnAjoutAnimal;
	}

	public JButton getBtnValider() {
		if (btnValider == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/saveBlanc.jpg")));
			btnValider = new JButton(image);
			btnValider.setToolTipText("Valider");

		}
		return btnValider;
	}

	public JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/annulerBlanc.jpg")));
			btnSupprimer = new JButton(image);
			btnSupprimer.setToolTipText("Annuler");

			btnSupprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnSupprimer;
	}

}