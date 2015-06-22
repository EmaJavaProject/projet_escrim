package ihm;

import java.util.List;

import escrim.manager.CompartimentManager;
import escrim.metiers.Compartiment;

@SuppressWarnings("serial")
public class CompartimentTableModel extends EscrimTableModel {
	private List<Compartiment> listeCompartiment = CompartimentManager
			.loadAllCompartiment();
	private String[] CompartimentColumnName = { "", "Nom", "Hauteur",
			"Longueur", "Largeur", "Volume", "Poids", "uid" };

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
		return 8;
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
			return compartiment.getVolume();
		case 6:
			return compartiment.getPoids();
		case 7:
			return compartiment.getUid();
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return Float.class;
		case 3:
			return Float.class;
		case 4:
			return Float.class;
		case 5:
			return Float.class;
		case 6:
			return Float.class;
		case 7:
			return Integer.class;
		}
		return null;
	}

	public void addElement() {
		// Adds the element in the last position in the list
		listeCompartiment.add(0, CompartimentManager.createTempCompartiment());
		fireTableRowsInserted(0, getRowCount());
	}
}
