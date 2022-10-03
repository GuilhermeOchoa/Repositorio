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
        switch (combustivel) {
            case "Petróleo":
            super.setPrecoMWh(super.getCustoMWh()*1.30);
                break;
            case "Carvão":
             super.setPrecoMWh(super.getCustoMWh()*1.20);
                break;
            case "Nuclear":
            super.setPrecoMWh(super.getCustoMWh()*1.10);
                break;

        }
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
            descricao += "Preço do Mwh: "+ super.getPrecoMWh() + "\n";
            return descricao;
          
    }
    @Override
    public String geraCsv() {
        String descricao = "2";
        descricao += ";"+ super.getNome();
        descricao += ";" + super.getProducaoMWh();
        descricao += ";"+ super.getCustoMWh();
        descricao += ";"+ combustivel;
        descricao += ";"+ durabilidade;
        descricao += ";"+ super.getPrecoMWh() +"\n";
        return descricao;
      
}


}
