public class Indices {
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

    public Indices(String nome, int homicidiosDolosos, int totalVitimasHomicidiosDolosos, int latrocinios,
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHomicidiosDolosos() {
        return homicidiosDolosos;
    }

    public void setHomicidiosDolosos(int homicidiosDolosos) {
        this.homicidiosDolosos = homicidiosDolosos;
    }

    public int getTotalVitimasHomicidiosDolosos() {
        return totalVitimasHomicidiosDolosos;
    }

    public void setTotalVitimasHomicidiosDolosos(int totalVitimasHomicidiosDolosos) {
        this.totalVitimasHomicidiosDolosos = totalVitimasHomicidiosDolosos;
    }

    public int getLatrocinios() {
        return latrocinios;
    }

    public void setLatrocinios(int latrocinios) {
        this.latrocinios = latrocinios;
    }

    public int getFurtos() {
        return furtos;
    }

    public void setFurtos(int furtos) {
        this.furtos = furtos;
    }

    public int getAbigeatos() {
        return abigeatos;
    }

    public void setAbigeatos(int abigeatos) {
        this.abigeatos = abigeatos;
    }

    public int getFurtoVeiculo() {
        return furtoVeiculo;
    }

    public void setFurtoVeiculo(int furtoVeiculo) {
        this.furtoVeiculo = furtoVeiculo;
    }

    public int getRoubos() {
        return roubos;
    }

    public void setRoubos(int roubos) {
        this.roubos = roubos;
    }

    public int getRouboVeiculo() {
        return rouboVeiculo;
    }

    public void setRouboVeiculo(int rouboVeiculo) {
        this.rouboVeiculo = rouboVeiculo;
    }

    public int getEstelionato() {
        return estelionato;
    }

    public void setEstelionato(int estelionato) {
        this.estelionato = estelionato;
    }

    public int getDelitosRelacionadosArmaMunicao() {
        return delitosRelacionadosArmaMunicao;
    }

    public void setDelitosRelacionadosArmaMunicao(int delitosRelacionadosArmaMunicao) {
        this.delitosRelacionadosArmaMunicao = delitosRelacionadosArmaMunicao;
    }

    public int getEntorpecentesPosse() {
        return entorpecentesPosse;
    }

    public void setEntorpecentesPosse(int entorpecentesPosse) {
        this.entorpecentesPosse = entorpecentesPosse;
    }

    public int getEntorpecentesTrafico() {
        return entorpecentesTrafico;
    }

    public void setEntorpecentesTrafico(int entorpecentesTrafico) {
        this.entorpecentesTrafico = entorpecentesTrafico;
    }

    public int getVitimasLatrocinio() {
        return vitimasLatrocinio;
    }

    public void setVitimasLatrocinio(int vitimasLatrocinio) {
        this.vitimasLatrocinio = vitimasLatrocinio;
    }

    public int getVitimasLesaoMorte() {
        return vitimasLesaoMorte;
    }

    public void setVitimasLesaoMorte(int vitimasLesaoMorte) {
        this.vitimasLesaoMorte = vitimasLesaoMorte;
    }

    public int getTotalVitimasCvli() {
        return totalVitimasCvli;
    }

    public void setTotalVitimasCvli(int totalVitimasCvli) {
        this.totalVitimasCvli = totalVitimasCvli;
    }
    public String geraCsv() {
        String descricao = "2";
        descricao += ";"+ nome;
        descricao += ";" + totalVitimasHomicidiosDolosos;
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
        descricao += ";"+ totalVitimasCvli +"\n";
        return descricao;

}
