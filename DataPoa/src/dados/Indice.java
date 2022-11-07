package dados;
public class Indice {
    private String nome;
    private int homicidiosDolosos;
    private int totalVitimasHomicidiosDolosos;
    private int latrocinios;
    private int furtos;
    private int abigeatos;
    private int furtoVeiculo;
    private int roubos;
    private int rouboVeiculo;
    private int estelionato;
    private int delitosRelacionadosArmaMunicao;
    private int entorpecentesPosse;
    private int entorpecentesTrafico;
    private int vitimasLatrocinio;
    private int vitimasLesaoMorte;
    private int totalVitimasCvli;

    public Indice(String nome, int homicidiosDolosos, int totalVitimasHomicidiosDolosos, int latrocinios,
            int furtos, int abigeatos, int furtoVeiculo, int roubos, int rouboVeiculo, int estelionato,
            int delitosRelacionadosArmaMunicao, int entorpecentesPosse, int entorpecentesTrafico, int vitimasLatrocinio,
            int vitimasLesaoMorte, int totalVitimasCvli) {
        this.nome = nome;
        this.homicidiosDolosos = homicidiosDolosos;
        this.totalVitimasHomicidiosDolosos = totalVitimasHomicidiosDolosos;
        this.latrocinios = latrocinios;
        this.furtos = furtos;
        this.abigeatos = abigeatos;
        this.furtoVeiculo = furtoVeiculo;
        this.roubos = roubos;
        this.rouboVeiculo = rouboVeiculo;
        this.estelionato = estelionato;
        this.delitosRelacionadosArmaMunicao = delitosRelacionadosArmaMunicao;
        this.entorpecentesPosse = entorpecentesPosse;
        this.entorpecentesTrafico = entorpecentesTrafico;
        this.vitimasLatrocinio = vitimasLatrocinio;
        this.vitimasLesaoMorte = vitimasLesaoMorte;
        this.totalVitimasCvli = totalVitimasCvli;
    }

    public String getNome() {
        return nome;
    }

    
    public int getHomicidiosDolosos() {
        return homicidiosDolosos;
    }

    public int getTotalVitimasHomicidiosDolosos() {
        return totalVitimasHomicidiosDolosos;
    }

    public int getLatrocinios() {
        return latrocinios;
    }

    public int getFurtos() {
        return furtos;
    }

    public int getAbigeatos() {
        return abigeatos;
    }

    public int getFurtoVeiculo() {
        return furtoVeiculo;
    }

    public int getRoubos() {
        return roubos;
    }

    public int getRouboVeiculo() {
        return rouboVeiculo;
    }

    public int getEstelionato() {
        return estelionato;
    }

    public int getDelitosRelacionadosArmaMunicao() {
        return delitosRelacionadosArmaMunicao;
    }

    public int getEntorpecentesPosse() {
        return entorpecentesPosse;
    }

    public int getEntorpecentesTrafico() {
        return entorpecentesTrafico;
    }

    public int getVitimasLatrocinio() {
        return vitimasLatrocinio;
    }

     public int getVitimasLesaoMorte() {
        return vitimasLesaoMorte;
    }

    public int getTotalVitimasCvli() {
        return totalVitimasCvli;
    }

    public String geraCsv() {
        String descricao = "";
        descricao += nome;
        descricao += ";"+ homicidiosDolosos;
        descricao += ";"+ totalVitimasHomicidiosDolosos;
        descricao += ";"+ latrocinios;
        descricao += ";"+ furtos;
        descricao += ";"+ abigeatos;
        descricao += ";"+ furtoVeiculo;
        descricao += ";"+ roubos;
        descricao += ";"+ rouboVeiculo;
        descricao += ";"+ estelionato;
        descricao += ";"+ delitosRelacionadosArmaMunicao;
        descricao += ";"+ entorpecentesPosse;
        descricao += ";"+ entorpecentesTrafico;
        descricao += ";"+ vitimasLatrocinio;
        descricao += ";"+ vitimasLesaoMorte;
        descricao += ";"+ totalVitimasCvli+"\n";
        return descricao;
    }
    @Override
    public String toString(){
        return nome+";"+homicidiosDolosos+";"+totalVitimasHomicidiosDolosos+";"+latrocinios+";"+
        furtos +";"+ abigeatos+";"+furtoVeiculo+";"+roubos+";"+rouboVeiculo+";"+estelionato+";"+
        delitosRelacionadosArmaMunicao+";"+entorpecentesPosse+";"+entorpecentesTrafico+";"+
        vitimasLatrocinio+";"+vitimasLesaoMorte+";"+totalVitimasCvli;
    }
    public String geraResumo() {
        String descricao = "";
        descricao +="Cidade: " +nome +"\n";
        descricao += "Qtd homicidios dolosos: "+ homicidiosDolosos +"\n";
        descricao += "Qtd total de vitimas de homicidios dolosos: "+ totalVitimasHomicidiosDolosos +"\n";
        descricao += "Qtd latrocinio: "+ latrocinios +"\n";
        descricao += "Qtd furtos: "+ furtos +"\n";
        descricao += "Qtd abigeatos: "+ abigeatos +"\n";
        descricao += "Qtd furto de veiculos: "+ furtoVeiculo +"\n";
        descricao += "Qtd roubos: "+ roubos +"\n";
        descricao += "Qtd de roubo de veiculos: "+ rouboVeiculo +"\n";
        descricao += "Qtd Estelionato: "+ estelionato +"\n";
        descricao += "Qtd delitos relacionados a armas e munição: "+ delitosRelacionadosArmaMunicao +"\n";
        descricao += "Qtd Posse de entorpecentes: "+ entorpecentesPosse +"\n";
        descricao += "Qtd Tráfico de entorpecentes: "+ entorpecentesTrafico +"\n";
        descricao += "Qtd vitimas de latrocinio: "+ vitimasLatrocinio +"\n";
        descricao += "Qtd Vitimas de morte por lesão: "+ vitimasLesaoMorte +"\n";
        descricao += "Qtd total de vitimas CVLI: "+ totalVitimasCvli+"\n";
        return descricao;
    }

}
