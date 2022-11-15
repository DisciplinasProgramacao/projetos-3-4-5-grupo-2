public enum TControleKm {

    CARRO(10000, 0, 0),
    UTILITARIO(10000, 0, 1000),
    CAMINHAO(0, 20000, 30000);

    private int kmAlinhamento;
    private int kmManutencao;
    private int kmVistoria;

    private TControleKm(int kmAlinhamento, int kmManutencao, int kmVistoria) {
        this.kmAlinhamento = kmAlinhamento;
        this.kmManutencao = kmManutencao;
        this.kmVistoria = kmVistoria;
    }

    public int getKmAlinhamento() {
        return kmAlinhamento;
    }

    public int getKmManutencao() {
        return kmManutencao;
    }

    public int getKmVistoria() {
        return kmVistoria;
    }
    
}
