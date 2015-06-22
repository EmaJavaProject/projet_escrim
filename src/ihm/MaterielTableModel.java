package ihm;
import java.util.ArrayList;
import java.util.List;

import escrim.manager.MaterielManager;
import escrim.metiers.Materiel;

public class MaterielTableModel extends EscrimTableModel{
	private List<Materiel> listeMateriel = new ArrayList();
	public String[] materielColName = { "", "Dénomination",
		"Observations", "Quantité", "uid" };

	public MaterielTableModel() {
		listeMateriel = MaterielManager.loadAllMateriels();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return materielColName[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (listeMateriel != null) {
			return listeMateriel.size();
		} else
			return 0;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Materiel materiel = listeMateriel.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return materiel.getDenomination();
		case 2:
			return materiel.getObservations();
		case 3:
			return materiel.getQuantite();
		case 4:
			return materiel.getId();
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return Integer.class;
		case 4:
			return Integer.class;
		}
		return null;
	}

	public void addRow() {
		listeMateriel.add(0, null);
		fireTableDataChanged();
	}	
}
