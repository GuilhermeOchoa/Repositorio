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
    // private ArrayList<Espaconave> frota = new ArrayList<>();
    private ArrayList<EspacoPorto> espacoPortos = new ArrayList<>();
    // private ArrayList<Transporte> transportes = new ArrayList<>();

    public Arquivos() {
    }

    public void carregaArquivo(String nome) {

        String espaconavesArq = "src/dados/" + nome + "-espaconaves.dat";
        String espacoportosArq = "src/dados/" + nome + "-espacoportos.dat";
        String transportesArq = "src/dados/" + nome + "-transportes.dat";
        leEspaconaves(espaconavesArq);
        leEspacoportos(espacoportosArq);
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
            System.out.println("Nenhum arquivo de localizacao com esse nome encontrado!");
        }catch (IOException ioerr) {
            System.err.format("IO Error! Error: %s%n", ioerr);
        } catch (Exception err) {
            System.out.println("An error has occurred! Error: " + err);
        }
    }

    private void leEspaconaves(String caminho) {
        // try (BufferedReader br = Files.newBufferedReader(Paths.get(caminho), StandardCharsets.ISO_8859_1)) {
        //     String linha = null;
        //     String header = br.readLine();
        //     while ((linha = br.readLine()) != null) {
        //         String[] arr = new String[5];
        //         int count = 0;
        //         Scanner sc = new Scanner(linha).useDelimiter(";");
        //         while (sc.hasNext()) {
        //             String word = sc.next();
        //             arr[count] = word;
        //             count++;
        //         }

        //         Espaconave espaconave = new Espaconave(Integer.parseInt(arr[0]),arr[1],Double.parseDouble(arr[2]),Double.parseDouble(arr[3]));
        //         System.out.println("Localizacao de logradouro " + location.getLogradouro() + " registrada");
        //         locationList.add(location);
        //     }

        //     locationList.forEach(l -> System.out.println("Localizacao - Codigo: " + l.getCodigo()
        //             + " | Logradouro: " + l.getLogradouro() + " | Latitude: " + l.getLatitude()
        //             + " | Longitude: " + l.getLongitude()));
        // }catch (NoSuchFileException noferr){
        //     System.out.println("Nenhum arquivo de localizacao com esse nome encontrado!");
        // }catch (IOException ioerr) {
        //     System.err.format("IO Error! Error: %s%n", ioerr);
        // } catch (Exception err) {
        //     System.out.println("An error has occurred! Error: " + err);
        // }
    }

    public ArrayList<EspacoPorto> clonePortos() {
        return(ArrayList<EspacoPorto>) espacoPortos.clone();
    }

   

    

    
}
