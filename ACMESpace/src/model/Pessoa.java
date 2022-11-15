package model;

public class Pessoa extends Transporte {

    private int quantidadePessoas;

    public Pessoa(int identificador, EspacoPorto origem, EspacoPorto destino, int quantidadePessoas) {
        super(identificador, origem, destino);
        this.quantidadePessoas = quantidadePessoas;
    }

    
}