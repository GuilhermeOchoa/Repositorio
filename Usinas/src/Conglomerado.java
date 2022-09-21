import java.util.ArrayList;

public class Conglomerado {

	private ArrayList<Usina> usinas;
	
	public Conglomerado() {
		usinas = new ArrayList<Usina>();
	}	

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
			return u.getPrecoMWh();
		}
		return -1;
	}

	public boolean salvaDadosArquivo(String nomeArquivo) {
		return false;
	}

}
