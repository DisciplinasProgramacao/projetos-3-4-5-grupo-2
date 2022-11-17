import javax.print.attribute.standard.RequestingUserName;
public class Caminhao extends Veiculo{

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
        return super.calcularIPVA(TCustosFixos.CAMINHAO.getIpva());
    };

    //#region - Métodos
    
    /**
     * Método para calcular o seguro do caminhão chamando o método da classe veículo
     */
    public double calcularSeguro() {
        return super.calcularSeguro(TCustosFixos.CAMINHAO.getSeguroTaxa(), TCustosFixos.CAMINHAO.getSeguroFixo());
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
