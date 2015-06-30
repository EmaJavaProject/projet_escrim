package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * The Class Avion.
 */
public class Avion {
	
	/** The onglet avion. */
	private JPanel ongletAvion;
	
	/** The donnee avion. */
	private JPanel donneeAvion;
	
	/** The lbl donnee1. */
	private JLabel lblDonnee1;
	
	/** The lbl valeur1. */
	private JLabel lblValeur1;
	
	/** The lbl donnee2. */
	private JLabel lblDonnee2;
	
	/** The lbl valeur2. */
	private JLabel lblValeur2;
	
	/** The lbl transport. */
	private JLabel lblTransport;
	
	/** The combo box transport. */
	private JComboBox comboBoxTransport;
	
	/** The lbl configuration. */
	private JLabel lblConfiguration;
	
	/** The combo box configuration. */
	private JComboBox comboBoxConfiguration;
	
	/** The btn validation chargement. */
	private JButton btnValidationChargement;
	
	/** The liste caisse. */
	private JPanel listeCaisse;
	
	/** The caisse obligatoire. */
	private JPanel caisseObligatoire;
	
	/** The scroll pane edit chargement. */
	private JScrollPane scrollPaneEditChargement;
	
	/** The table caisse obligatoire. */
	private JTable tableCaisseObligatoire;
	
	/** The caisse optionnel. */
	private JPanel caisseOptionnel;
	
	/** The table caisse optionnelle. */
	private JTable tableCaisseOptionnelle;
	
	/** The validation. */
	private JPanel validation;
	
	/** The btn validation caisse. */
	private JButton btnValidationCaisse;
	
	/** The label valid modif. */
	private JLabel labelValidModif;
	
	/** The lbl new label_1. */
	private JLabel lblNewLabel_1;
	
	/** The lbl en compte. */
	private JLabel lblEnCompte;
	
	/** The btn exporter. */
	private JButton btnExporter;
	
	/** The panel plan chargement. */
	private JPanel panelPlanChargement;
	
	/**
	 * Instantiates a new avion.
	 *
	 * @param tabPrincipal the tab principal
	 */
	public Avion(JTabbedPane tabPrincipal) {
		this.InitPage(tabPrincipal);
	}
	
	/**
	 * Inits the page.
	 *
	 * @param tabPrincipal the tab principal
	 */
	private void InitPage(JTabbedPane tabPrincipal){
	
				lblDonnee1 = new JLabel("Donn\u00E9e 1 :");
				lblDonnee1.setHorizontalAlignment(SwingConstants.CENTER);
				
				lblValeur1 = new JLabel("Valeur");
				
				lblDonnee2 = new JLabel("Donn\u00E9e 2 :");
				lblDonnee2.setHorizontalAlignment(SwingConstants.CENTER);
				
				lblValeur2 = new JLabel("Valeur");
				
				lblTransport = new JLabel("Transport :");
				lblTransport.setBounds(219, 12, 70, 21);
		    		
				comboBoxTransport = new JComboBox();
				comboBoxTransport.setBounds(299, 12, 124, 21);

				lblConfiguration = new JLabel("configuration");
				lblConfiguration.setBounds(451, 12, 70, 21);

				comboBoxConfiguration = new JComboBox();
				comboBoxConfiguration.setBounds(531, 12, 124, 21);
				
				btnValidationChargement = new JButton("Valider");
				btnValidationChargement.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnValidationChargement.setBounds(688, 11, 89, 23);
			
				scrollPaneEditChargement = new JScrollPane();
				scrollPaneEditChargement.setBounds(10, 178, 177, 484);
				scrollPaneEditChargement.setViewportView(listeCaisse);
				
				tableCaisseObligatoire = new JTable();
				tableCaisseObligatoire.setBounds(0, 155, 175, -152);
				
				caisseObligatoire = new JPanel();
				caisseObligatoire.setLayout(null);
				caisseObligatoire.add(tableCaisseObligatoire);

				tableCaisseOptionnelle = new JTable();
				tableCaisseOptionnelle.setBounds(87, 5, 0, 0);
				
				caisseOptionnel = new JPanel();
				caisseOptionnel.setLayout(null);
				caisseOptionnel.add(tableCaisseOptionnelle);
				

				btnValidationCaisse = new JButton("Enregistrer");
				btnValidationCaisse.setBounds(43, 76, 89, 23);

				labelValidModif = new JLabel("Toutes modifications non");
				labelValidModif.setHorizontalAlignment(SwingConstants.CENTER);
				labelValidModif.setBounds(10, 11, 155, 23);
				
				lblNewLabel_1 = new JLabel(" valid\u00E9es ne seront pas prises");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(10, 34, 155, 14);
				
				lblEnCompte = new JLabel(" en compte");
				lblEnCompte.setHorizontalAlignment(SwingConstants.CENTER);
				lblEnCompte.setBounds(10, 51, 155, 14);
				
				btnExporter = new JButton("Export");
				btnExporter.setBounds(570, 602, 120, 31);
				
				panelPlanChargement = new JPanel();
				panelPlanChargement.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				panelPlanChargement.setBounds(219, 58, 533, 484);
				
				validation = new JPanel();
				validation.setLayout(null);
				validation.add(btnValidationCaisse);
				validation.add(labelValidModif);
				validation.add(lblNewLabel_1);
				validation.add(lblNewLabel_1);
				validation.add(lblEnCompte);
				
				listeCaisse = new JPanel();
				listeCaisse.setLayout(new GridLayout(0, 1, 0, 0));
				listeCaisse.add(caisseObligatoire);
				listeCaisse.add(validation);
				listeCaisse.add(caisseOptionnel);
				
				donneeAvion = new JPanel();
				donneeAvion.setBounds(10, 11, 177, 143);
				donneeAvion.setLayout(new GridLayout(0, 2, 0, 0));
				donneeAvion.add(lblDonnee1);
				donneeAvion.add(lblValeur1);
				donneeAvion.add(lblDonnee2);
				donneeAvion.add(lblValeur2);
				
				ongletAvion = new JPanel();
				ongletAvion.setLayout(null);
				ongletAvion.add(comboBoxTransport);
				ongletAvion.add(lblConfiguration);
				ongletAvion.add(btnValidationChargement);
				ongletAvion.add(panelPlanChargement);
				ongletAvion.add(btnExporter);
				ongletAvion.add(scrollPaneEditChargement);
				ongletAvion.add(comboBoxConfiguration);
				ongletAvion.add(lblTransport);
				ongletAvion.add(donneeAvion);	
			
				tabPrincipal.addTab("Avion", null, ongletAvion, null);
	}

}
