import java.util.ArrayList;

public class Conglomerado {

	private ArrayList<Usina> usinas;
	
	public Conglomerado() {
		usinas = new ArrayList<Usina>();
	}	

	public boolean cadastraUsina(Usina usina) {
		if(pesquisaUsina(usina.getNome())==null){
		 usinas.add(usina);
		 return true;
	}
		 return false;
	}

	public Usina pesquisaUsina(String nome) {
		for(Usina u: usinas){
			if(u.getNome().equals(nome))
			return u;
		}
		return null;
	}

	public ArrayList<Usina> listaTodasUsinas() {
		return (ArrayList<Usina>)usinas.clone();
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
