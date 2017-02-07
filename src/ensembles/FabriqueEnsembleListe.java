package ensembles;

public class FabriqueEnsembleListe implements FabriqueEnsemble {

	@Override
	public EnsembleEntiers getNew() {
		return new EnsembleListeEntiers();
	}

	@Override
	public Ensemble<Integer> nouveau() {
		// TODO Auto-generated method stub
		return null;
	}
}
