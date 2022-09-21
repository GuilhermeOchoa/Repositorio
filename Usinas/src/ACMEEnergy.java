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
		u = new UsinaNaoRenovavel("Francisca", 300, 1000, "Carvão", 30);
		conglomerado.cadastraUsina(u);
		u = new UsinaRenovavel("Boca do Inferno", 100, 3000, "Eólica");
		conglomerado.cadastraUsina(u);
		u = new UsinaRenovavel("Santa Maria", 200, 2000, "Hídrica");
		conglomerado.cadastraUsina(u);
		u= new UsinaRenovavel("Passo Real", 200, 2000, "Hídrica");
		conglomerado.cadastraUsina(u);
	}

	public void executa() {
		inicializa();
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
		
		System.out.print("Bem vindo ao Cadastro de Usinas: ");
		System.out.print("Digite o Nome da Usina: ");
		entrada.nextLine();
	
	}

	private void salvaDadosArquivo() {

	}

	private void consultaPreco() {
		System.out.println("======================================");
		System.out.print("Digite o Nome da Usina: ");
		String nome = entrada.next();
		entrada.nextLine();
		System.out.print("O preço do MWh da Usina:"+ nome + "é de R$ " + conglomerado.consultaPreco(nome));
	
	}

	private void listaTodasUsinas() {
		conglomerado.listaTodasUsinas();
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
