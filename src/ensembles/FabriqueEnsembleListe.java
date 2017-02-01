package ensembles;

public class FabriqueEnsembleListe implements FabriqueEnsemble {

	@Override
	public EnsembleEntiers getNew() {
		return new EnsembleListeEntiers();
	}
}
