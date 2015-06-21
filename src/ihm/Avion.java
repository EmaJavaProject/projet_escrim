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

public class Avion {
	
	private JPanel ongletAvion;
	private JPanel donneeAvion;
	private JLabel lblDonnee1;
	private JLabel lblValeur1;
	private JLabel lblDonnee2;
	private JLabel lblValeur2;
	private JLabel lblTransport;
	private JComboBox comboBoxTransport;
	private JLabel lblConfiguration;
	private JComboBox comboBoxConfiguration;
	private JButton btnValidationChargement;
	private JPanel listeCaisse;
	private JPanel caisseObligatoire;
	private JScrollPane scrollPaneEditChargement;
	private JTable tableCaisseObligatoire;
	private JPanel caisseOptionnel;
	private JTable tableCaisseOptionnelle;
	private JPanel validation;
	private JButton btnValidationCaisse;
	private JLabel labelValidModif;
	private JLabel lblNewLabel_1;
	private JLabel lblEnCompte;
	private JButton btnExporter;
	private JPanel panelPlanChargement;
	
	public Avion(JTabbedPane tabPrincipal) {
		this.InitPage(tabPrincipal);
	}
	
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
