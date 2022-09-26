package ACMEFinancas;

public enum TipoServico {
    PESSOAL("pessoal"),
    EMPRESARIAL("empresarial");

    private String descricao;

    TipoServico(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
