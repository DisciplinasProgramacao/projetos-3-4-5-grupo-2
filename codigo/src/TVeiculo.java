public enum TVeiculo {
    CARRO(Tipva.CARRO, Tseguro.CARRO, TOutrosCustos.CARRO, TControleKm.CARRO, 50),
    CAMINHAO(Tipva.CAMINHAO, Tseguro.CAMINHAO, TOutrosCustos.CAMINHAO, TControleKm.CAMINHAO, 250),
    VAN(Tipva.VAN, Tseguro.VAN, TOutrosCustos.VAN, TControleKm.VAN, 60),
    FURGAO(Tipva.FURGAO, Tseguro.FURGAO, TOutrosCustos.FURGAO, TControleKm.FURGAO, 80);

    private Tipva ipva;
    private Tseguro seguro;
    private TOutrosCustos outrosCustos;
    private TControleKm controleKm;
    private double tanque;

    TVeiculo(Tipva ipva, Tseguro seguro, TOutrosCustos outrosCustos, TControleKm controleKm, double tanque) {
        this.ipva = ipva;
        this.seguro = seguro;
        this.outrosCustos = outrosCustos;
        this.controleKm = controleKm;
        this.tanque = tanque;
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

    public double getTanque() {
        return tanque;
    }

    

}
