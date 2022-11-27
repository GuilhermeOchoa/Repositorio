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
        for(Espaconave e:frota){
            if(e.getNome()== nome)
            return e;
        }
        return null;
    }
}
