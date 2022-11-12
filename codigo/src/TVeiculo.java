public enum TVeiculo {
    CARRO(Tipva.CARRO, Tseguro.CARRO, TOutrosCustos.CARRO),
    CAMINHAO(Tipva.CAMINHAO, Tseguro.CAMINHAO, TOutrosCustos.CAMINHAO),
    UTILITARIO(Tipva.UTILITARIO, Tseguro.UTILITARIO, TOutrosCustos.UTILITARIO);

    private Tipva ipva;
    private Tseguro seguro;
    private TOutrosCustos outrosCustos;

    TVeiculo(Tipva ipva, Tseguro seguro, TOutrosCustos outrosCustos) {
        this.ipva = ipva;
        this.seguro = seguro;
        this.outrosCustos = outrosCustos;
    }

    public Tipva getIPVA() {
        return this.ipva;
    }

    public Tseguro getSeguro() {
        return this.seguro;
    }

    public TOutrosCustos getOutrosCustos() {
        return this.outrosCustos;
    }
}
