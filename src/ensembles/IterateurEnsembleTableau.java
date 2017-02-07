package ensembles;

public class IterateurEnsembleTableau<T> implements Iterateur<T>{
	
	private int indice;
	private EnsembleTableau<T> ensemble;
	
	public IterateurEnsembleTableau(EnsembleTableau<T> ensemble) {
		super();
		this.ensemble = ensemble;
		this.indice=0;
	}

	

	public IterateurEnsembleTableau(EnsembleTableau<T> ensemble, int indice) {
		super();
		this.ensemble = ensemble;
		this.indice=indice;
	}



	@Override
	public boolean aProchain() {
		return this.ensemble.getTaille() <= this.indice;
	}

	@Override
	public T prochain() {
		T ret = ensemble.get(this.indice);
		this.indice ++;
		return ret;
		
	}

	@Override
	public void supprime() {
		this.ensemble.supprime(this.indice);
		
	}

	@Override
	public Iterateur<T> clone() {
		return new IterateurEnsembleTableau<T>(this.ensemble, this.indice);
	}

}
