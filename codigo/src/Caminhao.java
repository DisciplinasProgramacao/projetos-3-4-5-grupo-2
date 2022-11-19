import javax.print.attribute.standard.RequestingUserName;
public class Caminhao extends Veiculo{

    private static final double CAPACIDADETANQUE = 250;

    //#region - Construtores
    /**
     * Construtor caminhão
     * @param dadosCaminhao Linha de dados proveniente do arquivo.
     */
    public Caminhao(String dadosCaminhao) {
        super(dadosCaminhao, CAPACIDADETANQUE, TCombustivel.DIESEL);
    }
    //#endregion

    //#region - Métodos

    /**
     * Método para calcular os outros custos do caminhão chamando o método da classe veículo
     */
    @Override
    protected double calcularOutrosCustos() {
        return calcularManutencao() + calcularVistoria();
    }

    /**
     * Método para calcular custos de manutenção do caminhão
     */
    private double calcularManutencao() {
        return (kmRodados/20000.0) * TCustosFixos.CAMINHAO.getManutencao();
    };

    /**
     * Método para calcular custos de vistoria do caminhão
     */
    private double calcularVistoria() {
        return (kmRodados/30000.0) * TCustosFixos.CAMINHAO.getVistoria();
    };

    @Override
    public String toString() {
        return String.format("%s;", Caminhao.class.getSimpleName())+super.toString();
    }
    //#endregion

}
