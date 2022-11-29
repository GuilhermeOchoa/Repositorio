package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import model.*;

public class Arquivos {
    private ArrayList<Espaconave> frota = new ArrayList<>();
    private ArrayList<EspacoPorto> espacoPortos = new ArrayList<>();
    private ArrayList<Transporte> transportes = new ArrayList<>();

    public Arquivos() {
    }

    public void carregaArquivo(String nome) {

        String espacoportosArq = "src/dados/" + nome + "-espacoportos.dat";        
        String espaconavesArq = "src/dados/" + nome + "-espaconaves.dat";
        String transportesArq = "src/dados/" + nome + "-transportes.dat";
        
        leEspacoportos(espacoportosArq);
        leEspaconaves(espaconavesArq);
        leTransportes(transportesArq);

    }

    private void leTransportes(String caminho) {
        
    }

    private void leEspacoportos(String caminho) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(caminho), StandardCharsets.ISO_8859_1)) {
            String linha = null;
            String header = br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] arr = new String[5];
                int count = 0;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                while (sc.hasNext()) {
                    String word = sc.next();
                    arr[count] = word;
                    count++;
                }

                EspacoPorto espacoPorto = new EspacoPorto(Integer.parseInt(arr[0]),
                arr[1],
                Double.parseDouble(arr[2]),
                Double.parseDouble(arr[3]),
                Double.parseDouble(arr[4])
                );
                System.out.println("Espacoporto: " + espacoPorto.getNome() + " registrado");
                espacoPortos.add(espacoPorto);
            }

            espacoPortos.forEach(l -> System.out.println("Numero: " + l.getNumero()
            + " Nome: " + l.getNome() + " CoordX: " + l.getCoordX()
                    + " CoordY: " + l.getCoordY()+" CoordZ: "+l.getCoordZ()));
        }catch (NoSuchFileException noferr){
            System.out.println("Nenhum arquivo de Espacoporto com esse nome encontrado!");
        }catch (IOException ioerr) {
            System.err.format("IO Error! Error: %s%n", ioerr);
        } catch (Exception err) {
            System.out.println("An error has occurred! Error: " + err);
        }
    }

    private void leEspaconaves(String caminho) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(caminho), StandardCharsets.ISO_8859_1)) {
            String linha = null;
            String header = br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] arr = new String[5];
                int count = 0;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                while (sc.hasNext()) {
                    String word = sc.next();
                    arr[count] = word;
                    count++;
                }
                EspacoPorto localatual = pesquisaEspacoAtual(Integer.parseInt(arr[2]));
                switch (Integer.parseInt(arr[0])) {
                    case 1:
                    Espaconave espaconave1 = new EspaconaveSubluz(arr[1],localatual,Double.parseDouble(arr[3]),arr[4].toUpperCase());
                    System.out.println("Espaconave: " + espaconave1.getNome() + " registrado");
                    frota.add(espaconave1);
                    System.out.println(espaconave1.toString());
                        break;
                        case 2:
                    Espaconave espaconave2 = new EspaconaveFTL(arr[1],localatual,Double.parseDouble(arr[3]),Double.parseDouble(arr[4]));
                    System.out.println("Espaconave: " + espaconave2.getNome() + " registrado");
                    frota.add(espaconave2);
                    System.out.println(espaconave2.toString());
                        break;
                    default:
                        break;
                }                  
            }

         }catch (NoSuchFileException noferr){
            System.out.println("Nenhum arquivo de Espacoporto com esse nome encontrado!");
        }catch (IOException ioerr) {
            System.err.format("IO Error! Error: %s%n", ioerr);
        } catch (Exception err) {
            System.out.println("An error has occurred! Error: " + err);
        }
    }

    public ArrayList<EspacoPorto> clonePortos() {
        return(ArrayList<EspacoPorto>) espacoPortos.clone();
    }
    public ArrayList<Espaconave> cloneEspaconaves() {
        return(ArrayList<Espaconave>) frota.clone();
    }

    public EspacoPorto pesquisaEspacoAtual(int numero){
        for(EspacoPorto e:espacoPortos){
            if(e.getNumero()== numero)
            return e;
        }
        return null;
              
    }

    

    
}
