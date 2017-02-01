package ensembles;

public class FabriqueEnsembleTableau implements FabriqueEnsemble {

	@Override
	public EnsembleEntiers getNew() {
		return new EnsembleTableauEntiers();
	}


}
