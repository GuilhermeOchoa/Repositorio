package util;

import model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arquivos {
    private ArrayList<Espaconave> frota = new ArrayList<Espaconave>();
    private ArrayList<EspacoPorto> espacoPortos = new ArrayList<EspacoPorto>();
    private ArrayList<Transporte> transportes = new ArrayList<Transporte>();

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
        try (BufferedReader br = Files.newBufferedReader(Paths.get(caminho), StandardCharsets.ISO_8859_1)) {
            String linha = null;
            String header = br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] arr = new String[6];
                int count = 0;
                Scanner sc = new Scanner(linha).useDelimiter(";");
                while (sc.hasNext()) {
                    String word = sc.next();
                    arr[count] = word;
                    count++;
                }
                EspacoPorto origem = pesquisaEspacoPorto(Integer.parseInt(arr[2]));
                EspacoPorto destino = pesquisaEspacoPorto(Integer.parseInt(arr[3]));
                
                switch (Integer.parseInt(arr[0])) {
                    case 1:
                        Transporte tranporteP = new TransportePessoa(Integer.parseInt(arr[1]),origem,destino,Estados.PENDENTE,Integer.parseInt(arr[4]));
                        tranporteP.calculaDistancia();
                        tranporteP.calculaCusto();                        
                        transportes.add(tranporteP);
                        
                        break;
                    case 2:
                        Transporte tranporteM = new TransporteMaterial(Integer.parseInt(arr[1]),origem,destino,Estados.PENDENTE,Double.parseDouble(arr[4]),arr[5]);
                        tranporteM.calculaDistancia();
                        tranporteM.calculaCusto();
                        transportes.add(tranporteM);
                        break;
                    default:
                        break;
                }                  
            }
            System.out.println("=============Transportes registrados ==========="+"\n");
            transportes.forEach(l -> System.out.println("Numero: " + l.getIdentificador()
            + " Origem: " + l.getOrigem().getNome() + " Destino: " + l.getDestino().getNome()
            +" Distancia: " +l.getDistancia() +  " Custo: " +  l.getCusto()));

         }catch (NoSuchFileException noferr){
            System.out.println("Nenhum arquivo de TRANSPORTE com esse nome encontrado!");
        }catch (IOException ioerr) {
            System.err.format("IO Error! Error: %s%n", ioerr);
        } catch (Exception err) {
            System.out.println("An error has occurred! Error: " + err);
        }
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
                espacoPortos.add(espacoPorto);
            }
            System.out.println("=============EspaçoPortos registrados==========="+"\n");
            espacoPortos.forEach(l -> System.out.println("Numero: " + l.getNumero()
            + " Nome: " + l.getNome() + " CoordX: " + l.getCoordX()
                    + " CoordY: " + l.getCoordY()+" CoordZ: "+l.getCoordZ()));
        }catch (NoSuchFileException noferr){
            System.out.println("Nenhum arquivo de ESPACOPORTO com esse nome encontrado!");
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
                EspacoPorto localatual = pesquisaEspacoPorto(Integer.parseInt(arr[2]));
                switch (Integer.parseInt(arr[0])) {
                    case 1:
                    Espaconave espaconave1 = new EspaconaveSubluz(arr[1],localatual,Double.parseDouble(arr[3]),arr[4].toUpperCase());
                    frota.add(espaconave1);
                        break;
                        case 2:
                    Espaconave espaconave2 = new EspaconaveFTL(arr[1],localatual,Double.parseDouble(arr[3]),Double.parseDouble(arr[4]));
                    frota.add(espaconave2);
                        break;
                    default:
                        break;
                }                  
            }
            System.out.println("=============EspaçoNaves registradas ==========="+"\n");
            frota.forEach(l -> System.out.println("Numero: " + l.getNome()
            + " PortoAtual: " + l.getLocalAtual().getNome()
                    + " Velocidade Máxima : " + l.getVelocidadeMaxima()));

         }catch (NoSuchFileException noferr){
            System.out.println("Nenhuma arquivo de ESPACONAVE com esse nome encontrado!");
        }catch (IOException ioerr) {
            System.err.format("IO Error! Error: %s%n", ioerr);
        } catch (Exception err) {
            System.out.println("An error has occurred! Error: " + err);
        }
    }

    public void escreveEspacoportos(ArrayList<EspacoPorto> list, String nome) {
        String jsonPath = "src/res/"+nome+"_EspacoPorto.json";
        JSONArray array = new JSONArray();
        try {
            for (int i = 0; list.size() > i; i++) {
                EspacoPorto ePorto = list.get(i);
                JSONObject json = new JSONObject();
                json.put("Numero", ePorto.getNumero());
                json.put("Nome", ePorto.getNome());
                json.put("CoordX", ePorto.getCoordX());
                json.put("CoordY", ePorto.getCoordY());
                json.put("CoordZ", ePorto.getCoordZ());
                array.add(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(jsonPath))) {
            out.write(array.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void escreveEspaconaves(ArrayList<Espaconave> list, String nome)
        {
        String jsonPath = "src/res/"+nome+"_Espaconave.json";
        JSONArray array = new JSONArray();
        try {
            for (int i = 0; list.size() > i; i++) {
                Espaconave eNave = list.get(i);
                if(eNave instanceof EspaconaveFTL){
                    JSONObject json = new JSONObject();
                    json.put("Nome", eNave.getNome());
                    json.put("Espacoporto", eNave.getLocalAtual().getNumero());
                    json.put("Velocidade", eNave.getVelocidadeMaxima());
                    json.put("QuantidadeMaxima", ((EspaconaveFTL) eNave).getQuantidadeMaxima());
                    array.add(json);
                }else if(eNave instanceof EspaconaveSubluz){
                    JSONObject json = new JSONObject();
                    json.put("Nome", eNave.getNome());
                    json.put("Espacoporto", eNave.getLocalAtual().getNumero());
                    json.put("Velocidade", eNave.getVelocidadeMaxima());
                    json.put("Combustivel", ((EspaconaveSubluz) eNave).getCombustivel());
                    array.add(json);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(jsonPath))) {
            out.write(array.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void escreveTranportes(ArrayList<Transporte> list, String nome)
    {
    String jsonPath = "src/res/"+nome+"_Transporte.json";
    JSONArray array = new JSONArray();
    try {
        for (int i = 0; list.size() > i; i++) {
            Transporte eTransporte = list.get(i);
            if(eTransporte instanceof TransporteMaterial){
                JSONObject json = new JSONObject();
                json.put("Identificador", eTransporte.getIdentificador());
                json.put("Origem", eTransporte.getOrigem().getNumero());
                json.put("Destino", eTransporte.getDestino().getNumero());
                json.put("Quantidade", ((TransporteMaterial) eTransporte).getQuantidade());
                json.put("Descricao", ((TransporteMaterial) eTransporte).getDescricao());
                array.add(json);
            }else if(eTransporte instanceof TransportePessoa){
                JSONObject json = new JSONObject();
                json.put("Identificador", eTransporte.getIdentificador());
                json.put("Origem", eTransporte.getOrigem().getNumero());
                json.put("Destino", eTransporte.getDestino().getNumero());
                json.put("QuantidadePessoas", ((TransportePessoa) eTransporte).getQuantidadePessoas());
                array.add(json);
            }
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    try (PrintWriter out = new PrintWriter(new FileWriter(jsonPath))) {
        out.write(array.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public ArrayList<EspacoPorto> leEportoJSON(String nomeArquivo) {
    JSONParser jsonParser = new JSONParser();
    ArrayList<EspacoPorto> ePortos = new ArrayList<EspacoPorto>();

     try (FileReader reader = new FileReader("src/res/"+nomeArquivo+"_EspacoPorto.json")) {
        Object obj = jsonParser.parse(reader);
        JSONArray eportoList = (JSONArray) obj;
        
        eportoList.forEach(f -> { 
            JSONObject deObject = (JSONObject) f;           
          Long  numero= (long) deObject.get("Numero");
           String nome = (String)deObject.get("Nome");
           Double coordx = (Double) deObject.get("CoordX");
           Double coordy = (Double) deObject.get("CoordY");
           Double coordz = (Double) deObject.get("CoordZ");
             
            EspacoPorto espacoPorto = new EspacoPorto(numero.intValue(),nome,coordx,coordy,coordz);
            ePortos.add(espacoPorto);
         });

    } catch (IOException | org.json.simple.parser.ParseException e) {
        e.printStackTrace();
    }
    return ePortos;
}

public ArrayList<Espaconave> leEnaveJSON(ArrayList<EspacoPorto> espacoPorto,String nomeArquivo) {
    JSONParser jsonParser = new JSONParser();
    ArrayList<Espaconave> enave = new ArrayList<Espaconave>();

     try (FileReader reader = new FileReader("src/res/"+nomeArquivo+"_Espaconave.json")) {
        Object obj = jsonParser.parse(reader);
        JSONArray enaveList = (JSONArray) obj;
        
        enaveList.forEach(f -> { 
            JSONObject deObject = (JSONObject) f;           
           String nome = (String)deObject.get("Nome");
           int localatual = (int) deObject.get("EspacoPorto");
           Double velocidade = (Double) deObject.get("Velocidade");
           String combustivel = (String) deObject.get("Combustivel");

           List<EspacoPorto> acharEporto = espacoPorto.stream().filter(
                        l -> l.getNumero() == localatual
                ).collect(Collectors.toList());
             
            Espaconave espaconave = new Espaconave(nome,acharEporto.get(0),velocidade);
            enave.add(espaconave);
         });

    } catch (IOException | org.json.simple.parser.ParseException e) {
        e.printStackTrace();
    }
    return enave;
}

    public ArrayList<EspacoPorto> clonePortos() {
        return(ArrayList<EspacoPorto>) espacoPortos.clone();
    }
    public ArrayList<Espaconave> cloneEspaconaves() {
        return(ArrayList<Espaconave>) frota.clone();
    }
    public ArrayList<Transporte> cloneTransportes() {
        return(ArrayList<Transporte>)transportes.clone();
    }

    public EspacoPorto pesquisaEspacoPorto(int numero){
        for(EspacoPorto e:espacoPortos){
            if(e.getNumero()== numero)
            return e;
        }
        return null;
              
    }

    

    
}
