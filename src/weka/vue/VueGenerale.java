package weka.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import weka.algorithme.Algorithme;
import weka.controleurs.InterfaceControleur;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

public class VueGenerale implements Observer{
	private Algorithme algorithme;
	private InterfaceControleur controleur;
	private VueAlgoData vueAlgoData;
	private VueResultat vueResultat;
	
	public VueGenerale(Algorithme algorithme, InterfaceControleur controleur) {
		this.algorithme = algorithme;
		this.controleur = controleur;
		this.algorithme.registerObserver(this);
		
		affichage();
	}
	
	public void affichage() {
		vueAlgoData = new VueAlgoData(true);
		vueResultat = new VueResultat(true);
		
		vueAlgoData.getChoixFilename().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser choose = new JFileChooser();
				choose.setCurrentDirectory(new File("data/"));
				int retour = choose.showOpenDialog(null);
				
				if(retour==JFileChooser.APPROVE_OPTION)
					controleur.setFilename(choose.getSelectedFile().getAbsolutePath());
			}
		});
				
		vueAlgoData.getStart().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Changement du nombre de pas ou du nombre de plis */
				int pasRegulier = Integer.parseInt(vueAlgoData.getNbPas().getText());
				int nbPlis = Integer.parseInt(vueAlgoData.getNbPlis().getText());				
				controleur.setPasRegulier(pasRegulier);
				controleur.setNombrePlis(nbPlis);
				
				/* Enclenche l'algorithme */
				if(vueAlgoData.getAlgo48().isSelected())
					controleur.choixAlgorithme(1);
				else if(vueAlgoData.getBoosting().isSelected())
					controleur.choixAlgorithme(2);
				else if(vueAlgoData.getkNN().isSelected())
					controleur.choixAlgorithme(3);
				else if(vueAlgoData.getRandomForest().isSelected())
					controleur.choixAlgorithme(4);
				else
					vueResultat.getTextArea().setText("\n\n\n\n\n\n\n\n\n\n\t\t              Sélectionner un algorithme");
			}
		});
	}
	
	@Override
	public void update(ArrayList<Integer> numeroInstance, ArrayList<String> resume, ArrayList<Double> tauxErreur) {
		vueResultat.getTauxErreur().clear();
		vueResultat.getTextArea().setText("");
		
		String[] filename = controleur.getFilename().split("/");
		
		vueResultat.getTextArea().append("\t\tJeu de données : " + filename[filename.length-1] + "\n");
		
		for(int i = 0; i < resume.size(); i++)
			vueResultat.getTextArea().append(resume.get(i));
		
		for(int i = 0; i < numeroInstance.size(); i++)
			vueResultat.getTauxErreur().add(numeroInstance.get(i),tauxErreur.get(i));
	}
}
