import java.util.Scanner;

public class Aplicacao {
    private Colecao colecao;
    private Scanner entrada;

    public Aplicacao() {
        entrada = new Scanner(System.in);
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
						carregarDados();
						break;
					case 2:
						classificaNome();
						break;
					case 3:
						consultaTodos();
						break;
					case 4:
						consultaNomeIncompleto();
						break;
					case 5:
						salvaDadosArquivo();
						break;
					case 6:
					//	lerArquivo();
						break;
					default:
						System.out.println("Opcao invalida.");
						break;
				}
		} while (opcao != 0);
	}
    
    private void salvaDadosArquivo() {
        System.out.println("Digite o nome do Arquivo");
		String nomeArquivo = entrada.nextLine();
		colecao.salvaDadosArquivo(nomeArquivo);
    }


    private void consultaNomeIncompleto() {
    }


    private void consultaTodos() {
    }


    private void classificaNome() {
    }


    private void carregarDados() {
        System.out.println("Digite o nome do Arquivo");
			String nomeArquivo = entrada.nextLine();
			colecao.lerArquivo(nomeArquivo);	
    }


    public void menu() {
		System.out.println("======================================");
		System.out.println("Opcoes:");
		System.out.println("[0] Sair do sistema");
		System.out.println("[1] Carregar dados");
		System.out.println("[2] Classificar por Nome");
		System.out.println("[3] Consultar todos os dados");
		System.out.println("[4] Consultar nome incompleto");
		System.out.println("[5] Salvar dados em Arquivo");
		//System.out.println("[6] Lê arquivo");
		System.out.println("Opcao desejada: ");
		
	}
    
}
