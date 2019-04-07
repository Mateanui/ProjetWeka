package weka.vue;

import java.util.ArrayList;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

public interface Observer {
	public void update(ArrayList<Integer> numeroInstance, ArrayList<String> resume, ArrayList<Double> tauxErreur);
}
