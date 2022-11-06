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
        String descricao = nome;
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

}
