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

/**
 * The Class GestionTransport.
 */
public class GestionTransport {

	/** The jpanel transport. */
	private static JPanel jpanelTransport;
	
	/** The txt gestion transport. */
	private static JTextField txtGestionTransport;
	
	/** The tbl model transport. */
	private static TransportTableModel tblModelTransport;
	
	/** The table transport. */
	private static JTable tableTransport;
	
	/** The bouton ajouter transport. */
	private static JButton boutonAjouterTransport;
	
	/** The bouton quitter. */
	private static JButton boutonQuitter;
	
	/** The bouton remplissagecompartiment transport. */
	private static JButton boutonRemplissagecompartimentTransport;
	
	/** The bouton supprimer transport. */
	private static JButton boutonSupprimerTransport;
	
	/** The bouton modifier transport. */
	private static JButton boutonModifierTransport;
	
	/** The bouton valider transport. */
	private static JButton boutonValiderTransport;
	
	/** The bouton annuler transport. */
	private static JButton boutonAnnulerTransport;
	
	/** The scroll panel transport. */
	private static JScrollPane scrollPanelTransport;
	
	/** The jpanel compartiment. */
	private static JPanel jpanelCompartiment;
	
	/** The txt compartiment. */
	private static JTextField txtCompartiment;
	
	/** The compartiment table model. */
	private static CompartimentTableModel compartimentTableModel;
	
	/** The table compartiment. */
	private static JTable tableCompartiment;
	
	/** The bouton ajouter compartiment. */
	private static JButton boutonAjouterCompartiment;
	
	/** The bouton quitter compartiment. */
	private static JButton boutonQuitterCompartiment;
	
	/** The bouton supprimer compartiment. */
	private static JButton boutonSupprimerCompartiment;
	
	/** The bouton modifier compartiment. */
	private static JButton boutonModifierCompartiment;
	
	/** The bouton valider compartiment. */
	private static JButton boutonValiderCompartiment;
	
	/** The bouton annuler compartiment. */
	private static JButton boutonAnnulerCompartiment;
	
	/** The scroll panel compartiment. */
	private static JScrollPane scrollPanelCompartiment;
	
	/** The tab principal. */
	private static JTabbedPane tabPrincipal;

	/**
	 * Création jpanel transport.
	 *
	 * @param pPanelPrincipal the panel principal
	 * @return the action listener
	 * @wbp.parser.entryPoint 
	 */
	public static ActionListener CreationJpanelTransport(
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
									&& composantsPanelPrincipal
											.getName()
											.equals("Création de type de colis")
									|| composantsPanelPrincipal
											.getName()
											.equals("Gestion configuration d'hopital")
									|| composantsPanelPrincipal
											.getName()
											.equals("Création de type de colis")
									|| composantsPanelPrincipal.getName()
											.equals("Remplissage")) {
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

				boutonRemplissagecompartimentTransport = new JButton(
						"éditer le transport sélectionné");
				boutonRemplissagecompartimentTransport.setBounds(560, 589, 230,
						25);
				boutonRemplissagecompartimentTransport
						.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								if (!(tableTransport.getSelectedRow() == -1))
									Remplissage
											.CréationJpanelRemplissageTransport(
													pPanelPrincipal,
													tblModelTransport,
													(int) tblModelTransport.getValueAt(
															tableTransport
																	.getSelectedRow(),
															tableTransport
																	.getColumnCount()));

							}

						});

				boutonValiderTransport.setEnabled(false);
				boutonAnnulerTransport.setEnabled(false);

				boutonSupprimerTransport
						.addActionListener(new ActionListener() {
							@SuppressWarnings("deprecation")
							public void actionPerformed(ActionEvent arg0) {
								if (!(tableTransport.getSelectedRow() == -1)) {
									tblModelTransport
											.removeElement(tableTransport
													.getSelectedRow());
								}
							}

						});

				boutonAjouterTransport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						disableTransportButton(true);
						tblModelTransport.addElement();
						tableTransport.setRowSelectionInterval(
								tableTransport.getRowCount() - 1,
								tableTransport.getRowCount() - 1);

					}

				});

				boutonModifierTransport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (!(tableTransport.getSelectedRow() == -1)) {
							disableTransportButton(true);
							tblModelTransport.updateElement(tableTransport
									.getSelectedRow());

						}
					}

				});

				boutonValiderTransport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (tableTransport.isEditing()) {
							tableTransport.getCellEditor().stopCellEditing();
						}
						disableTransportButton(false);
						tblModelTransport.persistData(
								tableTransport.getSelectedRow(), true);
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
								if (!(tableCompartiment.getSelectedRow() == -1)) {
									compartimentTableModel
											.removeElement(tableCompartiment
													.getSelectedRow());
								}
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
								if (!(tableCompartiment.getSelectedRow() == -1)) {
									disableCompartimentButton(true);
									compartimentTableModel
											.updateElement(tableCompartiment
													.getSelectedRow());
								}

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
				jpanelTransport.add(boutonRemplissagecompartimentTransport);
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

				tableCompartiment.removeColumn(tableCompartiment
						.getColumn("uid"));
				tableTransport.removeColumn(tableTransport.getColumn("uid"));

			}
		};

		return action;

	}

	/**
	 * Fonction de gestion des boutons de la vue compartiment.
	 *
	 * @param disable the disable
	 */

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

	/**
	 * Fonction de gestion des boutons de la vue Transport.
	 *
	 * @param disable the disable
	 */

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
