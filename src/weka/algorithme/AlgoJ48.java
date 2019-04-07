package weka.algorithme;

import java.util.ArrayList;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

public class AlgoJ48 extends Algorithme{
	private String filename;
	private DataSource source;
	
	public AlgoJ48(String filename) throws Exception{
		super(filename);
		this.filename = filename;
	}
	
	public void evaluation() {
		/* Ces listes nous permet d'enregistrer :
		 * 	- les numero d'instances
		 * 	- le résumé (taux d'erreur ...) à chaque pas (iteration de 10)
		 *  - le taux d'erreur
		 *  On pourra par la suite les récupérer pour l'affichage du graphe
		 */
		ArrayList<Integer> numeroInstance = new ArrayList<>();
		ArrayList<String> resume = new ArrayList<>();
		ArrayList<Double> tauxErreur = new ArrayList<>();
		
		try {
			source = new DataSource(filename);
			Instances data = this.source.getDataSet();
			
			if(data.classIndex()==-1)
				data.setClassIndex(data.numAttributes()-1);
			
			int nombreInstances = data.numInstances();
			
			//Algorithme J48
			J48 tree = new J48();
			
			for(int i = 2; i < nombreInstances*0.1; i += this.getPasRegulier()) {
				tree.setMinNumObj(i);
				tree.buildClassifier(data);
				
				Evaluation evaluation = new Evaluation(data);
				evaluation.crossValidateModel(tree, data, this.getNombrePlis(), new Random(1));
				
				numeroInstance.add(i);
				resume.add(evaluation.toSummaryString());
				tauxErreur.add(evaluation.pctIncorrect());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.notifyObserver(numeroInstance, resume, tauxErreur);
	}
	
	public String getFilename() {
		return this.filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}
}
