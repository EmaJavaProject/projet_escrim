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





public class GestionAvion extends EscrimModelTable {

	public static ActionListener CréationJpanelAvion (JLayeredPane pPanelPrincipal) {
		
	
		ActionListener action = new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
            {
        		if (pPanelPrincipal!=null)
        		{
        			 /** J'ai été obligé de faire un double foreach car quand ont repasse dans cette méthode composantPanelPrincipal devient le pPanelPrincipal.
					*je ne sais pas pk si vous avez une autre solution pour limité le nombre de Tad gestion des avions.ps le singleton ne marche pas ici.
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
        		//--------------------------------Onglet Avion------------------------------------------------//
        		
        		JPanel jpanelAvion = new JPanel();
        		JTextField txtGestionAvion = new JTextField();
        		
        		DefaultTableModel tblModelAvion = new DefaultTableModel();
        		JTable tableAvion = new JTable(tblModelAvion);
        		JButton boutonAjouterAvion = new JButton("+");
        		JButton boutonQuitter = new JButton("Quitter");
        		JButton boutonSupprimerAvion = new JButton("-");
        		JButton boutonModifierAvion = new JButton("Editer");  
        		JScrollPane scrollPanelAvion = new JScrollPane();
        		 
        		tableAvion.setName("Table Transports");
            	
            	tableAvion.setModel(EscrimModelTable.BuildTableColumn(
            			tblModelAvion, tableAvion.getName()));
            	tableAvion.getColumn(tableAvion.getColumnName(0))
        				.setMaxWidth(20);
            	tableAvion.setBounds(12, 72, 899, 800);
            	
            
            	
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
            	
            	

        		
            	jpanelAvion.add(boutonQuitter);
            	
            	boutonAjouterAvion.setBounds(12, 589, 97, 25);
            	jpanelAvion.add(boutonAjouterAvion);
        		
        		boutonSupprimerAvion.setBounds(121, 589, 97, 25);
        		jpanelAvion.add(boutonSupprimerAvion);

        		boutonModifierAvion.setBounds(230, 589, 97, 25);
        		jpanelAvion.add(boutonModifierAvion);	

        		txtGestionAvion = new JTextField();
            	txtGestionAvion.setHorizontalAlignment(SwingConstants.CENTER);
            	txtGestionAvion.setEnabled(false);
            	txtGestionAvion.setPreferredSize(new Dimension(20, 20));
            	txtGestionAvion.setText("Gestion Transport");
            	txtGestionAvion.setColumns(10);
            	txtGestionAvion.setBounds(44, 11, 260, 25);
            	jpanelAvion.add(txtGestionAvion);
            	
            	scrollPanelAvion.setName("Scroll Transport");
            	scrollPanelAvion.setViewportView(tableAvion);
            	scrollPanelAvion.setBounds(12, 56, 800, 486);
            	jpanelAvion.setBounds(0, 0, 1017, 706);
            	jpanelAvion.add(scrollPanelAvion);
            	jpanelAvion.setName("Gestion Transport");
            	jpanelAvion.setLayout(null);
            	
            	JTabbedPane tabPrincipal = new JTabbedPane();
        		tabPrincipal.setName("Gestion Transport");
        		tabPrincipal.setBounds(0, 0, 1017, 706);
        		tabPrincipal.add(jpanelAvion);
        		//--------------------------------Onglet compartiment------------------------------------------------//
        		
        		JPanel jpanelCompartiment = new JPanel();
        		JTextField txtCompartiment = new JTextField();
        		
        		DefaultTableModel tblModelCompartiment = new DefaultTableModel();
        		JTable tableCompartiment = new JTable(tblModelAvion);
        		JButton boutonAjouterCompartiment = new JButton("+");
        		JButton boutonQuitterCompartiment = new JButton("Quitter");
        		JButton boutonSupprimerCompartiment = new JButton("-");
        		JButton boutonModifierCompartiment = new JButton("Editer");  
        		JScrollPane scrollPanelCompartiment = new JScrollPane();
        		
        		tableCompartiment.setName("Table Compartiments");
        		tableCompartiment.setModel(EscrimModelTable.BuildTableColumn(
            			tblModelCompartiment, tableCompartiment.getName()));
        		tableCompartiment.getColumn(tableCompartiment.getColumnName(0))
        				.setMaxWidth(20);
        		tableCompartiment.setBounds(12, 72, 899, 800);
            	
            
            	
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
            	
            	

        		
        		jpanelCompartiment.add(boutonQuitterCompartiment);
            	
        		boutonAjouterCompartiment.setBounds(12, 589, 97, 25);
        		jpanelCompartiment.add(boutonAjouterCompartiment);
        		
            	boutonSupprimerCompartiment.setBounds(121, 589, 97, 25);
        		jpanelCompartiment.add(boutonSupprimerCompartiment);

        		boutonModifierCompartiment.setBounds(230, 589, 97, 25);
        		jpanelCompartiment.add(boutonModifierCompartiment);	

        		txtCompartiment = new JTextField();
        		txtCompartiment.setHorizontalAlignment(SwingConstants.CENTER);
        		txtCompartiment.setEnabled(false);
        		txtCompartiment.setPreferredSize(new Dimension(20, 20));
        		txtCompartiment.setText("Gestion Compartiments");
        		txtCompartiment.setColumns(10);
        		txtCompartiment.setBounds(44, 11, 260, 25);
        		jpanelCompartiment.add(txtCompartiment);
            	
        		scrollPanelCompartiment.setName("Scroll Compartiments");
        		scrollPanelCompartiment.setViewportView(tableCompartiment);
        		scrollPanelCompartiment.setBounds(12, 56, 800, 486);
        		jpanelCompartiment.setBounds(0, 0, 1017, 706);
        		jpanelCompartiment.add(scrollPanelCompartiment);
        		jpanelCompartiment.setName("Gestion Compartiments");
        		jpanelCompartiment.setLayout(null);
       
        		tabPrincipal.add(jpanelCompartiment);
            	
            	pPanelPrincipal.add(tabPrincipal, new Integer(2));
            	pPanelPrincipal.revalidate();
            	

            	
            
            	
            
            }
       };

		return action;
	

	}
	
};


