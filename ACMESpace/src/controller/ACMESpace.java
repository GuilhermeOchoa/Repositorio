package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Combustiveis;
import model.EspacoPorto;
import model.EspaconaveFTL;
import model.EspaconaveSubluz;
import model.Transporte;
import model.TransporteMaterial;
import model.TransportePessoa;

public class ACMESpace {

    private ACMETransportes transporte;
    private ACMEFrota frota;
    private ACMEPortos porto;
    private Scanner entrada;
    
    public ACMESpace() {
        transporte = new ACMETransportes();
        frota = new ACMEFrota();
        porto = new ACMEPortos();        
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
                    case 2:
                        cadastraTransporte();
                        break;
                    case 3:
                        consultaTodosTransportes();
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

    private void consultaTodosTransportes() {
        System.out.println("Consulta todos os trasportes:"+"\n");
        ArrayList<Transporte> lista = transporte.listaTodosTransportes();
        if(lista.size()>0)
        lista.stream()
            .forEach(System.out::println);
            else
            System.out.println("Não há transporte cadastrado");
    }

    private void cadastraTransporte() {
        System.out.println("Cadastro de transporte"+"\n");
        System.out.println("Digite o identificador do transporte:");
        int identificador =  entrada.nextInt();        
                System.out.println("Espaçoportos disponíveis:");
                ArrayList<EspacoPorto> todoPortos =  porto.consultaPortos();
                for(EspacoPorto e:todoPortos){
                    System.out.println(e.toString());
                }
                System.out.println("Selecione o número do Espaçoporto ORIGEM:");
                int num1 = entrada.nextInt();
                EspacoPorto origem = porto.pesquisaEspacoPorto(num1);
                System.out.println("Selecione o número do Espaçoporto de DESTINO");
                int num2 = entrada.nextInt();
                EspacoPorto destino = porto.pesquisaEspacoPorto(num2);
                System.out.println("Digite o tipo de transporte: 1- Pessoas, 2-Materiais");
                   int tipo = entrada.nextInt();
                switch (tipo) {
                    case 1:                
                        System.out.println("Digite a quantidade de PESSOAS que serão transportadas:");
                        int quantidadeP = entrada.nextInt();
                            TransportePessoa t = new TransportePessoa(identificador, origem, destino, tipo, quantidadeP);
                            if(transporte.cadastraTransporte(t)){
                                t.calculaCusto();
                                t.calculaDistancia();
                                System.out.println("Transporte cadastrado.");
                                System.out.println(t.toString());
                            }else{System.out.println("Existe transporte cadastrado com este identificador.");}               
                        break;
                    case 2:
                        System.out.println("Digite a quantidade de MATERIAIS que serão transportadas:");
                        int quantidadeM = entrada.nextInt();
                        System.out.println("Digite a descrição do material que será transportado:");
                        String descricao = entrada.next();
                        TransporteMaterial m = new TransporteMaterial(identificador, origem, destino, tipo, quantidadeM, descricao);
                            if(transporte.cadastraTransporte(m)){
                                m.calculaCusto();
                                m.calculaDistancia();
                                System.out.println("Transporte cadastrado.");
                                System.out.println(m.toString());
                            }
                            
                            else
                            System.out.println("Existe transporte cadastrado com este identificador.");    
                        break;
                    default:
                         break;
        }



    }

    private void cadastraNovaEspaconave() {
        EspacoPorto localAtual = new EspacoPorto(11, "Terra", 0, 0, 0);
        System.out.println("Cadastro de nova Espaçonave " + "\n");
        System.out.println("Digite o Nome do Espaçonave:");
        String nome = entrada.next();
        System.out.println("Escolha o tipo de espaçonave: 1- Subluz, 2- FTL ");
        int tipo = entrada.nextInt();        
        switch (tipo) {
            case 1:
                System.out.println("Selecione o Combustivel: N- Nuclear, I - Ion");
                String combustivel = entrada.next().toUpperCase();
                switch (combustivel) {
                    case"N" :
                        if(frota.cadastraEspaconave(new EspaconaveSubluz(nome,localAtual, 0.3, Combustiveis.NUCLEAR)))
                            System.out.println("Espaçonave cadastrada!");
                        else 
                            System.out.println("Espaçonave já existe!");
                        break;
                     case "I":
                        if(frota.cadastraEspaconave(new EspaconaveSubluz(nome,localAtual, 0.3, Combustiveis.ION)))
                            System.out.println("Espaçonave cadastrada!");
                        else
                             System.out.println("Espaçonave já existe!");
                        break;
                    default:
                        break;
                }
                break;
                
            case 2:
            System.out.println("Digite a velocidade máxima Warp: ");
            double velocidade = entrada.nextDouble();
            System.out.println("Digite a quantidade máxima de pessoas ou carga:");
            double quantidade = entrada.nextDouble();
            if(frota.cadastraEspaconave(new EspaconaveFTL(nome, localAtual, velocidade, quantidade)))
                System.out.println("Espaçonave cadastrada");
            else
                System.out.println("Espaçonave já existe");
            break;
     
            default:
                break;
        }
           
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
        if (porto.cadastraEspacoPorto(new EspacoPorto(numero, nome, coordX, coordY, coordZ)))
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