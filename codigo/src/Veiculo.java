import java.util.Date;
import java.util.LinkedList;

public class Veiculo implements Comparable<Veiculo> {
    
    // #region - Atributos
    public String placa;
    private Tanque tanque;
    private LinkedList<Rota> rotas = new LinkedList<Rota>();
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
        } else if (tipo.equals("Utilitario")) {
            tpVeiculo = TVeiculo.UTILITARIO;
        }
    }
    // #endregion

    // #region métodos
    public double retornaCustosTotais(double valor, String descricao) {
        CustoFixo custoFixo = new CustoFixo(tpVeiculo);
        CustoVariavel custoVariavel = new CustoVariavel(valor, descricao);

        this.custosGerados = (custoFixo.retornaCustoFixo(this.valorDeVenda, this.kmRodados)
                + custoVariavel.retornaCustoVariavel());

        return custosGerados;
    }

    protected void verificarKmRodados() {

    };

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
        else if (this.rotas.size() > o.rotas.size())
            return -1;
        return 0;
    }

    public void incluirRota(Date date, double kmRota) {
        Rota newRota = new Rota(date, kmRota);
        rotas.add(newRota);
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
    // #endregion

}
