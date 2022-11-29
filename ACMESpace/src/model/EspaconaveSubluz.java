package model;

public class EspaconaveSubluz extends Espaconave{
    
     private String combustivel;
    
    public EspaconaveSubluz(String nome, EspacoPorto localAtual, double velocidadeMaxima, String combustivel) {
        super(nome, localAtual, velocidadeMaxima);
        this.combustivel = combustivel;
    }
    public EspaconaveSubluz(String nome, String combustivel) {
        super(nome);
        this.combustivel = combustivel;
    }   

    @Override
    public String toString() {
        return "EspaconaveSubluz [combustivel=" + combustivel + "]";
    }
   
    public String getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    
}
