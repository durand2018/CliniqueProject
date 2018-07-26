package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsMger;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.MiseEnPage;
import fr.eni.clinique.ihm.animal.PanelAnimalByClt;

@SuppressWarnings("serial")
public class EcranClients extends JFrame {
	// private JLabel logo;
	private JButton btnValider, btnAnnuler, btnAjouter, btnSupprimer, btnRechercher;
	private JPanel panelClt, panelBtn, panelBas;
	private PanelClient panClt;
	private ClientsMger mger;

	public EcranClients() {
		super("Clients");
		MiseEnPage.getMiseEnPage();
		initIHM();
	}

	public EcranClients(Clients c) {
		super("Clients");
		MiseEnPage.getMiseEnPage();
		initIHMavecClt(c);
	}

	private void initIHM() {
		panelClt = new JPanel();
		panelBtn = new JPanel();
		panelBas = new JPanel();
		PanelAnimalByClt panAni = new PanelAnimalByClt();

		panelBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
		// panelBtn.add(getLogo());
		panelBtn.add(getBtnRechercher());
		panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelBtn.add(getBtnAjouter());
		panelBtn.add(getBtnSupprimer());
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnValider());
		panelBtn.add(getBtnAnnuler());

		panelBas.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelBas.add(getPanClt().initIHM());
		gbc.gridx = 1;
		panelBas.add(panAni.initIHM());

		panelClt.setBackground(Color.gray);
		panelClt.add(panelBtn, BorderLayout.NORTH);
		panelClt.add(panelBas, BorderLayout.CENTER);

		// Changer Icone fenêtre
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/ico_veto.png"));
		this.setIconImage(image);

		// Lancer la fenêtre
		this.setContentPane(panelClt);
	}

	private void initIHMavecClt(Clients c) {
		panelClt = new JPanel();
		panelBtn = new JPanel();
		panelBas = new JPanel();
		PanelAnimalByClt panAni = new PanelAnimalByClt();

		panelBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelBtn.add(getBtnRechercher());
		panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelBtn.add(getBtnAjouter());
		panelBtn.add(getBtnSupprimer());
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnValider());
		panelBtn.add(getBtnAnnuler());

		panelBas.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelBas.add(getPanClt(c).initIHM());
		gbc.gridx = 1;
		panelBas.add(panAni.initIHM(c.getCodeClient()));

		panelClt.setBackground(Color.gray);
		panelClt.add(panelBtn, BorderLayout.NORTH);
		panelClt.add(panelBas, BorderLayout.CENTER);

		this.setContentPane(panelClt);
	}

	public PanelClient getPanClt() {
		if (panClt == null) {
			panClt = new PanelClient();
		}
		return panClt;
	}

	public PanelClient getPanClt(Clients client) {
		if (panClt == null) {
			panClt = new PanelClient(client);
		}
		return panClt;
	}

	public JButton getBtnValider() {
		if (btnValider == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/valider.png")));
			btnValider = new JButton(image);
			btnValider.setToolTipText("Valider");
		
			btnValider.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// Récupère le client affiché
					Clients cltAffiche = getPanClt().getClient();
					//System.out.println(getPanClt().getCodeCltAffiche());
					
					//System.out.println(cltAffiche);
					try {
						// Sauvegarde un nouveau client dans la BDD
						mger = new ClientsMger();
						mger.updateClient(cltAffiche);
						
					} catch (BLLException e1) {
						JOptionPane.showMessageDialog(EcranClients.this, "Une erreur est survenue lors de la Mise à jour");
						e1.printStackTrace();
					}
				}
			});
		}
		return btnValider;
	}

	public JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/annuler.png")));
			btnAnnuler = new JButton(image);
			btnAnnuler.setToolTipText("Annuler");

			btnAnnuler.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnAnnuler;
	}

	public JButton getBtnAjouter() {
		if (btnAjouter == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/ajouter.png")));
			btnAjouter = new JButton(image);
			btnAjouter.setToolTipText("Ajouter");

			btnAjouter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// Ouvre Ecran AjoutClient
					EcranAjoutClient ecranAjclt = new EcranAjoutClient();
					ecranAjclt.setSize(new Dimension(500, 600));
					ecranAjclt.setVisible(true);
					dispose();
					ecranAjclt.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				}
			});
		}
		return btnAjouter;
	}

	public JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/supprimer.png")));
			btnSupprimer = new JButton(image);
			btnSupprimer.setToolTipText("Supprimer");

			btnSupprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// Récupère le client affiché
					Clients cltAffiche = getPanClt().getClient();
					try {
						mger.removeClient(cltAffiche.getCodeClient());
					} catch (BLLException e1) {
						JOptionPane.showConfirmDialog(EcranClients.this,
								"Une erreur est survenue lors de la suppression");
						e1.printStackTrace();
					}
				}
			});
		}
		return btnSupprimer;
	}

	public JButton getBtnRechercher() {
		if (btnRechercher == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/loupe.png")));
			btnRechercher = new JButton(image);
			btnRechercher.setToolTipText("Rechercher");

			btnRechercher.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Clients cltAffiche = getPanClt().getClient();
					String nomPartiel = cltAffiche.getNomClient();
					System.out.println(nomPartiel);
					try {
						mger = ClientsMger.getInstance();
						List<Clients> filtreClt = mger.rechercherClt(nomPartiel);

						int i = filtreClt.size();
						System.out.println(i);
						// Ferme Ecran
						dispose();

						if (i == 1) {
							// Relance Ecran avec le client trouvé
							EcranClients ecranClt = new EcranClients(cltAffiche);
							ecranClt.setSize(new Dimension(1000, 600));
							ecranClt.setVisible(true);
							ecranClt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}
						if (i > 1) {
							// Relance Ecran avec le client trouvé
							EcranRechercheClient ecranRecherche = new EcranRechercheClient();
							ecranRecherche.setSize(new Dimension(700, 300));
							ecranRecherche.setVisible(true);
							ecranRecherche.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}
					} catch (BLLException e1) {
						JOptionPane.showMessageDialog(EcranClients.this,
								"Une erreur est survenue lors de la recherche");
						e1.printStackTrace();
					}
				}
			});
		}
		return btnRechercher;
	}

	// public JLabel getLogo() {
	// if(logo == null){
	// ImageIcon image = new ImageIcon(
	// Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/ico_veto.png")));
	// logo.setIcon(image);
	// }
	// return logo;
	// }

}
