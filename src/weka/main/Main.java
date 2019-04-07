package weka.main;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

import weka.algorithme.AlgoJ48;
import weka.controleurs.Controleur;
import weka.vue.VueGenerale;

public class Main {

	public static void main(String[] args) {
		
		try {
			AlgoJ48 algorithme = new AlgoJ48("data/iris.arff");
//			BoostingM1 algorithme = new BoostingM1("data/iris.arff");
//			KNN algorithme = new KNN("data/iris.arff");
//			RandomForest algorithme = new RandomForest("data/iris.arff");
			Controleur controleur = new Controleur(algorithme);
			@SuppressWarnings("unused")
			VueGenerale vueGenerale = new VueGenerale(algorithme, controleur);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}