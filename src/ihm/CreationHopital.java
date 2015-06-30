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
import javax.swing.SwingConstants;

import escrim.model.table.ConfigurationHopitalTableModel;

/**
 * The Class CreationHopital.
 */
public class CreationHopital {

	/** The tab principal. */
	private static JTabbedPane tabPrincipal;

	/** The jpanel configuration hopital. */
	private static JPanel jpanelConfigurationHopital;

	/** The txt configuration hopital. */
	private static JTextField txtConfigurationHopital;

	/** The configuration hopital table model. */
	private static ConfigurationHopitalTableModel configurationHopitalTableModel;

	/** The table configuration hopital. */
	private static JTable tableConfigurationHopital;

	/** The bouton ajouter configuration hopital. */
	private static JButton boutonAjouterConfigurationHopital;

	/** The bouton quitter configuration hopital. */
	private static JButton boutonQuitterConfigurationHopital;

	/** The bouton supprimer configuration hopital. */
	private static JButton boutonSupprimerConfigurationHopital;

	/** The bouton remplissage configuration hopital. */
	private static JButton boutonRemplissageConfigurationHopital;

	/** The bouton modifier configuration hopital. */
	private static JButton boutonModifierConfigurationHopital;

	/** The bouton valider configuration hopital. */
	private static JButton boutonValiderConfigurationHopital;

	/** The bouton annuler configuration hopital. */
	private static JButton boutonAnnulerConfigurationHopital;

	/** The scroll panel configuration hopital. */
	private static JScrollPane scrollPanelConfigurationHopital;

	/**
	 * Création jpanel hopital.
	 *
	 * @param pPanelPrincipal
	 *            the panel principal
	 * @return the action listener
	 */
	public static ActionListener CreationJpanelHopital(
			JLayeredPane pPanelPrincipal) {

		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pPanelPrincipal != null) {

					// -------------------------pour éviter de créer plusieur
					// Jpanel-----------//////////
					for (Component composantPanelPrincipal : pPanelPrincipal
							.getComponents()) {
						for (Component composantsPanelPrincipal : composantPanelPrincipal
								.getParent().getComponents()) {

							if (composantsPanelPrincipal != null
									&& composantsPanelPrincipal.getName() != null
									&& composantsPanelPrincipal
											.getName()
											.equals("Création de type de colis")
									|| composantsPanelPrincipal
											.getName()
											.equals("Gestion configuration d'hopital")
									|| composantsPanelPrincipal.getName()
											.equals("Gestion Transport")
									|| composantsPanelPrincipal.getName()
											.equals("Remplissage")) {
								return;
							}
						}
					}
				}

				configurationHopitalTableModel = new ConfigurationHopitalTableModel();
				tableConfigurationHopital = new JTable(
						configurationHopitalTableModel);
				tableConfigurationHopital
						.setName("Table Configuration Hopitals");
				tableConfigurationHopital.setBounds(12, 72, 899, 800);
				// tableConfigurationHopital
				// .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				// tableConfigurationHopital.setCellSelectionEnabled(false);
				// tableConfigurationHopital.setRowSelectionAllowed(true);

				boutonQuitterConfigurationHopital = new JButton("Quitter");
				boutonQuitterConfigurationHopital.setBounds(800, 13, 97, 25);
				boutonQuitterConfigurationHopital
						.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								for (Component composant : pPanelPrincipal
										.getComponents()) {
									if (composant.getName().equals(
											"Gestion configuration d'hopital"))
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

				boutonRemplissageConfigurationHopital = new JButton(
						"Éditer La configuration d'hôpital sélectionné");
				boutonRemplissageConfigurationHopital.setBounds(560, 589, 283,
						25);
				boutonRemplissageConfigurationHopital
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (!(tableConfigurationHopital
										.getSelectedRow() == -1))
									Remplissage
											.CreationJpanelRemplissageConfigHopital(
													pPanelPrincipal,
													configurationHopitalTableModel,
													tableConfigurationHopital
															.getSelectedRow());
							}
						});

				boutonRemplissageConfigurationHopital = new JButton(
						"Éditer la configuration d'hôpital sélectionnée");
				boutonRemplissageConfigurationHopital.setBounds(560, 589, 283,
						25);
				boutonRemplissageConfigurationHopital
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (!(tableConfigurationHopital
										.getSelectedRow() == -1))
									Remplissage
											.CreationJpanelRemplissageConfigHopital(
													pPanelPrincipal,
													configurationHopitalTableModel,
													(int) configurationHopitalTableModel.getValueAt(
															tableConfigurationHopital
																	.getSelectedRow(),
															tableConfigurationHopital
																	.getColumnCount()));

							}

						});

				boutonValiderConfigurationHopital.setEnabled(false);
				boutonAnnulerConfigurationHopital.setEnabled(false);

				boutonSupprimerConfigurationHopital
						.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (!(tableConfigurationHopital
										.getSelectedRow() == -1)) {
									configurationHopitalTableModel
											.removeElement(tableConfigurationHopital
													.getSelectedRow());
								}
							}

						});

				boutonAjouterConfigurationHopital
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								disableConfigurationHopitalButton(true);
								configurationHopitalTableModel.addElement();
								tableConfigurationHopital
										.setRowSelectionInterval(
												tableConfigurationHopital
														.getRowCount() - 1,
												tableConfigurationHopital
														.getRowCount() - 1);

							}

						});

				boutonModifierConfigurationHopital
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								disableConfigurationHopitalButton(true);
								configurationHopitalTableModel
										.updateElement(tableConfigurationHopital
												.getSelectedRow());

							}

						});

				boutonValiderConfigurationHopital
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (tableConfigurationHopital.isEditing()) {
									tableConfigurationHopital.getCellEditor()
											.stopCellEditing();
								}
								disableConfigurationHopitalButton(false);
								configurationHopitalTableModel.persistData(
										tableConfigurationHopital
												.getSelectedRow(), true);
							}

						});

				boutonAnnulerConfigurationHopital
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								disableConfigurationHopitalButton(false);
								configurationHopitalTableModel.persistData(
										tableConfigurationHopital
												.getSelectedRow(), false);

							}

						});

				txtConfigurationHopital = new JTextField();
				txtConfigurationHopital
						.setHorizontalAlignment(SwingConstants.CENTER);
				txtConfigurationHopital.setEnabled(false);
				txtConfigurationHopital.setPreferredSize(new Dimension(20, 20));
				txtConfigurationHopital
						.setText("Gestion configuration d'hopitals");
				txtConfigurationHopital.setColumns(10);
				txtConfigurationHopital.setBounds(44, 11, 260, 25);

				scrollPanelConfigurationHopital = new JScrollPane();
				scrollPanelConfigurationHopital
						.setName("Scroll ConfigurationHopitals");
				scrollPanelConfigurationHopital
						.setViewportView(tableConfigurationHopital);
				scrollPanelConfigurationHopital.setBounds(12, 56, 800, 486);

				// ---------------------------------------------création et
				// ajout des Jpanel dans le
				// Tabprincipal---------------------------------------------------//

				jpanelConfigurationHopital = new JPanel();
				jpanelConfigurationHopital.setBounds(0, 0, 1017, 706);
				jpanelConfigurationHopital.add(scrollPanelConfigurationHopital);
				jpanelConfigurationHopital
						.setName("Gestion configuration d'hopital");
				jpanelConfigurationHopital.setLayout(null);
				jpanelConfigurationHopital.add(txtConfigurationHopital);
				jpanelConfigurationHopital
						.add(boutonModifierConfigurationHopital);
				jpanelConfigurationHopital
						.add(boutonSupprimerConfigurationHopital);
				jpanelConfigurationHopital
						.add(boutonAjouterConfigurationHopital);
				jpanelConfigurationHopital
						.add(boutonQuitterConfigurationHopital);
				jpanelConfigurationHopital
						.add(boutonValiderConfigurationHopital);
				jpanelConfigurationHopital
						.add(boutonAnnulerConfigurationHopital);
				jpanelConfigurationHopital
						.add(boutonRemplissageConfigurationHopital);

				pPanelPrincipal.add(jpanelConfigurationHopital, new Integer(4));
				pPanelPrincipal.revalidate();

				// Suppression de la colonne UID
				tableConfigurationHopital
						.removeColumn(tableConfigurationHopital
								.getColumn("uid"));
			}
		};

		return action;

	}

	/**
	 * Disable configuration hopital button.
	 *
	 * @param disable
	 *            the disable
	 */
	private static void disableConfigurationHopitalButton(boolean disable) {
		if (disable) {
			boutonAjouterConfigurationHopital.setEnabled(false);
			boutonSupprimerConfigurationHopital.setEnabled(false);
			boutonModifierConfigurationHopital.setEnabled(false);
			boutonValiderConfigurationHopital.setEnabled(true);
			boutonAnnulerConfigurationHopital.setEnabled(true);
		} else {
			boutonAjouterConfigurationHopital.setEnabled(true);
			boutonSupprimerConfigurationHopital.setEnabled(true);
			boutonModifierConfigurationHopital.setEnabled(true);
			boutonValiderConfigurationHopital.setEnabled(false);
			boutonAnnulerConfigurationHopital.setEnabled(false);
		}
	}

};
