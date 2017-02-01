package ensembles;

public class EnsembleListeEntiers implements EnsembleEntiers {

	private MonEntier tete;

	public EnsembleListeEntiers() {
		super();
		this.tete = null;
	}

	@Override
	public void ajoute(int c) {
		MonEntier tete = new MonEntier(c, this.tete);
		this.tete = tete;
	}

	@Override
	public void supprime(int c) throws Exception {
		MonEntier entierSuccessif = this.tete;
		MonEntier entierPrecedent = null;

		if (entierSuccessif == null) {
			throw new Exception(c + " non trouvé");
		}

		if (entierSuccessif.getEntier() == c) {
			this.tete = entierSuccessif.getSuivant();
			return;
		}

		while (entierSuccessif.getSuivant() != null) {
			entierPrecedent = entierSuccessif;
			entierSuccessif = entierSuccessif.getSuivant();

			if (entierSuccessif.getEntier() == c) {
				entierPrecedent.setSuivant(entierSuccessif.getSuivant());
				return;
			}
		}

		throw new Exception(c + " non trouvé");
	}

	@Override
	public String toString() {
		String ret = "EnsembleListeEntiers [";
		MonEntier entierSuccessif = this.tete;

		while (entierSuccessif != null) {
			ret += entierSuccessif.getEntier() + ", ";
			entierSuccessif = entierSuccessif.getSuivant();
		}
		
		/* Fancy display */
		if(ret.charAt(ret.length() - 2) == ','){
	        ret = ret.substring(0,ret.length()-2);
		}
		
		return ret + "]";
	}

}
