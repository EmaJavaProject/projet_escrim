package ihm;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import escrim.dao.GestionPersistance;
import escrim.metiers.Materiel;
import escrim.metiers.Metier;

public class Stock {
	
	private JTable tableContenu;
	public Stock(JTabbedPane tabPrincipal) {
		this.initPage(tabPrincipal);
	}
	
	private void initPage(JTabbedPane tabPrincipal){
		
		JTabbedPane ongletStock = new JTabbedPane(JTabbedPane.TOP);
		ongletStock.setAlignmentY(Component.TOP_ALIGNMENT);
		ongletStock.setAlignmentX(Component.LEFT_ALIGNMENT);
		tabPrincipal.addTab("Stock", null, ongletStock, null);
		
		JPanel contenuStock = new JPanel();
		contenuStock.setMinimumSize(new Dimension(20, 20));
		ongletStock.addTab("Contenu", null, contenuStock, null);
		contenuStock.setLayout(null);
		JScrollPane scrollPaneContenu = new JScrollPane();
		scrollPaneContenu.setBounds(12, 56, 800, 486);
		contenuStock.add(scrollPaneContenu);

		DefaultTableModel modelTableContenu = new DefaultTableModel();
		TableColumnModel allTableContenuColumn = new DefaultTableColumnModel();
		tableContenu = new JTable(modelTableContenu);
		scrollPaneContenu.setViewportView(tableContenu);

		// JTableHeader headerContenu = new JTableHeader();

		JButton btnAjouterStock = new JButton("+");
		btnAjouterStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modelTableContenu.addRow(new Object[] { "", "", "", "" });
			}
		});
		btnAjouterStock.setBounds(12, 589, 97, 25);
		contenuStock.add(btnAjouterStock);

		JButton btnSupprimerStock = new JButton("-");
		btnSupprimerStock.setBounds(121, 589, 97, 25);
		contenuStock.add(btnSupprimerStock);

		JButton btnEditerStock = new JButton("Editer");
		btnEditerStock.setBounds(230, 589, 97, 25);
		contenuStock.add(btnEditerStock);

		JButton btnLocaliserStock = new JButton("Localiser");
		btnLocaliserStock.setBounds(339, 589, 97, 25);
		contenuStock.add(btnLocaliserStock);

		JComboBox<String> comboSelectContenu = new JComboBox<String>();

		// Mise a jour de la JTable en fonction de la combobox
		comboSelectContenu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (modelTableContenu.getColumnCount() != 0) {
					modelTableContenu.setColumnCount(0);
				}

				tableContenu.setModel(EscrimModelTable.BuildTableColumn(
						modelTableContenu, comboSelectContenu.getSelectedItem()
								.toString()));
				tableContenu.getColumn(tableContenu.getColumnName(0))
						.setMaxWidth(20);
				;
			}

		});
		JButton btnValiderStockContenu = new JButton("Valider");

		btnValiderStockContenu.setBounds(446, 590, 89, 23);
		contenuStock.add(btnValiderStockContenu);

		JButton btnAnnulerContenuStock = new JButton("Annuler");
		btnAnnulerContenuStock.setBounds(545, 590, 89, 23);
		contenuStock.add(btnAnnulerContenuStock);

		JButton btnSupprimerStockContenu = new JButton("-");
		btnSupprimerStockContenu.setBounds(121, 589, 97, 25);
		contenuStock.add(btnSupprimerStockContenu);

		JButton btnEditerStockContenu = new JButton("Editer");
		btnEditerStockContenu.setBounds(230, 589, 97, 25);
		contenuStock.add(btnEditerStockContenu);

		JButton btnLocaliserStockContenu = new JButton("Localiser");
		btnLocaliserStockContenu.setBounds(339, 589, 97, 25);
		contenuStock.add(btnLocaliserStockContenu);

		btnValiderStockContenu.setEnabled(false);
		btnAnnulerContenuStock.setEnabled(false);
		comboSelectContenu.setBounds(12, 13, 141, 25);
		contenuStock.add(comboSelectContenu);
		comboSelectContenu.addItem("Materiel");
		comboSelectContenu.addItem("Médicaments");

		JComboBox<?> comboBox = new JComboBox<Object>();
		comboBox.setBounds(12, 13, 141, 25);
		contenuStock.add(comboBox);

		JPanel conteneurStock = new JPanel();
		ongletStock.addTab("Conteneur", null, conteneurStock, null);
		btnAjouterStock.addActionListener(new ActionListener() {
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
		});

		btnValiderStockContenu.addActionListener(new ActionListener() {
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
		});
		
	}

}
