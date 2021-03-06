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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import escrim.model.table.ColisTableModel;
import escrim.model.table.MaterielTableModel;
import escrim.model.table.MedicamentTableModel;
import escrim.utils.ComboBoxBuilder;

/**
 * The Class Stock.
 */
public class Stock {

	/** The table colis. */
	private JTable tableColis;

	/** The table contenu. */
	private JTable tableContenu;

	/** The onglet stock. */
	private JTabbedPane ongletStock;

	/** The Stock contenu. */
	private JPanel StockContenu;

	/** The scroll pane contenu. */
	private JScrollPane scrollPaneContenu;

	/** The btn ajouter stock contenu. */
	private static JButton btnAjouterStockContenu;

	/** The lbl message derreur. */
	private static JLabel lblMessageDerreur;

	/** The btn valider stock contenu. */
	private static JButton btnValiderStockContenu;

	/** The btn annuler stock contenu. */
	private static JButton btnAnnulerStockContenu;

	/** The btn supprimer stock contenu. */
	private static JButton btnSupprimerStockContenu;

	/** The btn editer stock contenu. */
	private static JButton btnEditerStockContenu;

	/** The btn localiser stock contenu. */
	private static JButton btnLocaliserStockContenu;

	/** The combo select contenu. */
	private static JComboBox<String> comboSelectContenu;

	/** The conteneur stock. */
	private static JPanel conteneurStock;

	/** The combo select colis. */
	private static JComboBox<?> comboSelectColis;

	/** The scroll pane colis. */
	private static JScrollPane scrollPaneColis;

	/** The btn ajouter stock colis. */
	private static JButton btnAjouterStockColis;

	/** The btn supprimer stock colis. */
	private static JButton btnSupprimerStockColis;

	/** The btn valider stock colis. */
	private static JButton btnValiderStockColis;

	/** The btn remplir stock colis. */
	private static JButton btnRemplirStockColis;

	/** The btn annuler stock colis. */
	private static JButton btnAnnulerStockColis;

	/** The btn editer stock colis. */
	private static JButton btnEditerStockColis;

	/** The btn localiser stock colis. */
	private static JButton btnLocaliserStockColis;

	/** The materiel table model. */
	private static MaterielTableModel materielTableModel;

	/** The medicament table model. */
	private static MedicamentTableModel medicamentTableModel;

	/** The colis table model. */
	private static ColisTableModel colisTableModel;

	/**
	 * Instantiates a new stock.
	 *
	 * @param tabPrincipal
	 *            the tab principal
	 * @param gestionairePage
	 *            the gestionaire page
	 */
	public Stock(JTabbedPane tabPrincipal, JLayeredPane gestionairePage) {
		this.initPage(tabPrincipal, gestionairePage);
	}

	/**
	 * Inits the page.
	 *
	 * @param tabPrincipal
	 *            the tab principal
	 * @param gestionairePage
	 *            the gestionaire page
	 */
	private void initPage(JTabbedPane tabPrincipal, JLayeredPane gestionairePage) {

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
				if (!(tableContenu.getSelectedRow() == -1)) {
					if (comboSelectContenu.getSelectedItem() == "Materiels") {
						materielTableModel.removeElement(tableContenu
								.getSelectedRow());
					} else if (comboSelectContenu.getSelectedItem() == "Médicaments") {
						medicamentTableModel.removeElement(tableContenu
								.getSelectedRow());
					}
				}
			}

		});

		btnAjouterStockContenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				disableStockButton(true);
				if (comboSelectContenu.getSelectedItem() == "Materiels") {
					materielTableModel.addElement();

				} else if (comboSelectContenu.getSelectedItem() == "Médicaments") {
					medicamentTableModel.addElement();
				}
				tableContenu.setRowSelectionInterval(
						tableContenu.getRowCount() - 1,
						tableContenu.getRowCount() - 1);

			}

		});

		btnEditerStockContenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(tableContenu.getSelectedRow() == -1)) {
					disableStockButton(true);
					if (comboSelectContenu.getSelectedItem() == "Materiels") {
						materielTableModel.updateElement(tableContenu
								.getSelectedRow());
					} else if (comboSelectContenu.getSelectedItem() == "Médicaments") {
						medicamentTableModel.updateElement(tableContenu
								.getSelectedRow());
					}

				}
			}

		});

		btnValiderStockContenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (tableContenu.isEditing()) {
						tableContenu.getCellEditor().stopCellEditing();
					}
					disableStockButton(false);
					if (comboSelectContenu.getSelectedItem() == "Materiels") {
						materielTableModel.persistData(
								tableContenu.getSelectedRow(), true);
					} else if (comboSelectContenu.getSelectedItem() == "Médicaments") {
						medicamentTableModel.persistData(
								tableContenu.getSelectedRow(), true);
					}
				} catch (Exception e) {
					disableStockButton(true);
				}

			}

		});

		btnAnnulerStockContenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disableStockButton(false);

				if (comboSelectContenu.getSelectedItem() == "Materiels") {
					materielTableModel.persistData(
							tableContenu.getSelectedRow(), false);
				} else if (comboSelectContenu.getSelectedItem() == "Médicaments") {
					medicamentTableModel.persistData(
							tableContenu.getSelectedRow(), false);
				}

			}

		});

		comboSelectContenu = new JComboBox<String>();
		comboSelectContenu.setBounds(12, 13, 141, 25);
		comboSelectContenu.addItem("Materiels");
		comboSelectContenu.addItem("Médicaments");

		comboSelectColis = new JComboBox<String>();
		comboSelectColis.setBounds(12, 13, 141, 25);

		comboSelectContenu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (comboSelectContenu.getSelectedItem() == "Materiels") {
					medicamentTableModel.setRowCount(0);
					tableContenu.setModel(materielTableModel);
				} else if (comboSelectContenu.getSelectedItem() == "Médicaments") {
					materielTableModel.setRowCount(0);
					tableContenu.setModel(medicamentTableModel);

				}
				tableContenu.repaint();

			}
		});

		// --------------------- Vue Colis ------------------ //

		colisTableModel = new ColisTableModel();
		tableColis = new JTable(colisTableModel);
		tableColis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableColis.setRowSelectionAllowed(true);

		tableColis.getColumn("").setMaxWidth(10);
		// tableColis.removeColumn(tableColis.getColumn("uid"));

		btnAjouterStockColis = new JButton("+");
		btnAjouterStockColis.setBounds(12, 589, 97, 25);

		btnSupprimerStockColis = new JButton("-");
		btnSupprimerStockColis.setBounds(121, 589, 97, 25);

		btnAnnulerStockColis = new JButton("Annuler");
		btnAnnulerStockColis.setBounds(545, 590, 89, 23);

		btnEditerStockColis = new JButton("Editer");
		btnEditerStockColis.setBounds(230, 589, 97, 25);

		btnLocaliserStockColis = new JButton("Localiser");
		btnLocaliserStockColis.setBounds(339, 589, 97, 25);

		btnValiderStockColis = new JButton("Valider");
		btnValiderStockColis.setBounds(446, 590, 89, 23);

		btnRemplirStockColis = new JButton("Remplir le Colis Sélectionné");
		btnRemplirStockColis.setBounds(646, 590, 210, 23);
		btnRemplirStockColis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(tableColis.getSelectedRow() == -1))
					Remplissage.CreationJpanelRemplissageColis(
							gestionairePage,
							(int) colisTableModel.getValueAt(
									tableColis.getSelectedRow(),
									tableColis.getColumnCount()));

			}

		});

		btnValiderStockColis.setEnabled(false);
		btnAnnulerStockColis.setEnabled(false);

		btnSupprimerStockColis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!(tableColis.getSelectedRow() == -1)) {
					colisTableModel.removeElement(tableColis.getSelectedRow());
				}

			}

		});

		btnAjouterStockColis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disableColisButton(true);
				ComboBoxBuilder.setUpTypeColisColumn(tableColis,
						tableColis.getColumn("Type Colis"));

				colisTableModel.addElement();
				tableColis.setRowSelectionInterval(
						tableColis.getRowCount() - 1,
						tableColis.getRowCount() - 1);

			}

		});

		btnEditerStockColis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!(tableColis.getSelectedRow() == -1)) {
					ComboBoxBuilder.setUpTypeColisColumn(tableColis,
							tableColis.getColumn("Type Colis"));
					disableColisButton(true);
					colisTableModel.updateElement(tableColis.getSelectedRow());
				}

			}

		});

		btnValiderStockColis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (tableColis.isEditing()) {
						tableColis.getCellEditor().stopCellEditing();
					}
					disableColisButton(false);
					colisTableModel.persistData(tableColis.getSelectedRow(),
							true);
				} catch (Exception e) {
					disableColisButton(true);
				}

			}

		});

		btnAnnulerStockColis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disableColisButton(false);

				colisTableModel.persistData(tableColis.getSelectedRow(), false);

			}

		});

		scrollPaneColis = new JScrollPane();
		scrollPaneColis.setBounds(12, 56, 900, 486);
		scrollPaneColis.setViewportView(tableColis);

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
		conteneurStock.add(btnAnnulerStockColis);
		conteneurStock.add(scrollPaneColis);
		conteneurStock.add(btnEditerStockColis);
		conteneurStock.add(btnLocaliserStockColis);
		conteneurStock.add(btnValiderStockColis);
		conteneurStock.add(btnRemplirStockColis);
		conteneurStock.add(btnSupprimerStockColis);
		conteneurStock.add(btnAjouterStockColis);

		ongletStock = new JTabbedPane(JTabbedPane.TOP);
		ongletStock.setAlignmentY(Component.TOP_ALIGNMENT);
		ongletStock.setAlignmentX(Component.LEFT_ALIGNMENT);
		ongletStock.addTab("Contenu", null, StockContenu, null);
		ongletStock.addTab("Colis", null, conteneurStock, null);

		tabPrincipal.addTab("Stock", null, ongletStock, null);

	}

	/**
	 * Disable stock button.
	 *
	 * @param disable
	 *            the disable
	 */
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

	/**
	 * Disable colis button.
	 *
	 * @param disable
	 *            the disable
	 */
	private static void disableColisButton(boolean disable) {
		if (disable) {
			btnAjouterStockColis.setEnabled(false);
			btnSupprimerStockColis.setEnabled(false);
			btnEditerStockColis.setEnabled(false);
			btnLocaliserStockColis.setEnabled(false);
			btnValiderStockColis.setEnabled(true);
			btnAnnulerStockColis.setEnabled(true);
		} else {
			btnAjouterStockColis.setEnabled(true);
			btnSupprimerStockColis.setEnabled(true);
			btnEditerStockColis.setEnabled(true);
			btnLocaliserStockColis.setEnabled(true);
			btnValiderStockColis.setEnabled(false);
			btnAnnulerStockColis.setEnabled(false);
		}
	}
}
