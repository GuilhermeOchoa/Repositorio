package model;
public abstract class Transporte {

	private int tipo;
	private int identificador;
	private EspacoPorto origem;
	private EspacoPorto destino;
	private Espaconave espaconave;
	private double distancia;
	private double custo;

	public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino, int tipo) {

	}
	public Transporte(int tipo, int identificador, EspacoPorto origem, EspacoPorto destino, Espaconave espaconave,
			double distancia, double custo) {
		
	}

	public abstract double calculaDistancia();

	public abstract double calculaCusto();

}
