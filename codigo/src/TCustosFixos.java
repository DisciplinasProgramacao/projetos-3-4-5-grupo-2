public enum TCustosFixos {
    CARRO(0.04, 0.05, 300, 80, 0, 0),
    CAMINHAO(0.03, 0.02, 2000, 0, 1000, 1000),
    UTILITARIO(0.01, 0.03, 120, 120, 0, 500);

    private double ipva;
    private double seguroTaxa;
    private int seguroFixo;
    private int alinhamento;
    private int manutencao;
    private int vistoria;

    private TCustosFixos(double ipva, double seguroTaxa, int seguroFixo, int alinhamento, int manutencao,
            int vistoria) {
        this.ipva = ipva;
        this.seguroTaxa = seguroTaxa;
        this.seguroFixo = seguroFixo;
        this.alinhamento = alinhamento;
        this.manutencao = manutencao;
        this.vistoria = vistoria;
    }

    public double getIpva() {
        return ipva;
    }

    public double getSeguroTaxa() {
        return seguroTaxa;
    }

    public int getSeguroFixo() {
        return seguroFixo;
    }

    public int getAlinhamento() {
        return alinhamento;
    }

    public int getManutencao() {
        return manutencao;
    }

    public int getVistoria() {
        return vistoria;
    }

    
}
