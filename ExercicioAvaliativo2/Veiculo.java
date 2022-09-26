package ACMEFinancas;

public class Veiculo extends Cobravel{
    private TipoVeiculo tipoVeiculo;

    public Veiculo(int identificador, String nome, double valorBase, TipoVeiculo tipo) {
        super(identificador, nome, valorBase);
        this.tipoVeiculo = tipo;
    }

    @Override
    public double calculaImposto() {
        if(this.tipoVeiculo.getDescricao().equals("popular")){
            return valorBase * 0.05;
        }else if(this.tipoVeiculo.getDescricao().equals("básico")){
            return valorBase * 0.2;
        }else{
            return valorBase * 0.5;
        }
    }

    @Override
    public String toCsv() {
        return "Veiculo;" + this.identificador + ";" + this.nome + ";" + this.valorBase + ";" + this.tipoVeiculo + ";";
    }
}
