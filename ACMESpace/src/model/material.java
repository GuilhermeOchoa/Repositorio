package model;

public class material extends Transporte {
    private double carga;
    private String descricao;
    
    public material(int identificador, EspacoPorto origem, EspacoPorto destino, double carga, String descricao) {
        super(identificador, origem, destino);
        this.carga = carga;
        this.descricao = descricao;
    }
    
}