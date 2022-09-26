package ACMEFinancas;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACMEFinancas {

    private Cadastro cadastro = new Cadastro();

    public void inicializa() {
        Veiculo veiculo1 = new Veiculo(1, "BMW", 1500.00, TipoVeiculo.BASICO);
        Servico servico1 = new Servico(2, "Aluguel", 670.00, TipoServico.PESSOAL);
        Veiculo veiculo2 = new Veiculo(3, "BMW", 2400.000, TipoVeiculo.ESPORTIVO);
        cadastro.adiciona(veiculo1);
        cadastro.adiciona(servico1);
        cadastro.adiciona(veiculo2);
    }

    public void executa() {
        boolean estaRodando = true;
        Scanner in = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema ACMEFinancas!");
        System.out.println("Favor insira o comando conforme as informações que deseja");
        while (estaRodando) {
            System.out.println("0: Sair");
            System.out.println("1: Cadastrar item cobrável");
            System.out.println("2: Mostrar todas informações de cadastro");
            System.out.println("3: Pesquisar item por nome");
            System.out.println("4: Calcular imposto de item");
            System.out.println("5: Salvar arquivo de dados");
            System.out.println("6: Carregar arquivo de dados");

            String escolha = in.nextLine();
            try {
                switch (Integer.parseInt(escolha)) {
                    case 0:
                        estaRodando = false;
                        in.close();
                        break;
                    case 1:
                        System.out.println("Aperte 1 para Veiculo e 2 para Servico");
                        int tipo = Integer.parseInt(in.nextLine());
                        if (tipo == 1) {
                            System.out.println("Digite o numero identificador");
                            int identificador = Integer.parseInt(in.nextLine());
                            if (cadastro.pesquisa(identificador)) {
                                throw new Exception("Numero Identificador já registrado");
                            }
                            System.out.println("Digite o nome");
                            String nome = in.nextLine();
                            System.out.println("Digite o valor base");
                            Double valorBase = Double.parseDouble(in.nextLine());
                            System.out.println("Digite 1 se o veiculo for popular, 2 se for básico e 3 se for esportivo");
                            int veiculoTipo = Integer.parseInt(in.nextLine());

                            Veiculo veiculo = new Veiculo(identificador, nome, valorBase,
                                    veiculoTipo == 1 ? TipoVeiculo.POPULAR :
                                            veiculoTipo == 2 ? TipoVeiculo.BASICO : TipoVeiculo.ESPORTIVO);
                            cadastro.adiciona(veiculo);
                        } else if (tipo == 2) {
                            System.out.println("Digite o numero identificador");
                            int identificador = Integer.parseInt(in.nextLine());
                            if (cadastro.pesquisa(identificador)) {
                                throw new Exception("Numero Identificador já registrado");
                            }
                            System.out.println("Digite o nome");
                            String nome = in.nextLine();
                            System.out.println("Digite o valor base");
                            Double valorBase = Double.parseDouble(in.nextLine());
                            System.out.println("Digite 1 se o serviço for pessoal, e 2 se for empresarial");
                            int servicoTipo = Integer.parseInt(in.nextLine());
                            Servico servico = new Servico(identificador, nome, valorBase,
                                    servicoTipo == 1 ? TipoServico.PESSOAL : TipoServico.EMPRESARIAL);
                            cadastro.adiciona(servico);
                        }
                        break;
                    case 2:
                        Cobravel[] cobraveis = cadastro.pesquisa();
                        for (int i = 0; i < cobraveis.length; i++) {
                            System.out.println("Nome: " + cobraveis[i].getNome() + " " + "Imposto: " + cadastro.calculaImpostoItem(cobraveis[i].getIdentificador()));
                        }
                        break;
                    case 3:
                        System.out.println("Informe o nome a ser pesquisado");
                        String nome = in.nextLine();
                        Cobravel[] cobraveisComMesmoNome = cadastro.pesquisa(nome);
                        if (cobraveisComMesmoNome != null) {
                            for (int i = 0; i < cobraveisComMesmoNome.length; i++) {
                                System.out.println("ID:" + cobraveisComMesmoNome[i].getIdentificador()
                                        + " " + "Nome:" + cobraveisComMesmoNome[i].getNome() + " " +
                                        "Imposto: " + cadastro.calculaImpostoItem(cobraveisComMesmoNome[i].getIdentificador())
                                );
                            }
                        } else {
                            System.out.println("Nenhum cobravel com esse nome encontrado");
                        }
                        break;
                    case 4:
                        System.out.println("Digite o numero identificador do item");
                        int identificador = Integer.parseInt(in.nextLine());
                        double imposto = cadastro.calculaImpostoItem(identificador);
                        if(imposto != -1){
                            System.out.println(imposto);
                        }else {
                            System.out.println("Item não encontrado");
                        }
                        break;
                    case 5:
                        System.out.println("Digite o nome do arquivo");
                        String nomeArquivo = in.nextLine();
                        cadastro.salvaArquivoTexto(nomeArquivo);
                        break;
                    case 6:
                        System.out.println("Digite o nome do arquivo a ser carregado");
                        String nomeArquivoCarregado = in.nextLine();
                        cadastro.carregaArquivoTexto(nomeArquivoCarregado);
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException err) {
                System.out.println("Ocorreu um erro! Erro: Você inseriu um input do tipo de errado. Tente novamente!");
            } catch (Exception err) {
                System.out.println("Ocorreu um erro! Erro: " + err + ". Tente novamente!");
            }
        }

    }

}
