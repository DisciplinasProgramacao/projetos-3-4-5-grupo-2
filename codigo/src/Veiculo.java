public abstract class Veiculo {

    //#region - Atributos
    protected String placa;
    protected double valorDeVenda;
    protected double kmRodados;
    protected int qtdRotas;
    //#endregion

    //#region - Construtores
    public Veiculo(String dados) {
        String[] vetDados = dados.split(";");
        this.placa = vetDados[1];
        this.valorDeVenda = Double.parseDouble(vetDados[2]);
        this.kmRodados = Double.parseDouble(vetDados[3]);
    }
    //#endregion

    //#region - Métodos
    protected double calcularIPVA(double ipva) {
        return this.valorDeVenda * ipva;
    };

    protected double calcularSeguro(double seguroTaxa, double seguroFixo) {
        return (this.valorDeVenda * seguroTaxa) + seguroFixo;
    };

    protected abstract double calcularOutrosCustos();

    protected abstract double calcularIPVA();

    protected abstract double calcularSeguro();

    protected double calcularGastosTotais() {
        return calcularIPVA() + calcularSeguro() + calcularOutrosCustos();
    }

    protected void verificarKmRodados() {

    };

    @Override
    public String toString() {
        return String.format("%s;%.2f;%d;", this.placa, this.valorDeVenda, this.kmRodados).toString();
    }

    public String dadosVeiculo(){
        return toString();
    }
    //#endregion
 
}
