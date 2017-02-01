package ensembles;

public class EnsembleTableauEntiers implements EnsembleEntiers {

	private static final int DEFAULT_TABLE_LENGTH = 10;
	private int[] tableau;
	private int indiceTete;
	private int longueur;
	
	
	
	public EnsembleTableauEntiers() {
		super();
		this.longueur = DEFAULT_TABLE_LENGTH;
		this.tableau = new int[this.longueur];
		this.indiceTete = 0;
	}

	@Override
	public void ajoute(int c) {
		if(this.longueur-1 == this.indiceTete){
			this.etendreTableau();
		}
		this.tableau[this.indiceTete] = c;
		this.indiceTete ++;
	}

	private void etendreTableau() {
		int[] tableau = new int[this.longueur * 2];
		
		for(int i=0; i<this.longueur; i++){
			tableau[i] = this.tableau[i];
		}
		
		this.longueur *= 2;
		this.tableau = tableau;
	}

	@Override
	public void supprime(int c) throws Exception {
		int indice = this.getIndice(c);
		this.echange(indice);
		this.longueur --;
	}

	private int getIndice(int c) throws Exception {
		for(int i=0; i<this.longueur; i++){
			if(this.tableau[i] == c){
				return i;
			}
		}
		
		throw new Exception(c + "Not in table");
	}

	private void echange(int indice) {
		this.echange(indice, this.longueur-1);
	}

	private void echange(int indice, int i) {

//		if(indice > this.longueur || indice < 0)
//			throw new IndexOutOfBoundsException();
//		
//		if(i > this.longueur || i < 0)
//			throw new IndexOutOfBoundsException();
		
		int tmp = this.tableau[indice];
		this.tableau[indice] = this.tableau[i];
		this.tableau[i] = tmp;
	}

	@Override
	public String toString() {
		String ret = "[";
		for(int i=0; i< this.indiceTete ; i++){
			ret += this.tableau[i] + ", ";
		}
		
		/* Fancy display */
		if(ret.charAt(ret.length() - 2) == ','){
	        return ret.substring(0,ret.length()-2);
		}
		
		return ret + "]";
	}

}
