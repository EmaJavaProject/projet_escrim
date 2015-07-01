package escrim.model.table;

import java.util.List;

import escrim.manager.TransportManager;
import escrim.metiers.Transport;

/**
 * The Class TransportTableModel.
 */
@SuppressWarnings("serial")
public class TransportTableModel extends EscrimTableModel {

	/** The liste transport. */
	private List<Transport> listeTransport = TransportManager
			.loadAllTransport();

	/** The Transport column name. */
	private String[] TransportColumnName = { "", "Dénomination", "Poids Max" };

	/**
	 * Instantiates a new transport table model.
	 */
	public TransportTableModel() {
		listeTransport = TransportManager.loadAllTransport();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return TransportColumnName[columnIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		if (listeTransport != null) {
			return listeTransport.size();
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
		return 3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Transport Transport = listeTransport.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return Transport.getDenomination();
		case 2:
			return Transport.getPoidsMax();
		case 3:
			return Transport.getUid();
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
			listeTransport.get(rowIndex).setDenomination(
					aValue == null ? null : aValue.toString());
			break;
		case 2:
			listeTransport.get(rowIndex).setPoidsMax(
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
		TransportManager.createTransport(listeTransport.get(rowIndex));
	}

	/**
	 * Refresh model.
	 */
	public void refreshModel() {
		listeTransport = TransportManager.loadAllTransport();
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
			return Integer.class;
		}
		return null;
	}

	/**
	 * Adds the element.
	 */
	public void addElement() {
		// Adds the element in the last position in the list

		setAddition(true);
		setEdition(false);
		setRemove(false);
		listeTransport.add(getRowCount(),
				TransportManager.createTempTransport());
		fireTableRowsInserted(0, getRowCount());
	}

	/**
	 * Removes the element.
	 *
	 * @param rowIndex
	 *            the row index
	 */
	public void removeElement(int rowIndex) {
		setRemove(true);
		setAddition(false);
		setEdition(false);
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
			if (isAddition() && !isEdition() && !isRemove()) {
				TransportManager.createTransport(listeTransport.get(rowIndex));
				setAddition(false);
			} else if (!isAddition() && isEdition() && !isRemove()) {
				TransportManager.updateTransport(listeTransport.get(rowIndex),
						(Integer) getValueAt(rowIndex, getColumnCount()));
				setEdition(false);
			} else if (!isAddition() && !isEdition() && isRemove()) {
				TransportManager.removeTransport((Integer) getValueAt(rowIndex,
						getColumnCount()));
				setRemove(false);
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
		setEditedRow(rowIndex);
		setEdition(true);
		setAddition(false);
		setRemove(false);
	}
}
