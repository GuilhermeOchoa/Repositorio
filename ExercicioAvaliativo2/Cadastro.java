package ACMEFinancas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cadastro {

    private ArrayList<Cobravel> cobraveis = new ArrayList<>();

    public boolean adiciona(Cobravel item) {
        try {
            cobraveis.add(item);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Cobravel[] pesquisa(String nome) {
            List<Cobravel> foundCobraveis = cobraveis.stream().filter(cobravel -> cobravel.getNome().equals(nome))
                    .collect(Collectors.toList());
            if (foundCobraveis.size() > 0) {
                Cobravel[] copia = new Cobravel[foundCobraveis.size()];
                copia = foundCobraveis.toArray(copia);
                return copia;
            } else {
                return null;
            }
    }

    public Cobravel[] pesquisa() {
        if (cobraveis.size() > 0) {
            Cobravel[] copia = new Cobravel[cobraveis.size()];
            copia = cobraveis.toArray(copia);
            return copia;
        }
        return null;
    }

    public boolean pesquisa(Integer identificador) {
        Cobravel foundCobravel = cobraveis.stream()
                .filter(cobravel -> cobravel.getIdentificador() == identificador)
                .findAny()
                .orElse(null);

        if (foundCobravel != null) return true;
        return false;
    }

    public double calculaImpostoItem(int identificador) {
        Cobravel cobravelFound = cobraveis.stream()
                .filter(cobravel -> cobravel.getIdentificador() == identificador)
                .findAny()
                .orElse(null);

        if (cobravelFound != null) return cobravelFound.calculaImposto();
        return -1;

    }

    public void salvaArquivoTexto(String nomeArquivo) {
        String path = nomeArquivo + ".csv";
        try{
            BufferedWriter bw = Files.newBufferedWriter(Paths.get(path), Charset.defaultCharset());
            PrintWriter writer = new PrintWriter(bw);
            for (Cobravel c : cobraveis) {
                writer.format("%s%n", c.toCsv());
            }
            bw.close();
        }
        catch (IOException ioerr) {
            System.err.format("Erro de E/S: %s%n", ioerr);
        }
    }

    public void carregaArquivoTexto(String nomeArquivo){
        String pathArquivoCarregado = nomeArquivo + ".csv";
        Integer identificador;
        String tipo;
        String nome;
        Double valorBase;
        String tipoEspecifico;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(pathArquivoCarregado), Charset.defaultCharset())) {
            String linha = null;
            while ((linha = br.readLine()) != null) {
                Scanner sc = new Scanner(linha).useDelimiter(";");
                tipo = sc.next();
                identificador = Integer.parseInt(sc.next());
                nome = sc.next();
                valorBase = Double.parseDouble(sc.next());
                tipoEspecifico = sc.next();
                if(pesquisa(identificador)){
                    throw new Exception("Foi encontrado um identificador já registrado no arquivo. Altere o arquivo e tente novamente!");
                }
                if(tipo.equals("Veiculo")){
                    Veiculo newVeiculo = new Veiculo(identificador, nome, valorBase,
                            tipoEspecifico.equals("POPULAR") ? TipoVeiculo.POPULAR : tipoEspecifico.equals("BASICO") ?
                            TipoVeiculo.BASICO : TipoVeiculo.ESPORTIVO);
                    cobraveis.add(newVeiculo);
                }else{
                    Servico newServico = new Servico(identificador, nome, valorBase,
                            tipoEspecifico.equals("PESSOAL")? TipoServico.PESSOAL : TipoServico.EMPRESARIAL);
                    cobraveis.add(newServico);
                }
            }
        }
        catch (IOException ioerr) {
            System.err.format("Erro de E/S: %s%n", ioerr);
        }
        catch (Exception err) {
            System.out.println("Ocorreu um erro! Erro: " + err);
        }
    }

}
