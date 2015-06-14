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
import javax.swing.table.DefaultTableModel;





public class GestionAvion extends IhmBuilder {

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

        					if (composantsPanelPrincipal != null  && composantsPanelPrincipal.getName()!=null && composantsPanelPrincipal.getName().equals("Gestion Avion"))
        					{
        						return;
        					}
        				}
        			}
        		}
        		
        		
        		JPanel jpanelAvion = new JPanel();
        		DefaultTableModel tblModelAvion = new DefaultTableModel();
        		JTable tableAvion = new JTable(tblModelAvion);
        		JButton boutonAjouterAvion = new JButton("+");
        		JButton boutonQuitter = new JButton("Quitter");
        		JButton boutonSupprimerAvion = new JButton("-");
        		JButton boutonModifierAvion = new JButton("Editer");  
        		JScrollPane scrollPanelAvion = new JScrollPane();
        		 
        		tableAvion.setName("Table Avion");
            	
            	tableAvion.setModel(IhmBuilder.BuildTableColumn(
            			tblModelAvion, tableAvion.getName()));
            	tableAvion.getColumn(tableAvion.getColumnName(0))
        				.setMaxWidth(20);
            	tableAvion.setBounds(12, 72, 899, 800);
            	
            
            	
            	boutonQuitter.setBounds(800, 13, 97, 25);
            	boutonQuitter.addMouseListener(new MouseAdapter() {
        			@Override
        			public void mouseClicked(MouseEvent arg0) {
        				for (Component composant : pPanelPrincipal.getComponents()) {
        					if (composant.getName().equals("Gestion Avion"))
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

            	scrollPanelAvion.setName("Scroll Avion");
            	scrollPanelAvion.setViewportView(tableAvion);
            	scrollPanelAvion.setBounds(12, 56, 800, 486);
            	jpanelAvion.setBounds(0, 0, 1017, 706);
            	jpanelAvion.add(scrollPanelAvion);
            	jpanelAvion.setName("Gestion Avion");
            	jpanelAvion.setLayout(null);
            	
            	pPanelPrincipal.add(jpanelAvion, new Integer(2));
            	pPanelPrincipal.revalidate();
            	

            	
            
            	
            
            }
       };

		return action;
	

	}
	
};


