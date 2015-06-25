package escrim.model.table;

import java.util.List;

import escrim.manager.MaterielManager;
import escrim.metiers.Materiel;

@SuppressWarnings("serial")
public class MaterielTableModel extends EscrimTableModel {
	private List<Materiel> listeMateriel = MaterielManager.loadAllMateriel();
	private String[] MaterielColumnName = { "", "Denomination", "Observations",
			"Quantite", "uid" };

	public MaterielTableModel() {
		listeMateriel = MaterielManager.loadAllMateriel();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return MaterielColumnName[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (listeMateriel != null) {
			return listeMateriel.size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Materiel Materiel = listeMateriel.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return Materiel.getDenomination();
		case 2:
			return Materiel.getObservations();
		case 3:
			return Materiel.getQuantite();
		case 4:
			return Materiel.getUid();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 1:
			listeMateriel.get(rowIndex).setDenomination(
					aValue == null ? null : aValue.toString());
			break;
		case 2:
			listeMateriel.get(rowIndex).setObservations(
					aValue == null ? null : aValue.toString());
			break;
		case 3:
			listeMateriel.get(rowIndex).setQuantite(
					aValue == null ? new Integer(0) : Integer
							.parseInt(((String) aValue).trim()));
			break;
		default:
			break;
		}
	}

	public void validatePersistance(int rowIndex) {
		MaterielManager.createMateriel(listeMateriel.get(rowIndex));
	}

	public void refreshModel() {
		listeMateriel = MaterielManager.loadAllMateriel();
		fireTableDataChanged();
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

	public void addElement() {
		// Adds the element in the last position in the list
		super.setAddition(true);
		super.setEdition(false);
		super.setRemove(false);
		listeMateriel.add(getRowCount(), MaterielManager.createTempMateriel());
		fireTableRowsInserted(0, getRowCount());
	}

	public void removeElement(int rowIndex) {
		super.setRemove(true);
		super.setAddition(false);
		super.setEdition(false);
		persistData(rowIndex, true);
	}

	public void persistData(int rowIndex, boolean validate) {
		if (validate) {
			if (super.isAddition() && !super.isEdition() && !super.isRemove()) {
				MaterielManager.createMateriel(listeMateriel.get(rowIndex));
				setAddition(false);
			} else if (!super.isAddition() && super.isEdition()
					&& !super.isRemove()) {
				MaterielManager.updateMateriel(listeMateriel.get(rowIndex),
						(Integer) getValueAt(rowIndex, 6));
				setEdition(false);
			} else if (!super.isAddition() && !super.isEdition()
					&& super.isRemove()) {
				MaterielManager.removeMateriel((Integer) getValueAt(rowIndex,
						getColumnCount() - 1));
				setRemove(false);
			}
		}

		refreshModel();

	}

	public void updateElement(int rowIndex) {
		setEditedRow(rowIndex);
		setEdition(true);
		setAddition(false);
		setRemove(false);
	}
}
