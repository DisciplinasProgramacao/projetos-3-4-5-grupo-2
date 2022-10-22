import org.junit.platform.commons.util.ToStringBuilder;

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
    public Veiculo(String dados) {
        String[] vetDados = dados.split(";");
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

    @Override
    public String toString() {
        return String.format("%s;%s;%.2f;%d;%s;%s", this.placa, this.chassi, this.valorDeVenda, this.kmRodados, this.anoFabricacao, this.cor).toString();
    }

    public String dadosVeiculo(){
        return toString();
    }
    //#endregion
 
}
