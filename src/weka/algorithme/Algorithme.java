package weka.algorithme;

import java.util.ArrayList;
import java.util.List;

import weka.vue.Observer;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

public abstract class Algorithme implements Subject{
	private List<Observer> observers = new ArrayList<>();
	private int pasRegulier;
	private int nombrePlis;
	
	public Algorithme(String filename) {
		this.pasRegulier = 10;
		this.nombrePlis = 5;
	}
	
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	@Override
	public void notifyObserver(ArrayList<Integer> numeroInstance, ArrayList<String> resume, ArrayList<Double> tauxErreur) {
		for(int i = 0; i < observers.size(); i++)
			observers.get(i).update(numeroInstance, resume, tauxErreur);
	}
	
	/*
	 * Méthodes abstraites permettant de gérer différents types de d'algorithme qui étendera cette classe
	 * evaluation qui applique les algo sur les jeux de données
	 */
	
	public abstract void evaluation();
	public abstract String getFilename();
	public abstract void setFilename(String filename);
	
	/*********************************/
	/*********************************/
	
	public int getPasRegulier() {
		return pasRegulier;
	}
	public void setPasRegulier(int pasRegulier) {
		this.pasRegulier = pasRegulier;
	}
	public int getNombrePlis() {
		return nombrePlis;
	}
	public void setNombrePlis(int nombrePlis) {
		this.nombrePlis = nombrePlis;
	}
}
