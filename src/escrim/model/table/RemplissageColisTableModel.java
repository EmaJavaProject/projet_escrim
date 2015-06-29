package escrim.model.table;

import java.util.ArrayList;
import java.util.List;

import escrim.manager.MaterielManager;
import escrim.manager.MedicamentManager;
import escrim.metiers.Materiel;
import escrim.metiers.Medicament;

@SuppressWarnings("serial")
public class RemplissageColisTableModel extends EscrimTableModel {
	private List<Materiel> listeMateriel = new ArrayList();
	private String[] MaterielColumnName = { "Type", "Denomination",
			"Observations", "Quantite", "uid" };
	private int uidColisToManage;

	public RemplissageColisTableModel(boolean allMateriel, int uidColis) {
		uidColisToManage = uidColis;
		if (allMateriel) {
			listeMateriel = MaterielManager.loadOutsideColis(uidColisToManage);
		} else {
			listeMateriel = MaterielManager.loadByColis(uidColisToManage);
		}
	}

	public int getColumnCount() {
		return 5;
	}

	public void refreshModel(boolean allMateriel) {
		if (allMateriel) {
			listeMateriel = MaterielManager.loadOutsideColis(uidColisToManage);

		} else {
			listeMateriel = MaterielManager.loadByColis(uidColisToManage);
		}
		fireTableDataChanged();

	}

	public int getRowCount() {
		if (listeMateriel != null) {
			return listeMateriel.size();
		} else {
			return 0;
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		return MaterielColumnName[columnIndex];
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
			return String.class;
		case 4:
			return Integer.class;
		}
		return null;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Materiel materiel = listeMateriel.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return materiel.getType();
		case 1:
			return materiel.getDenomination();
		case 2:
			if (materiel.getType() == "Materiel") {
				return materiel.getObservations();
			} else {
				if (materiel instanceof Medicament) {
					Medicament tempMed = MedicamentManager
							.createTempMedicament();
					tempMed = (Medicament) materiel;
					return tempMed.getDosage();
				}
			}
		case 3:
			return materiel.getQuantite();
		case 4:
			return materiel.getUid();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			listeMateriel.get(rowIndex).setType(
					aValue == null ? null : aValue.toString());
			break;
		case 1:
			listeMateriel.get(rowIndex).setDenomination(
					aValue == null ? null : aValue.toString());
			break;
		case 2:
			if (listeMateriel.get(rowIndex).getType() == "Materiel") {
				listeMateriel.get(rowIndex).setObservations(
						aValue == null ? null : aValue.toString());
			} else {
				if (listeMateriel.get(rowIndex) instanceof Medicament) {
					((Medicament) listeMateriel.get(rowIndex))
							.setDosage(aValue == null ? null : aValue
									.toString());
				}
			}
			break;
		case 3:
			listeMateriel.get(rowIndex).setQuantite(
					aValue == null ? new Integer(0) : Integer
							.parseInt(((String) aValue).trim()));
			break;
		}
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;

	}

}
