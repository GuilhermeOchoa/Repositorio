package ACMEFinancas;

public abstract class Cobravel {

	protected int identificador;

	protected String nome;
	protected double valorBase;

	public Cobravel(int identificador, String nome, double valorBase) {
		this.identificador = identificador;
		this.nome = nome;
		this.valorBase = valorBase;
	}

	public abstract double calculaImposto();

	public abstract String toCsv();

	public int getIdentificador() {
		return identificador;
	}

	public String getNome() {
		return nome;
	}

}
