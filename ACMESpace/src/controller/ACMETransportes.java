package controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import model.Transporte;


public class ACMETransportes {
    private Queue<Transporte> filaPendentes; 
    private Queue<Transporte> filaDesignados; 
    private ArrayList<Transporte> historicoTransportes; 

    public void setFilaPendentes(Queue<Transporte> filaPendentes) {
        this.filaPendentes = filaPendentes;
    }

    public Transporte retiraUmFila() {
        return filaPendentes.remove();
    }   

    /**
     * Fila de transportes aguardando naves disponíveis
     */
    public ACMETransportes() {
       filaPendentes = new LinkedList <Transporte>();
       filaDesignados = new LinkedList<Transporte>();
       historicoTransportes = new ArrayList<Transporte>();

    }    
    
    public boolean cadastraTransporte(Transporte transportec) {
        if(pesquisaTransportePendentes(transportec.getIdentificador())== null){
            historicoTransportes.add(transportec);
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
    public boolean cadastradaClonados(ArrayList<Transporte> transportes){
        historicoTransportes.addAll(transportes);
        filaPendentes.addAll(transportes);
        return true;
    }
    
    public ArrayList<Transporte> historicoTransporte(){
        return(ArrayList<Transporte>)historicoTransportes.clone();
    }
    public Transporte pesquisaHistoricoTransporte(int identificador){
        for(Transporte e:historicoTransportes){
            if(e.getIdentificador() == identificador)
            return e;
        }
        return null;
    }
    public Queue<Transporte> listaTodosTransportesDesignados(){
        return(Queue<Transporte>)filaDesignados;
        
    }
    public boolean cadastraTransporteDesignado(Transporte transportec) {
        historicoTransportes.add(transportec);
         return filaDesignados.add(transportec);
    }
    public Queue<Transporte> listaTodosTransportesPendetes(){
        return (Queue<Transporte>)filaPendentes;
    }
    
}