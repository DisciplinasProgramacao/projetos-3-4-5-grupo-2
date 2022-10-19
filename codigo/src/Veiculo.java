public abstract class Veiculo {

    //#region - Atributos
    protected String placa;
    protected double valorDeVenda;
    protected int kmRodados;
    protected String chassi;
    protected String anoFabricacao;
    protected String cor;
    //#endregion

    //#region - Construtores
    public Veiculo(String[] vetDados) {
        this.placa = vetDados[1];
        this.chassi = vetDados[2];
        this.valorDeVenda = Double.parseDouble(vetDados[3]);
        this.kmRodados = Integer.parseInt(vetDados[4]);
        this.anoFabricacao = vetDados[5];
        this.cor = vetDados[6];
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
