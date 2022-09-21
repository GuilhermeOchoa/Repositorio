public class UsinaNaoRenovavel extends Usina {
    private String combustivel;
    private int durabilidade;
    

    public UsinaNaoRenovavel(String nome, double producaoMWh, double custoMWh, String combustivel, int durabilidade) {
        super(nome, producaoMWh, custoMWh);
        this.combustivel = combustivel;
        this.durabilidade = durabilidade;
    }
   @Override
    public double calculaPrecoMWh() {
        // switch (combustivel) {
        //     case "PETRÓLEO":
        //     super.setCustoMWh(super.getCustoMWh()*1.25);
        //         break;
        //     case "CARVÃO":
        //         break;
        //     case "NUCLEAR":
        //         break;

        // }
         return 0;
    }

    @Override
    public String geraResumo() {
            String descricao = "";
            descricao += "Nome: "+ super.getNome() + "\n";
            descricao += "Produção de MWh: " + super.getProducaoMWh() + "\n";
            descricao += "Custo do MWh: "+ super.getCustoMWh() + "\n";
            descricao += "Combustivel: "+ combustivel + "\n";
            descricao += "Durabilidade: "+ durabilidade + "\n";
            return descricao;
          
    }
}