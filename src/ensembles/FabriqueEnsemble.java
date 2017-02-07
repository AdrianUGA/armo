package ensembles;

import java.util.Properties;

public interface FabriqueEnsemble {
	EnsembleEntiers getNew();

	Ensemble<Integer> nouveau();

	static void init(Properties proprietes) {
		// TODO Auto-generated method stub
		
	}

	static FabriqueEnsemble grand() {
		// TODO Auto-generated method stub
		return null;
	}

	static FabriqueEnsemble petit() {
		// TODO Auto-generated method stub
		return null;
	}
}
