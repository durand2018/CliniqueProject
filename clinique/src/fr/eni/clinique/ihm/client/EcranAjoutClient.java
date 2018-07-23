package fr.eni.clinique.ihm.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EcranAjoutClient extends JFrame{
	private JButton btnValider, btnAnnuler;
	private JPanel panelAjoutClt, panelBtn;
	
	public EcranAjoutClient() {
		super("Ajouter Client");
		initIHMAjoutClt();
	}


	private void initIHMAjoutClt() {
		panelAjoutClt = new JPanel();
		panelBtn = new JPanel();
		PanelClient panClt = new PanelClient();
		
		panelAjoutClt.setOpaque(true);
		panelAjoutClt.setLayout(new BorderLayout());
		
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(getBtnValider());
		panelBtn.add(getBtnAnnuler());
		
		panelAjoutClt.add(panelBtn, BorderLayout.NORTH);
		panelAjoutClt.add(panClt.initIHM(), BorderLayout.CENTER);
		
		this.setContentPane(panelAjoutClt);
	}
	
	public JButton getBtnValider() {
		if(btnValider == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/saveBlanc.jpg")));
			btnValider = new JButton(image);
		}
		return btnValider;
	}


	public JButton getBtnAnnuler() {
		if(btnAnnuler == null){
			ImageIcon image = new ImageIcon(
					Toolkit.getDefaultToolkit().getImage(getClass().getResource("../../images/annulerBlanc.jpg")));
			btnAnnuler = new JButton(image);
		}
		return btnAnnuler;
	}
}
