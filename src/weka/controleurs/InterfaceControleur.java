package weka.controleurs;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

public interface InterfaceControleur {
	public String getFilename();
	public void setFilename(String filename);
	public int getPasRegulier();
	public void setPasRegulier(int pasRegulier);
	public int getNombrePlis();
	public void setNombrePlis(int nombrePlis);
	public void choixAlgorithme(int choix);
}
