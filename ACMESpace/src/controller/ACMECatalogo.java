package controller;

import java.util.ArrayList;
import java.util.Queue;

import model.EspacoPorto;
import model.Espaconave;
import model.Transporte;

public class ACMECatalogo {
    ArrayList<EspacoPorto> porto;
    ArrayList<Espaconave> frota;
    Queue<Transporte> transportes;
    
    

    public ACMECatalogo() {
        porto = new ArrayList<EspacoPorto>();
        frota = new ArrayList<Espaconave>();
        transportes = new Queue<Transporte>();

    }
    public boolean cadastraEspacoPorto(EspacoPorto espacoPorto) {
        if(pesquisaEspacoPorto(espacoPorto.getNumero())== null){
            return porto.add(espacoPorto);
        }
        return false;
    }
    public EspacoPorto pesquisaEspacoPorto(int numero){
        for(EspacoPorto e:porto){
            if(e.getNumero()== numero)
            return e;
        }
        return null;
    }
    public boolean cadastraEspaconave(Espaconave espaconave) {
        if(pesquisaEspaconave(espaconave.getNome())== null){
            return frota.add(espaconave);
        }
        return false;
    }
    public Espaconave pesquisaEspaconave(String nome){
        for(Espaconave e:frota){
            if(e.getNome()== nome)
            return e;
        }
        return null;
    }
    
    public boolean cadastraTransporte(Transporte transporte) {
        if(pesquisaEspaconave(transporte.getNome())== null){
            return frota.add(espaconave);
        }
        return false;
    }
    public Transporte pesquisaTransporte(int identificador){
        for(Transporte e:transportes){
            if(e.get == nome)
            return e;
        }
        return null;
    }
    
}