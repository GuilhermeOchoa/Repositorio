package model;

public class TransportePessoa extends Transporte {
   
    private int quantidadePessoas;
    private double distancia;
    private double custo;
   
   
    public TransportePessoa(int identificador, EspacoPorto origem, EspacoPorto destino, int tipo,
            int quantidadePessoas, Estados estado) {
        super(identificador, origem, destino, tipo,estado);
        this.quantidadePessoas = quantidadePessoas;
    }

    public TransportePessoa(int tipo, int identificador, EspacoPorto origem, EspacoPorto destino, Espaconave espaconave,
            double distancia, double custo) {
        super(tipo, identificador, origem, destino, espaconave, distancia, custo);
    }  

    @Override
    public double calculaDistancia() {
       super.setDistancia(distancia);
        return 0;
    }

    @Override
    public double calculaCusto() {
        super.setCusto(custo);
        return 0;
    }


   
    
}