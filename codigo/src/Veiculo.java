import java.util.Date;
import java.util.LinkedList;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.ElasticCharAppender;

public abstract class Veiculo implements Comparable<Veiculo> {
    
    // #region - Atributos
    private String placa;
    private Tanque tanque;
    private LinkedList<Rota> rotas = new LinkedList<Rota>();
    private LinkedList<CustoVariavel> custosVariaveis = new LinkedList<CustoVariavel>();
    private double valorDeVenda;
    private double kmRodados;
    private TVeiculo tpVeiculo;
    private double custosGerados;
    // #endregion

    // #region - Construtores
    /**
     * Construtor veículos
     * 
     * @param dados String de dados proveniente do arquivo Veiculos.txt
     */
    public Veiculo(String dados) {
        String[] vetDados = dados.split(";");
        defineTipoVeiculo(vetDados[0]);

        this.placa = vetDados[1];
        this.valorDeVenda = Double.parseDouble(vetDados[2]);
        this.kmRodados = Double.parseDouble(vetDados[3]);
        this.custosGerados = 0;
    }

    private void defineTipoVeiculo(String tipo) {
        if (tipo.equals("Carro")) {
            tpVeiculo = TVeiculo.CARRO;
        } else if (tipo.equals("Caminhao")) {
            tpVeiculo = TVeiculo.CAMINHAO;
        } else if (tipo.equals("Van")) {
            tpVeiculo = TVeiculo.VAN;
        } else if (tipo.equals("Furgao")) {
            tpVeiculo = TVeiculo.FURGAO;
        }
    }
    // #endregion

    // #region métodos

    
    public double retornaCustosTotais(double valor, String descricao) {
        CustoFixo custoFixo = new CustoFixo(tpVeiculo);
     
        this.custosGerados = (custoFixo.retornaCustoFixo(this.valorDeVenda, this.kmRodados)
                + this.somaCustosVariaveis());

        return custosGerados;
    }

    protected void verificarKmRodados() {

    };

        /**
     * Soma todas as rotas de determinado veiculo
     * @return soma as rotas
     */
    public double totalRotas(){
        return this.rotas.stream()
                .mapToDouble(r-> r.getKmRota())
                .sum() + this.kmRodados;
    }
    
    /**
     * Método para retornar o método toString() da classe veículo
     * 
     * @return Método toString()
     */
    public String dadosVeiculo() {
        return toString();
    }

    public int maiorQuantRotas(Veiculo o) {
        if (this.rotas.size() < o.rotas.size())
            return 1;
        else if (this.rotas.size()> o.rotas.size())
            return -1;
        return 0;
    }

    /**
     * Método para incluir rota em um veículo
     * @param date Data dd/mm/aaaa
     * @param kmRota Comprimento da rota em KM
     */
    public void incluirRota(Date date, double kmRota) {
        tanque.verificarCombustivelParaRota(kmRota);
        Rota newRota = new Rota(date, kmRota);
        rotas.add(newRota);
    }

    /**
     * Inclui um novo custo variavel ao veículo
     * @param descricao
     * @param valor
     */

    public void incluirCusto(String descricao, double valor){
        CustoVariavel custoVariavel = new CustoVariavel(valor, descricao);
        custosVariaveis.add(custoVariavel);
    }

    /**
     * Soma todos os custos variaveis de determinado veículo
     * @return soma dos custos variaveis
     */
    private double somaCustosVariaveis(){
        return this.custosVariaveis.stream()
                .mapToDouble(c-> c.getValor())
                .sum();
    }

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

    // #endregion

    // #region Override
    @Override
    public int compareTo(Veiculo o) {
        return this.placa.compareTo(o.placa);
    }

    @Override
    public String toString() {
        return String.format("%s;%.2f;%d;", this.placa, this.valorDeVenda, this.kmRodados).toString();
    }
    // #endregion

    // #region getters and setters
    public double getCustosGerados() {
        return custosGerados;
    }

    public LinkedList<Rota> getRotas() {
        return rotas;
    }

    public String getPlaca() {
        return placa;
    }
    // #endregion

}
