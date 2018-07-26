/**
 * 
 */
package fr.eni.clinique.ihm.rendezVous;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.ihm.MiseEnPage;

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
	@SuppressWarnings("unused")
	private AnimalMger mgr;
	private JPanel panelPour, panelPar, panelQuand, panelTable, panelBtn, panelFinal, panelNorth;
	private JLabel labelTravaux;

	public EcranRDV() {
		super("Prise de rendez-vous");
		MiseEnPage.getMiseEnPage();
		this.setLocation(280,200);
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

		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ico_veto.png"));
		this.setIconImage(image.getImage());

		// Lancer la fenêtre
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
		panelTable = new JPanel();
		panelTable.setBackground(Color.white);
		panelTable.setSize(new Dimension(300, 150));
		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("travaux_infos.jpg"));
		labelTravaux = new JLabel(image);
		panelTable.add(labelTravaux);

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
		combClient.setSize(new Dimension(200, 20));
		return combClient;
	}

	public JComboBox<String> getCombAnimal() {
		combAnimal = new JComboBox<String>();
		combAnimal.addItem("Animal");
		combAnimal.setSize(new Dimension(200, 20));
		return combAnimal;
	}

	public JComboBox<String> getCombVeto() {
		combVeto = new JComboBox<String>();
		combVeto.setSize(new Dimension(200, 20));
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
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("valider.png"));
			btnValider = new JButton(image);
			btnValider.setBackground(Color.white);
			btnValider.setToolTipText("Valider");

		}
		return btnValider;
	}

	public JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("sortir.png"));
			btnSupprimer = new JButton(image);
			btnSupprimer.setBackground(Color.white);
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