package fr.eni.clinique.ihm.gestionpersonnel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.ihm.MiseEnPage;

@SuppressWarnings("serial")
public class EcranGestion extends JFrame {

	private JButton btnAjouter;
	private JButton btnSupprimer;
	private JButton btnReinitialiser;
	protected List<Personnels> liste;
	protected JTable tableau;
	protected LoginMger mgr;
	// private MouseListener click;

	public EcranGestion() {
		super();
		MiseEnPage.getMiseEnPage();
		this.setLocation(280,200);
		setTitle("Gestion du personnel");
		try {
			mgr = LoginMger.getInstance();
		} catch (BLLException e) {
			System.out.println("Pb fenetre d'ajout personnel");
			System.exit(1);
		}
		initIHM();
	}

	private void initIHM() {

		JPanel panelFinal = new JPanel();
		JPanel panelBtn = new JPanel();
		JPanel panelTable = new JPanel();
		panelFinal.setOpaque(true);
		panelFinal.setLayout(new BorderLayout());
		panelFinal.setBackground(Color.gray);
		GridBagConstraints gbc = new GridBagConstraints();

		tableau = new JTable(new ModeleDynamique());
		panelTable.add(tableau);
		panelTable.setBackground(Color.gray);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.insets = new Insets(2, 2, 2, 2);
		gbc.fill = GridBagConstraints.WEST;
		panelBtn.add(getBtnAjouter(), gbc);
		panelBtn.setBackground(Color.gray);
		panelBtn.setPreferredSize(new Dimension(500, 100));

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.fill = GridBagConstraints.WEST;
		panelBtn.add(getBtnSupprimer(), gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.fill = GridBagConstraints.WEST;
		panelBtn.add(getBtnReinitialiser(), gbc);

		// panelFinal.add(panelBtn);
		// panelFinal.add(panelTable);
		panelFinal.add(panelBtn, BorderLayout.NORTH);
		panelFinal.add(panelTable, BorderLayout.CENTER);

		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ico_veto.png"));
		this.setIconImage(image.getImage());

		// Lancer la fenêtre
		this.setContentPane(panelFinal);
	}

	public JButton getBtnAjouter() {
		if (btnAjouter == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ajouter.png"));
			btnAjouter = new JButton(image);
			btnAjouter.setBackground(Color.white);
			btnAjouter.setToolTipText("Valider");

			btnAjouter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					EcranAjoutPers EcranAjout = new EcranAjoutPers();
					EcranAjout.setSize(new Dimension(800, 600));
					dispose();
					EcranAjout.setVisible(true);
				}
			});
		}
		return btnAjouter;
	}

	public JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("supprimer.png"));
			btnSupprimer = new JButton(image);
			btnSupprimer.setBackground(Color.white);
			btnSupprimer.setToolTipText("Supprimer");

			btnSupprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					i = tableau.getSelectedRow();
					if (i == -1) {
						JOptionPane.showMessageDialog(null, "Selectionnez un membre du personnel",
								"suppression d'un client", JOptionPane.WARNING_MESSAGE);
						return;
					}
					try {
						mgr.removePersonnel(i);

						dispose();
						EcranGestion EcranGestion = new EcranGestion();
						EcranGestion.setSize(new Dimension(800, 600));
						EcranGestion.setVisible(true);

					} catch (BLLException e1) {
						System.err.println("probleme EcranGestion personnel non supprimé ");
						System.err.println("ou probleme errreur  base de donn�e ");
					}
				}
			});
		}
		return btnSupprimer;
	}

	public JButton getBtnReinitialiser() {
		if (btnReinitialiser == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("cadena.png"));
			btnReinitialiser = new JButton(image);
			btnReinitialiser.setBackground(Color.white);
			btnReinitialiser.setToolTipText("Reinitialiser");
			
			btnReinitialiser.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String mdp;
					mdp = JOptionPane.showInputDialog("Saisir le nouveau mot de passe");

					int i = 0;
					i = tableau.getSelectedRow();
					if (i == -1) {
						JOptionPane.showMessageDialog(null, "Sectionnez un membre du personnel",
								"Réinitialisation mot de passe", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if (mdp.isEmpty()) {
						System.out.println("Hey mdp = 0");
						JOptionPane.showMessageDialog(null, "Entrez un mot de passe!", "Echec réinitialisation",
								JOptionPane.ERROR_MESSAGE);
					}

					try {
						Personnels p = new Personnels();
						try {
							p = mgr.getPersonnel(i);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						p.setMotPasse(mdp);
						mgr.updatePersonnel(p);
						dispose();

						EcranGestion EcranGestion = new EcranGestion();
						EcranGestion.setSize(new Dimension(800, 600));
						EcranGestion.setVisible(true);

					} catch (BLLException e1) {

						JOptionPane.showMessageDialog(null, "Echec réinitialisation", "Mise a jour mot de passe",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnReinitialiser;
	}

	public List<Personnels> getListe() {
		return liste;
	}

}

// Méthode appelée lorsque l'on presse le bouton gauche de la souris
// public void mousePressed(MouseEvent event) {
// int i = tableau.getSelectedRow();
// System.out.println("ligne selectionné"+i);
// }
//
// public void MousePressed(MouseEvent e) {

// int i = tableau.getSelectedRow();
// System.out.println("ligne selectionné"+i);
// }
