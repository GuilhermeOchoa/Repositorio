package model;

public class EspaconaveSubluz extends Espaconave{
    
    private Combustivel combustivel;
    
    public EspaconaveSubluz(String nome, EspacoPorto localAtual, double velocidadeMaxima, Combustivel combustivel) {
        super(nome, localAtual, velocidadeMaxima);
        this.combustivel = combustivel;
    }
    public EspaconaveSubluz(String nome, Combustivel combustivel) {
        super(nome);
        this.combustivel = combustivel;
    }
    
    public enum Combustivel{
        NUCLEAR, ION;
    }

    

    @Override
    public String toString() {
        return "EspaconaveSubluz [combustivel=" + combustivel + "]";
    }
   
    public Combustivel getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }

    
}
