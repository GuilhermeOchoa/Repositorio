package controller;
import java.util.ArrayList;

import model.Espaconave;

public class ACMEFrota {
   private ArrayList<Espaconave> frota;

    public ACMEFrota() {
        frota = new ArrayList<Espaconave>();
    }
    public boolean cadastraEspaconave(Espaconave espaconave) {
        if(pesquisaEspaconave(espaconave.getNome())== null){
            return frota.add(espaconave);
        }
        return false;
    }
    public Espaconave pesquisaEspaconave(String nome){
        for(Espaconave s:frota){
            if(s.getNome().equals(nome)){
                return s;
            }
                
        }
        return null;
    }
    public boolean cadastradaClonados(ArrayList<Espaconave> espaconaves){
        frota.addAll(espaconaves);
        return true;
    }
    public ArrayList<Espaconave> retornaEspaconaves(){
        return frota;
    }
}
