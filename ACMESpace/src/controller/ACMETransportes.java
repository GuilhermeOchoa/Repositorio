package controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import model.Transporte;


public class ACMETransportes {
    private Queue<Transporte> filaPendentes;    
    private ArrayList<Transporte> listaTodosTransportes;

    /**
     * Fila de transportes aguardando naves disponíveis
     */
    public ACMETransportes() {
       filaPendentes = new LinkedList <Transporte>();
       listaTodosTransportes = new ArrayList<Transporte>();

    }    
    
    public boolean cadastraTransporte(Transporte transportec) {
        if(pesquisaTransportePendentes(transportec.getIdentificador())== null){
            listaTodosTransportes.add(transportec);
            return filaPendentes.add(transportec);
        }
        return false;
    }
    public Transporte pesquisaTransportePendentes(int identificador){
        for(Transporte e:filaPendentes){
            if(e.getIdentificador() == identificador)
            return e;
        }
        return null;
    }
    
    public ArrayList<Transporte> listaTodosTransportes(){
        return(ArrayList<Transporte>)listaTodosTransportes.clone();
    }
    
}