public enum TUtilitario {
    //#region - Atributos
    VAN(60),
    FURGAO(80);

    private double capacidadeMax;
    //#endregion
    
    //#region - Métodos

    private TUtilitario(double capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public double tanque() {
        return capacidadeMax;
    }
    
    //#endregion
}
