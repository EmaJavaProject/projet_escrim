package escrim.model.table;

import java.util.List;

import escrim.manager.MaterielManager;
import escrim.metiers.Materiel;

/**
 * The Class MaterielTableModel.
 */
@SuppressWarnings("serial")
public class MaterielTableModel extends EscrimTableModel {
	
	/** The liste materiel. */
	private List<Materiel> listeMateriel = MaterielManager.loadAllMateriel();
	
	/** The Materiel column name. */
	private String[] MaterielColumnName = { "", "Denomination", "Observations",
			"Quantite", "uid" };

	/**
	 * Instantiates a new materiel table model.
	 */
	public MaterielTableModel() {
		listeMateriel = MaterielManager.loadAllMateriel();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return MaterielColumnName[columnIndex];
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		if (listeMateriel != null) {
			return listeMateriel.size();
		} else {
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 5;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
	 */
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

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#setValueAt(java.lang.Object, int, int)
	 */
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

	/**
	 * Validate persistance.
	 *
	 * @param rowIndex the row index
	 */
	public void validatePersistance(int rowIndex) {
		MaterielManager.createMateriel(listeMateriel.get(rowIndex));
	}

	/**
	 * Refresh model.
	 */
	public void refreshModel() {
		listeMateriel = MaterielManager.loadAllMateriel();
		fireTableDataChanged();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
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

	/**
	 * Adds the element.
	 */
	public void addElement() {
		// Adds the element in the last position in the list
		super.setAddition(true);
		super.setEdition(false);
		super.setRemove(false);
		listeMateriel.add(getRowCount(), MaterielManager.createTempMateriel());
		fireTableRowsInserted(0, getRowCount());

	}

	/**
	 * Removes the element.
	 *
	 * @param rowIndex the row index
	 */
	public void removeElement(int rowIndex) {
		if (rowIndex != -1) {
			super.setRemove(true);
			super.setAddition(false);
			super.setEdition(false);
			persistData(rowIndex, true);
		}

	}

	/**
	 * Persist data.
	 *
	 * @param rowIndex the row index
	 * @param validate the validate
	 */
	public void persistData(int rowIndex, boolean validate) {
		if (validate) {
			if (super.isAddition() && !super.isEdition() && !super.isRemove()) {
				MaterielManager.createMateriel(listeMateriel.get(rowIndex));
				setAddition(false);
			} else if (!super.isAddition() && super.isEdition()
					&& !super.isRemove()) {
				MaterielManager.updateMateriel(listeMateriel.get(rowIndex),
						(Integer) getValueAt(rowIndex, getColumnCount() - 1));
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

	/**
	 * Update element.
	 *
	 * @param rowIndex the row index
	 */
	public void updateElement(int rowIndex) {
		setEditedRow(rowIndex);
		setEdition(true);
		setAddition(false);
		setRemove(false);
	}
}
