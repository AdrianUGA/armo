package ensembles;

public class MonEntier {
	
	private int entier;
	private MonEntier suivant;
	
	
	
	public MonEntier(int entier, MonEntier suivant) {
		super();
		this.entier = entier;
		this.suivant = suivant;
	}



	public int getEntier() {
		return entier;
	}

	public void setEntier(int entier) {
		this.entier = entier;
	}

	public MonEntier getSuivant() {
		return suivant;
	}

	public void setSuivant(MonEntier suivant) {
		this.suivant = suivant;
	}


}
