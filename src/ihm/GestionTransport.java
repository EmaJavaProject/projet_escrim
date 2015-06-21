package ihm;


import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;





public class GestionTransport extends EscrimModelTable {
	
		
	private static JPanel jpanelTransport;
	private static JTextField txtGestionTransport;
	private static DefaultTableModel tblModelTransport;
	private static JTable tableTransport;
	private static JButton boutonAjouterTransport;
	private static JButton boutonQuitter;
	private static JButton boutonSupprimerTransport;
	private static JButton boutonModifierTransport;  
	private static JScrollPane scrollPanelTransport;
	private static JPanel jpanelCompartiment;
	private static JTextField txtCompartiment; 
	private static DefaultTableModel tblModelCompartiment ;
	private static JTable tableCompartiment;
	private static JButton boutonAjouterCompartiment;
	private static JButton boutonQuitterCompartiment;
	private static JButton boutonSupprimerCompartiment;
	private static JButton boutonModifierCompartiment;  
	private static JScrollPane scrollPanelCompartiment;
	private static JTabbedPane tabPrincipal;

	public static ActionListener CréationJpanelTransport (JLayeredPane pPanelPrincipal) {
		
	
		ActionListener action = new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
            {
        		if (pPanelPrincipal!=null)
        		{
        			 /** J'ai été obligé de faire un double foreach car quand ont repasse dans cette méthode composantPanelPrincipal devient le pPanelPrincipal.
					*je ne sais pas pk si vous avez une autre solution pour limité le nombre de Tad gestion des Transports.ps le singleton ne marche pas ici.
					*le double foreach ici ne géne pas la performance car quand nous ont revient dans cette méthod pPanelPrincipal ne comptient qu'un seul composants. 
					*Si je ne suis pas assez clair faite moi signe je vous expliquerai ou sinon rentré en debug pour voir ce qu'il ce passe vraiment
					*ps ce commentaire sera enlevé si le prof regarde notre code vu les fautes d'orthographes.
					*/
        			
        			for (Component composantPanelPrincipal : pPanelPrincipal.getComponents()) 
        			{																				
        				for (Component composantsPanelPrincipal : composantPanelPrincipal.getParent().getComponents()) 
        				{

        					if (composantsPanelPrincipal != null  && composantsPanelPrincipal.getName()!=null && composantsPanelPrincipal.getName().equals("Gestion Transport"))
        					{
        						return;
        					}
        				}
        			}
        		}
        		//--------------------------------Onglet Transport------------------------------------------------//
        		
        		
        		
        		
        		tblModelTransport = new DefaultTableModel();
        		tableTransport = new JTable(tblModelTransport);
        		tableTransport.setName("Table Transports");
            	tableTransport.setModel(EscrimModelTable.BuildTableColumn(
            			tblModelTransport, tableTransport.getName()));
            	tableTransport.getColumn(tableTransport.getColumnName(0))
        				.setMaxWidth(20);
            	tableTransport.setBounds(12, 72, 899, 800);
            	boutonQuitter = new JButton("Quitter");
            	boutonQuitter.setBounds(800, 13, 97, 25);
            	boutonQuitter.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseClicked(MouseEvent arg0) {
        				for (Component composant : pPanelPrincipal.getComponents()) {
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
        		
        		txtGestionTransport = new JTextField();
        		txtGestionTransport = new JTextField();
            	txtGestionTransport.setHorizontalAlignment(SwingConstants.CENTER);
            	txtGestionTransport.setEnabled(false);
            	txtGestionTransport.setPreferredSize(new Dimension(20, 20));
            	txtGestionTransport.setText("Gestion Transport");
            	txtGestionTransport.setColumns(10);
            	txtGestionTransport.setBounds(44, 11, 260, 25);
            	
            	scrollPanelTransport = new JScrollPane();
            	scrollPanelTransport.setName("Scroll Transport");
            	scrollPanelTransport.setViewportView(tableTransport);
            	scrollPanelTransport.setBounds(12, 56, 800, 486);
            	

        		//--------------------------------Onglet compartiment------------------------------------------------//
        		
        		
        		tblModelCompartiment = new DefaultTableModel();
        		tableCompartiment = new JTable(tblModelTransport);
        		tableCompartiment.setName("Table Compartiments");
        		tableCompartiment.setModel(EscrimModelTable.BuildTableColumn(
            			tblModelCompartiment, tableCompartiment.getName()));
        		tableCompartiment.getColumn(tableCompartiment.getColumnName(0))
        				.setMaxWidth(20);
        		tableCompartiment.setBounds(12, 72, 899, 800);
            	
            
        		boutonQuitterCompartiment = new JButton("Quitter");
        		boutonQuitterCompartiment.setBounds(800, 13, 97, 25);
        		boutonQuitterCompartiment.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseClicked(MouseEvent arg0) {
        				for (Component composant : pPanelPrincipal.getComponents()) {
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
        		
        		txtCompartiment = new JTextField();
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

        		//---------------------------------------------création et ajout des Jpanel dans le Tabprincipal---------------------------------------------------//
        		
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
            	jpanelTransport.add(boutonAjouterTransport);
            	
            	
            	
            	tabPrincipal = new JTabbedPane();	
        		tabPrincipal.setName("Gestion Transport");
        		tabPrincipal.setBounds(0, 0, 1017, 706);
        		tabPrincipal.add(jpanelTransport);
        		tabPrincipal.add(jpanelCompartiment);
        		
            	pPanelPrincipal.add(tabPrincipal, new Integer(2));
            	pPanelPrincipal.revalidate();
            	

            	
            
            	
            
            }
       };

		return action;
	

	}
	
};


