import java.util.ArrayList;

public class Conglomerado {

	private ArrayList<Usina> usinas;

	public boolean cadastraUsina(Usina usina) {
		return usinas.add(usina);
	}

	public Usina pesquisaUsina(String nome) {
		for(Usina u: usinas){
			if(u.getNome().equals(nome))
			return u;
		}
		return null;
	}

	public ArrayList<Usina> listaTodasUsinas() {
		return usinas;
	}

	public double consultaPreco(String nome) {
		for(Usina u: usinas){
			if(u.getNome().equals(nome))
			return u.calculaPrecoMWh();
		}
		return -1;
	}

	public boolean salvaDadosArquivo(String nomeArquivo) {
		return false;
	}

}
