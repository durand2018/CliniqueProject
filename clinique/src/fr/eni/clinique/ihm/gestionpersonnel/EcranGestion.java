package fr.eni.clinique.ihm.gestionpersonnel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.bo.Personnels;

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
		GridBagConstraints gbc = new GridBagConstraints();

		tableau = new JTable(new ModeleDynamique());
		panelTable.add(tableau);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.insets = new Insets(2, 2, 2, 2);
		gbc.fill = GridBagConstraints.WEST;
		panelBtn.add(getBtnAjouter(), gbc);

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
		this.setContentPane(panelFinal);

	}

	public JButton getBtnAjouter() {
		if (btnAjouter == null) {
			btnAjouter = new JButton("Ajouter");

			btnAjouter.addActionListener(new ActionListener() {
				EcranAjoutPers EcranAjout = new EcranAjoutPers();

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
			btnSupprimer = new JButton("Supprimer");

			btnSupprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int i = tableau.getSelectedRow();

					try {
						mgr.removePersonnel(i);
						dispose();

						EcranGestion EcranGestion = new EcranGestion();
						EcranGestion.setSize(new Dimension(800, 300));
						EcranGestion.setVisible(true);
						EcranGestion.pack();
						
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						System.err.println("probleme EcranGestion personnel non supprimé ");
						System.err.println("ou probleme errreur  base de donnée ");
					}

				}
			});

		}
		return btnSupprimer;
	}

	public JButton getBtnReinitialiser() {
		if (btnReinitialiser == null) {
			btnReinitialiser = new JButton("Reinitialiser");
			btnReinitialiser.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String mdp;
					mdp = JOptionPane.showInputDialog("saisir le nouveau mot de passe");
					if( mdp.isEmpty()){
						System.out.println("hey mdp = 0");
						JOptionPane.showMessageDialog(null, "echec réinitialisation", "entrez un mot de passe!bon dieu..",
								JOptionPane.ERROR_MESSAGE);
					}
					int i = tableau.getSelectedRow();
					try {
						Personnels p = new Personnels();
						p = mgr.getPersonnel(i);
						p.setMotPasse(mdp);
						mgr.updatePersonnel(p);
						dispose();

						EcranGestion EcranGestion = new EcranGestion();
						EcranGestion.setSize(new Dimension(1000, 500));
						EcranGestion.setVisible(true);
						EcranGestion.pack();
						EcranGestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
					} catch (BLLException e1) {
					
						JOptionPane.showMessageDialog(null, "echec réinitialisation", "mise a jour mot de passe",
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

	// TODO Auto-generated method stub

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
