import java.util.LinkedList;

public abstract class Veiculo {
    //#region - Atributos
    protected String placa;
    protected Tanque tanque;
    protected int qtdRotas;
    protected LinkedList<Rota> rotas;
    protected double valorDeVenda;
    protected double kmRodados;
    //#endregion

    //#region - Construtores
    /**
     * Construtor veículos
     * @param dados String de dados proveniente do arquivo Veiculos.txt
     */
    public Veiculo(String dados) {
        String[] vetDados = dados.split(";");
        this.placa = vetDados[1];
        this.valorDeVenda = Double.parseDouble(vetDados[2]);
        this.kmRodados = Double.parseDouble(vetDados[3]);
    }
    //#endregion

    //#region - Métodos
    /**
     * Calcular IPVA do veículo 
     * @param ipva Porcentagem real do IPVA de acordo com o tipo de veículo.
     * @return A multiplicação da porcentagem pelo valor de venda
     */
    protected double calcularIPVA(double ipva) {
        return this.valorDeVenda * ipva;
    };

    /**
     * Calcular seguro do veículo
     * @param seguroTaxa Porcentagem real do seguro de acordo com o tipo de veículo.
     * @param seguroFixo Ao valor a ser adicionado ao valor total do seguro.
     * @return A multiplicação da porcentagem pelo valor de venda + segurofixo.
     */
    protected double calcularSeguro(double seguroTaxa, double seguroFixo) {
        return (this.valorDeVenda * seguroTaxa) + seguroFixo;
    };

    protected abstract double calcularOutrosCustos();

    protected abstract double calcularIPVA();

    protected abstract double calcularSeguro();

    /**
     * Calcular gastos totais 
     * @return A soma do cálculo do IPVA com seguro com outros custos.
     */
    protected double calcularGastosTotais() {
        return calcularIPVA() + calcularSeguro() + calcularOutrosCustos();
    }

    protected void verificarKmRodados() {

    };

    
    @Override
    public String toString() {
        return String.format("%s;%.2f;%d;", this.placa, this.valorDeVenda, this.kmRodados).toString();
    }

    /**
     * Método para retornar o método toString() da classe veículo
     * @return Método toString()
     */
    public String dadosVeiculo(){
        return toString();
    }
    //#endregion
 
}
