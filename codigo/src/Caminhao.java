import javax.print.attribute.standard.RequestingUserName;
public class Caminhao extends Veiculo{

    //#region - Atributos
    private static final int TANQUE = 250;    
    private static final double IPVA = 0.01;
    private static final double SEGURO_TAXA = 0.02;
    private static final double SEGURO_FIXO = 2000;
    private static final double MANUTENCAO_VALOR = 1000;    
    private static final double VISTORIA_VALOR = 1000;
    //#endregion

    //#region - Construtores
    /**
     * Construtor caminhão
     * @param linha Linha de dados proveniente do arquivo.
     */
    public Caminhao(String linha) {
        super(linha);
    }
    //#endregion

    //#region - Métodos

    /**
     * Método para calcular o IPVA do caminhão chamando o método da classe veículo
     */
    public double calcularIPVA(){
        return super.calcularIPVA(IPVA);
    };

    //#region - Métodos
    
    /**
     * Método para calcular o seguro do caminhão chamando o método da classe veículo
     */
    public double calcularSeguro() {
        return super.calcularSeguro(SEGURO_TAXA, SEGURO_FIXO);
    };

    /**
     * Método para calcular os outros custos do caminhão chamando o método da classe veículo
     */
    protected double calcularOutrosCustos() {
        return calcularManutencao() + calcularVistoria();
    }

    /**
     * Método para calcular custos de manutenção do caminhão
     */
    private double calcularManutencao() {
        return (kmRodados/20000.0) * MANUTENCAO_VALOR;
    };

       /**
     * Método para calcular custos de vistoria do caminhão
     */
    private double calcularVistoria() {
        return (kmRodados/30000.0) * VISTORIA_VALOR;
    };

    @Override
    public String toString() {
        return String.format("%s;", Caminhao.class.getSimpleName())+super.toString();
    }
    //#endregion

}
