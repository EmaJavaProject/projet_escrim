package ihm;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import escrim.model.table.ColisTableModel;
import escrim.model.table.EscrimTableModel;

public class CreationDeColis {
	
	private static JPanel jpanelColis;
	private static JTable tableColis;
	private static JScrollPane scrollPanelColis;
	private static JTextField txtColis;
	private static ColisTableModel tblModelColis;
	private static JButton boutonAjouterColis;
	private static JButton boutonQuitter;
	private static JButton boutonSupprimerColis;
	private static JButton boutonModifierColis;
	private static JButton boutonValiderColis;
	private static JButton boutonAnnulerColis;
	private static JTabbedPane tabPrincipal;
	private static JPanel jpanelConfigurationHopital;
	private static JTextField txtConfigurationHopital;
	private static EscrimTableModel ConfigurationHopitalTableModel;
	private static JTable tableConfigurationHopital;
	private static JButton boutonAjouterConfigurationHopital;
	private static JButton boutonQuitterConfigurationHopital;
	private static JButton boutonSupprimerConfigurationHopital;
	private static JButton boutonModifierConfigurationHopital;
	private static JButton boutonValiderConfigurationHopital;
	private static JButton boutonAnnulerConfigurationHopital;
	private static JScrollPane scrollPanelConfigurationHopital;
	
	public static ActionListener CréationJpanelColis(
			JLayeredPane pPanelPrincipal) {

		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pPanelPrincipal != null) {

					for (Component composantPanelPrincipal : pPanelPrincipal
							.getComponents()) {
						for (Component composantsPanelPrincipal : composantPanelPrincipal
								.getParent().getComponents()) {

							if (composantsPanelPrincipal != null
									&& composantsPanelPrincipal.getName() != null
									&& composantsPanelPrincipal.getName()
											.equals("Création de colis")) {
								return;
							}
						}
					}
				}
				
				//------------------------------------ Jpanel conf hopital---------------------------//
				
				tableConfigurationHopital = new JTable();
				tableConfigurationHopital.setName("Table ConfigurationHopitals");
				tableConfigurationHopital.setBounds(12, 72, 899, 800);
				tableConfigurationHopital
						.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableConfigurationHopital.setCellSelectionEnabled(false);
				tableConfigurationHopital.setRowSelectionAllowed(true);

				boutonQuitterConfigurationHopital = new JButton("Quitter");
				boutonQuitterConfigurationHopital.setBounds(800, 13, 97, 25);
				boutonQuitterConfigurationHopital.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						for (Component composant : pPanelPrincipal
								.getComponents()) {
							if (composant.getName().equals("Création de colis"))
								pPanelPrincipal.remove(composant);
						}
						pPanelPrincipal.repaint();

					}
				});

				boutonAjouterConfigurationHopital = new JButton("+");
				boutonAjouterConfigurationHopital.setBounds(12, 589, 97, 25);

				boutonSupprimerConfigurationHopital = new JButton("-");
				boutonSupprimerConfigurationHopital.setBounds(121, 589, 97, 25);

				boutonModifierConfigurationHopital = new JButton("Editer");
				boutonModifierConfigurationHopital.setBounds(230, 589, 97, 25);

				boutonValiderConfigurationHopital = new JButton("Valider");
				boutonValiderConfigurationHopital.setBounds(340, 589, 97, 25);

				boutonAnnulerConfigurationHopital = new JButton("Annuler");
				boutonAnnulerConfigurationHopital.setBounds(450, 589, 97, 25);

				boutonValiderConfigurationHopital.setEnabled(false);
				boutonAnnulerConfigurationHopital.setEnabled(false);

				
				txtConfigurationHopital = new JTextField();
				txtConfigurationHopital.setHorizontalAlignment(SwingConstants.CENTER);
				txtConfigurationHopital.setEnabled(false);
				txtConfigurationHopital.setPreferredSize(new Dimension(20, 20));
				txtConfigurationHopital.setText("Gestion configuration d'hopitals");
				txtConfigurationHopital.setColumns(10);
				txtConfigurationHopital.setBounds(44, 11, 260, 25);
				
				scrollPanelConfigurationHopital = new JScrollPane();
				scrollPanelConfigurationHopital.setName("Scroll ConfigurationHopitals");
				scrollPanelConfigurationHopital.setViewportView(tableConfigurationHopital);
				scrollPanelConfigurationHopital.setBounds(12, 56, 800, 486);
				
				
				
				//------------------------------------ Jpanel Colis---------------------------//
				
				
				
				tblModelColis = new ColisTableModel();
				tableColis = new JTable(tblModelColis);
				tableColis.setName("Table Colis");
				tableColis.setBounds(12, 72, 899, 800);
				boutonQuitter = new JButton("Quitter");
				boutonQuitter.setBounds(800, 13, 97, 25);
				boutonQuitter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						for (Component composant : pPanelPrincipal
								.getComponents()) {
							if (composant.getName().equals("Création de colis"))
								pPanelPrincipal.remove(composant);
						}
						pPanelPrincipal.repaint();

					}
				});
					
				boutonAjouterColis = new JButton("+");
				boutonAjouterColis.setBounds(12, 589, 97, 25);

				boutonSupprimerColis = new JButton("-");
				boutonSupprimerColis.setBounds(121, 589, 97, 25);

				boutonModifierColis = new JButton("Editer");
				boutonModifierColis.setBounds(230, 589, 97, 25);

				boutonValiderColis = new JButton("Valider");
				boutonValiderColis.setBounds(340, 589, 97, 25);

				boutonAnnulerColis = new JButton("Annuler");
				boutonAnnulerColis.setBounds(450, 589, 97, 25);

				boutonValiderColis.setEnabled(false);
				boutonAnnulerColis.setEnabled(false);
				
				scrollPanelColis = new JScrollPane();
				scrollPanelColis.setName("Scroll Colis");
				scrollPanelColis.setViewportView(tableColis);
				scrollPanelColis.setBounds(12, 56, 950, 486);
				
				txtColis = new JTextField();
				txtColis.setHorizontalAlignment(SwingConstants.CENTER);
				txtColis.setEnabled(false);
				txtColis.setPreferredSize(new Dimension(20, 20));
				txtColis.setText("Gestion Colis");
				txtColis.setColumns(10);
				txtColis.setBounds(44, 11, 260, 25);
					
					
				
				// ---------------------------------------------création et
				// ajout des Jpanel dans le
				// Tabprincipal---------------------------------------------------//
				
				
				
				jpanelConfigurationHopital = new JPanel();
				jpanelConfigurationHopital.setBounds(0, 0, 1017, 706);
				jpanelConfigurationHopital.add(scrollPanelConfigurationHopital);
				jpanelConfigurationHopital.setName("Gestion configuration d'hopital");
				jpanelConfigurationHopital.setLayout(null);
				jpanelConfigurationHopital.add(txtConfigurationHopital);
				jpanelConfigurationHopital.add(boutonModifierConfigurationHopital);
				jpanelConfigurationHopital.add(boutonSupprimerConfigurationHopital);
				jpanelConfigurationHopital.add(boutonAjouterConfigurationHopital);
				jpanelConfigurationHopital.add(boutonQuitterConfigurationHopital);
				jpanelConfigurationHopital.add(boutonValiderConfigurationHopital);
				jpanelConfigurationHopital.add(boutonAnnulerConfigurationHopital);
				
				
				jpanelColis = new JPanel();
				jpanelColis.add(boutonModifierColis);
				jpanelColis.setBounds(0, 0, 1017, 706);
				jpanelColis.setName("Création De colis");
				jpanelColis.add(txtColis);
				jpanelColis.add(scrollPanelColis);
				jpanelColis.setLayout(null);
				jpanelColis.add(boutonQuitter);
				jpanelColis.add(boutonModifierColis);
				jpanelColis.add(boutonSupprimerColis);
				jpanelColis.add(boutonAjouterColis);
				jpanelColis.add(boutonValiderColis);
				jpanelColis.add(boutonAnnulerColis);
				
				tabPrincipal = new JTabbedPane();
				tabPrincipal.setName("Création de colis");
				tabPrincipal.setBounds(0, 0, 1017, 706);
				tabPrincipal.add(jpanelConfigurationHopital);
				tabPrincipal.add(jpanelColis);



				pPanelPrincipal.add(tabPrincipal, new Integer(2));
				pPanelPrincipal.revalidate();
				
				
		
			}

		};

		return action;

	}
			

				
}
