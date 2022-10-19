public abstract class Veiculo {

    //#region - Atributos
    protected String placa;
    protected double valorDeVenda;
    protected int kmRodados;
    //#endregion

    //#region - Construtores
    public Veiculo(String placa, double valorDeVenda, int kmRodados) {
        this.placa = placa;
        this.valorDeVenda = valorDeVenda;
        this.kmRodados = kmRodados;
    }
    //#endregion

    //#region - Métodos

    protected abstract double calcularIPVA();

    protected abstract double calcularSeguro();

    protected abstract void calcularGastosTotais();

    protected void verificarKmRodados() {

    };

    //#endregion
 
}
