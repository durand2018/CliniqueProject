package fr.eni.clinique.ihm.animal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import fr.eni.clinique.bll.AnimalMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsMger;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.MiseEnPage;
import fr.eni.clinique.ihm.client.EcranAjoutClient;
import fr.eni.clinique.ihm.client.EcranClients;

@SuppressWarnings("serial")
public class PanelAnimalByClt extends JFrame {
	private JLabel jlTitre, jlAucunAni;
	private JButton btnAjouter, btnSupprimer, btnEditer;
	private JPanel panelBtn, panelAni;
	private AnimalMger amger;
	private JTable tabAni;

	public PanelAnimalByClt() {
		super();
		MiseEnPage.getMiseEnPage();
		initIHM();
	}

	public PanelAnimalByClt(int CodeClt) {
		super();
		MiseEnPage.getMiseEnPage();
		initIHM(CodeClt);
	}

	public Component initIHM() {
		panelAni = new JPanel();
		panelBtn = new JPanel();

		panelAni.setOpaque(true);
		panelAni.setLayout(new BorderLayout());

		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnAjouter());
		panelBtn.add(getBtnSupprimer());
		panelBtn.add(getBtnEditer());

		panelAni.add(getJlTitre(), BorderLayout.NORTH);
		panelAni.add(panelBtn, BorderLayout.SOUTH);
		panelAni.add(getJlAucunAni(), BorderLayout.CENTER);

		return panelAni;
	}

	public Component initIHM(int CodeClt) {
		panelAni = new JPanel();
		panelBtn = new JPanel();
		tabAni = new JTable(new ModeleTableAnimaux(CodeClt));

		panelAni.setOpaque(true);
		panelAni.setLayout(new BorderLayout());

		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnAjouter());
		panelBtn.add(getBtnSupprimer());
		panelBtn.add(getBtnEditer());

		panelAni.add(getJlTitre(), BorderLayout.NORTH);
		panelAni.add(panelBtn, BorderLayout.SOUTH);
		if (tabAni.getRowCount() == 0) {
			panelAni.add(getJlAucunAni(), BorderLayout.CENTER);
		} else {
			panelAni.add(tabAni, BorderLayout.CENTER);
		}

		return panelAni;
	}

	public JLabel getJlTitre() {
		if (jlTitre == null) {
			jlTitre = new JLabel("ANIMAUX DU CLIENT SELECTIONNE");
		}
		return jlTitre;
	}

	public JLabel getJlAucunAni() {
		if (jlAucunAni == null) {
			jlAucunAni = new JLabel("Aucun Animal");
			jlAucunAni.setPreferredSize(new Dimension(300, 200));
			jlAucunAni.setHorizontalAlignment(SwingConstants.CENTER);
			jlAucunAni.setBorder(BorderFactory.createEtchedBorder());
		}
		return jlAucunAni;
	}

	public JButton getBtnAjouter() {
		if (btnAjouter == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("ajouter.png"));
			btnAjouter = new JButton(image);
			btnAjouter.setToolTipText("Ajouter");
			
			btnAjouter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// Ouvre Ecran Animaux
					try {
						EcranAnimaux ecranAnimal;
						ecranAnimal = new EcranAnimaux();
						ecranAnimal.setSize(new Dimension(800, 600));
						ecranAnimal.setVisible(true);
						
					} catch (BLLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
			});
		}
		return btnAjouter;
	}

	public JButton getBtnSupprimer() {
		if (btnSupprimer == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("supprimer.png"));
			btnSupprimer = new JButton(image);
			btnSupprimer.setToolTipText("Supprimer");
			btnSupprimer.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// Keep select animal
					int idAs = tabAni.getSelectedRow();
					int idAniSelect = (int) tabAni.getValueAt(idAs, 0);
					System.out.println("ani sélectionné" + idAniSelect);
					
					try {
						//Crée une instance d'animal
						amger = new AnimalMger();
						amger.removeAnimal(idAniSelect);
						
//						//Relance l'écran vierge
//						EcranClients ecranClt = new EcranClients();
//						ecranClt.setSize(new Dimension(1000, 600));
//						ecranClt.setVisible(true);
					} catch (BLLException e1) {
						JOptionPane.showConfirmDialog(null,	"Une erreur est survenue lors de l'archivage");
						e1.printStackTrace();
					}
				}
			});
		}
		return btnSupprimer;
	}

	public JButton getBtnEditer() {
		if (btnEditer == null) {
			ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("editer.png"));
			btnEditer = new JButton(image);
			btnEditer.setToolTipText("Editer");
		}
		return btnEditer;
	}

}
