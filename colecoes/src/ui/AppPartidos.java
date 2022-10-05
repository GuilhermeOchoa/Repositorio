package ui;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import dados.Candidato;
import dados.Partido;

public class AppPartidos {
    private Partido partido;
    private Scanner entrada;

    public AppPartidos() {
        partido =new Partido();
        entrada = new Scanner(System.in);
    }
    
    public void executaAplicaçao(){
        int opcao=0;
        do{
            menu();
            System.out.println("Digite a opcao");
            opcao = entrada.nextInt();
            switch(opcao){
            case 0: break;
            case 1:
            cadastraCandidato();
             break;
            case 2:
            mostrarTodosCandidatos();
             break;
             case 3:
             salvarArquivo();
             break;
            default:
            System.out.println("Opcão invalida");
            } 
        }while(opcao!=0);
       


    }
    
    private void menu() {
		System.out.println("======================================");
		System.out.println("Opcoes:");
		System.out.println("[0] Sair do Sistema");
		System.out.println("[1] Cadastra um candidato");
		System.out.println("[2] Mostra todos os candidatos");
        System.out.println("[3] Gravar arquivos");
        System.out.println("[4] Le arquivos");
		System.out.println("Opcao desejada: ");
		
	}

public void cadastraCandidato(){
    System.out.println("cadastra de nome Candidato");
    System.out.println("Digite o Codigo");
    int codigo = entrada.nextInt();
    entrada.nextLine();
    System.out.println("Digite o nome");
    String nome = entrada.nextLine();
    Candidato c = new Candidato(codigo, nome);
    if(partido.adicionaCanditato(c))
    System.out.println("Candidato Cadastrado");
    else
    System.out.println("Candidato repetido");

    }

public void mostrarTodosCandidatos(){
    System.out.println("Todos candidatos");
    ArrayList<Candidato> candidatos = partido.consultaTodosCandidatos();
    for(Candidato c : candidatos){
        System.out.println("Numero: "+ c.getNumero());
        System.out.println("Nome: "+ c.getNome());
    }
    
}
public void salvarArquivo() {
    String nomeArquivo = entrada.nextLine();
    if(partido.gravaArquivo(nomeArquivo))
    System.out.println("Arquivo Gravado");
    else
    System.out.println("arquivo invalido");
    
}
    

}
