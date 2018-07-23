package fr.eni.clinique.ihm.login;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginMger;
import fr.eni.clinique.bo.Personnels;
import fr.eni.clinique.ihm.accueil.EcranAccueil;

public class EcranLogin extends JFrame {
	private JLabel jlNom;
	private JTextField jtNom;
	private JLabel jlPNom;
	private JTextField jtPNom;
	private JLabel jlMdp;
	private JPasswordField jpMdp;
	private JButton btnValider;
	private LoginMger mger = null;
	private JPanel panel;
	public String codeRole;



	public EcranLogin() {
		super("Connexion");
		setSize(new Dimension(500,250));
		try {
			mger = LoginMger.getInstance();
		} catch (BLLException e) {
			System.out.println("Pb avec la fenêtre de connexion");
			System.exit(1);
		}
		initIHM();
	}

	private void initIHM() {
		panel = new JPanel();
		panel.setOpaque(true);

		panel.setLayout(new GridBagLayout());
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

		// ligne 3
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(getJlMdp(), gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.EAST;
		panel.add(getJpMdp(), gbc);

		// ligne 4
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.fill = GridBagConstraints.WEST;

		panel.add(getBtnValider(), gbc);

		this.setContentPane(panel);

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

	public JLabel getJlMdp() {
		if (jlMdp == null) {
			jlMdp = new JLabel("Mot de passe :");
		}
		return jlMdp;
	}

	public JTextField getJpMdp() {
		if (jpMdp == null) {
			jpMdp = new JPasswordField(20);
		}
		return jpMdp;
	}
	
	public String getCodeRole() {
		return codeRole;
	}

	public JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");

			btnValider.addActionListener(new ActionListener() {
				
				StringBuffer sb = new StringBuffer();
				@Override
				public void actionPerformed(ActionEvent e) {
					String nom = jtNom.getText();
					String prenom = jtPNom.getText();
					char[] mdp = jpMdp.getPassword();
					for(int i = 0; i<mdp.length;i++){
						sb.append(mdp[i]);
					}
					
					String userMdp = null;
					Boolean userExist = false;
					try {
						Iterator<Personnels> it = mger.getList().iterator();
						Personnels p;
						while (it.hasNext()) {
							p = it.next();
							if (p.getNom().equals(nom) && p.getPrenom().equals(prenom)) {
								userExist = true;
								userMdp = p.getMotPasse();
								codeRole = p.getRole();
								System.out.println(getCodeRole()+"  Ecranlogin");
							}
						}
						if (userExist == false) {
							JOptionPane.showMessageDialog(panel, "Utilisateur inconnu", "Connexion",
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if (userMdp.equals(sb.toString())) {
							EcranAccueil ecranAccueil = new EcranAccueil (EcranLogin.this);
							ecranAccueil.setSize(new Dimension(500,250));
							
							dispose();
							
							ecranAccueil.setVisible(true);
							
						} else {
							JOptionPane.showMessageDialog(panel, "Mot de Passe incorrect", "Connexion",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (BLLException e1) {
						
						System.out.println("Erreur connexion");
					}
				}

			});
		}
		return btnValider;
	}

}
