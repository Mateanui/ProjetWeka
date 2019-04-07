
package weka.algorithme;

import java.util.ArrayList;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

public class KNN extends Algorithme{
	private String filename;
	private DataSource source;
	
	public KNN(String filename) throws Exception{
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
			
			//Algorithme kNN
			Classifier tree = new IBk(1);
			
			for(int i = 2; i < nombreInstances*0.1; i += this.getPasRegulier()) {
				tree.buildClassifier(data);
				
				Evaluation evaluation = new Evaluation(data);
				evaluation.crossValidateModel(tree, data, 5, new Random(1));
				
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
