package fr.eni.clinique.ihm.accueil;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import fr.eni.clinique.ihm.MiseEnPage;
import fr.eni.clinique.ihm.agenda.EcranAgenda;
import fr.eni.clinique.ihm.client.EcranClients;
import fr.eni.clinique.ihm.gestionpersonnel.EcranGestion;
import fr.eni.clinique.ihm.login.EcranLogin;
import fr.eni.clinique.ihm.rendezVous.EcranRDV;

@SuppressWarnings("serial")
public class EcranAccueil extends JFrame {

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Fichier");
	private JMenu menu_2 = new JMenu("Gestion des RDV");
	private JMenuItem menu_3 = new JMenuItem("Agenda");
	private JMenuItem menu_4 = new JMenuItem("Gestion du Personnel");
	private JMenuItem menuItem = new JMenuItem("Deconnection");
	private JMenuItem menuItem1 = new JMenuItem("Fermer");
	private JMenuItem menuItem2 = new JMenuItem("Prise de RDV");
	private JMenuItem menuItem2b = new JMenuItem("Gestion des Clients");
	protected EcranLogin ecranLogin;

	public EcranAccueil(EcranLogin ecranLogin) {
		MiseEnPage.getMiseEnPage();
		// Changer Icone fenêtre
		ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ico_veto.png"));
		this.setIconImage(image.getImage());

		CardLayout CardL = new CardLayout();
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.DARK_GRAY);
		setTitle("Ecran d'accueil");
		this.setLocation(280,200);
		
		System.out.println("Lancement EcranAccueil");
		menuBar.add(menu);
		menuBar.add(menu_2);
		menuBar.add(menu_3);
		menuBar.add(menu_4, BorderLayout.EAST);

		menu.add(menuItem);
		menu.add(menuItem1);
		menu_2.add(menuItem2);
		menu_2.add(menuItem2b);

		setJMenuBar(menuBar);

		System.out.println(ecranLogin.getCodeRole());
		if (ecranLogin.getCodeRole().equals("VET")) {
			menu_2.setEnabled(false);
			menu_4.setEnabled(false);
		}
		if (ecranLogin.getCodeRole().equals("SEC")) {
			menu_3.setEnabled(false);
			menu_4.setEnabled(false);
		}
		panel1.setLayout(CardL);

		menu_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				EcranAgenda ecranAgenda = new EcranAgenda();

				ecranAgenda.setSize(new Dimension(800, 600));

				ecranAgenda.setVisible(true);
			}
		});

		menu_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				EcranGestion ecranGestion = new EcranGestion();
				ecranGestion.setSize(new Dimension(800, 600));
				ecranGestion.setVisible(true);
			}
		});

		// revenir a l'ecran login a l'action "deconnection"
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				EcranLogin ecranLogin2 = new EcranLogin();
				ecranLogin2.setSize(new Dimension(500, 250));
				dispose();
				ecranLogin2.setVisible(true);
			}
		});

		// fermer la fenetre a l'action "fermer"
		menuItem1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(DISPOSE_ON_CLOSE);

			}

		});

		menuItem2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				EcranRDV ecranRdv = new EcranRDV();

				ecranRdv.setSize(new Dimension(940, 720));

				ecranRdv.setVisible(true);
			}
		});

		menuItem2b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EcranClients ecranClt = new EcranClients();
				ecranClt.setSize(new Dimension(1000, 600));
				ecranClt.setVisible(true);
			}
		});
	}

}
