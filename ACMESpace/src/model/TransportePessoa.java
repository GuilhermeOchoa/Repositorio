package model;

public class TransportePessoa extends Transporte {
   
    private int quantidadePessoas;
   
   
    public TransportePessoa(int tipo, int identificador, EspacoPorto origem, EspacoPorto destino, Espaconave espaconave,
            double distancia, double custo) {
        super(tipo, identificador, origem, destino, espaconave, distancia, custo);
    }  

    @Override
    public double calculaDistancia() {
       // double distancia = 
        return 0;
    }

    @Override
    public double calculaCusto() {
        // TODO Auto-generated method stub
        return 0;
    }

    
}