import java.util.ArrayList;
import java.util.InputMismatchException;
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
		u = new UsinaNaoRenovavel("Dona Francisca", 300, 1000, "Carvao", 30);
		u.calculaPrecoMWh();
		conglomerado.cadastraUsina(u);
		u = new UsinaRenovavel("Boca Do Inferno", 100, 3000, "Eolica");
		u.calculaPrecoMWh();
		conglomerado.cadastraUsina(u);
		u = new UsinaRenovavel("Santa Maria", 200, 2000, "Hidrica");
		u.calculaPrecoMWh();
		conglomerado.cadastraUsina(u);
		u= new UsinaRenovavel("Passo Real", 200, 2000, "Hidrica");
		u.calculaPrecoMWh();
		conglomerado.cadastraUsina(u);
	}

	/**
	 * execução do laço principal/ seleceção de menus
	 */
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
					case 6:
						lerArquivo();
						break;
					default:
						System.out.println("Opcao invalida.");
						break;
				}
		} while (opcao != 0);
	}
	
	public void CadastraUsina() {
		try {
			System.out.println("Bem vindo ao Cadastro de Usinas!");
			System.out.println("Digite o Nome da Usina: ");
			String nome = entrada.nextLine();
			System.out.println("Digite a producao em MWh: ");
			double producao= entrada.nextDouble();
			System.out.println("Digite o custo do MWh: ");
			double custo= entrada.nextDouble();
			System.out.println("Ditige sua opção: 1 - Usina Renovavel / 2 - Usina nao-renovavel ");
			int opcao = entrada.nextInt();
			entrada.nextLine();
			if(opcao == 1){
				System.out.println("Digite a fonte de energia: ");
				String fonte = entrada.nextLine();
				Usina u = new UsinaRenovavel(nome, producao, custo, fonte);
				u.calculaPrecoMWh();
				conglomerado.cadastraUsina(u);			
			}
			if(opcao==2){
				System.out.println("Digite o Combustivel");
				String combustivel = entrada.nextLine();
				System.out.println("Digite a durabilidade");
				int durabilidade = entrada.nextInt();
				Usina u = new UsinaNaoRenovavel(nome, producao, custo, combustivel,durabilidade);
				u.calculaPrecoMWh();
				conglomerado.cadastraUsina(u);
			}
		} catch (Exception e) {
			System.out.println("Tipo de entrada de dados inválido"+e.getMessage());
		}
			
	}

	public void salvaDadosArquivo() {
		System.out.println("Digite o nome do Arquivo");
		String nomeArquivo = entrada.nextLine();
		conglomerado.salvaDadosArquivo(nomeArquivo);
	}

	public void consultaPreco() {
		System.out.println("======================================");
		System.out.print("Digite o Nome da Usina: ");
		String nome = entrada.nextLine();
		Usina u = conglomerado.pesquisaUsina(nome);
		if (u == null)
			System.out.println("Erro. Nao ha Usina com este nome");
		else {
			System.out.println("O preço do MWh da Usina: "+ nome + " é de R$: " + conglomerado.consultaPreco(nome));
		}	
	}

    /**
     * Leitura de arquivo (usando java.io)
     * @param nomeArquivo nome do arquivo
     * @return true se leu; false em caso contrario
     */
    public void lerArquivo() {
       		System.out.println("Digite o nome do Arquivo");
			String nomeArquivo = entrada.nextLine();
			conglomerado.lerArquivo(nomeArquivo);	
        
    }

	public void listaTodasUsinas() {
		ArrayList<Usina> usinas = conglomerado.listaTodasUsinas();
		for(Usina u : usinas){
			System.out.println(u.geraResumo());
		}
	}

	public void pesquisaUsina() {
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

	public void menu() {
		System.out.println("======================================");
		System.out.println("Opcoes:");
		System.out.println("[0] Sair do Sistema");
		System.out.println("[1] Cadastra Usina");
		System.out.println("[2] Pesquisa Usina por Nome");
		System.out.println("[3] Lista todas Usinas");
		System.out.println("[4] Consultar preço do MWh por Usina");
		System.out.println("[5] Salvar dados em Arquivo");
		System.out.println("[6] Lê arquivo");
		System.out.println("Opcao desejada: ");
		
	}



}
