package model;

public class EspaconaveSubluz extends Espaconave{
    
    private double velocidadeMaxima;
    private String combustivel;

    public enum combustivel{
        Nuclear, Ion;
    }
    public EspaconaveSubluz(String nome, double velocidadeMaxima, String combustivel) {
        super(nome);
        this.velocidadeMaxima = velocidadeMaxima;
        this.combustivel = combustivel;
    }
    @Override
    public String toString() {
        return "EspaconaveSubluz [velocidadeMaxima=" + velocidadeMaxima + ", combustivel=" + combustivel + "]";
    }
    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }
    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }
    public String getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    
}
