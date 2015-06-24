package ihm;

import java.util.Date;

import javax.swing.JTable;

import escrim.manager.MedicamentManager;

public class MedicamentTable extends JTable{

	public void addMedicament(int index){
		MedicamentManager.createMedicaments((String) this.getModel().getValueAt(index, 1),
											(String) this.getModel().getValueAt(index, 2),
											(String) this.getModel().getValueAt(index, 3),
											(Date) this.getModel().getValueAt(index, 4),
											Integer.parseInt((String)this.getModel().getValueAt(index, 5)),
											(String) this.getModel().getValueAt(index, 6),
											(String) this.getModel().getValueAt(index, 7),
											Integer.parseInt((String)this.getModel().getValueAt(index, 8)));
	}

	public void editMedicament(int index){
		MedicamentManager.updateMedicaments(Integer.parseInt((String)this.getModel().getValueAt(index, 9)),
											(String) this.getModel().getValueAt(index, 1),
											(String) this.getModel().getValueAt(index, 2),
											(String) this.getModel().getValueAt(index, 3),
											(Date) this.getModel().getValueAt(index, 4),
											Integer.parseInt((String)this.getModel().getValueAt(index, 5)),
											(String) this.getModel().getValueAt(index, 6),
											(String) this.getModel().getValueAt(index, 7),
											Integer.parseInt((String)this.getModel().getValueAt(index, 8)));
	}

	public void removeMedicament(int index){
		MedicamentManager.deleteMedicaments(Integer.parseInt((String)this.getModel().getValueAt(index, 9)));
	}
}
