package ensembles;

public class IterateurEnsembleListe<T> implements Iterateur{
	
	private Maillon<T> element;
	private EnsembleListe<T> ensemble;
	private Maillon<T> précedent;
	
	
	
	public IterateurEnsembleListe(EnsembleListe<T> tete) {
		super();
		this.element= tete.getTete();
		this.ensemble = tete;
	}

	@Override
	public boolean aProchain() {
		return this.element.suivant!=null;
	}

	@Override
	public Object prochain() {
		Maillon<T> element1=this.element;
		this.précedent = this.element;
		this.element=this.element.suivant;
		return element1.element;
	}

	@Override
	public void supprime() {
		this.ensemble.supprime(this.précedent.element);
	}

	@Override
	public Iterateur clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
