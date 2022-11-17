package controller;

import java.util.ArrayList;

import model.EspacoPorto;

public class ACMECatalogo {
    ArrayList<EspacoPorto> catalogo;

    public ACMECatalogo() {
        catalogo = new ArrayList<EspacoPorto>();

    }
    public boolean cadastraEspacoPorto(EspacoPorto espacoPorto) {
        if(pesquisaEspacoPorto(espacoPorto.getNumero())== null){
            return catalogo.add(espacoPorto);
        }
        return false;
    }
    public EspacoPorto pesquisaEspacoPorto(int numero){
        for(EspacoPorto e:catalogo){
            if(e.getNumero()== numero)
            return e;
        }sadfsdaf
        return null;
    }
    
    
    
}