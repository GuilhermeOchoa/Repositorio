package model;

public class TransportePessoa extends Transporte {
    private int quantidadePessoas;
    
        

    public TransportePessoa(int identificador, EspacoPorto origem, EspacoPorto destino, Estados estado,
            int quantidadePessoas) {
        super(identificador, origem, destino, estado);
        this.quantidadePessoas = quantidadePessoas;
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
        double custo = super.getDistancia()* quantidadePessoas * 100;
        super.setCusto(custo);
        return custo;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }
}