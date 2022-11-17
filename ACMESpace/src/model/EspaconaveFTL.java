package model;

public class EspaconaveFTL extends Espaconave{
    private double velocidadeMaxima;
    private double quantidadeMaxima;
    public EspaconaveFTL(String nome, double velocidadeMaxima, double quantidadeMaxima) {
        super(nome);
        this.velocidadeMaxima = velocidadeMaxima;
        this.quantidadeMaxima = quantidadeMaxima;
    }


    @Override
    public String toString() {
        return "{" +
            " velocidadeMaxima='" + getVelocidadeMaxima() + "'" +
            ", quantidadeMaxima='" + getQuantidadeMaxima() + "'" +
            "}";
    }


    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }


    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }


    public double getQuantidadeMaxima() {
        return quantidadeMaxima;
    }


    public void setQuantidadeMaxima(double quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }
    


    
}