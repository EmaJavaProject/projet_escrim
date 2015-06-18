package escrim.utils;

import escrim.manager.CompartimentManager;

public class TestPersist {

	public static void main(String[] args) {
		CompartimentManager.createCompartiment(1, 1, 1, 1, 1, null);
		CompartimentManager.updateCompartiment(CompartimentManager
				.loadCompartiment(1).getUid(), 2, 2, 2, 2, 2, null);
	}
}
