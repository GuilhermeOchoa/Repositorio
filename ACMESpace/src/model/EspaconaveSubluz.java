package model;

public class EspaconaveSubluz extends Espaconave{
    
     private Combustiveis combustivel;
    
    public EspaconaveSubluz(String nome, EspacoPorto localAtual, double velocidadeMaxima, Combustiveis combustivel) {
        super(nome, localAtual, velocidadeMaxima);
        this.combustivel = combustivel;
    }
    public EspaconaveSubluz(String nome, Combustiveis combustivel) {
        super(nome);
        this.combustivel = combustivel;
    }   

    @Override
    public String toString() {
        return "EspaconaveSubluz [combustivel=" + combustivel + "]";
    }
   
    public Combustiveis getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(Combustiveis combustivel) {
        this.combustivel = combustivel;
    }

    
}
