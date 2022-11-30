package model;

public class TransporteMaterial extends Transporte {
    private double quantidade;
    private String descricao;
    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    
    
    

    public TransporteMaterial(int identificador, EspacoPorto origem, EspacoPorto destino, Estados estado,
            double quantidade, String descricao) {
        super(identificador, origem, destino, estado);
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    @Override
    public double calculaDistancia() {
        double distancia = Math.sqrt(Math.pow((super.getDestino().getCoordX()-super.getOrigem().getCoordX()),2)
        + Math.pow((super.getDestino().getCoordY()-super.getOrigem().getCoordY()), 2)+
        +Math.pow((super.getDestino().getCoordZ()-super.getOrigem().getCoordZ()), 2));
        
        if(distancia<0.5){
            distancia=distancia*1000000;
        }else{
            distancia=distancia*100;}
            
        super.setDistancia(distancia);

        return distancia;
    }

    @Override
    public double calculaCusto() {
        double custo = super.getDistancia()* quantidade * 500;
        super.setCusto(custo);
        return custo;
    }
   
}