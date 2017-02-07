package ensembles;

public class FabriqueEnsembleByString implements FabriqueEnsemble{

	private FabriqueEnsemble factory;

	@Override
	public EnsembleEntiers getNew() {
		return this.factory.getNew();
	}

	public void init(String size) {
		if(size.equals("petit"))
			this.factory = new FabriqueEnsembleListe();
		else
			this.factory = new FabriqueEnsembleListe();
	}

	@Override
	public Ensemble<Integer> nouveau() {
		// TODO Auto-generated method stub
		return null;
	}

}
