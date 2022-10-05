import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

//classe de aplicação

public class ACMEEnergy {
	private Conglomerado conglomerado;
	private Scanner entrada;
	
	public ACMEEnergy() {
		entrada = new Scanner(System.in);
		conglomerado = new Conglomerado();
		
	}

	public void inicializa() {		
	Usina u;
		u = new UsinaNaoRenovavel("Dona Francisca", 300, 1000, "Carvão", 30);
		u.calculaPrecoMWh();
		conglomerado.cadastraUsina(u);
		u = new UsinaRenovavel("Boca Do Inferno", 100, 3000, "Eólica");
		u.calculaPrecoMWh();
		conglomerado.cadastraUsina(u);
		u = new UsinaRenovavel("Santa Maria", 200, 2000, "Hídrica");
		u.calculaPrecoMWh();
		conglomerado.cadastraUsina(u);
		u= new UsinaRenovavel("Passo Real", 200, 2000, "Hídrica");
		u.calculaPrecoMWh();
		conglomerado.cadastraUsina(u);
	}

	public void executa() {
		
		int opcao;
		do {
			menu();
			opcao = entrada.nextInt();
			entrada.nextLine();
			switch (opcao) {
				case 0:
					break;
				case 1:
					CadastraUsina();
					break;
				case 2:
					pesquisaUsina();
					break;
				case 3:
					listaTodasUsinas();
					break;
				case 4:
					consultaPreco();
					break;
				case 5:
					salvaDadosArquivo();
					break;
				default:
					System.out.println("Opcao invalida.");
					break;
			}
		} while (opcao != 0);
	}

	private void CadastraUsina() {
		
		System.out.print("Bem vindo ao Cadastro de Usinas");
		System.out.print("Digite o Nome da Usina: ");
		String nome = entrada.nextLine();
		System.out.print("Digite a producao: ");
		double producao= entrada.nextDouble();
		System.out.print("Digite o custo do MWh: ");
		double custo= entrada.nextDouble();
		System.out.print("Ditige sua opção: ");
		System.out.print("[1]Usina Renovavel [2]Usina nao-renovavel");
		int opcao = entrada.nextInt();
		if(1){
			System.out.println("Digite a fonte de energia: ");
			String fonte = entrada.nextLine();
		Usina u = new Usina(nome, producao, custo, fonte);
		u.calculaPrecoMWh();
		conglomerado.cadastraUsina(u);			
		}
		else
		System.out.println("Digite o Combustivel");
		String combustivel = entrada.nextLine();
		System.out.println("Digite a durabilidade");
		int durabilidade = entrada.nextInt();
		Usina u = new Usina(nome, producao, custo, combustivel,durabilidade);
		u.calculaPrecoMWh();
		conglomerado.cadastraUsina(u);		
	
	}

	private void salvaDadosArquivo() {
	ArrayList<Usina> usinas = conglomerado.listaTodasUsinas();
	Path path = Paths.get("usinas.txt");
	try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path,Charset.defaultCharset()))) {
		for (Usina u : usinas) {
			writer.format(u.geraCsv());
		}
	}
		catch (IOException e) {
			System.err.format("Erro de E/S: %s%n", e);
		}

	}

	private void consultaPreco() {
		System.out.println("======================================");
		System.out.print("Digite o Nome da Usina: ");
		String nome = entrada.nextLine();
		System.out.println("O preço do MWh da Usina: "+ nome + " é de R$: " + conglomerado.consultaPreco(nome));
	
	}

	private void listaTodasUsinas() {
		ArrayList<Usina> usinas = conglomerado.listaTodasUsinas();
		for(Usina u : usinas){
			System.out.println( u.geraResumo());
		}
	}

	private void pesquisaUsina() {
		System.out.println("======================================");
		System.out.print("Digite o nome da Usina: ");
		String nome = entrada.nextLine();
		Usina u = conglomerado.pesquisaUsina(nome);
		if (u == null)
			System.out.println("Erro. Nao ha Usina com este nome");
		else {
			System.out.println(u.geraResumo());
		}

	}

	private void menu() {
		System.out.println("======================================");
		System.out.println("Opcoes:");
		System.out.println("[0] Sair do Sistema");
		System.out.println("[1] Cadastra Usina");
		System.out.println("[2] Pesquisa Usina por Nome");
		System.out.println("[3] Lista todas Usinas");
		System.out.println("[4] Consultar preço do MWh por Usina");
		System.out.println("[5] Salvar dados em Arquivo");
		System.out.println("Opcao desejada: ");
		
	}
}
