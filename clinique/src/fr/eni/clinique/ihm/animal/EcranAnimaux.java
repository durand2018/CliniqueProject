package fr.eni.clinique.ihm.animal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsMger;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Race;
import fr.eni.clinique.ihm.client.EcranAjoutClient;
import fr.eni.clinique.ihm.client.EcranClients;
import fr.eni.clinique.ihm.client.PanelClient;

@SuppressWarnings("serial")
public class EcranAnimaux extends JFrame {

	private JPanel panelFinal, panelBtn, panelClt, panelChamps, panelItermediaire;
	private JLabel jlClient, jlCode, jlNom, jlCouleur, jlEspece, jlRace, jlTatoo;
	private JTextField jtClient, jtCode, jtNom, jtCouleur, jtTatoo;
	private JButton btnValider, btnAnnuler;
	private JComboBox<String> jcombSexe, jcombEspece, jcombRaces;
	private AnimalMger mgr;
	
	private int indexRace;
	public int getIndexRace() {
		return indexRace;
	}

	public void setIndexRace(int indexRace) {
		this.indexRace = indexRace;
	}

	public JPanel getPanelFinal() {
		return panelFinal;
	}

	public JPanel getPanelBtn() {
		return panelBtn;
	}

	public JPanel getPanelClt() {
		return panelClt;
	}

	public JPanel getPanelChamps() {
		return panelChamps;
	}

	public JPanel getPanelItermediaire() {
		return panelItermediaire;
	}

	public AnimalMger getMgr() {
		return mgr;
	}

	private int indexSexe;
	private int indexEspece;

	public int getIndexEspece() {
		return indexEspece;
	}

	public void setIndexEspece(int indexEspece) {
		this.indexEspece = indexEspece;
	}

	public int getIndexSexe() {
		return indexSexe;
	}

	public void setIndexSexe(int indexSexe) {
		this.indexSexe = indexSexe;
	}

	public EcranAnimaux() throws BLLException {
		super("Animaux");
		try {
			mgr = AnimalMger.getInstance();
		} catch (BLLException e) {
			e.printStackTrace();
			System.out.println("Aucun animal à afficher !");
		}
		initIHM();
	}

	public EcranAnimaux(int codeAnimal) {
		super("Animaux");
		try {
			mgr = AnimalMger.getInstance();
		} catch (BLLException e) {
			e.printStackTrace();
			System.out.println("Aucun animal à afficher !");
		}

		initIHM(codeAnimal);
		jtCode.setText(Integer.toString(mgr.getAnimal(codeAnimal).getCodeAnimal()));
		jtNom.setText(mgr.getAnimal(codeAnimal).getNomAnimal());
		jtCouleur.setText(mgr.getAnimal(codeAnimal).getCouleur());
		jcombSexe.setToolTipText(mgr.getAnimal(codeAnimal).getSexe());
		jcombEspece.setToolTipText(mgr.getAnimal(codeAnimal).getEspece());
		jcombRaces.setToolTipText(mgr.getAnimal(codeAnimal).getRace());
		jtTatoo.setText(mgr.getAnimal(codeAnimal).getTatouage());
		mgr.getAnimal(codeAnimal).getCodeClient();
	}

	private void initIHM() throws BLLException {
		panelFinal = new JPanel();
		panelItermediaire = new JPanel();
		panelBtn = new JPanel();
		panelClt = new JPanel();
		panelChamps = new JPanel();
		panelFinal.setOpaque(true);
		panelFinal.setLayout(new BorderLayout());
		panelFinal.setBackground(Color.lightGray);
		panelItermediaire.setOpaque(true);
		panelItermediaire.setLayout(new BorderLayout());
		panelItermediaire.setBackground(Color.lightGray);
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.setBackground(Color.lightGray);
		panelBtn.setPreferredSize(new Dimension(500, 50));
		panelClt.setLayout(new GridBagLayout());
		panelClt.setBackground(Color.lightGray);
		panelClt.setPreferredSize(new Dimension(500, 80));
		panelChamps.setLayout(new GridBagLayout());
		panelChamps.setBackground(Color.GRAY);
		panelChamps.setMaximumSize(new Dimension(750, 750));
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gbcp = new GridBagConstraints();

		/////////////////////////////////////////////////////// PanelBtn
		panelBtn.add(getBtnValider());
		panelBtn.add(getBtnAnnuler());
		gbc.insets = new Insets(5, 5, 5, 5);
		/////////////////////////////////////////////////////// PanelClt
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		panelClt.add(getJlClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelClt.add(getJtClient(), gbc);

		/////////////////////////////////////////////////////// PanelFields
		// ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		panelChamps.add(getJlCode(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtCode(), gbc);

		// ligne2

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		panelChamps.add(getJlNom(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtNom(), gbc);

		gbc.gridx = 4;
		gbc.gridwidth = 1;
		panelChamps.add(getJcombSexe(), gbc);

		// ligne3
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelChamps.add(getJlCouleur(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtCouleur(), gbc);

		// ligne4
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		panelChamps.add(getJlEspece(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 2;
		panelChamps.add(getJcombEspece(), gbc);

		gbc.gridx = 3;
		gbc.gridwidth = 1;
		panelChamps.add(getJlRace(), gbc);

		gbc.gridx = 4;
		panelChamps.add(getJcombRaces(), gbc);

		// ligne 5
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelChamps.add(getJlTatoo(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtTatoo(), gbc);

		// panels finaux

		panelFinal.add(panelBtn, BorderLayout.NORTH);
		panelItermediaire.add(panelClt, BorderLayout.NORTH);
		panelItermediaire.add(panelChamps, BorderLayout.CENTER);
		panelFinal.add(panelItermediaire, BorderLayout.CENTER);

		this.setContentPane(panelFinal);

	}

	private void initIHM(int codeAnimal) {
		panelFinal = new JPanel();
		panelItermediaire = new JPanel();
		panelBtn = new JPanel();
		panelClt = new JPanel();
		panelChamps = new JPanel();
		panelFinal.setOpaque(true);
		panelFinal.setLayout(new BorderLayout());
		panelFinal.setBackground(Color.lightGray);
		panelItermediaire.setOpaque(true);
		panelItermediaire.setLayout(new BorderLayout());
		panelItermediaire.setBackground(Color.lightGray);
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.setBackground(Color.lightGray);
		panelBtn.setPreferredSize(new Dimension(500, 50));
		panelClt.setLayout(new GridBagLayout());
		panelClt.setBackground(Color.lightGray);
		panelClt.setPreferredSize(new Dimension(500, 80));
		panelChamps.setLayout(new GridBagLayout());
		panelChamps.setBackground(Color.GRAY);
		panelChamps.setMaximumSize(new Dimension(750, 750));
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gbcp = new GridBagConstraints();

		/////////////////////////////////////////////////////// PanelBtn
		panelBtn.add(getBtnValider());
		panelBtn.add(getBtnAnnuler());
		gbc.insets = new Insets(5, 5, 5, 5);
		/////////////////////////////////////////////////////// PanelClt
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		panelClt.add(getJlClient(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelClt.add(getJtClient(), gbc);

		/////////////////////////////////////////////////////// PanelFields
		// ligne 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		panelChamps.add(getJlCode(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtCode(), gbc);

		// ligne2

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		panelChamps.add(getJlNom(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtNom(), gbc);

		gbc.gridx = 4;
		gbc.gridwidth = 1;
		panelChamps.add(getJcombSexe(), gbc);

		// ligne3
		gbc.gridx = 0;
		gbc.gridy = 2;
		panelChamps.add(getJlCouleur(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtCouleur(), gbc);

		// ligne4
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		panelChamps.add(getJlEspece(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 2;
		panelChamps.add(getJcombEspece(codeAnimal), gbc);

		gbc.gridx = 3;
		gbc.gridwidth = 1;
		panelChamps.add(getJlRace(), gbc);

		gbc.gridx = 4;
		panelChamps.add(getJcombRaces(codeAnimal), gbc);

		// ligne 5
		gbc.gridx = 0;
		gbc.gridy = 4;
		panelChamps.add(getJlTatoo(), gbc);

		gbc.gridx = 1;
		gbc.gridwidth = 3;
		panelChamps.add(getJtTatoo(), gbc);

		// panels finaux

		panelFinal.add(panelBtn, BorderLayout.NORTH);
		panelItermediaire.add(panelClt, BorderLayout.NORTH);
		panelItermediaire.add(panelChamps, BorderLayout.CENTER);
		panelFinal.add(panelItermediaire, BorderLayout.CENTER);

		this.setContentPane(panelFinal);

	}

	public JLabel getJlClient() {
		if (jlClient == null) {
			jlClient = new JLabel("Client ");
		}
		return jlClient;
	}

	public JLabel getJlCode() {
		if (jlCode == null) {
			jlCode = new JLabel("Code ");
		}
		return jlCode;
	}

	public JLabel getJlNom() {
		if (jlNom == null) {
			jlNom = new JLabel("Nom ");
		}
		return jlNom;
	}

	public JLabel getJlCouleur() {
		if (jlCouleur == null) {
			jlCouleur = new JLabel("Couleur ");
		}
		return jlCouleur;
	}

	public JLabel getJlEspece() {
		if (jlEspece == null) {
			jlEspece = new JLabel("Espèce ");
		}
		return jlEspece;
	}

	public JLabel getJlRace() {
		if (jlRace == null) {
			jlRace = new JLabel("Race ");
		}
		return jlRace;
	}

	public JLabel getJlTatoo() {
		if (jlTatoo == null) {
			jlTatoo = new JLabel("Tatouage ");
		}
		return jlTatoo;
	}

	public JTextField getJtClient() {
		if (jtClient == null) {
			jtClient = new JTextField(20);
			// Récupère le code client
			// Animaux codeClt = getJtClient().getCodeClient();
			// System.out.println(codeClt);

		}
		return jtClient;
	}

	public JTextField getJtCode() {
		if (jtCode == null) {
			jtCode = new JTextField(20);
		}
		return jtCode;
	}

	public JTextField getJtNom() {
		if (jtNom == null) {
			jtNom = new JTextField(20);
		}
		return jtNom;
	}

	public JTextField getJtCouleur() {
		if (jtCouleur == null) {
			jtCouleur = new JTextField(20);
		}
		return jtCouleur;
	}

	public JTextField getJtTatoo() {
		if (jtTatoo == null) {
			jtTatoo = new JTextField(20);
		}
		return jtTatoo;
	}

	public JButton getBtnValider() {
		if (btnValider == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/New24.gif")));
			btnValider = new JButton(image);
			btnValider.setToolTipText("Valider");

			btnValider.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// Recupere l'animal affiche

					try {
						Animaux aniAffiche = getAnimal();
						System.out.println(aniAffiche);
						// Sauvegarde un nouvel animal dans la BDD
						mgr = new AnimalMger();
						mgr.addAnimaux(aniAffiche);
						int c = aniAffiche.getCodeAnimal();
						// Ferme l'ecran
						dispose();
						// Ouvre un nouvel ecran client qui affiche le nouveau
						// animal
						EcranClients ecranClt = new EcranClients();
						ecranClt.setSize(new Dimension(1000, 600));
						ecranClt.setVisible(true);
						ecranClt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						} catch (BLLException e1) {
						JOptionPane.showConfirmDialog(EcranAnimaux.this, "Une erreur est survenue lors de l'Ajout");
						e1.printStackTrace();
					}
				}
			});
		}
		return btnValider;
	}

	public Animaux getAnimal() throws BLLException {

		Animaux AniCourant = new Animaux();
		AniCourant.setNomAnimal(getJtNom().getText());
		AniCourant.setCouleur(getJtCouleur().getText());
		// att
		AniCourant.setSexe(getJcombSexe().getItemAt(getIndexSexe()));
		AniCourant.setTatouage(getJtTatoo().getText());
		// att
		AniCourant.setEspece(getJcombEspece().getItemAt(getIndexEspece()));
		// att
		AniCourant.setRace(getJcombRaces().toString());
		System.out.println(AniCourant);
		return AniCourant;
	}

	public JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/New24.gif")));
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

	public JComboBox<String> getJcombSexe() {
		jcombSexe = new JComboBox<String>();
		jcombSexe.setPreferredSize(new Dimension(80, 20));
		jcombSexe.addItem("Mâle");
		jcombSexe.addItem("Femelle");
		jcombSexe.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				indexSexe = jcombSexe.getSelectedIndex();
				System.out.println(indexSexe);
				setIndexSexe(indexSexe);

			}
		});

		return jcombSexe;
	}

	public JComboBox<String> getJcombEspece() throws BLLException {
		jcombEspece = new JComboBox<String>();
		jcombEspece.setPreferredSize(new Dimension(150, 20));


		Iterator<Race> itR;
		try {
			itR = mgr.selectEspece().iterator();
			Race ra;
			while (itR.hasNext()) {
				ra = itR.next();
				jcombEspece.addItem(ra.getEspece());
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

		jcombEspece.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				indexEspece = jcombEspece.getSelectedIndex();
				setIndexEspece(indexEspece);
				System.out.println(getIndexEspece());

			}
		});
		return jcombEspece;
	}

	public JComboBox<String> getJcombEspece(int codeAnimal) {
		jcombEspece = new JComboBox<String>();
		jcombEspece.setPreferredSize(new Dimension(150, 20));
		jcombEspece.addItem(mgr.getAnimal(codeAnimal).getEspece());

		return jcombEspece;
	}

	public JComboBox<String> getJcombRaces() {
		jcombRaces = new JComboBox<String>();
		jcombRaces.setPreferredSize(new Dimension(150, 20));
		Iterator<Race> itR;
		String espece = null;

		try {
			itR = mgr.selectRaceByEspece(espece).iterator();
			Race ra;
			while (itR.hasNext()) {
				ra = itR.next();
				jcombRaces.addItem(ra.getRace());
				jcombRaces.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
					//	jcombRaces = jcombRaces.getSelectedIndex();*****************
						setIndexEspece(indexRace);
						System.out.println(getIndexEspece());
					}
				});
				
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

		return jcombRaces;
	}

	public JComboBox<String> getJcombRaces(String espece) {
		jcombRaces = new JComboBox<String>();
		jcombRaces.setPreferredSize(new Dimension(150, 20));
		Iterator<Race> itR;

		try {
			itR = mgr.selectRaceByEspece(espece).iterator();
			Race ra;
			while (itR.hasNext()) {
				ra = itR.next();
				jcombRaces.addItem(ra.getRace());
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

		return jcombRaces;
	}

	public JComboBox<String> getJcombRaces(int codeAnimal) {
		jcombRaces = new JComboBox<String>();
		jcombRaces.setPreferredSize(new Dimension(150, 20));
		jcombRaces.addItem(mgr.getAnimal(codeAnimal).getRace());

		return jcombRaces;

	}
}