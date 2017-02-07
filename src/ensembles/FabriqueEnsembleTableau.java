package ensembles;

public class FabriqueEnsembleTableau implements FabriqueEnsemble {

	@Override
	public EnsembleEntiers getNew() {
		return new EnsembleTableauEntiers();
	}

	@Override
	public Ensemble<Integer> nouveau() {
		// TODO Auto-generated method stub
		return null;
	}


}
