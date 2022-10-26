import org.junit.platform.commons.util.ToStringBuilder;

public abstract class Veiculo {

    //#region - Atributos
    protected String placa;
    protected double valorDeVenda;
    protected int kmRodados;
    //#endregion

    //#region - Construtores
    public Veiculo(String dados) {
        String[] vetDados = dados.split(";");
        this.placa = vetDados[1];
        this.valorDeVenda = Double.parseDouble(vetDados[3]);
        this.kmRodados = Integer.parseInt(vetDados[4]);
    }
    //#endregion

    //#region - Métodos
    protected double calcularIPVA(double ipva) {
        return this.valorDeVenda * ipva;
    };

    protected double calcularSeguro(double seguroTaxa, double seguroFixo) {
        return (this.valorDeVenda * seguroTaxa) + seguroFixo;
    };

    protected abstract void calcularGastosTotais();

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
