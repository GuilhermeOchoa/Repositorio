import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

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

	/**
	 * @param nomeArquivo
	 * @return
	 */
	public boolean salvaDadosArquivo(String nomeArquivo) {
		Path path = Paths.get(nomeArquivo);
	try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path,Charset.defaultCharset()))) {
		for (Usina u : usinas) {
			writer.format(u.geraCsv());
		}
	}
		catch (IOException e) {
			System.err.format("Erro de E/S: %s%n", e);
		}
		return false;
	}
	public boolean lerArquivo(String nomeArquivo) {
        try {
			FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Scanner sc = new Scanner(linha).useDelimiter(";");
                	int numero = Integer.parseInt(sc.next());
					if(numero == 1){
						String nome =sc.next();
						double producao = Double.parseDouble(sc.next());
						double custo = Double.parseDouble(sc.next());
						String fonte = sc.next();
						Usina u = new UsinaRenovavel(nome, producao, custo, fonte);
						u.calculaPrecoMWh();
						cadastraUsina(u);
					}else{
						String nome =sc.next();
						double producao = Double.parseDouble(sc.next());
						double custo = Double.parseDouble(sc.next());
						String fonte = sc.next();
						int durabilidade = Integer.parseInt(sc.next());
						Usina u = new UsinaNaoRenovavel(nome, producao, custo, fonte, durabilidade);
						u.calculaPrecoMWh();
						cadastraUsina(u);
					}
                
            
                }
            br.close();
        }
        catch(IOException e) {
            System.err.println("Erro:" + e);
            return false;
        }
        return true;
    }

}
