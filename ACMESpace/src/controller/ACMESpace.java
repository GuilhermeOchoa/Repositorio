package controller;

import java.util.Scanner;

import model.EspacoPorto;
import model.EspaconaveSubluz;
import model.EspaconaveSubluz.Combustivel;

public class ACMESpace {

    private ACMECatalogo acmeCatalogo;
    private Scanner entrada;

    public ACMESpace() {
        acmeCatalogo = new ACMECatalogo();
        entrada = new Scanner(System.in);
    }

    public void executa() {
        int opcao = 9;
        do {
            menu();
            try {
                opcao = entrada.nextInt();
                entrada.nextLine();
                switch (opcao) {
                    case 0:
                        cadastraNovoEspacoPorto();
                        break;
                    case 1:
                        cadastraNovaEspaconave();
                        break;

                    default:
                        System.out.println("Opcao invalida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida: " + e.getMessage());
                entrada.nextLine();

            }

        } while (opcao != 8);

    }

    private void cadastraNovaEspaconave() {
        System.out.println("Cadastro de nova Espaçonave " + "\n");
        System.out.println("Digite o Nome do Espaçonave:");
        String nome = entrada.next();
        System.out.println("Escolha o tipo de espaçonave: 1- Subluz, 2- FTL ");
        int tipo = entrada.nextInt();
        if (tipo == 1) 
            System.out.println("Selecione o Combustivel: 1- Nuclear, 2 - Ion");
            int c = entrada.nextInt();
            if (c==1)
            

        else
            System.out.println("Espaço porto já existe");
    }

    private void cadastraNovoEspacoPorto() {
        System.out.println("Cadastro de novo espaço porto! " + "\n");
        System.out.println("Digite o número do espaço porto: ");
        int numero = entrada.nextInt();
        System.out.println("Digite o Nome do espaço porto:");
        String nome = entrada.next();
        System.out.println("Digite a coordenada X: ");
        double coordX = entrada.nextDouble();
        System.out.println("Digite a coordenada Y: ");
        double coordY = entrada.nextDouble();
        System.out.println("Digite a coordenada Z: ");
        double coordZ = entrada.nextDouble();
        if (acmeCatalogo.cadastraEspacoPorto(new EspacoPorto(numero, nome, coordX, coordY, coordZ)))
            System.out.println("Espaço porto cadastrado");
        else
            System.out.println("Espaço porto já existe");

    }

    public void menu() {
        System.out.println("======================================");
        System.out.println("Opcoes:");
        System.out.println("[0] Cadastrar novo espaço-porto");
        System.out.println("[1] Cadastrar nova espaçonave");
        System.out.println("[2] Cadastrar novo transporte");
        System.out.println("[3] Consultar todos os transporte");
        System.out.println("[4] Alterar estado do transporte");
        System.out.println("[5] Carregar dados iniciais");
        System.out.println("[6] Designar transporte");
        System.out.println("[7] Salvar dados");
        System.out.println("[8] Sair do programa");
        System.out.println("Opcao desejada: ");

    }
}