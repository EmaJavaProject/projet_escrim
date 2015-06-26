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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import escrim.manager.MedicamentManager;
import escrim.metiers.Medicament;
import escrim.model.table.MaterielTableModel;
import escrim.model.table.MedicamentTableModel;

public class Stock {

	private JTable tableConteneur;
	private JTable tableContenu;
	private JTabbedPane ongletStock;
	private JPanel StockContenu;
	private JScrollPane scrollPaneContenu;

	private static JButton btnAjouterStockContenu;
	private static JLabel lblMessageDerreur;
	private static JButton btnValiderStockContenu;
	private static JButton btnAnnulerStockContenu;
	private static JButton btnSupprimerStockContenu;
	private static JButton btnEditerStockContenu;
	private static JButton btnLocaliserStockContenu;
	private static JComboBox<String> comboSelectContenu;
	private static JPanel conteneurStock;
	private static JComboBox<?> comboSelectConteneur;
	private static JScrollPane scrollPaneConteneur;
	private static JButton btnAjouterStockConteneur;
	private static JButton btnSupprimerStockConteneur;
	private static JButton btnValiderStockConteneur;
	private static JButton btnAnnulerConteneurStock;
	private static JButton btnEditerStockConteneur;
	private static JButton btnLocaliserStockConteneur;
	private static MaterielTableModel materielTableModel;
	private static MedicamentTableModel medicamentTableModel;

	public Stock(JTabbedPane tabPrincipal) {
		this.initPage(tabPrincipal);
	}

	private void initPage(JTabbedPane tabPrincipal) {

		materielTableModel = new MaterielTableModel();
		medicamentTableModel = new MedicamentTableModel();
		tableContenu = new JTable(materielTableModel);
		tableContenu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableContenu.setRowSelectionAllowed(true);

		btnAjouterStockContenu = new JButton("+");
		btnAjouterStockContenu.setBounds(12, 589, 97, 25);

		lblMessageDerreur = new JLabel("");
		lblMessageDerreur.setVerticalAlignment(SwingConstants.TOP);
		lblMessageDerreur.setHorizontalAlignment(SwingConstants.LEFT);
		lblMessageDerreur.setEnabled(true);
		lblMessageDerreur.setForeground(Color.RED);
		lblMessageDerreur.setBounds(644, 594, 265, 50);

		btnValiderStockContenu = new JButton("Valider");
		btnValiderStockContenu.setBounds(446, 590, 89, 23);

		btnAnnulerStockContenu = new JButton("Annuler");
		btnAnnulerStockContenu.setBounds(545, 590, 89, 23);

		btnSupprimerStockContenu = new JButton("-");
		btnSupprimerStockContenu.setBounds(121, 589, 97, 25);

		btnEditerStockContenu = new JButton("Editer");
		btnEditerStockContenu.setBounds(230, 589, 97, 25);

		btnLocaliserStockContenu = new JButton("Localiser");
		btnLocaliserStockContenu.setBounds(339, 589, 97, 25);

		btnValiderStockContenu.setEnabled(false);
		btnAnnulerStockContenu.setEnabled(false);

		// Event sur les boutons

		btnSupprimerStockContenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (comboSelectContenu.getSelectedItem() == "Materiels") {
					materielTableModel.removeElement(tableContenu
							.getSelectedRow());
				} else if (comboSelectContenu.getSelectedItem() == "M�dicaments") {
					medicamentTableModel.removeElement(tableContenu
							.getSelectedRow());
				}
			}

		});

		btnAjouterStockContenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disableStockButton(true);

				if (comboSelectContenu.getSelectedItem() == "Materiels") {
					materielTableModel.addElement();

				} else if (comboSelectContenu.getSelectedItem() == "M�dicaments") {
					medicamentTableModel.addElement();
				}
				tableContenu.setRowSelectionInterval(
						tableContenu.getRowCount() - 1,
						tableContenu.getRowCount() - 1);

			}

		});

		btnEditerStockContenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disableStockButton(true);
				materielTableModel.updateElement(tableContenu.getSelectedRow());
				if (comboSelectContenu.getSelectedItem() == "Materiels") {
					materielTableModel.updateElement(tableContenu
							.getSelectedRow());
				} else if (comboSelectContenu.getSelectedItem() == "M�dicaments") {
					medicamentTableModel.updateElement(tableContenu
							.getSelectedRow());
				}

			}

		});

		btnValiderStockContenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tableContenu.isEditing()) {
					tableContenu.getCellEditor().stopCellEditing();
				}
				disableStockButton(false);
				if (comboSelectContenu.getSelectedItem() == "Materiels") {
					materielTableModel.persistData(
							tableContenu.getSelectedRow(), true);
				} else if (comboSelectContenu.getSelectedItem() == "M�dicaments") {
					medicamentTableModel.persistData(
							tableContenu.getSelectedRow(), true);
				}

			}

		});

		btnAnnulerStockContenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disableStockButton(false);

				if (comboSelectContenu.getSelectedItem() == "Materiels") {
					materielTableModel.persistData(
							tableContenu.getSelectedRow(), false);
				} else if (comboSelectContenu.getSelectedItem() == "M�dicaments") {
					medicamentTableModel.persistData(
							tableContenu.getSelectedRow(), false);
				}

			}

		});

		comboSelectContenu = new JComboBox<String>();
		comboSelectContenu.setBounds(12, 13, 141, 25);
		comboSelectContenu.addItem("Materiels");
		comboSelectContenu.addItem("M�dicaments");

		comboSelectConteneur = new JComboBox<String>();
		comboSelectConteneur.setBounds(12, 13, 141, 25);

		tableConteneur = new JTable();
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

		StockContenu = new JPanel();
		StockContenu.setMinimumSize(new Dimension(20, 20));
		StockContenu.setLayout(null);
		StockContenu.add(comboSelectContenu);
		StockContenu.add(btnLocaliserStockContenu);
		StockContenu.add(btnEditerStockContenu);
		StockContenu.add(btnAnnulerStockContenu);
		StockContenu.add(btnAjouterStockContenu);
		StockContenu.add(btnSupprimerStockContenu);
		StockContenu.add(btnValiderStockContenu);
		StockContenu.add(scrollPaneContenu);

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
		ongletStock.addTab("Contenu", null, StockContenu, null);
		ongletStock.addTab("Conteneur", null, conteneurStock, null);

		tabPrincipal.addTab("Stock", null, ongletStock, null);
		List<Medicament> list = MedicamentManager.loadAllMedicament();
		comboSelectContenu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboSelectContenu.getSelectedItem() == "Materiels") {
					medicamentTableModel.setRowCount(0);
					tableContenu.setModel(materielTableModel);
					tableContenu.repaint();
				} else if (comboSelectContenu.getSelectedItem() == "M�dicaments") {
					materielTableModel.setRowCount(0);
					tableContenu.setModel(medicamentTableModel);
					tableContenu.repaint();
				}

			}
		});

	}

	private static void disableStockButton(boolean disable) {
		if (disable) {
			btnAjouterStockContenu.setEnabled(false);
			btnSupprimerStockContenu.setEnabled(false);
			btnEditerStockContenu.setEnabled(false);
			btnLocaliserStockContenu.setEnabled(false);
			btnValiderStockContenu.setEnabled(true);
			btnAnnulerStockContenu.setEnabled(true);
		} else {
			btnAjouterStockContenu.setEnabled(true);
			btnSupprimerStockContenu.setEnabled(true);
			btnEditerStockContenu.setEnabled(true);
			btnLocaliserStockContenu.setEnabled(true);
			btnValiderStockContenu.setEnabled(false);
			btnAnnulerStockContenu.setEnabled(false);
		}
	}

}
