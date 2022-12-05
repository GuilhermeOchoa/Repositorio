package model;

public class EspaconaveFTL extends Espaconave{
    private double quantidadeMaxima;
   

    public EspaconaveFTL(String nome, EspacoPorto localAtual, double velocidadeMaxima, double quantidadeMaxima) {
        super();
        this.quantidadeMaxima = quantidadeMaxima;
    }

    

    @Override
    public String toString() {
        return "{" +
            " velocidadeMaxima='" + getVelocidadeMaxima() + "'" +
            ", quantidadeMaxima='" + getQuantidadeMaxima() + "'" +
            "}";
    }

    public double getQuantidadeMaxima() {
        return quantidadeMaxima;
    }


    public void setQuantidadeMaxima(double quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }
    


    
}