package weka.controleurs;

import weka.algorithme.Algorithme;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

public class Controleur implements InterfaceControleur{
	private Algorithme algorithme;
	
	public Controleur(Algorithme algorithme) {
		this.algorithme = algorithme;
	}
	
	@Override
	public String getFilename() {
		return algorithme.getFilename();
	}
	
	@Override
	public void setFilename(String filename) {
		algorithme.setFilename(filename);
	}
	
	@Override
	public int getPasRegulier() {
		return algorithme.getPasRegulier();
	}
	
	@Override
	public void setPasRegulier(int pasRegulier) {
		algorithme.setPasRegulier(pasRegulier);
	}
	
	@Override
	public int getNombrePlis() {
		return algorithme.getNombrePlis();
	}
	
	@Override
	public void setNombrePlis(int nombrePlis) {
		algorithme.setNombrePlis(nombrePlis);
	}
	
	@Override
	public void choixAlgorithme(int choix) {
		if(choix==1) {
			algorithme.evaluation();
		} else if(choix==2) {
			algorithme.evaluation();
		} else if(choix==3) {
			algorithme.evaluation();
		} else if(choix==4) {
			algorithme.evaluation();
		}
	}
}
