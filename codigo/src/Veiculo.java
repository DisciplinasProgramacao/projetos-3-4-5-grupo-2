import java.util.Date;
import java.util.LinkedList;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.ElasticCharAppender;

public class Veiculo implements Comparable<Veiculo> {
    
    // #region - Atributos
    public String placa;
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
        if (this.totalRotas() < o.totalRotas())
            return 1;
        else if (this.totalRotas() > o.totalRotas())
            return -1;
        return 0;
    }

    public void incluirRota(Date date, double kmRota) {
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
