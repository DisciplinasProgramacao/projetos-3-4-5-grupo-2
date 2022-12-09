public class Utilitario extends Veiculo{

    //#region - Atributos
    private double tanqueMax;
    //#endregion

    /**
     * Construtor veículos da classe utilitário (vans ou furgões)
     * @param dadosUtilitario Linha de dados 
     */
    public Utilitario(String dados, TUtilitario tipoUtilitario) {
        super(dados, tipoUtilitario.tanque());
        this.tanqueMax = tipoUtilitario.tanque();
    }
    //#region - Métodos

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
}
