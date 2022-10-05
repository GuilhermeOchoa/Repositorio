package dados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.ArrayList;

public class Partido {
    private ArrayList<Candidato> candidatos;

    public Partido() {
        candidatos = new ArrayList<Candidato>();
    }
    // create

    /**
     * @param c
     * @return true se adicionou
     */
    public boolean adicionaCanditato(Candidato c){
        if(consultCandidatoPorNumero(c.getNumero())== null){
            candidatos.add(c);
        return true;

        }
        return false;
    }
// Retrieve

/**
 * @param numero
 * @return candidato com o numero indicado; null se não achou
 */
public Candidato consultCandidatoPorNumero(int numero){
    for(Candidato c : candidatos){
        if(c.getNumero()==numero)
        return c;
        }
    return null;


}
/**
 * @return
 */
public ArrayList<Candidato> consultaTodosCandidatos(){
    return (ArrayList<Candidato>)candidatos.clone();
}

public boolean gravaArquivo(String nomeArquivo){
    String linha = "";    
	try{
        FileWriter fw = new FileWriter(nomeArquivo);
        BufferedWriter bw = new BufferedWriter(fw);        
        for(Candidato c : candidatos){
            linha = c.getNumero()+";"+c.getNome()+ "\n";
            bw.write(linha);
	    }
    
        bw.close();
    }
		catch (IOException e) {
			System.err.println("Erro de E/S: %s%n :"+ e);
            return false;
		}
    
    return true;
}

public boolean leArquivo(String nomeArquivo){
    String linha = "";    
	try{
        FileReader fw = new FileReader(nomeArquivo);
        BufferedReader bw = new BufferedReader(fw);        
        
        while(){
            
        }
    
        bw.close();
    }
		catch (IOException e) {
			System.err.println("Erro de E/S: %s%n :"+ e);
            return false;
		}
    
    return true;
}

    }
