package model;
import java.util.Collection;

public class Espaconave {

	private String nome;
	private EspacoPorto localAtual;
	private Collection<Transporte> transporte;
	public Espaconave(String nome) {

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

	

}
