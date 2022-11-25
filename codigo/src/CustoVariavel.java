public class CustoVariavel {
    private double valor;
    private String descricao;

    /**
     * Construtor da classe
     * @param valor valor do custo variável
     * @param descricao descrição do custo variável
     */
    public CustoVariavel(double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    /**
     * Método retorna o custo variável 
     * @return
     */
    public double retornaCustoVariavel() {
        return valor;
    }
}
