public enum Tipva {

    CARRO(0.04),
    VAN(0.01),
    FURGAO(0.01),
    CAMINHAO(0.03);

    private double valorIPVA;

    Tipva(double valor) {
        this.valorIPVA = valor;
    }

    public double getTaxaIPVA() {
        return this.valorIPVA;
    }
}
