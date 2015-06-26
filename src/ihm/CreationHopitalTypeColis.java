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

import escrim.model.table.ConfigurationHopitalTableModel;
import escrim.model.table.TypeColisTableModel;

public class CreationHopitalTypeColis {

	private static JPanel jpanelTypeColis;
	private static JTable tableTypeColis;
	private static JScrollPane scrollPanelTypeColis;
	private static JTextField txtTypeColis;
	private static TypeColisTableModel typeColisTableModel;
	private static JButton boutonAjouterTypeColis;
	private static JButton boutonQuitter;
	private static JButton boutonSupprimerTypeColis;
	private static JButton boutonModifierTypeColis;
	private static JButton boutonValiderTypeColis;
	private static JButton boutonAnnulerTypeColis;
	private static JTabbedPane tabPrincipal;
	private static JPanel jpanelConfigurationHopital;
	private static JTextField txtConfigurationHopital;
	private static ConfigurationHopitalTableModel configurationHopitalTableModel;
	private static JTable tableConfigurationHopital;
	private static JButton boutonAjouterConfigurationHopital;
	private static JButton boutonQuitterConfigurationHopital;
	private static JButton boutonSupprimerConfigurationHopital;
	private static JButton boutonModifierConfigurationHopital;
	private static JButton boutonValiderConfigurationHopital;
	private static JButton boutonAnnulerConfigurationHopital;
	private static JScrollPane scrollPanelConfigurationHopital;

	public static ActionListener CréationJpanelTypeColis(
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
									&& composantsPanelPrincipal
											.getName()
											.equals("Création de type de colis")) {
								return;
							}
						}
					}
				}

				// ------------------------------------ Jpanel conf
				// hopital---------------------------//

				configurationHopitalTableModel = new ConfigurationHopitalTableModel();
				tableConfigurationHopital = new JTable(
						configurationHopitalTableModel);
				tableConfigurationHopital
						.setName("Table ConfigurationHopitals");
				tableConfigurationHopital.setBounds(12, 72, 899, 800);
				tableConfigurationHopital
						.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableConfigurationHopital.setCellSelectionEnabled(false);
				tableConfigurationHopital.setRowSelectionAllowed(true);

				boutonQuitterConfigurationHopital = new JButton("Quitter");
				boutonQuitterConfigurationHopital.setBounds(800, 13, 97, 25);
				boutonQuitterConfigurationHopital
						.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								for (Component composant : pPanelPrincipal
										.getComponents()) {
									if (composant.getName().equals(
											"Création de type de colis"))
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

				// ------------------------------------ Jpanel
				// Colis---------------------------//

				typeColisTableModel = new TypeColisTableModel();
				tableTypeColis = new JTable(typeColisTableModel);
				tableTypeColis.setName("Table Colis");
				tableTypeColis.setBounds(12, 72, 899, 800);
				boutonQuitter = new JButton("Quitter");
				boutonQuitter.setBounds(800, 13, 97, 25);
				boutonQuitter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						for (Component composant : pPanelPrincipal
								.getComponents()) {
							if (composant.getName().equals(
									"Création de type de colis"))
								pPanelPrincipal.remove(composant);
						}
						pPanelPrincipal.repaint();

					}
				});

				boutonAjouterTypeColis = new JButton("+");
				boutonAjouterTypeColis.setBounds(12, 589, 97, 25);

				boutonSupprimerTypeColis = new JButton("-");
				boutonSupprimerTypeColis.setBounds(121, 589, 97, 25);

				boutonModifierTypeColis = new JButton("Editer");
				boutonModifierTypeColis.setBounds(230, 589, 97, 25);

				boutonValiderTypeColis = new JButton("Valider");
				boutonValiderTypeColis.setBounds(340, 589, 97, 25);

				boutonAnnulerTypeColis = new JButton("Annuler");
				boutonAnnulerTypeColis.setBounds(450, 589, 97, 25);

				boutonValiderTypeColis.setEnabled(false);
				boutonAnnulerTypeColis.setEnabled(false);

				boutonSupprimerTypeColis
						.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (!(tableTypeColis.getSelectedRow() == -1)) {
									typeColisTableModel
											.removeElement(tableTypeColis
													.getSelectedRow());
								}
							}

						});

				boutonAjouterTypeColis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						disableTypeColisButton(true);
						typeColisTableModel.addElement();
						tableTypeColis.setRowSelectionInterval(
								tableTypeColis.getRowCount() - 1,
								tableTypeColis.getRowCount() - 1);

					}

				});

				boutonModifierTypeColis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						disableTypeColisButton(true);
						typeColisTableModel.updateElement(tableTypeColis
								.getSelectedRow());

					}

				});

				boutonValiderTypeColis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (tableTypeColis.isEditing()) {
							tableTypeColis.getCellEditor().stopCellEditing();
						}
						disableTypeColisButton(false);
						typeColisTableModel.persistData(
								tableTypeColis.getSelectedRow(), true);
					}

				});

				boutonAnnulerTypeColis.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						disableTypeColisButton(false);
						typeColisTableModel.persistData(
								tableTypeColis.getSelectedRow(), false);

					}

				});

				scrollPanelTypeColis = new JScrollPane();
				scrollPanelTypeColis.setName("Scroll TypeColis");
				scrollPanelTypeColis.setViewportView(tableTypeColis);
				scrollPanelTypeColis.setBounds(12, 56, 950, 486);

				txtTypeColis = new JTextField();
				txtTypeColis.setHorizontalAlignment(SwingConstants.CENTER);
				txtTypeColis.setEnabled(false);
				txtTypeColis.setPreferredSize(new Dimension(20, 20));
				txtTypeColis.setText("Gestion Type de Colis");
				txtTypeColis.setColumns(10);
				txtTypeColis.setBounds(44, 11, 260, 25);

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

				jpanelTypeColis = new JPanel();
				jpanelTypeColis.add(boutonModifierTypeColis);
				jpanelTypeColis.setBounds(0, 0, 1017, 706);
				jpanelTypeColis.setName("Création de type de colis");
				jpanelTypeColis.add(txtTypeColis);
				jpanelTypeColis.add(scrollPanelTypeColis);
				jpanelTypeColis.setLayout(null);
				jpanelTypeColis.add(boutonQuitter);
				jpanelTypeColis.add(boutonModifierTypeColis);
				jpanelTypeColis.add(boutonSupprimerTypeColis);
				jpanelTypeColis.add(boutonAjouterTypeColis);
				jpanelTypeColis.add(boutonValiderTypeColis);
				jpanelTypeColis.add(boutonAnnulerTypeColis);

				tabPrincipal = new JTabbedPane();
				tabPrincipal.setName("Création de type de colis");
				tabPrincipal.setBounds(0, 0, 1017, 706);
				tabPrincipal.add(jpanelConfigurationHopital);
				tabPrincipal.add(jpanelTypeColis);

				pPanelPrincipal.add(tabPrincipal, new Integer(3));
				pPanelPrincipal.revalidate();

			}
		};

		return action;

	}

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

	private static void disableTypeColisButton(boolean disable) {
		if (disable) {
			boutonAjouterTypeColis.setEnabled(false);
			boutonSupprimerTypeColis.setEnabled(false);
			boutonModifierTypeColis.setEnabled(false);
			boutonValiderTypeColis.setEnabled(true);
			boutonAnnulerTypeColis.setEnabled(true);
		} else {
			boutonAjouterTypeColis.setEnabled(true);
			boutonSupprimerTypeColis.setEnabled(true);
			boutonModifierTypeColis.setEnabled(true);
			boutonValiderTypeColis.setEnabled(false);
			boutonAnnulerTypeColis.setEnabled(false);
		}
	}

};
