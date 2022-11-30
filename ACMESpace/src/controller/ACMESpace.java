package controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import model.*;
import util.Arquivos;

public class ACMESpace {

    private ACMETransportes transporte;
    private ACMEFrota frota;
    private ACMEPortos porto;
    private Scanner entrada;
    private Arquivos arquivos;
    
    public ACMESpace() {
        transporte = new ACMETransportes();
        frota = new ACMEFrota();
        porto = new ACMEPortos();        
        entrada = new Scanner(System.in);
        arquivos = new Arquivos();
        
    }

    public void executa() {
        int opcao=9;
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
                    case 4:
                        alteraEstadoTransporte();
                        break;
                    case 5:
                        carregarDadosInciais();
                        break;
                    case 6:
                        designarTransporte();
                        break;
                    case 7:
                        salvarDados();
                        break;    
                    case 8:
                        carregarDados();
                        break;
                    case 9:
                        System.out.println("Saindo do programa!");
                            break;                                            
                    default:
                        System.out.println("Opcao invalida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada invalida: " + e.getMessage());
                entrada.nextLine();

            }

        } while (opcao != 9);

    }

    private void carregarDados() {
        System.out.println("Digite o nome do arquivo com os dados:");
        String nomeArquivo = entrada.nextLine();
        porto.cadastradaClonados(arquivos.leEportoJSON(nomeArquivo));
        System.out.println("Arquivo de portos cadastrado");      

    }

    private void salvarDados() {
        System.out.println("Digite o nome do arquivo");
        String nome = entrada.nextLine();
        arquivos.escreveEspacoportos(porto.consultaPortos(),nome);
        arquivos.escreveEspaconaves(frota.retornaEspaconaves(),nome);
        arquivos.escreveTranportes(transporte.historicoTransporte(),nome);
    }

    private void designarTransporte() {
        Transporte proximodafila = transporte.retiraUmFila();
        ArrayList<Espaconave> todasEsp = frota.retornaEspaconaves();
        ArrayList<Transporte> transporthist = transporte.historicoTransporte();
        System.out.println("Proximo trasporte da fila de Pendentes: "+"\n" + proximodafila);       

        // List<String> espaconaves = transporthist.stream()
        //                 .filter(f-> f.getEspaconave()!=null)
        //                 .map(f-> f.getEspaconave().getNome() + ",")
        //                 .collect(Collectors.toList());
        //                  System.out.println("Espaconaves designadas para transporte:");
        //                  espaconaves.stream()
        //                 .forEach(System.out::println);
        // System.out.println("Espaconaves livres para tranporte:");
        // todasEsp.stream()
        // .filter(f-> f.getNome())
        // .collect(Collectors.toList())
        // .forEach(System.out::println);
        System.out.println("Selecione uma Espaçonave: ");        
        String nome = entrada.nextLine();
        Espaconave espaconave = frota.pesquisaEspaconave(nome);
        proximodafila.setEspaconave(espaconave);
        Transporte historico = transporte.pesquisaHistoricoTransporte(proximodafila.getIdentificador());
        transporte.cadastraTransporteDesignado(historico);
        System.out.println(historico.toString());
        historico.setEspaconave(espaconave);
    }

    private void carregarDadosInciais() {
        System.out.println("Digite o nome do arquivo que deseja ler");
        String file = entrada.nextLine();
        arquivos.carregaArquivo(file);
        ArrayList<EspacoPorto> portoclonado = arquivos.clonePortos();
        porto.cadastradaClonados(portoclonado);
        ArrayList<Espaconave> espaconaveclonado = arquivos.cloneEspaconaves();
        frota.cadastradaClonados(espaconaveclonado);
        ArrayList<Transporte> transportesclonado = arquivos.cloneTransportes();
        transporte.cadastradaClonados(transportesclonado);

    }

    private void alteraEstadoTransporte() {
        System.out.println("Digite o identificador do transporte para alterar o Estado");
        int identificador = entrada.nextInt();
        Transporte peTransporte = transporte.historicoTransporte(identificador);
        System.out.println(peTransporte.toString());
        System.out.println("Selecione o novo Estado para o Transporte :1- PENDENTE, 2- TRANSPORTANDO, 3- CANCELADO, 4-FINALIZADO");
        int estado = entrada.nextInt();
        if((peTransporte.getEstado()!= Estados.CANCELADO)&&(peTransporte.getEstado()!= Estados.FINALIZADO)){
            switch (estado) {
                case 1:
                    peTransporte.setEstado(Estados.PENDENTE);
                    break;
                case 2 :
                    peTransporte.setEstado(Estados.TRANSPORTANDO);
                    break;
                case 3 :
                    peTransporte.setEstado(Estados.CANCELADO);
                    break;
                case 4:
                    peTransporte.setEstado(Estados.FINALIZADO);
                    break;                
                default:
                   break;
              }

        }else{
            System.out.println("Transporte com estados FINALIZADOS ou CANCELADOS não podem ser alterados");
        }
        
    }

    private void consultaTodosTransportes() {
        System.out.println("Consulta todos os trasportes:"+"\n");
        ArrayList<Transporte> lista = transporte.historicoTransporte();
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
                if(todoPortos.size()>0){
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
                            TransportePessoa t = new TransportePessoa(identificador, origem, destino,Estados.PENDENTE,quantidadeP);
                            if(transporte.cadastraTransporte(t)){
                                t.calculaDistancia();
                                t.calculaCusto();                                
                                System.out.println("Transporte cadastrado.");
                                System.out.println(t.toString());
                            }else{System.out.println("Existe transporte cadastrado com este identificador.");}               
                        break;
                    case 2:
                        System.out.println("Digite a quantidade de MATERIAIS que serão transportadas:");
                        int quantidadeM = entrada.nextInt();
                        System.out.println("Digite a descrição do material que será transportado:");
                        String descricao = entrada.next();
                        TransporteMaterial m = new TransporteMaterial(identificador, origem, destino,Estados.PENDENTE,quantidadeM,descricao);
                            if(transporte.cadastraTransporte(m)){
                                m.calculaDistancia();
                                m.calculaCusto();                                
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
                    else{
                        System.out.println("Sem espacosportos cadastrados para registrar transporte");
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
                System.out.println("Digite um valor para velocidade máxima, menor ou igual a 0,3 Warp");
                double velocidadeS = entrada.nextDouble();
                switch (combustivel) {
                    case"N" :
                        if(frota.cadastraEspaconave(new EspaconaveSubluz(nome,localAtual, velocidadeS, "NUCLEAR")))
                            System.out.println("Espaçonave cadastrada!");
                        else 
                            System.out.println("Espaçonave já existe!");
                        break;
                     case "I":
                        if(frota.cadastraEspaconave(new EspaconaveSubluz(nome,localAtual, velocidadeS, "ION")))
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
            double velocidadeF = entrada.nextDouble();
            System.out.println("Digite a quantidade máxima de pessoas ou carga:");
            double quantidade = entrada.nextDouble();
            if(frota.cadastraEspaconave(new EspaconaveFTL(nome, localAtual, velocidadeF, quantidade)))
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
        System.out.println("[8] Carregar dados");
        System.out.println("[9] Sair do programa");
        System.out.println("Opcao desejada: ");

    }
}