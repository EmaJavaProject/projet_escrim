package escrim.model.table;

import java.util.List;

import escrim.manager.TransportManager;
import escrim.metiers.Transport;

@SuppressWarnings("serial")
public class TransportTableModel extends EscrimTableModel {
	private List<Transport> listeTransport = TransportManager
			.loadAllTransport();
	private String[] TransportColumnName = { "", "Dénomination",
			"Poids Max", "uid"};

	public TransportTableModel() {
		listeTransport = TransportManager.loadAllTransport();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return TransportColumnName[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (listeTransport != null) {
			return listeTransport.size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

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

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 1:
			listeTransport.get(rowIndex).setPoidsMax(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 2:
			listeTransport.get(rowIndex).setDenomination(
					aValue == null ? null : aValue.toString());
			break;

		default:
			break;
		}
	}

	public void validatePersistance(int rowIndex) {
		TransportManager.createTransport(listeTransport.get(rowIndex));
	}

	public void refreshModel() {
		listeTransport = TransportManager.loadAllTransport();
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
			return Integer.class;
		}
		return null;
	}

	public void addElement() {
		// Adds the element in the last position in the list
		
		setAddition(true);
		setEdition(false);
		setRemove(false);
		listeTransport.add(getRowCount(),
				TransportManager.createTempTransport());
		fireTableRowsInserted(0, getRowCount());
	}

	public void removeElement(int rowIndex) {
		setRemove(true);
		setAddition(false);
		setEdition(false);
		persistData(rowIndex, true);
	}

	public void persistData(int rowIndex, boolean validate) {
		if (validate) {
			if (isAddition() && !isEdition() && !isRemove()) {
				TransportManager.createTransport(listeTransport.get(rowIndex));
				setAddition(false);
			} else if (!isAddition() && isEdition() && !isRemove()) {
				TransportManager.updateTransport(listeTransport.get(rowIndex),
						(Integer) getValueAt(rowIndex, 6));
				setEdition(false);
			} else if (!isAddition() && !isEdition() && isRemove()) {
				TransportManager.removeTransport((Integer) getValueAt(rowIndex,
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
