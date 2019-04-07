package weka.algorithme;

import java.util.ArrayList;

import weka.vue.Observer;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

public interface Subject {
	public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObserver(ArrayList<Integer> numeroInstance, ArrayList<String> resume, ArrayList<Double> tauxErreur);
}
