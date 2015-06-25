package escrim.model.table;

import java.util.List;

import escrim.manager.CompartimentManager;
import escrim.metiers.Compartiment;

@SuppressWarnings("serial")
public class CompartimentTableModel extends EscrimTableModel {
	private List<Compartiment> listeCompartiment = CompartimentManager
			.loadAllCompartiment();
	private String[] CompartimentColumnName = { "", "Nom", "Hauteur",
			"Longueur", "Largeur", "Poids", "uid" };

	public CompartimentTableModel() {
		listeCompartiment = CompartimentManager.loadAllCompartiment();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return CompartimentColumnName[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (listeCompartiment != null) {
			return listeCompartiment.size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Compartiment compartiment = listeCompartiment.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return null;
		case 1:
			return compartiment.getNom();
		case 2:
			return compartiment.getHauteur();
		case 3:
			return compartiment.getLongueur();
		case 4:
			return compartiment.getLargeur();
		case 5:
			return compartiment.getPoids();
		case 6:
			return compartiment.getUid();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 1:
			listeCompartiment.get(rowIndex).setNom(
					aValue == null ? null : aValue.toString());
			break;
		case 2:
			listeCompartiment.get(rowIndex).setHauteur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 3:
			listeCompartiment.get(rowIndex).setLongueur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 4:
			listeCompartiment.get(rowIndex).setLargeur(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;
		case 5:
			listeCompartiment.get(rowIndex).setPoids(
					aValue == null ? new Float(0) : Float
							.parseFloat(((String) aValue).trim()));
			break;

		default:
			break;
		}
	}

	public void validatePersistance(int rowIndex) {
		CompartimentManager.createCompartiment(listeCompartiment.get(rowIndex));
	}

	public void refreshModel() {
		listeCompartiment = CompartimentManager.loadAllCompartiment();
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
		listeCompartiment.add(getRowCount(),
				CompartimentManager.createTempCompartiment());
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
				CompartimentManager.createCompartiment(listeCompartiment
						.get(rowIndex));
				super.setAddition(false);
			} else if (!super.isAddition() && super.isEdition()
					&& !super.isRemove()) {
				CompartimentManager.updateCompartiment(
						listeCompartiment.get(rowIndex),
						(Integer) getValueAt(rowIndex, getColumnCount() - 1));
				super.setEdition(false);
			} else if (!super.isAddition() && !super.isEdition()
					&& super.isRemove()) {
				CompartimentManager.removeCompartiment((Integer) getValueAt(
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
