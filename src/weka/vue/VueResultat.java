package weka.vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author Mateanui ARAPARI et Riad GUENANE
 */

public class VueResultat extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
	private XYSeries tauxErreur;
	
	public VueResultat(boolean b) {
		this.affichage(b);
	}
	
	public void affichage(boolean b) {
		textArea = new JTextArea(28,60);
		textArea.setEditable(false);
		textArea.setForeground(Color.BLUE);
		JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		tauxErreur = new XYSeries("Performance");
		XYSeriesCollection data = new XYSeriesCollection(this.tauxErreur);
		
		JFreeChart chart = ChartFactory.createXYLineChart("Performances", "Nombre d'instance", "Taux d'erreur",data);
		ChartPanel chartPanel = new ChartPanel(chart);
		
		JPanel conteneurResume = new JPanel();
		conteneurResume.add(scrollPane);
		
		JPanel conteneurChart = new JPanel();
		conteneurChart.add(chartPanel);
		
		JPanel conteneurGeneral = new JPanel();
		conteneurGeneral.setLayout(new GridLayout(0,2));
		conteneurGeneral.add(conteneurResume);
		conteneurGeneral.add(conteneurChart);
		
		this.setTitle("Comparaison d'algorithme de classification");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400,450);
		this.setLocation(300,300);
		
		this.setContentPane(conteneurGeneral);
		
		this.setVisible(b);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public XYSeries getTauxErreur() {
		return tauxErreur;
	}

	public void setTauxErreur(XYSeries tauxErreur) {
		this.tauxErreur = tauxErreur;
	}
}
