package escrim.model.table;

import java.util.List;

import escrim.manager.TypeColisManager;
import escrim.metiers.TypeColis;

/**
 * The Class TypeColisTableModel.
 */
@SuppressWarnings("serial")
public class TypeColisTableModel extends EscrimTableModel {

	/** The liste type colis. */
	private List<TypeColis> listeTypeColis = TypeColisManager
			.loadAllTypeColis();

	/** The type colis column name. */
	private String[] typeColisColumnName = { "", "Nom", "Hauteur", "Longueur",
			"Largeur", "Poids" };

	/**
	 * Instantiates a new type colis table model.
	 */
	public TypeColisTableModel() {
		listeTypeColis = TypeColisManager.loadAllTypeColis();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return typeColisColumnName[columnIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		if (listeTypeColis != null) {
			return listeTypeColis.size();
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return 6;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TypeColis typeColis = listeTypeColis.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return typeColis.getDesignation();
		case 2:
			return typeColis.getHauteur();
		case 3:
			return typeColis.getLongueur();
		case 4:
			return typeColis.getLargeur();
		case 5:
			return typeColis.getPoidsMax();
		case 6:
			return typeColis.getUid();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#setValueAt(java.lang.Object,
	 * int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 1:
			listeTypeColis.get(rowIndex).setDesignation(
					aValue == null ? null : aValue.toString());
			break;
		case 2:
			listeTypeColis.get(rowIndex).setHauteur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 3:
			listeTypeColis.get(rowIndex).setLongueur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 4:
			listeTypeColis.get(rowIndex).setLargeur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 5:
			listeTypeColis.get(rowIndex).setPoidsMax(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;

		default:
			break;
		}
	}

	/**
	 * Validate persistance.
	 *
	 * @param rowIndex
	 *            the row index
	 */
	public void validatePersistance(int rowIndex) {
		TypeColisManager.createTypeColis(listeTypeColis.get(rowIndex));
	}

	/**
	 * Refresh model.
	 */
	public void refreshModel() {
		listeTypeColis = TypeColisManager.loadAllTypeColis();
		fireTableDataChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
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
			return String.class;
		case 5:
			return String.class;
		case 6:
			return Integer.class;

		}
		return null;
	}

	/**
	 * Adds the element.
	 */
	public void addElement() {
		super.setAddition(true);
		super.setEdition(false);
		super.setRemove(false);
		listeTypeColis.add(getRowCount(),
				TypeColisManager.createTempTypeColis());
		fireTableRowsInserted(0, getRowCount());
	}

	/**
	 * Removes the element.
	 *
	 * @param rowIndex
	 *            the row index
	 */
	public void removeElement(int rowIndex) {
		super.setRemove(true);
		super.setAddition(false);
		super.setEdition(false);
		persistData(rowIndex, true);
	}

	/**
	 * Persist data.
	 *
	 * @param rowIndex
	 *            the row index
	 * @param validate
	 *            the validate
	 */
	public void persistData(int rowIndex, boolean validate) {
		if (validate) {
			if (super.isAddition() && !super.isEdition() && !super.isRemove()) {
				TypeColisManager.createTypeColis(listeTypeColis.get(rowIndex));
				super.setAddition(false);
			} else if (!super.isAddition() && super.isEdition()
					&& !super.isRemove()) {
				TypeColisManager.updateTypeColis(listeTypeColis.get(rowIndex),
						(Integer) getValueAt(rowIndex, getColumnCount()));
				super.setEdition(false);
			} else if (!super.isAddition() && !super.isEdition()
					&& super.isRemove()) {
				TypeColisManager.removeTypeColis((Integer) getValueAt(rowIndex,
						getColumnCount()));
				super.setRemove(false);
			}
		}

		refreshModel();

	}

	/**
	 * Update element.
	 *
	 * @param rowIndex
	 *            the row index
	 */
	public void updateElement(int rowIndex) {
		super.setEditedRow(rowIndex);
		super.setEdition(true);
		super.setAddition(false);
		super.setRemove(false);
	}
}
