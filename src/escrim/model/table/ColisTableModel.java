package escrim.model.table;

import java.util.List;

import escrim.manager.ColisManager;
import escrim.metiers.Colis;

@SuppressWarnings("serial")
public class ColisTableModel extends EscrimTableModel {
	private List<Colis> listeColis = ColisManager.loadAllColis();
	private String[] ColisColumnName = { "", "N° Colis", "Nom", "Affectataire",
			"Optionnel", "Secteur", "Type Colis", "Dimension", "Volume",
			"Poids Max", "Valeur", "Iata", "Projection", "Observation", "uid" };

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
		return 15;
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
		case 3:
			return Colis.getAffectation();
		case 4:
			return Colis.isOptionnel();
		case 5:
			return Colis.getSecteur();
		case 6:
			return Colis.getTypeColis().getDesignation();

		case 7:
			return String.valueOf(Colis.getTypeColis().getHauteur()) + "x"
					+ String.valueOf(Colis.getTypeColis().getLongueur()) + "x"
					+ String.valueOf(Colis.getTypeColis().getLargeur());
		case 8:
			return Colis.getTypeColis().getVolume();
		case 9:
			return Colis.getTypeColis().getPoidsMax();

		case 10:
			return Colis.getValeur();
		case 11:
			return Colis.getIata();
		case 12:
			return Colis.getProjection();
		case 13:
			return Colis.getObservation();
		case 14:
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
		case 3:
			listeColis.get(rowIndex).setAffectation(
					aValue == null ? null : aValue.toString());
			break;
		case 4:
			listeColis.get(rowIndex).setOptionnel(((boolean) aValue));
			break;
		case 5:
			listeColis.get(rowIndex).setSecteur(
					aValue == null ? new Integer(0) : Integer
							.parseInt(((String) aValue).trim()));
			break;
		case 6:
			listeColis.get(rowIndex).getTypeColis()
					.setDesignation(aValue == null ? null : aValue.toString());
			break;
		case 10:
			listeColis.get(rowIndex).setValeur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 11:
			listeColis.get(rowIndex).setIata(
					aValue == null ? null : aValue.toString());
			break;
		case 12:
			listeColis.get(rowIndex).setProjection(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 13:
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
			return Boolean.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		case 7:
			return String.class;
		case 8:
			return Float.class;
		case 9:
			return Float.class;
		case 10:
			return String.class;
		case 11:
			return String.class;
		case 12:
			return String.class;
		case 13:
			return String.class;
		case 14:
			return Integer.class;

		}
		return null;
	}

	public void addElement() {
		// Adds the element in the last position in the list
		super.setAddition(true);
		super.setEdition(false);
		super.setRemove(false);
		listeColis.add(getRowCount(), ColisManager.createTempColis());
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
				ColisManager.createColis(listeColis.get(rowIndex));
				super.setAddition(false);
			} else if (!super.isAddition() && super.isEdition()
					&& !super.isRemove()) {
				ColisManager.updateColis(listeColis.get(rowIndex),
						(Integer) getValueAt(rowIndex, getColumnCount() - 1));
				super.setEdition(false);
			} else if (!super.isAddition() && !super.isEdition()
					&& super.isRemove()) {
				ColisManager.removeColis((Integer) getValueAt(rowIndex,
						getColumnCount() - 1));
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

	@Override
	public boolean isCellEditable(int row, int column) {

		if (column == 7 || column == 8 || column == 9) {
			return false;
		} else if (isAddition() && row == getRowCount() - 1) {
			return true;
		} else if (isEdition() && row == editedRow) {
			return true;
		} else {
			return false;

		}
	}
}
