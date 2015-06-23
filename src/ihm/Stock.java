package ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import escrim.manager.GestionPersistance;
import escrim.metiers.Materiel;
import escrim.metiers.Metier;

public class Stock {

	private JTable tableConteneur;
	private JTable tableContenu;
	private JTabbedPane ongletStock;
	private JPanel contenuStock;
	private JScrollPane scrollPaneContenu;
	private EscrimTableModel modelTableContenu;
	private JButton btnAjouterStock;
	private JButton btnSupprimerStock;
	private JButton btnEditerStock;
	private JButton btnLocaliserStock;
	private JLabel lblMessageDerreur;
	private JButton btnValiderStockContenu;
	private JButton btnAnnulerContenuStock;
	private JButton btnSupprimerStockContenu;
	private JButton btnEditerStockContenu;
	private JButton btnLocaliserStockContenu;
	private JComboBox<String> comboSelectContenu;
	private JPanel conteneurStock;
	private JComboBox<?> comboSelectConteneur;
	private JScrollPane scrollPaneConteneur;
	private EscrimTableModel modelTableConteneur;
	private JButton btnAjouterStockConteneur;
	private JButton btnSupprimerStockConteneur;
	private JButton btnValiderStockConteneur;
	private JButton btnAnnulerConteneurStock;
	private JButton btnEditerStockConteneur;
	private JButton btnLocaliserStockConteneur;

	public Stock(JTabbedPane tabPrincipal) {
		this.initPage(tabPrincipal);
	}

	private void initPage(JTabbedPane tabPrincipal) {

	
//		modelTableContenu = new EscrimModelTable();
		tableContenu = new JTable(modelTableContenu);
		tableContenu.setRowSelectionAllowed(true);
		tableContenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableContenu.setCellSelectionEnabled(false);

		btnAjouterStock = new JButton("+");
		btnAjouterStock.addMouseListener(mouseAdapterAjouterStock());
		btnAjouterStock.setBounds(12, 589, 97, 25);
		btnAjouterStock.addActionListener(actionAjouterStock());

		btnSupprimerStock = new JButton("-");
		btnSupprimerStock.setBounds(121, 589, 97, 25);

		btnEditerStock = new JButton("Editer");
		btnEditerStock.setBounds(230, 589, 97, 25);
		
		btnLocaliserStock = new JButton("Localiser");
		btnLocaliserStock.setBounds(339, 589, 97, 25);
		
		lblMessageDerreur = new JLabel("");
		lblMessageDerreur.setVerticalAlignment(SwingConstants.TOP);
		lblMessageDerreur.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessageDerreur.setEnabled(true);
		lblMessageDerreur.setForeground(Color.RED);
		lblMessageDerreur.setBounds(644, 594, 265, 50);


		
		btnValiderStockContenu = new JButton("Valider");
		btnValiderStockContenu.setBounds(446, 590, 89, 23);
		btnValiderStockContenu.addActionListener(actionValiderStockContenu());
		
		btnAnnulerContenuStock = new JButton("Annuler");
		btnAnnulerContenuStock.setBounds(545, 590, 89, 23);
		
		btnSupprimerStockContenu = new JButton("-");
		btnSupprimerStockContenu.setBounds(121, 589, 97, 25);
		
		btnEditerStockContenu = new JButton("Editer");
		btnEditerStockContenu.setBounds(230, 589, 97, 25);
		
		btnLocaliserStockContenu = new JButton("Localiser");
		btnLocaliserStockContenu.setBounds(339, 589, 97, 25);
	
		btnValiderStockContenu.setEnabled(false);
		btnAnnulerContenuStock.setEnabled(false);
		
		comboSelectContenu = new JComboBox<String>();
		comboSelectContenu.setBounds(12, 13, 141, 25);
		comboSelectContenu.addItemListener(listenerComboContenue());
		comboSelectContenu.addItem("Materiel");
		comboSelectContenu.addItem("Médicaments");
	
		comboSelectConteneur = new JComboBox<String>();
		comboSelectConteneur.setBounds(12, 13, 141, 25);
		
//		modelTableConteneur = new EscrimModelTable();
		tableConteneur = new JTable(modelTableConteneur);
		tableConteneur.setRowSelectionAllowed(true);
		tableConteneur.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableConteneur.setCellSelectionEnabled(false);
		
		btnAjouterStockConteneur = new JButton("+");
		btnAjouterStockConteneur.setBounds(12, 589, 97, 25);

		btnSupprimerStockConteneur = new JButton("-");
		btnSupprimerStockConteneur.setBounds(121, 589, 97, 25);

		btnAnnulerConteneurStock = new JButton("Annuler");
		btnAnnulerConteneurStock.setBounds(545, 590, 89, 23);
		btnAnnulerConteneurStock.setEnabled(false);
		
		btnEditerStockConteneur = new JButton("Editer");
		btnEditerStockConteneur.setBounds(230, 589, 97, 25);
		
		btnLocaliserStockConteneur = new JButton("Localiser");
		btnLocaliserStockConteneur.setBounds(339, 589, 97, 25);
		
		btnValiderStockConteneur = new JButton("Valider");
		btnValiderStockConteneur.setEnabled(false);
		btnValiderStockConteneur.setBounds(446, 590, 89, 23);
		
		scrollPaneConteneur = new JScrollPane();
		scrollPaneConteneur.setBounds(12, 56, 800, 486);
		scrollPaneConteneur.setViewportView(tableConteneur);
		
		scrollPaneContenu = new JScrollPane();
		scrollPaneContenu.setBounds(12, 56, 800, 486);
		scrollPaneContenu.setViewportView(tableContenu);
		
		contenuStock = new JPanel();
		contenuStock.setMinimumSize(new Dimension(20, 20));
		contenuStock.setLayout(null);
		contenuStock.add(comboSelectContenu);
		contenuStock.add(btnLocaliserStockContenu);
		contenuStock.add(btnEditerStockContenu);
		contenuStock.add(btnAnnulerContenuStock);
		contenuStock.add(btnSupprimerStockContenu);
		contenuStock.add(btnValiderStockContenu);
		contenuStock.add(btnLocaliserStock);
		contenuStock.add(btnEditerStock);
		contenuStock.add(scrollPaneContenu);
		contenuStock.add(btnSupprimerStock);
		contenuStock.add(btnAjouterStock);
		
		conteneurStock = new JPanel();
		conteneurStock.setMinimumSize(new Dimension(20, 20));
		conteneurStock.setLayout(null);
		conteneurStock.add(btnAnnulerConteneurStock);
		conteneurStock.add(scrollPaneConteneur);
		conteneurStock.add(btnEditerStockConteneur);
		conteneurStock.add(btnLocaliserStockConteneur);
		conteneurStock.add(btnValiderStockConteneur);
		conteneurStock.add(btnSupprimerStockConteneur);
		conteneurStock.add(btnAjouterStockConteneur);
		conteneurStock.add(comboSelectConteneur);
		
		ongletStock = new JTabbedPane(JTabbedPane.TOP);
		ongletStock.setAlignmentY(Component.TOP_ALIGNMENT);
		ongletStock.setAlignmentX(Component.LEFT_ALIGNMENT);
		ongletStock.addTab("Contenu", null, contenuStock, null);
		ongletStock.addTab("Conteneur", null, conteneurStock, null);
		
		tabPrincipal.addTab("Stock", null, ongletStock, null);
	}

	private ActionListener actionValiderStockContenu() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// On créé notre objet materiel
				Metier materiel = new Materiel();

				// On désactive l'édition de cellule pour assurer la
				// récupération des valeurs

				if (tableContenu.getCellEditor() != null) {
					tableContenu.getCellEditor().stopCellEditing();
				}

				// On récupère les données des cellules
				if (modelTableContenu.testRowValue(tableContenu
						.getSelectedRow())) {
					((Materiel) materiel).setDenomination((String) tableContenu
							.getModel().getValueAt(0, 1));
					((Materiel) materiel).setObservations((String) tableContenu
							.getModel().getValueAt(0, 2));
					// Par défaut les cell sont des strings, donc on récup les
					// int insérés

					try {
						((Materiel) materiel).setQuantite(Integer
								.parseInt((String) tableContenu.getModel()
										.getValueAt(0, 3)));
					} catch (NumberFormatException e) {
						lblMessageDerreur
								.setText("<html>La colonne Quantité doit être <br>un nombre écrit en chiffres</html>");
						return;
					}

					// On rend persistant l'objet
					GestionPersistance.addObjetToDB(materiel);

					// On insère l'uid dans la dernière colonne invisible pour
					// être capable d'appliquer des traitement

					tableContenu.getModel().setValueAt(
							((Materiel) materiel).getId(), 0,
							tableContenu.getColumnCount() - 1);

					// On rétablit l'état des boutons
					btnValiderStockContenu.setEnabled(false);
					btnAnnulerContenuStock.setEnabled(false);
					btnAjouterStock.setEnabled(true);
					btnSupprimerStockContenu.setEnabled(true);
					btnLocaliserStockContenu.setEnabled(true);
					btnEditerStockContenu.setEnabled(true);
					modelTableContenu.lockAllRow(false);

					// On nettoie le message d'erreur
					lblMessageDerreur.setText("");
				} else {
					lblMessageDerreur
							.setText("Erreur dans la saisie des données");
				}
			}
		};
		return action;
	}

	private ActionListener actionAjouterStock() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// On enable/disable les boutons nécessaire
				btnValiderStockContenu.setEnabled(true);
				btnAnnulerContenuStock.setEnabled(true);
				btnAjouterStock.setEnabled(false);
				btnSupprimerStockContenu.setEnabled(false);
				btnLocaliserStockContenu.setEnabled(false);
				btnEditerStockContenu.setEnabled(false);

				// on ajoute une ligne avec des champs nulls
				modelTableContenu.insertRow(0, new Vector());
				modelTableContenu.unlockFirstRow(true);

			}
		};
		return action;
	}

	private ItemListener listenerComboContenue() {
		ItemListener listern = new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				if (modelTableContenu.getColumnCount() != 0) {
					modelTableContenu.setColumnCount(0);
				}

//				tableContenu.setModel(EscrimModelTable.BuildTableColumn(
//						modelTableContenu, comboSelectContenu.getSelectedItem()
//								.toString()));
				tableContenu.getColumn(tableContenu.getColumnName(0))
						.setMaxWidth(20);

			}

		};
		return listern;
	}

	private MouseAdapter mouseAdapterAjouterStock() {
		MouseAdapter mouseAdapter = new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
				modelTableContenu.addRow(new Object[] { "", "", "", "" });
			}

		};
		return mouseAdapter;
	}
	

}
