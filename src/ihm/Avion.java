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
	public Avion(JTabbedPane tabPrincipal) {
		this.InitPage(tabPrincipal);
	}
	
	private void InitPage(JTabbedPane tabPrincipal){

				JPanel ongletAvion = new JPanel();
				tabPrincipal.addTab("Avion", null, ongletAvion, null);
				ongletAvion.setLayout(null);

				// Il affiche obligatoirement un onglet avec le JPanel, voir pour
				// l'enlever ?
				JPanel donneeAvion = new JPanel();
				donneeAvion.setBounds(10, 11, 177, 143);
				ongletAvion.add(donneeAvion);
				donneeAvion.setLayout(new GridLayout(0, 2, 0, 0));

				JLabel lblDonnee1 = new JLabel("Donn\u00E9e 1 :");
				lblDonnee1.setHorizontalAlignment(SwingConstants.CENTER);
				donneeAvion.add(lblDonnee1);

				JLabel lblValeur1 = new JLabel("Valeur");
				donneeAvion.add(lblValeur1);

				JLabel lblDonne2 = new JLabel("Donn\u00E9e 2 :");
				lblDonne2.setHorizontalAlignment(SwingConstants.CENTER);
				donneeAvion.add(lblDonne2);

				JLabel lblValeur2 = new JLabel("Valeur");
				donneeAvion.add(lblValeur2);

				JLabel lblTransport = new JLabel("Transport :");
				lblTransport.setBounds(219, 12, 70, 21);
				ongletAvion.add(lblTransport);
		    		
				JComboBox comboBoxTransport = new JComboBox();
				comboBoxTransport.setBounds(299, 12, 124, 21);
				ongletAvion.add(comboBoxTransport);

				JLabel lblConfiguration = new JLabel("configuration");
				lblConfiguration.setBounds(451, 12, 70, 21);
				ongletAvion.add(lblConfiguration);

				JComboBox comboBoxConfiguration = new JComboBox();
				comboBoxConfiguration.setBounds(531, 12, 124, 21);
				ongletAvion.add(comboBoxConfiguration);

				JButton btnValidationChargement = new JButton("Valider");
				btnValidationChargement.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnValidationChargement.setBounds(688, 11, 89, 23);
				ongletAvion.add(btnValidationChargement);

				JScrollPane scrollPaneEditChargement = new JScrollPane();
				scrollPaneEditChargement.setBounds(10, 178, 177, 484);
				ongletAvion.add(scrollPaneEditChargement);

				JPanel listeCaisse = new JPanel();
				scrollPaneEditChargement.setViewportView(listeCaisse);
				listeCaisse.setLayout(new GridLayout(0, 1, 0, 0));

				JPanel caisseObligatoire = new JPanel();
				listeCaisse.add(caisseObligatoire);
				caisseObligatoire.setLayout(null);

				JTable tableCaisseObligatoire = new JTable();
				tableCaisseObligatoire.setBounds(0, 155, 175, -152);
				caisseObligatoire.add(tableCaisseObligatoire);

				JPanel caisseOptionnel = new JPanel();
				listeCaisse.add(caisseOptionnel);
				caisseOptionnel.setLayout(null);

				JTable tableCaisseOptionnelle = new JTable();
				tableCaisseOptionnelle.setBounds(87, 5, 0, 0);
				caisseOptionnel.add(tableCaisseOptionnelle);

				JPanel validation = new JPanel();
				listeCaisse.add(validation);
				validation.setLayout(null);

				JButton btnValidationCaisse = new JButton("Enregistrer");
				btnValidationCaisse.setBounds(43, 76, 89, 23);
				validation.add(btnValidationCaisse);

				JLabel labelValidModif = new JLabel("Toutes modifications non");
				labelValidModif.setHorizontalAlignment(SwingConstants.CENTER);
				labelValidModif.setBounds(10, 11, 155, 23);
				validation.add(labelValidModif);

				JLabel lblNewLabel_1 = new JLabel(" valid\u00E9es ne seront pas prises");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(10, 34, 155, 14);
				validation.add(lblNewLabel_1);

				JLabel lblEnCompte = new JLabel(" en compte");
				lblEnCompte.setHorizontalAlignment(SwingConstants.CENTER);
				lblEnCompte.setBounds(10, 51, 155, 14);
				validation.add(lblEnCompte);

				JButton btnExporter = new JButton("Export");
				btnExporter.setBounds(570, 602, 120, 31);
				ongletAvion.add(btnExporter);

				JPanel panelPlanChargement = new JPanel();
				panelPlanChargement.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				panelPlanChargement.setBounds(219, 58, 533, 484);
				ongletAvion.add(panelPlanChargement);
	}

}
