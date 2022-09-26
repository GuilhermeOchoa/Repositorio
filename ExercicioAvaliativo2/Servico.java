package ACMEFinancas;

public class Servico extends Cobravel{
    private TipoServico tipoServico;

    public Servico(int identificador, String nome, double valorBase, TipoServico tipo) {
        super(identificador, nome, valorBase);
        this.tipoServico = tipo;
    }

    @Override
    public double calculaImposto() {
        if(this.tipoServico.getDescricao().equals("pessoal")){
            return valorBase * 0.15;
        }else {
            return valorBase * 0.3;
        }
    }

    @Override
    public String toCsv() {
        return "Serviço;" + this.identificador + ";" + this.nome + ";" + this.valorBase + ";" + this.tipoServico + ";";
    }
}
