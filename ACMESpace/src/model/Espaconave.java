package model;
import java.util.ArrayList;

public class Espaconave {

	private String nome;
	private EspacoPorto localAtual;
	private ArrayList<Transporte> transporte = new ArrayList<Transporte>();
	private double velocidadeMaxima;

	public Espaconave(String nome, EspacoPorto localAtual, double velocidadeMaxima) {
		this.nome = nome;
		this.localAtual = localAtual;
		this.velocidadeMaxima = velocidadeMaxima;
	}

	public Espaconave() {
		

	}

	public double getVelocidadeMaxima() {
		return velocidadeMaxima;
	}

	public void setVelocidadeMaxima(double velocidadeMaxima) {
		this.velocidadeMaxima = velocidadeMaxima;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EspacoPorto getLocalAtual() {
		return localAtual;
	}

	public void setLocalAtual(EspacoPorto localAtual) {
		this.localAtual = localAtual;
	}
	public ArrayList<Transporte> getTransporte() {
		return transporte;
	}
	public boolean setTransporte(Transporte transportep) {
		return transporte.add(transportep);
	}

	@Override
	public String toString() {
		return "[" +
			" nome= " + getNome() + 
			", localAtual= " + getLocalAtual() + 
			", transporte= " + getTransporte() + 
			", velocidadeMaxima= " + getVelocidadeMaxima() +
			"]";
	}
	

}
