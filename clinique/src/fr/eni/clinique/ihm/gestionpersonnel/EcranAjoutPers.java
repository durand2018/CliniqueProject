package fr.eni.clinique.ihm.gestionpersonnel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.bo.Personnels;

public class EcranAjoutPers extends JFrame {

	private JLabel jlNom;
	private JTextField jtNom;
	private JLabel jlPNom;
	private JTextField jtPNom;
	private JLabel jlMdp;
	private JTextField jtMdp;
	private JLabel jlRole;
	private JButton btnValider;
	private JPanel panel;
	private JPanel panelbtn;
	private Personnels p;

	private String Nom;
	private String Prenom;
	private String Role;
	private String MDP;
	protected LoginMger mgr;

	private JRadioButton rdbtnVET;
	private JRadioButton rdbtnSEC;
	private JRadioButton rdbtnADM;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	public EcranAjoutPers() {

		super("Ajouter Personnel");
		setSize(new Dimension(800, 600));
		try {
			mgr = LoginMger.getInstance();
		} catch (BLLException e) {
			System.out.println("Pb fenetre d'ajout personnel");
			System.exit(1);
		}
		initIHM();
	}

	//////////////////////////////////////////////////
	private void initIHM() {
		panel = new JPanel();
		panel.setOpaque(true);

		panel.setLayout(new GridBagLayout());

		panelbtn = new JPanel();
		panelbtn.setOpaque(true);
		panelbtn.setLayout(new FlowLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		// ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(2, 2, 2, 2);
		panel.add(getJlNom(), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(getJtNom(), gbc);

		// ligne 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;

		panel.add(getJlPNom(), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panel.add(getJtPNom(), gbc);
		panelbtn.add(getJlRole());

		// bouton VET
		
		panelbtn.add(getRdbtnVET());
		buttonGroup_1.add(rdbtnVET);

		// bouton SEC

		panelbtn.add(getRdbtnSEC());
		buttonGroup_1.add(rdbtnSEC);

		// bouton ADM
		panelbtn.add(getRdbtnADM());
		buttonGroup_1.add(rdbtnADM);


		panel.add(panelbtn);

		// ligne 4
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(getJlMdp(), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(getJtMdp(), gbc);

		// ligne 5
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.fill = GridBagConstraints.WEST;

		panel.add(getBtnValider(), gbc);
		this.setContentPane(panel);

	}

	//////////////////////////////////////////////////
	public JLabel getJlNom() {
		if (jlNom == null) {
			jlNom = new JLabel("Nom :");
		}
		return jlNom;
	}

	public JTextField getJtNom() {
		if (jtNom == null) {
			jtNom = new JTextField(20);
		}
		return jtNom;
	}

	public JLabel getJlPNom() {
		if (jlPNom == null) {
			jlPNom = new JLabel("Prenom :");
		}
		return jlPNom;
	}

	public JTextField getJtPNom() {
		if (jtPNom == null) {
			jtPNom = new JTextField(20);
		}
		return jtPNom;
	}

	public JLabel getJlMdp() {
		if (jlMdp == null) {
			jlMdp = new JLabel("Mdp :");
		}
		return jlMdp;
	}

	public JTextField getJtMdp() {
		if (jtMdp == null) {
			jtMdp = new JTextField(20);
		}
		return jtMdp;
	}

	public JLabel getJlRole() {
		if (jlRole == null) {
			jlRole = new JLabel("Role :");
		}
		return jlRole;
	}

	// public JTextField getJtRole() {
	// if (jtRole == null) {
	// jtRole = new JTextField(20);
	// }
	// return jtRole;
	// }

	public JRadioButton getRdbtnVET() {
		if (rdbtnVET == null) {
			rdbtnVET = new JRadioButton("VET");
		}
		return rdbtnVET;
	}

	public JRadioButton getRdbtnSEC() {
		if (rdbtnSEC == null) {
			rdbtnSEC = new JRadioButton("SEC");
		}
		return rdbtnSEC;
	}

	public JRadioButton getRdbtnADM() {
		if (rdbtnADM == null) {
			rdbtnADM = new JRadioButton("ADM");
		}
		return rdbtnADM;
	}

	// ajouter les données saisie a la base de donnée
	public JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valdier");
			btnValider.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// recupertation des valeur dans des variable
					Nom = jtNom.getText();
					Prenom = jtPNom.getText();
					if (rdbtnSEC.isSelected()) {
						Role = "SEC";
					} else if (rdbtnADM.isSelected()) {
						Role = "ADM";
					} else {
						Role = "VET";
					}

					MDP = jtMdp.getText();
					Personnels p = new Personnels(Nom, Prenom, MDP, Role, false);

					try {
						mgr.addPersonnel(p);
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						System.err.println("probleme ajout dans EcranAjouPers");
					}

					dispose();

					// afficher ecran de gestion a jour apres validation
					EcranGestion EcranGestion = new EcranGestion();
					EcranGestion.setSize(new Dimension(1000, 500));
					EcranGestion.setVisible(true);
					EcranGestion.pack();

					// test console
					System.out.println("Ajout d'de personnel");
					System.out.println(Nom);
					System.out.println(Prenom);
					System.out.println(Role);
					System.out.println(MDP);

				}
			});

		}
		return btnValider;
	}
}
