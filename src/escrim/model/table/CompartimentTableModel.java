package escrim.model.table;

import java.util.List;

import escrim.manager.CompartimentManager;
import escrim.metiers.Compartiment;

/**
 * The Class CompartimentTableModel.
 */
@SuppressWarnings("serial")
public class CompartimentTableModel extends EscrimTableModel {

	/** The liste compartiment. */
	private List<Compartiment> listeCompartiment = CompartimentManager
			.loadAllCompartiment();

	/** The Compartiment column name. */
	private String[] CompartimentColumnName = { "", "Nom", "Hauteur",
			"Longueur", "Largeur", "Poids", };

	/**
	 * Instantiates a new compartiment table model.
	 */
	public CompartimentTableModel() {
		listeCompartiment = CompartimentManager.loadAllCompartiment();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return CompartimentColumnName[columnIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.DefaultTableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		if (listeCompartiment != null) {
			return listeCompartiment.size();
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

	/**
	 * Validate persistance.
	 *
	 * @param rowIndex
	 *            the row index
	 */
	public void validatePersistance(int rowIndex) {
		CompartimentManager.createCompartiment(listeCompartiment.get(rowIndex));
	}

	/**
	 * Refresh model.
	 */
	public void refreshModel() {
		listeCompartiment = CompartimentManager.loadAllCompartiment();
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
		// Adds the element in the last position in the list
		super.setAddition(true);
		super.setEdition(false);
		super.setRemove(false);
		listeCompartiment.add(getRowCount(),
				CompartimentManager.createTempCompartiment());
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
				CompartimentManager.createCompartiment(listeCompartiment
						.get(rowIndex));
				super.setAddition(false);
			} else if (!super.isAddition() && super.isEdition()
					&& !super.isRemove()) {
				CompartimentManager.updateCompartiment(
						listeCompartiment.get(rowIndex),
						(Integer) getValueAt(rowIndex, getColumnCount()));
				super.setEdition(false);
			} else if (!super.isAddition() && !super.isEdition()
					&& super.isRemove()) {
				CompartimentManager.removeCompartiment((Integer) getValueAt(
						rowIndex, getColumnCount()));
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
