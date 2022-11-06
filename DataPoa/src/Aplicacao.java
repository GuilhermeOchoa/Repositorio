import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Aplicacao {
    private Colecao colecao;
    private Scanner entrada;

    public Aplicacao() {
        entrada = new Scanner(System.in);
        colecao = new Colecao();
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
		String nomeArquivo = entrada.next();
		colecao.salvaDadosArquivo(nomeArquivo);
    }


    private void consultaNomeIncompleto() {
    }


    private void consultaTodos() {
		ArrayList<Indice> lista = colecao.consultaTodasCidades();
        if (lista.size() == 0)
			System.out.println("Erro. Não há dados na coleção");
		else {
			System.out.println("Resultado da consulta de todos dados:");
		lista.stream()
		.forEach(System.out::println);
		}
    }


    private void classificaNome() {
		ArrayList<Indice> lista = colecao.consultaTodasCidades();
		System.out.println("Digite 1 para ordem crescente ou 2 para ordem decresente");
		int n = entrada.nextInt();
		if (n==1){
			Collections.sort(lista,
                (Indice u1, Indice u2) -> u1.getNome().compareTo(u2.getNome()));
		}
		else{
			Collections.sort(lista,
                (Indice u1, Indice u2) -> u2.getNome().compareTo(u1.getNome()));

		}
		lista.stream()
		.forEach(System.out::println);
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
