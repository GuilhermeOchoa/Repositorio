public class UsinaRenovavel extends Usina{
    private String fonte;
    
    public UsinaRenovavel(String nome, double producaoMWh, double custoMWh,String fonte) {
        super(nome, producaoMWh, custoMWh);
        this.fonte = fonte;
    }
    @Override
    public double calculaPrecoMWh() {
        switch (fonte) {
            case "Solar":
            super.setCustoMWh(super.getCustoMWh()*1.25);
                break;
            case "Eólica":
            super.setCustoMWh(super.getCustoMWh()*1.15);
                break;
            case "Hídrica":
            super.setCustoMWh(super.getCustoMWh()*1.5);
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
            descricao += "Combustivel: "+ fonte + "\n";
            descricao += "Preço do Mwh: "+ super.getPrecoMWh() + "\n";
            return descricao;
    }

    public String getFonte() {
        return fonte;
    }
    public void setFonte(String fonte) {
        this.fonte = fonte;
    }
   
}
