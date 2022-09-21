public class UsinaRenovavel extends Usina{
    private String fonte;
    
    public UsinaRenovavel(String nome, double producaoMWh, double custoMWh,String fonte) {
        super(nome, producaoMWh, custoMWh);
        this.fonte = fonte;
    }
    @Override
    public double calculaPrecoMWh() {
        // String fonte =  getFonte();
        // switch (fonte) {
        //     case "SOLAR":
            
        //         break;
        //     case "EÓLICA":
        //         break;
        //     case "HÍDRICA":
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
            descricao += "Combustivel: "+ fonte + "\n";
            return descricao;
    }

    public String getFonte() {
        return fonte;
    }
    public void setFonte(String fonte) {
        this.fonte = fonte;
    }
   
}
