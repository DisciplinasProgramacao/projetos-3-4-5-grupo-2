public enum TUtilitario {
    VAN(60),
    FURGAO(80);

    private double capacidadeMax;

    private TUtilitario(double capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public double tanque() {
        return capacidadeMax;
    }
    
    
}
