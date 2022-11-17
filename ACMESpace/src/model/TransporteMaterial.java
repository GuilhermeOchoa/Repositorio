package model;

public class TransporteMaterial extends Transporte {
    private double quantidade;
    private String descricao;
    
    public TransporteMaterial(int identificador, EspacoPorto origem, EspacoPorto destino, int tipo, double quantidade,
    String descricao) {
            super(identificador, origem, destino, tipo);
            this.quantidade = quantidade;
            this.descricao = descricao;
    }
    

    @Override
    public double calculaDistancia() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double calculaCusto() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}