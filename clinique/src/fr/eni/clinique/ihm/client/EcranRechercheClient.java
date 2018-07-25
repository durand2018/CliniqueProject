/**
 * 
 */
package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsMger;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.gestionpersonnel.EcranGestion;

/**
 * Classe en charge de l'Ecran de Recherche Client
 * 
 * @author vmetayer2018
 * @date 24 juil. 2018 - 14:29:41 clinique - Version 1.0
 */
@SuppressWarnings("serial")
public class EcranRechercheClient extends JFrame {
	private JTextField jtRecherche;
	private JLabel jlAucuneSelection;
	private JPanel panelRecherche, panelResultat;
	private JButton btnRechercher;
	private ClientsMger mger;

	public EcranRechercheClient() {
		super("Résultat de la Recherche");
		initIHM();
	}

	public EcranRechercheClient(String saisie) {
		super("Résultat de la Recherche");
		initIHM(saisie);
	}

	private void initIHM() {
		panelRecherche = new JPanel();
		panelResultat = new JPanel();

		// panelRecherche.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelRecherche.add(getJtRecherche());
		// panelRecherche.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelRecherche.add(getBtnRechercher());

		panelResultat.setLayout(new BorderLayout());
		panelResultat.add(panelRecherche, BorderLayout.NORTH);
		panelResultat.add(getJlAucuneSelection(), BorderLayout.CENTER);

		// Changer Icone fenêtre
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/ico_veto.png"));
		this.setIconImage(image);

		// Lancer la fenêtre
		this.setContentPane(panelResultat);
	}

	private void initIHM(String saisie) {
		panelRecherche = new JPanel();
		panelResultat = new JPanel();
		JTable tabClt = new JTable(new ModeleTableClient(saisie));

		panelRecherche.add(getJtRecherche());
		panelRecherche.add(getBtnRechercher());
		jtRecherche.setText(saisie);
		jtRecherche.getFont().deriveFont(Font.PLAIN);
		jtRecherche.setForeground(Color.black);

		panelResultat.setLayout(new BorderLayout());
		panelResultat.add(panelRecherche, BorderLayout.NORTH);

		if (tabClt.getRowCount() == 0) {
			panelResultat.add(getJlAucuneSelection(), BorderLayout.CENTER);
		} else {
			panelResultat.add(tabClt, BorderLayout.CENTER);
		}

		// Changer Icone fenêtre
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/ico_veto.png"));
		this.setIconImage(image);

		// Lancer la fenêtre
		this.setContentPane(panelResultat);

		// Suivi clic sur liste client
		tabClt.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = 0;
				 i = tabClt.getSelectedRow();
				 System.out.println(i);
				try {
					// Récupère le client affiché
					mger = new ClientsMger();
					int idCltChoisi = mger.getClient(i).getCodeClient();
					System.out.println("idCltChoisi");
					System.out.println(idCltChoisi);
					Clients cltChoisi = mger.selectByCode(idCltChoisi);
					System.out.println(cltChoisi);
					// Ferme l'écran
					dispose();
					//Ouvre un nouvel écran client qui affiche le client choisi
					EcranClients ecranClt = new EcranClients(cltChoisi);
					ecranClt.setSize(new Dimension(1000,600));
					ecranClt.setVisible(true);
					ecranClt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (BLLException e1) {
					System.err.println("Probleme Selection Client recherché ");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
	}

	public JTextField getJtRecherche() {
		if (jtRecherche == null) {
			// jtRecherche = new JTextField(50);
			jtRecherche = new JTextField("nom du client");
			jtRecherche.setPreferredSize(new Dimension(300, 20));
			jtRecherche.getFont().deriveFont(Font.ITALIC);
			jtRecherche.setForeground(Color.gray);

			jtRecherche.addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JTextField jtRecherche = ((JTextField) e.getSource());
					if (jtRecherche.getText().equals("nom du client")) {
						jtRecherche.setText("");
						jtRecherche.getFont().deriveFont(Font.PLAIN);
						jtRecherche.setForeground(Color.black);
						jtRecherche.removeMouseListener(this);
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
		}
		return jtRecherche;
	}

	public JLabel getJlAucuneSelection() {
		if (jlAucuneSelection == null) {
			jlAucuneSelection = new JLabel("Aucun client sélectionné");
			jlAucuneSelection.setPreferredSize(new Dimension(100, 200));
			jlAucuneSelection.setHorizontalAlignment(SwingConstants.CENTER);
			jlAucuneSelection.setBorder(BorderFactory.createEtchedBorder());
		}
		return jlAucuneSelection;
	}

	public JButton getBtnRechercher() {
		if (btnRechercher == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/rechercherBlanc.jpg")));
			btnRechercher = new JButton(image);
			btnRechercher.setToolTipText("Rechercher");

			btnRechercher.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String nomPartiel = getJtRecherche().getText();
					System.out.println(nomPartiel);
					// Fermer écran précédent
					dispose();
					// Relancer un écran de recherche actualisé
					EcranRechercheClient ecranFind = new EcranRechercheClient(nomPartiel);
					ecranFind.setSize(new Dimension(700, 300));
					ecranFind.setVisible(true);
					ecranFind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				}
			});
		}
		return btnRechercher;
	}

}
