import javax.naming.InitialContext;

public class Utilitario extends Veiculo{

    //#region - Atributos
    private int tanque;
    private static final double IPVA = 0.03;
    private static final double SEGURO_TAXA = 0.03;
    private static final double ALINHAMENTO_VALOR = 120;
    private static final double VISTORIA_VALOR = 500;
    //#endregion

    /**
     * Construtor veículos da classe utilitário (vans ou furgões)
     * @param dados Linha de dados 
     * @param tanque Capacidade em litros do tanque
     */
    public Utilitario(String dados, int tanque) {
        super(dados);
        this.tanque = tanque;
    }

    private boolean verificarTanque(int tanque) {
        return ((tanque == 60 || tanque == 80) ? true : false);
    }

    /**
     * Método para calcular o IPVA do utilitário
     */
    public double calcularIPVA(){
        return super.calcularIPVA(IPVA);
    };

    //#region - Métodos
     /**
     * Método para calcular o seguro do utilitário
     */
    public double calcularSeguro() {
        return super.calcularSeguro(SEGURO_TAXA, 0);
    };
     
    /**
     * Método para calcular outros custos do utilitário
     */
    protected double calcularOutrosCustos() {
        return calcularAlinhamento() + calcularVistoria();
    }

    private double calcularAlinhamento() {
        return (kmRodados/10000.0) * ALINHAMENTO_VALOR;
    };
    
    private double calcularVistoria() {
        return (kmRodados/10000.0) * VISTORIA_VALOR;
    };

    @Override
    public String toString() {
        return String.format("%s;", Utilitario.class.getSimpleName())+super.toString();
    }
}
