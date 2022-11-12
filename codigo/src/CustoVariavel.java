public class CustoVariavel implements ICusto {
    private double valor;
    private String descricao;

    public CustoVariavel(double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    @Override
    public double retornaCusto() {
        return valor;
    }
    
}
