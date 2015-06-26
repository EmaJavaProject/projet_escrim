package escrim.model.table;

import java.util.List;

import escrim.manager.ColisManager;
import escrim.metiers.Colis;

@SuppressWarnings("serial")
public class ColisTableModel extends EscrimTableModel {
	private List<Colis> listeColis = ColisManager
			.loadAllColis();
	private String[] ColisColumnName = {  "", "Numéro Colis",
			"Désignation", "Nature Colis", "Affectataire", "Optionnel",
			"Secteur", "Dimension", "Volume", "Poids", "Valeur", "Iata",
			"Projection", "Observation", "uid"};

	public ColisTableModel() {
		listeColis = ColisManager.loadAllColis();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return ColisColumnName[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (listeColis != null) {
			return listeColis.size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return 13;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Colis Colis = listeColis.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return Colis.getNumeroColis();
		case 2:
			return Colis.getDesignation();

		case 4:
			return Colis.getTypeColis();
		case 5:
			return Colis.getNumeroColis();

		case 7:
			return Colis.getListeMateriel();
		case 8:
			return Colis.getValeur();
		case 9:
			return Colis.getIata();
		case 10:
			return Colis.getProjection();
		case 11:
			return Colis.getObservation();
		case 12:
			return Colis.getUid();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 1:
			listeColis.get(rowIndex).setNumeroColis(
					aValue == null ? new Integer(0) : Integer
							.parseInt(((String) aValue).trim()));
			break;
		case 2:
			listeColis.get(rowIndex).setDesignation(
					aValue == null ? null : aValue.toString());
			break;

		case 5:
			listeColis.get(rowIndex).setNumeroColis(
					aValue == null ? new Integer(0) : Integer
							.parseInt(((String) aValue).trim()));
			
			break;
		case 8:
			listeColis.get(rowIndex).setValeur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 9:
			listeColis.get(rowIndex).setIata(
					aValue == null ? null : aValue.toString());
			break;
		case 10:
			listeColis.get(rowIndex).setProjection(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 11:
			listeColis.get(rowIndex).setObservation(
					aValue == null ? null : aValue.toString());
			break;

			

		default:
			break;
		}
	}

	public void validatePersistance(int rowIndex) {
		ColisManager.createColis(listeColis.get(rowIndex));
	}

	public void refreshModel() {
		listeColis = ColisManager.loadAllColis();
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
			return String.class;
		case 5:
			return String.class;
		case 6:
			return Integer.class;

		}
		return null;
	}

	public void addElement() {
		// Adds the element in the last position in the list
		super.setAddition(true);
		super.setEdition(false);
		super.setRemove(false);
		listeColis.add(getRowCount(),
				ColisManager.createTempColis());
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
				ColisManager.createColis(listeColis
						.get(rowIndex));
				super.setAddition(false);
			} else if (!super.isAddition() && super.isEdition()
					&& !super.isRemove()) {
				ColisManager.updateColis(
						listeColis.get(rowIndex),
						(Integer) getValueAt(rowIndex, getColumnCount() - 1));
				super.setEdition(false);
			} else if (!super.isAddition() && !super.isEdition()
					&& super.isRemove()) {
				ColisManager.removeColis((Integer) getValueAt(
						rowIndex, getColumnCount() - 1));
				super.setRemove(false);
			}
		}

		refreshModel();

	}

	public void updateElement(int rowIndex) {
		super.setEditedRow(rowIndex);
		super.setEdition(true);
		super.setAddition(false);
		super.setRemove(false);
	}
}
