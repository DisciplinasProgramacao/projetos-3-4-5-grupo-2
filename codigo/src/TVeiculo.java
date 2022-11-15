public enum TVeiculo {
    CARRO(Tipva.CARRO, Tseguro.CARRO, TOutrosCustos.CARRO, TControleKm.CARRO),
    CAMINHAO(Tipva.CAMINHAO, Tseguro.CAMINHAO, TOutrosCustos.CAMINHAO, TControleKm.CAMINHAO),
    UTILITARIO(Tipva.UTILITARIO, Tseguro.UTILITARIO, TOutrosCustos.UTILITARIO, TControleKm.UTILITARIO);

    private Tipva ipva;
    private Tseguro seguro;
    private TOutrosCustos outrosCustos;
    private TControleKm controleKm;

    TVeiculo(Tipva ipva, Tseguro seguro, TOutrosCustos outrosCustos, TControleKm controleKm) {
        this.ipva = ipva;
        this.seguro = seguro;
        this.outrosCustos = outrosCustos;
        this.controleKm = controleKm;
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

    public TControleKm getControleKm() {
        return controleKm;
    }

}
