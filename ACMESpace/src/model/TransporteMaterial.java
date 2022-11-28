package model;

public class TransporteMaterial extends Transporte {
    private double quantidade;
    private String descricao;
    private double distancia;
    private double custo;
    
    public TransporteMaterial(int identificador, EspacoPorto origem, EspacoPorto destino, int tipo, double quantidade,
    String descricao, Estados estado) {
            super(identificador, origem, destino, tipo,estado);
            this.quantidade = quantidade;
            this.descricao = descricao;
    }
    

    @Override
    public double calculaDistancia() {

        super.setDistancia(distancia);
        return distancia;
    }

    @Override
    public double calculaCusto() {
        super.setCusto(custo);
        return custo;
    }
    
}