public abstract class Veiculo {

    protected int placa;
    protected int tanque;
    protected double ipva;
    protected double seguro;

    public Veiculo(int placa, int tanque, double ipva, double seguro) {
        this.placa = placa;
        this.tanque = tanque;
        this.ipva = ipva;
        this.seguro = seguro;
    }

    protected abstract void calcularIPVA();

    protected abstract void calcularSeguro();

    protected abstract void calcularGastosTotais();
     
}
