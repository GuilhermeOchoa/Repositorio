package controller;

import java.util.ArrayList;
import java.util.Queue;
import model.Transporte;

public class ACMETransportes {
    private Queue<Transporte> transportes;    

    public ACMETransportes() {
       transportes = new Queue<Transporte>();

    }    
    
    public boolean cadastraTransporte(Transporte transporte) {
        if(pesquisaTransporte(transporte.getIdentificador())== null){
            return transportes.add(transporte);
        }
        return false;
    }
    public Transporte pesquisaTransporte(int identificador){
        for(Transporte e:transportes){
            if(e.getIdentificador() == identificador)
            return e;
        }
        return null;
    }
    
}