package ACMEFinancas;

public enum TipoVeiculo {
    POPULAR("popular"),
    BASICO("básico"),
    ESPORTIVO("esportivo");

    private String descricao;

    TipoVeiculo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
