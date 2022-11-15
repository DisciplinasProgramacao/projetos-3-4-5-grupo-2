public enum TOutrosCustos {

    CARRO(80, 0, 0),
    UTILITARIO(120, 0, 500),
    CAMINHAO(0, 1000, 1000);

    private int alinhamento;
    private int manutencao;
    private int vistoria;
    
    private TOutrosCustos(int alinhamento, int manutencao, int vistoria) {
        this.alinhamento = alinhamento;
        this.manutencao = manutencao;
        this.vistoria = vistoria;
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
