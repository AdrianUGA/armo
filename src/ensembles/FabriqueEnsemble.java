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
import java.util.Properties;

abstract public class FabriqueEnsemble {

    static FabriqueEnsemble grand;
    static FabriqueEnsemble petit;

    static FabriqueEnsemble creerFabriqueEnsemble(String type) {
        switch (type) {
            case "Tableau":
                return new FabriqueEnsembleTableau();
            case "Liste":
                return new FabriqueEnsembleListe();
            default:
                throw new NoSuchElementException("Ensemble de type " + type);
        }
    }

    public static void init(Properties p) {
        grand = creerFabriqueEnsemble(p.getProperty("GrandEnsemble"));
        petit = creerFabriqueEnsemble(p.getProperty("PetitEnsemble"));
        //System.err.println("Grand ensemble : " + grand + ", Petit Ensemble : " + petit);
    }

    public static FabriqueEnsemble grand() {
        return grand;
        //return new FabriqueEnsembleTableau();
    }

    public static FabriqueEnsemble petit() {
        return petit;
        //return new FabriqueEnsembleListe();
    }

    public abstract <T> Ensemble<T> nouveau();
}
