package model;
public abstract class Transporte {

	private int tipo;
	private int identificador;
	private EspacoPorto origem;
	private EspacoPorto destino;
	private Espaconave espaconave;
	private double distancia;
	private double custo;

	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public EspacoPorto getOrigem() {
		return origem;
	}
	public void setOrigem(EspacoPorto origem) {
		this.origem = origem;
	}
	public EspacoPorto getDestino() {
		return destino;
	}
	public void setDestino(EspacoPorto destino) {
		this.destino = destino;
	}
	public Espaconave getEspaconave() {
		return espaconave;
	}
	public void setEspaconave(Espaconave espaconave) {
		this.espaconave = espaconave;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public Transporte(int identificador, EspacoPorto origem, EspacoPorto destino, int tipo) {

	}
	public Transporte(int tipo, int identificador, EspacoPorto origem, EspacoPorto destino, Espaconave espaconave,
			double distancia, double custo) {
		
	}

	public abstract double calculaDistancia();

	public abstract double calculaCusto();

}
