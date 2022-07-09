package it.polito.tdp.genes.model;

public class Vicino {
	String vicino;
	double peso;
	public Vicino(String vicino, double peso) {
		super();
		this.vicino = vicino;
		this.peso = peso;
	}
	public String getVicino() {
		return vicino;
	}
	public void setVicino(String vicino) {
		this.vicino = vicino;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return vicino + " = " + peso+"\n";
	}
	
}
