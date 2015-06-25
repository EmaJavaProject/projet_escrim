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

import escrim.model.table.CompartimentTableModel;
import escrim.model.table.TransportTableModel;

public class GestionTransport {

	private static JPanel jpanelTransport;
	private static JTextField txtGestionTransport;
	private static TransportTableModel tblModelTransport;
	private static JTable tableTransport;
	private static JButton boutonAjouterTransport;
	private static JButton boutonQuitter;
	private static JButton boutonSupprimerTransport;
	private static JButton boutonModifierTransport;
	private static JButton boutonValiderTransport;
	private static JButton boutonAnnulerTransport;
	private static JScrollPane scrollPanelTransport;
	private static JPanel jpanelCompartiment;
	private static JTextField txtCompartiment;
	private static CompartimentTableModel compartimentTableModel;
	private static JTable tableCompartiment;
	private static JButton boutonAjouterCompartiment;
	private static JButton boutonQuitterCompartiment;
	private static JButton boutonSupprimerCompartiment;
	private static JButton boutonModifierCompartiment;
	private static JButton boutonValiderCompartiment;
	private static JButton boutonAnnulerCompartiment;
	private static JScrollPane scrollPanelCompartiment;
	private static JTabbedPane tabPrincipal;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static ActionListener CréationJpanelTransport(
			JLayeredPane pPanelPrincipal) {

		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pPanelPrincipal != null) {
					/**
					 * J'ai été obligé de faire un double foreach car quand ont
					 * repasse dans cette méthode composantPanelPrincipal
					 * devient le pPanelPrincipal. je ne sais pas pk si vous
					 * avez une autre solution pour limité le nombre de Tad
					 * gestion des Transports.ps le singleton ne marche pas ici.
					 * le double foreach ici ne géne pas la performance car
					 * quand nous ont revient dans cette méthod pPanelPrincipal
					 * ne comptient qu'un seul composants. Si je ne suis pas
					 * assez clair faite moi signe je vous expliquerai ou sinon
					 * rentré en debug pour voir ce qu'il ce passe vraiment ps
					 * ce commentaire sera enlevé si le prof regarde notre code
					 * vu les fautes d'orthographes.
					 */

					for (Component composantPanelPrincipal : pPanelPrincipal
							.getComponents()) {
						for (Component composantsPanelPrincipal : composantPanelPrincipal
								.getParent().getComponents()) {

							if (composantsPanelPrincipal != null
									&& composantsPanelPrincipal.getName() != null
									&& composantsPanelPrincipal.getName()
											.equals("Gestion Transport")) {
								return;
							}
						}
					}
				}
				// --------------------------------Onglet
				// Transport------------------------------------------------//

				tblModelTransport = new TransportTableModel();
				tableTransport = new JTable(tblModelTransport);
				tableTransport.setName("Table Transports");
				tableTransport.setBounds(12, 72, 899, 800);
				boutonQuitter = new JButton("Quitter");
				boutonQuitter.setBounds(800, 13, 97, 25);
				boutonQuitter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						for (Component composant : pPanelPrincipal
								.getComponents()) {
							if (composant.getName().equals("Gestion Transport"))
								pPanelPrincipal.remove(composant);
						}
						pPanelPrincipal.repaint();

					}
				});

				boutonAjouterTransport = new JButton("+");
				boutonAjouterTransport.setBounds(12, 589, 97, 25);

				boutonSupprimerTransport = new JButton("-");
				boutonSupprimerTransport.setBounds(121, 589, 97, 25);

				boutonModifierTransport = new JButton("Editer");
				boutonModifierTransport.setBounds(230, 589, 97, 25);

				boutonValiderTransport = new JButton("Valider");
				boutonValiderTransport.setBounds(340, 589, 97, 25);

				boutonAnnulerTransport = new JButton("Annuler");
				boutonAnnulerTransport.setBounds(450, 589, 97, 25);

				boutonValiderTransport.setEnabled(false);
				boutonAnnulerTransport.setEnabled(false);

				boutonSupprimerTransport
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								tblModelTransport.removeElement(tableTransport
										.getSelectedRow());

							}

						});

				boutonAjouterTransport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						disableTransportButton(true);
						tblModelTransport.addElement();

					}

				});

				boutonModifierTransport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						tblModelTransport.updateElement(tableTransport
								.getSelectedRow());

					}

				});

				boutonValiderTransport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (tableTransport.isEditing()) {
							tableTransport.getCellEditor().stopCellEditing();
						}
						disableTransportButton(false);
						tblModelTransport.persistData(
								tableTransport.getSelectedRow() + 1, true);
					}

				});

				boutonAnnulerTransport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						disableTransportButton(false);
						tblModelTransport.persistData(
								tableTransport.getSelectedRow(), false);

					}

				});

				txtGestionTransport = new JTextField();
				txtGestionTransport = new JTextField();
				txtGestionTransport
						.setHorizontalAlignment(SwingConstants.CENTER);
				txtGestionTransport.setEnabled(false);
				txtGestionTransport.setPreferredSize(new Dimension(20, 20));
				txtGestionTransport.setText("Gestion Transport");
				txtGestionTransport.setColumns(10);
				txtGestionTransport.setBounds(44, 11, 260, 25);

				scrollPanelTransport = new JScrollPane();
				scrollPanelTransport.setName("Scroll Transport");
				scrollPanelTransport.setViewportView(tableTransport);
				scrollPanelTransport.setBounds(12, 56, 800, 486);

				// --------------------------------Onglet
				// compartiment------------------------------------------------//

				compartimentTableModel = new CompartimentTableModel();
				tableCompartiment = new JTable(compartimentTableModel);
				tableCompartiment.setName("Table Compartiments");
				tableCompartiment.setBounds(12, 72, 899, 800);
				tableCompartiment
						.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableCompartiment.setCellSelectionEnabled(false);
				tableCompartiment.setRowSelectionAllowed(true);

				boutonQuitterCompartiment = new JButton("Quitter");
				boutonQuitterCompartiment.setBounds(800, 13, 97, 25);
				boutonQuitterCompartiment.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						for (Component composant : pPanelPrincipal
								.getComponents()) {
							if (composant.getName().equals("Gestion Transport"))
								pPanelPrincipal.remove(composant);
						}
						pPanelPrincipal.repaint();

					}
				});

				boutonAjouterCompartiment = new JButton("+");
				boutonAjouterCompartiment.setBounds(12, 589, 97, 25);

				boutonSupprimerCompartiment = new JButton("-");
				boutonSupprimerCompartiment.setBounds(121, 589, 97, 25);

				boutonModifierCompartiment = new JButton("Editer");
				boutonModifierCompartiment.setBounds(230, 589, 97, 25);

				boutonValiderCompartiment = new JButton("Valider");
				boutonValiderCompartiment.setBounds(340, 589, 97, 25);

				boutonAnnulerCompartiment = new JButton("Annuler");
				boutonAnnulerCompartiment.setBounds(450, 589, 97, 25);

				boutonValiderCompartiment.setEnabled(false);
				boutonAnnulerCompartiment.setEnabled(false);

				// Event sur les boutons

				boutonSupprimerCompartiment
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								compartimentTableModel
										.removeElement(tableCompartiment
												.getSelectedRow());

							}

						});

				boutonAjouterCompartiment
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								disableCompartimentButton(true);
								compartimentTableModel.addElement();
								tableCompartiment.setRowSelectionInterval(
										tableCompartiment.getRowCount() - 1,
										tableCompartiment.getRowCount() - 1);

							}

						});

				boutonModifierCompartiment
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								compartimentTableModel
										.updateElement(tableCompartiment
												.getSelectedRow());

							}

						});

				boutonValiderCompartiment
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (tableCompartiment.isEditing()) {
									tableCompartiment.getCellEditor()
											.stopCellEditing();
								}
								disableCompartimentButton(false);
								compartimentTableModel.persistData(
										tableCompartiment.getSelectedRow(),
										true);

							}

						});

				boutonAnnulerCompartiment
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								disableCompartimentButton(false);
								compartimentTableModel.persistData(
										tableCompartiment.getSelectedRow(),
										false);

							}

						});

				txtCompartiment = new JTextField();
				txtCompartiment.setHorizontalAlignment(SwingConstants.CENTER);
				txtCompartiment.setEnabled(false);
				txtCompartiment.setPreferredSize(new Dimension(20, 20));
				txtCompartiment.setText("Gestion Compartiments");
				txtCompartiment.setColumns(10);
				txtCompartiment.setBounds(44, 11, 260, 25);

				scrollPanelCompartiment = new JScrollPane();
				scrollPanelCompartiment.setName("Scroll Compartiments");
				scrollPanelCompartiment.setViewportView(tableCompartiment);
				scrollPanelCompartiment.setBounds(12, 56, 800, 486);

				// ---------------------------------------------création et
				// ajout des Jpanel dans le
				// Tabprincipal---------------------------------------------------//

				jpanelCompartiment = new JPanel();
				jpanelCompartiment.setBounds(0, 0, 1017, 706);
				jpanelCompartiment.add(scrollPanelCompartiment);
				jpanelCompartiment.setName("Gestion Compartiments");
				jpanelCompartiment.setLayout(null);
				jpanelCompartiment.add(txtCompartiment);
				jpanelCompartiment.add(boutonModifierCompartiment);
				jpanelCompartiment.add(boutonSupprimerCompartiment);
				jpanelCompartiment.add(boutonAjouterCompartiment);
				jpanelCompartiment.add(boutonQuitterCompartiment);
				jpanelCompartiment.add(boutonValiderCompartiment);
				jpanelCompartiment.add(boutonAnnulerCompartiment);

				jpanelTransport = new JPanel();
				jpanelTransport.add(boutonModifierTransport);
				jpanelTransport.setBounds(0, 0, 1017, 706);
				jpanelTransport.setName("Gestion Transport");
				jpanelTransport.setLayout(null);
				jpanelTransport.add(scrollPanelTransport);
				jpanelTransport.add(txtGestionTransport);
				jpanelTransport.add(boutonQuitter);
				jpanelTransport.add(boutonModifierTransport);
				jpanelTransport.add(boutonSupprimerTransport);
				jpanelTransport.add(boutonAjouterTransport);
				jpanelTransport.add(boutonValiderTransport);
				jpanelTransport.add(boutonAnnulerTransport);

				tabPrincipal = new JTabbedPane();
				tabPrincipal.setName("Gestion Transport");
				tabPrincipal.setBounds(0, 0, 1017, 706);
				tabPrincipal.add(jpanelTransport);
				tabPrincipal.add(jpanelCompartiment);

				pPanelPrincipal.add(tabPrincipal, new Integer(2));
				pPanelPrincipal.revalidate();

				// Suppression de la colonne UID

				// tableCompartiment.removeColumn(tableCompartiment
				// .getColumn("uid"));

			}
		};

		return action;

	}

	private static void disableCompartimentButton(boolean disable) {
		if (disable) {
			boutonAjouterCompartiment.setEnabled(false);
			boutonSupprimerCompartiment.setEnabled(false);
			boutonModifierCompartiment.setEnabled(false);
			boutonValiderCompartiment.setEnabled(true);
			boutonAnnulerCompartiment.setEnabled(true);
		} else {
			boutonAjouterCompartiment.setEnabled(true);
			boutonSupprimerCompartiment.setEnabled(true);
			boutonModifierCompartiment.setEnabled(true);
			boutonValiderCompartiment.setEnabled(false);
			boutonAnnulerCompartiment.setEnabled(false);
		}
	}

	private static void disableTransportButton(boolean disable) {
		if (disable) {
			boutonAjouterTransport.setEnabled(false);
			boutonSupprimerTransport.setEnabled(false);
			boutonModifierTransport.setEnabled(false);
			boutonValiderTransport.setEnabled(true);
			boutonAnnulerTransport.setEnabled(true);
		} else {
			boutonAjouterTransport.setEnabled(true);
			boutonSupprimerTransport.setEnabled(true);
			boutonModifierTransport.setEnabled(true);
			boutonValiderTransport.setEnabled(false);
			boutonAnnulerTransport.setEnabled(false);
		}
	}

};
