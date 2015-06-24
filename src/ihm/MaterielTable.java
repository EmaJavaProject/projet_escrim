package ihm;

import javax.swing.JTable;

import escrim.manager.MaterielManager;


public class MaterielTable extends JTable{
	
	public void addMateriel(int index){
		MaterielManager.createMateriel((String) this.getModel().getValueAt(index, 1),
										(String) this.getModel().getValueAt(index, 2),
										Integer.parseInt((String) this.getModel().getValueAt(index, 3)));	
	}
	
	public void editMateriel(int index){
		MaterielManager.updateMateriel(Integer.parseInt((String) this.getModel().getValueAt(index, 4)),
										(String) this.getModel().getValueAt(index, 1),
										(String) this.getModel().getValueAt(index, 2),
										Integer.parseInt((String) this.getModel().getValueAt(index, 3)));
	}
	
	public void removeMateriel(int index){
		MaterielManager.deleteMateriel(Integer.parseInt((String)this.getModel().getValueAt(index, 4)));
	}
}
