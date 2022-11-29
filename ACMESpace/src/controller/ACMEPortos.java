package controller;

import java.util.ArrayList;

import model.EspacoPorto;

public class ACMEPortos {
    private ArrayList<EspacoPorto> porto;

    public ACMEPortos() {
        porto = new ArrayList<EspacoPorto>();
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
    public boolean cadastradaClonados(ArrayList<EspacoPorto> espacoPortos){
        porto.addAll(espacoPortos);
        return true;
    }
    public ArrayList<EspacoPorto> consultaPortos(){
        return (ArrayList<EspacoPorto>)porto.clone();
    }

}
