public enum Tseguro {

    CARRO(0.05, 300),
    UTILITARIO(0.03, 120),
    CAMINHAO(0.02, 2000);

    private double seguroTaxa;
    private int seguroFixo;

    Tseguro(double seguroTaxa, int seguroFixo) {
        this.seguroTaxa = seguroTaxa;
        this.seguroFixo = seguroFixo;
    }
}
