/**
 * 
 */
package fr.eni.clinique.ihm.ecranrdv;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import fr.eni.clinique.bll.AgendaMger;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.ihm.gestionpersonnel.ModeleDynamique;

/**
 * Classe en charge de
 * @author frimajou2018
 * @date 23 juil. 2018 - 14:11:42
 * clinique - Version 1.0
 */
public class EcranRDV extends JFrame {
	
	private JTextField jtRecherche;
	private JButton btnRecherche;
	private JTable tableResultat;
	private JPanel panelRech;
	private JPanel panelTable;
	private JPanel panelFinal;
	private AgendaMger mger = null;
//////////
	protected JTable tableau;
	

	public EcranRDV() throws BLLException {
		super();
		setSize(new Dimension(500,250));
		mger = AgendaMger.getInstance();
		initIHM();
}
	/**
	 * Fonction en charge d'oganiser la page
	 */
	private void initIHM() {
		
		panelRech = new JPanel();
		panelRech.setOpaque(true);
		panelRech.setLayout(new FlowLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		panelTable= new JPanel ();
	//	panelTable.add(tableau);
		tableau = new JTable(new ModeleDynamique());
		
		// premier panel
		panelRech.add(jtRecherche);
		panelRech.add(btnRecherche);
		this.setContentPane(panelRech);
		
	}
	public JTable getTableResultat() {
		if (tableResultat == null) {
			tableResultat = new JTable();
		}
		return tableResultat;
	}
	public void setTableResultat(JTable tableResultat) {
		this.tableResultat = tableResultat;
	}
	public JTextField getJtRecherche() {
		if (jtRecherche == null) {
			jtRecherche = new JTextField(20);
		}
		return jtRecherche;
	}
	public JButton getBtnRecherche() {
		if (btnRecherche == null) {
			btnRecherche = new JButton("rechercher");
		}
		return btnRecherche;
	}

	public JTable getTableau() {
		if (tableau == null) {
			tableau = new JTable();
		}
		return tableau;
	}
}