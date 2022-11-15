package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Colecao {
    private ArrayList<Indice> colecao;
    private ArrayList<Indice> ultimaconsulta;

    
    public Colecao() {
        colecao = new ArrayList<Indice>();
        ultimaconsulta = new ArrayList<Indice>();
    }

    /**
     * @param indice
     * @return boolean
     */
    public boolean cadastraColecao(Indice indice) {
        return colecao.add(indice);
    }

    /**
     * @param indice
     * @return boolean
     * Funciona como buffer Armazenando sempre a ultima consulta feita 
     */
    public void cadastraUltimaconsulta(ArrayList<Indice> indice) {
     ultimaconsulta = indice;
    }
    public void limpaUltimaConsuta(){
        ultimaconsulta.clear();

    }
    public ArrayList<Indice> consultaTodasCidades() {
        return (ArrayList<Indice>) colecao.clone();
    }

    /**
     * @param nomeArquivo
     * @return
     */
    public boolean salvaDadosArquivo(String nomeArquivo) {
        Path path = Paths.get(nomeArquivo);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()))) {
            /* 
             * Escrever código para salvar coleção gerada na última consulta.
             */
            
            for (Indice i : ultimaconsulta) {
                writer.format(i.geraCsv());
            }
        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
        return false;
    }

    public boolean lerArquivo(String nomeArquivo) {
        try {
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Scanner sc = new Scanner(linha).useDelimiter(";");
                String nome = sc.next();
                int homicidiosDolosos = Integer.parseInt(sc.next());
                int totalVitimasHomicidiosDolosos = Integer.parseInt(sc.next());
                int latrocinios = Integer.parseInt(sc.next());
                int furtos = Integer.parseInt(sc.next());
                int abigeatos = Integer.parseInt(sc.next());
                int furtoVeiculo = Integer.parseInt(sc.next());
                int roubos = Integer.parseInt(sc.next());
                int rouboVeiculo = Integer.parseInt(sc.next());
                int estelionato = Integer.parseInt(sc.next());
                int delitosRelacionadosArmaMunicao = Integer.parseInt(sc.next());
                int entorpecentesPosse = Integer.parseInt(sc.next());
                int entorpecentesTrafico = Integer.parseInt(sc.next());
                int vitimasLatrocinio = Integer.parseInt(sc.next());
                int vitimasLesaoMorte = Integer.parseInt(sc.next());
                int totalVitimasCvli = Integer.parseInt(sc.next());
                Indice i = new Indice(nome, homicidiosDolosos, totalVitimasHomicidiosDolosos, latrocinios,
                        furtos, abigeatos, furtoVeiculo, roubos, rouboVeiculo, estelionato,
                        delitosRelacionadosArmaMunicao, entorpecentesPosse, entorpecentesTrafico, vitimasLatrocinio,
                        vitimasLesaoMorte, totalVitimasCvli);
                cadastraColecao(i);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Erro:" + e);
            return false;
        }
        return true;
    }

}
