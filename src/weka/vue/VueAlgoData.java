package weka.vue;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

public class VueAlgoData extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton choixFilename;
	private JRadioButton algo48;
	private JRadioButton boosting;;
	private JRadioButton kNN;
	private JRadioButton randomForest;
	private JButton start;
	private JTextArea nbPas;
	private JTextArea nbPlis;
	
	public VueAlgoData(boolean b) {
		affichage(b);
	}
	
	public void affichage(boolean b) {
		this.setTitle("Jeu de données et Algorithme");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,100);
		this.setLocation(500,800);
		
		this.choixFilename = new JButton("Données");
		
		algo48 = new JRadioButton("J48",false);
		boosting = new JRadioButton("BoostingM1",false);
		kNN = new JRadioButton("kNN",false);
		randomForest = new JRadioButton("RandomForest",false);
		
		this.start = new JButton("Commencer");
		
		this.nbPas = new JTextArea("10");
		this.nbPas.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		this.nbPlis = new JTextArea("5");
		this.nbPlis.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel nbPasLabel = new JLabel("Nombre de pas régulier : ");
		JLabel nbPlisLabel = new JLabel("Nombre de plis : ");
		
		JPanel conteneurConfiguration = new JPanel();
		conteneurConfiguration.setLayout(new GridLayout(1,4));
		conteneurConfiguration.add(nbPasLabel);
		conteneurConfiguration.add(nbPas);
		conteneurConfiguration.add(nbPlisLabel);
		conteneurConfiguration.add(nbPlis);
		
		JPanel conteneurAlgoData = new JPanel();
		
		conteneurAlgoData.setLayout(new GridLayout(1,5));
		conteneurAlgoData.add(choixFilename);
		conteneurAlgoData.add(algo48);
		conteneurAlgoData.add(boosting);
		conteneurAlgoData.add(kNN);
		conteneurAlgoData.add(randomForest);
		conteneurAlgoData.add(start);
		
		ButtonGroup group = new ButtonGroup();
		group.add(algo48);
		group.add(boosting);
		group.add(kNN);
		group.add(randomForest);
		
		JPanel conteneurGeneral = new JPanel();
		conteneurGeneral.setLayout(new GridLayout(2,1));
		conteneurGeneral.add(conteneurAlgoData);
		conteneurGeneral.add(conteneurConfiguration);
		
		this.setContentPane(conteneurGeneral);
		
		this.setVisible(b);
	}

	public JButton getChoixFilename() {
		return choixFilename;
	}

	public void setChoixFilename(JButton choixFilename) {
		this.choixFilename = choixFilename;
	}

	public JRadioButton getAlgo48() {
		return algo48;
	}

	public void setAlgo48(JRadioButton algo48) {
		this.algo48 = algo48;
	}

	public JRadioButton getBoosting() {
		return boosting;
	}

	public void setBoosting(JRadioButton boosting) {
		this.boosting = boosting;
	}

	public JRadioButton getkNN() {
		return kNN;
	}

	public void setkNN(JRadioButton kNN) {
		this.kNN = kNN;
	}

	public JRadioButton getRandomForest() {
		return randomForest;
	}

	public void setRandomForest(JRadioButton randomForest) {
		this.randomForest = randomForest;
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	public JTextArea getNbPas() {
		return nbPas;
	}

	public void setNbPas(JTextArea nbPas) {
		this.nbPas = nbPas;
	}
	
	public JTextArea getNbPlis() {
		return nbPlis;
	}

	public void setNbPlis(JTextArea nbPlis) {
		this.nbPlis = nbPlis;
	}
}
