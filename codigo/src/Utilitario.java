public class Utilitario extends Veiculo{

    //#region - Atributos
    private double tanqueMax;
    //#endregion

    /**
     * Construtor veículos da classe utilitário (vans ou furgões)
     * @param dados Linha de dados 
     * @param tanque Capacidade em litros do tanque
     */
    public Utilitario(String dados, TUtilitario qual) {
        super(dados);
        this.tanqueMax = qual.tanque()
    }

    private boolean verificarTanque(int tanque) {
        return ((tanque == 60 || tanque == 80) ? true : false);
    }

    /**
     * Método para calcular o IPVA do utilitário
     */
    public double calcularIPVA(){
        return super.calcularIPVA(TCustosFixos.UTILITARIO.getIpva());
    };

    //#region - Métodos
     /**
     * Método para calcular o seguro do utilitário
     */
    public double calcularSeguro() {
        return super.calcularSeguro(TCustosFixos.UTILITARIO.getSeguroTaxa(), TCustosFixos.UTILITARIO.getSeguroFixo());
    };
     
    /**
     * Método para calcular outros custos do utilitário
     */
    protected double calcularOutrosCustos() {
        return calcularAlinhamento() + calcularVistoria();
    }

    private double calcularAlinhamento() {
        return (kmRodados/10000.0) * TCustosFixos.UTILITARIO.getAlinhamento();
    };
    
    private double calcularVistoria() {
        return (kmRodados/10000.0) * TCustosFixos.UTILITARIO.getVistoria();
    };

    @Override
    public String toString() {
        return String.format("%s;", Utilitario.class.getSimpleName())+super.toString();
    }
}
