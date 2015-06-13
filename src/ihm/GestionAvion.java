package ihm;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;





public class GestionAvion extends IhmBuilder {

	public static ActionListener Cr�ationJpanelAvion(JTabbedPane pPanelPrincipal){
		
		

		
	
		ActionListener action = new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
            {
        		if (pPanelPrincipal!=null)
        		{
        			 /** J'ai �t� oblig� de faire un double foreach car quand ont repasse dans cette m�thode composantPanelPrincipal devient le pPanelPrincipal.
					*je ne sais pas pk si vous avez une autre solution pour limit� le nombre de Tad gestion des avions.ps le singleton ne marche pas ici.
					*le double foreach ici ne g�ne pas la performance car quand nous ont revient dans cette m�thod pPanelPrincipal ne comptient qu'un seul composants. 
					*Si je ne suis pas assez clair faite moi signe je vous expliquerai ou sinon rentr� en debug pour voir ce qu'il ce passe vraiment
					*ps ce commentaire sera enlev� si le prof regarde notre code vu les fautes d'orthographes.
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
        		JButton boutonSupprimerAvion = new JButton("-");
        		JButton boutonModifierAvion = new JButton("Editer");  
        		JScrollPane scrollPanelAvion = new JScrollPane();
        		 
 

        		tableAvion.setName("Gestion Avion");
            	
            	tableAvion.setModel(IhmBuilder.BuildTableColumn(
            			tblModelAvion, tableAvion.getName()));
            	tableAvion.getColumn(tableAvion.getColumnName(0))
        				.setMaxWidth(20);
            	tableAvion.setBounds(12, 72, 899, 800);
            	
            	
            	
            	boutonAjouterAvion.setBounds(12, 589, 97, 25);
            	jpanelAvion.add(boutonAjouterAvion);
        		
        		boutonSupprimerAvion.setBounds(121, 589, 97, 25);
        		jpanelAvion.add(boutonSupprimerAvion);

        		boutonModifierAvion.setBounds(230, 589, 97, 25);
        		jpanelAvion.add(boutonModifierAvion);	
            	
            	scrollPanelAvion.setName("Gestion Avion");
            	scrollPanelAvion.setViewportView(tableAvion);
            	scrollPanelAvion.setBounds(12, 56, 800, 486);
            	
            	jpanelAvion.add(scrollPanelAvion);
            	jpanelAvion.setLayout(null);
            	
            	pPanelPrincipal.add(jpanelAvion);
            	pPanelPrincipal.setMinimumSize(new Dimension(20, 20));
            	pPanelPrincipal.addTab("Gestion Avion", null, jpanelAvion, null);
            	jpanelAvion.setLayout(null);
            	
            	
            
            }
       };

		return action;
	

	}
}