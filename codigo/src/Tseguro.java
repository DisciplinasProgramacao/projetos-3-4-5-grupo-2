public enum Tseguro {

    CARRO(0.05, 300),
    VAN(0.03, 120),
    FURGAO(0.03, 120),
    CAMINHAO(0.02, 2000);

    private double seguroTaxa;
    private int seguroFixo;

    Tseguro(double seguroTaxa, int seguroFixo) {
        this.seguroTaxa = seguroTaxa;
        this.seguroFixo = seguroFixo;
    }

    public double getSeguroTaxa() {
        return seguroTaxa;
    }

    public int getSeguroFixo() {
        return seguroFixo;
    }
}
