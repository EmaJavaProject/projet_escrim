package ihm;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Localisation {
	
	private JTable tableLocalContenuTop;
	private JTable tableLocalContenuBot;
	
	private JTable tableLocalConteneurTop;
	private JTable tableLocalConteneurBot;	
	private JTextField filtreRecherche;
	private JTabbedPane onglet;
	private JScrollPane scrollPaneContenu;
	private JPanel contenuLocalisation;
	private EscrimModelTable modelTableContenu;
	
	public Localisation(JTabbedPane tabPrincipal) {
		
		this.initPage(tabPrincipal);
		
	}

	private void initPage(JTabbedPane tabPrincipal) {
		
		onglet= new JTabbedPane(JTabbedPane.TOP);
		onglet.setBorder(null);
		onglet.setAlignmentY(Component.TOP_ALIGNMENT);
		onglet.setAlignmentX(Component.LEFT_ALIGNMENT);
		tabPrincipal.addTab("Localisation", null, onglet, null);


		contenuLocalisation = new JPanel();
		onglet.addTab("Contenu", null, contenuLocalisation, null);
		contenuLocalisation.setLayout(null);

		scrollPaneContenu = new JScrollPane();
		scrollPaneContenu.setBounds(52, 73, 706, 212);
	
		
		modelTableContenu = new EscrimModelTable();
		contenuLocalisation.add(scrollPaneContenu);
		
		tableLocalContenuTop = new JTable(modelTableContenu);
		tableLocalContenuTop.setBounds(62, 287, 706, 223);
		scrollPaneContenu.add(tableLocalContenuTop);
		scrollPaneContenu.setViewportView(tableLocalContenuTop);
		filtreRecherche = new JTextField();
		filtreRecherche.setBounds(504, 13, 177, 22);
		contenuLocalisation.add(filtreRecherche);
		filtreRecherche.setColumns(10);
		
		
		EscrimModelTable modelTableContenuLocalBot = new EscrimModelTable();
		tableLocalContenuBot = new JTable(modelTableContenuLocalBot);
		tableLocalContenuBot.setName("Caisse");
		tableLocalContenuBot.setModel(EscrimModelTable.BuildTableColumn(
				modelTableContenuLocalBot, tableLocalContenuBot.getName()));
		tableLocalContenuBot.getColumn(tableLocalContenuBot.getColumnName(0))
				.setMaxWidth(20);
		tableLocalContenuBot.setBounds(52, 324, 706, 223); //todo
		JScrollPane scrollPaneContenuLocalBot = new JScrollPane();
		scrollPaneContenuLocalBot.setBounds(52, 324, 706, 223);
		scrollPaneContenuLocalBot.add(tableLocalContenuBot);
		scrollPaneContenuLocalBot.setViewportView(tableLocalContenuBot);
		contenuLocalisation.add(scrollPaneContenuLocalBot);
		
		JComboBox<String> comboSelectContenuLocal = new JComboBox<String>();

		// Mise a jour de la JTable en fonction de la combobox
		comboSelectContenuLocal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (modelTableContenu.getColumnCount() != 0) {
					modelTableContenu.setColumnCount(0);
				}

				tableLocalContenuTop.setModel(EscrimModelTable.BuildTableColumn(
						modelTableContenu, comboSelectContenuLocal.getSelectedItem()
								.toString()));
				tableLocalContenuTop.getColumn(tableLocalContenuTop.getColumnName(0))
						.setMaxWidth(20);
				;
			}

		});
		comboSelectContenuLocal.addItem("Materiel");
		comboSelectContenuLocal.addItem("Médicaments");

		comboSelectContenuLocal.setBounds(121, 13, 136, 22);
		contenuLocalisation.add(comboSelectContenuLocal);
		filtreRecherche = new JTextField();
		filtreRecherche.setBounds(504, 13, 177, 22);
		contenuLocalisation.add(filtreRecherche);
		filtreRecherche.setColumns(10);


		JButton btnModifierContenu = new JButton("Modifier contenu");
		btnModifierContenu.setBounds(121, 612, 136, 25);
		contenuLocalisation.add(btnModifierContenu);

		JPanel conteneurLocalisation = new JPanel();
		onglet.addTab("Conteneur", null, conteneurLocalisation, null);
		conteneurLocalisation.setLayout(null);

		JButton btnNewButton = new JButton("Editer localisation");
		btnNewButton.setBounds(340, 279, 149, 25);
		conteneurLocalisation.add(btnNewButton);

		JComboBox<?> secteur = new JComboBox<Object>();
		secteur.setBounds(63, 29, 160, 22);
		conteneurLocalisation.add(secteur);

		tableLocalConteneurTop = new JTable();
		tableLocalConteneurTop.setBounds(12, 72, 899, 194);
		conteneurLocalisation.add(tableLocalConteneurTop);

		tableLocalConteneurBot = new JTable();
		tableLocalConteneurBot.setBounds(12, 357, 899, 194);
		conteneurLocalisation.add(tableLocalConteneurBot);
		//LOCAL CONTENEUR
		

				btnNewButton = new JButton("Editer localisation");
				btnNewButton.setBounds(340, 279, 149, 25);
				conteneurLocalisation.add(btnNewButton);

				secteur = new JComboBox<Object>();
				secteur.setName("");
				secteur.setBounds(75, 29, 160, 22);
				conteneurLocalisation.add(secteur);

				JScrollPane scrollPaneLocalConteneurTop = new JScrollPane();
				scrollPaneLocalConteneurTop.setBounds(12, 72, 899, 194);
				conteneurLocalisation.add(scrollPaneLocalConteneurTop);
				
				EscrimModelTable modelLocalConteneurTop = new EscrimModelTable();
				tableLocalConteneurTop = new JTable(modelLocalConteneurTop);
				tableLocalConteneurTop.setRowSelectionAllowed(true);
				tableLocalConteneurTop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableLocalConteneurTop.setCellSelectionEnabled(false);
				scrollPaneConteneur.setViewportView(tableLocalConteneurTop);
				
				
				JScrollPane scrollPaneLocalConteneurBot = new JScrollPane();
				scrollPaneLocalConteneurBot.setBounds(12, 357, 899, 194);
				conteneurLocalisation.add(scrollPaneLocalConteneurBot);
				
				JLabel lblSecteur = new JLabel("Secteur :");
				lblSecteur.setBounds(12, 32, 56, 16);
				conteneurLocalisation.add(lblSecteur);
				
				EscrimModelTable modelLocalConteneurBot = new EscrimModelTable();
				tableLocalConteneurBot = new JTable(modelLocalConteneurBot);
				tableLocalConteneurBot.setRowSelectionAllowed(true);
				tableLocalConteneurBot.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableLocalConteneurBot.setCellSelectionEnabled(false);
				scrollPaneConteneur.setViewportView(tableLocalConteneurBot);

	}
}
