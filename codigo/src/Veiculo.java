import java.util.Date;
import java.util.LinkedList;

public abstract class Veiculo implements Comparable<Veiculo> {
    
    // #region - Atributos
    protected String placa;
    protected double valorDeVenda;
    protected double kmRodados;
    protected double custosGerados;
    protected Tanque tanque;
    protected LinkedList<Rota> rotas = new LinkedList<Rota>();
    protected LinkedList<CustoVariavel> custosVariaveis = new LinkedList<CustoVariavel>();
    private String tpVeiculo;
    // #endregion

    // #region - Construtores
    /**
     * Construtor veículos
     * @param dados String de dados proveniente do arquivo Veiculos.txt
     */
    Veiculo(String dados, double capacidadeTanque) {
        String[] vetDados = dados.split(";");
        this.tpVeiculo = vetDados[0];
        this.placa = vetDados[1];
        this.valorDeVenda = Double.parseDouble(vetDados[2]);
        this.kmRodados = Double.parseDouble(vetDados[3]);
        this.tanque = new Tanque(capacidadeTanque);
        tipoDeCusto();
    }
    // #endregion

    // #region métodos

    protected abstract double calcularOutrosCustos();

    public void tipoDeCusto() {

        TCustosFixos tipoVeiculo = null;

        switch (this.tpVeiculo) {
            case "Carro":
                tipoVeiculo = TCustosFixos.CARRO;
                break;
            case "Van":
                tipoVeiculo = TCustosFixos.UTILITARIO;
                break;
            case "Furgao":
                tipoVeiculo = TCustosFixos.UTILITARIO;
                break;
            case "Caminhao":
                tipoVeiculo = TCustosFixos.CAMINHAO;
                break;
        }

        retornaCustosTotais(tipoVeiculo);
    }
    
    /**
     * Método para retornar os custos totais de um Veículo
     * @param tipoVeiculo Tipo do veículo
     */
    public void retornaCustosTotais(TCustosFixos tipoVeiculo) {  

        double custoIpva = (double) valorDeVenda * tipoVeiculo.getIpva();
        double custoSeguro = (double) (valorDeVenda * tipoVeiculo.getSeguroTaxa()) + tipoVeiculo.getSeguroFixo();

        this.custosGerados = custoIpva + custoSeguro + calcularOutrosCustos() + somaCustosVariaveis();
    }

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
     * @return Método toString()
     */
    public String dadosVeiculo() {
        return toString();
    }

    /**
     * Método para calcular a maior quantidade de rotas feitas por um veículo
     * @param v Veículo
     * @return
     */
    public int maiorQuantRotas(Veiculo v) {
        if (this.rotas.size() < v.rotas.size())
            return 1;
        else if (this.rotas.size()> v.rotas.size())
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
                .mapToDouble(c-> c.retornaCustoVariavel())
                .sum();
    }

    /**
     * Método para retornar o combustível do Veículo
     */
    public LinkedList<TCombustivel> retornaCombustivelVeiculo(){
        LinkedList<TCombustivel> combustiveis = new LinkedList<TCombustivel>();

        if (this.tpVeiculo.contains("Carro")){
           combustiveis.add(TCombustivel.GASOLINA); 
           combustiveis.add(TCombustivel.ETANOL);
        }      
        else if (this.tpVeiculo.contains("Caminhão")){
            combustiveis.add(TCombustivel.DIESEL);
        }
        else if (this.tpVeiculo.contains("Van")){
            combustiveis.add(TCombustivel.GASOLINA); 
            combustiveis.add(TCombustivel.DIESEL);
        }
        else{
            combustiveis.add(TCombustivel.GASOLINA);
        }
        
        return combustiveis;
    }
    // #endregion

    // #region Override
    @Override
    public int compareTo(Veiculo o) {
        return this.placa.compareTo(o.placa);
    }

    @Override
    public String toString() {

         StringBuilder dadosVeiculo = new StringBuilder("\n--> Dados do veículo");
        dadosVeiculo.append("\n----------------------------------");
        dadosVeiculo.append(
            "\nTipo: " + this.tpVeiculo
            +"\nPlaca: " + this.placa
            +"\nValor de venda: R$"+this.valorDeVenda
            +"\nQuilometros rodados: "+this.kmRodados + " Km"
            +"\nCapacidade do tanque: "+this.tanque.getCapMaxima()+" litros"
            +"\nQuantidade de combustível atual: "+this.tanque.getCombustivelAtual()+" litros"
        );

        return dadosVeiculo.toString();
    }
    // #endregion

    // #region getters and setters
    public double getCustosGerados() {
        return this.custosGerados;
    }

    public LinkedList<Rota> getRotas() {
        return rotas;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTpVeiculo() {
        return tpVeiculo;
    }

    public void setTpVeiculo(String tpVeiculo) {
        this.tpVeiculo = tpVeiculo;
    }
    // #endregion

}
