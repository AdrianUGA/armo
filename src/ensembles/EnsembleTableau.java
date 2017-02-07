/*
 * Armoroides - casse briques à but pédagogique
 * Copyright (C) 2016 Guillaume Huard

 * Ce programme est libre, vous pouvez le redistribuer et/ou le
 * modifier selon les termes de la Licence Publique Générale GNU publiée par la
 * Free Software Foundation (version 2 ou bien toute autre version ultérieure
 * choisie par vous).

 * Ce programme est distribué car potentiellement utile, mais SANS
 * AUCUNE GARANTIE, ni explicite ni implicite, y compris les garanties de
 * commercialisation ou d'adaptation dans un but spécifique. Reportez-vous à la
 * Licence Publique Générale GNU pour plus de détails.

 * Vous devez avoir reçu une copie de la Licence Publique Générale
 * GNU en même temps que ce programme ; si ce n'est pas le cas, écrivez à la Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307,
 * États-Unis.

 * Contact: Guillaume.Huard@imag.fr
 *          Laboratoire LIG
 *          700 avenue centrale
 *          Domaine universitaire
 *          38401 Saint Martin d'Hères
 */
package ensembles;

import java.util.NoSuchElementException;

public class EnsembleTableau<T> implements Ensemble<T> {

    private T[] contenu;
    private int taille;

    public int getTaille() {
		return this.taille;
	}

	public EnsembleTableau() {
        this(16);
    }

    EnsembleTableau(int t) {
        taille = 0;
        contenu = (T[]) new Object[t];
    }

    @Override
    public void ajoute(T c) {
        if (taille >= contenu.length) {
            T[] nouveau = (T[]) new Object[contenu.length * 2];
            System.arraycopy(contenu, 0, nouveau, 0, contenu.length);
            contenu = nouveau;
        }
        contenu[taille++] = c;
    }

    @Override
    public void supprime(T c) {
        for (int i = 0; i < taille; i++) {
            if (contenu[i] == c) {
                taille--;
                contenu[i] = contenu[taille];
                contenu[taille] = null;
                return;
            }
        }
        throw new NoSuchElementException(c + " not found");
    }
    
    public void supprime(int i){
    	if(taille <= i)
    		throw new NoSuchElementException(i + "° not found");
    	taille--;
    	contenu[i] = contenu[taille];
        contenu[taille] = null;
    }

    @Override
    public String toString() {
        String resultat = "{";
        int i = 0;

        if (i < taille) {
            resultat += contenu[i++];
        }
        while (i < taille) {
            resultat += ", " + contenu[i++];
        }
        return resultat + "}";
    }

	@Override
	public Iterateur<T> iterateur() {
		return new IterateurEnsembleTableau(this);
	}

	public T get(int i) {
		return this.contenu[i];
	}


}
