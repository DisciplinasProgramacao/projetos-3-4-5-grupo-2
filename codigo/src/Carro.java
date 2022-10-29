public class Carro extends Veiculo{

    //#region - Atributos
    private static final int TANQUE = 50;
    private static final double IPVA = 0.04;
    private static final double SEGURO_TAXA = 0.05;
    private static final double SEGURO_FIXO = 300;
    private static final double ALINHAMENTO_VALOR = 80;
    //#endregion

    //#region - Construtores
    /**
     * Método construtor do carro o método construtor da classe veículo
     */
    public Carro(String linha) {
        super(linha);
    }

    //#endregion
    
    /**
     * Método para calcular o IPVA do carro chamando o método da classe veículo
     */
    public double calcularIPVA(){
        return super.calcularIPVA(IPVA);
    };

    //#region - Métodos
    /**
     * Método para calcular o seguro do carro chamando o método da classe veículo
     */
    public double calcularSeguro() {
        return super.calcularSeguro(SEGURO_TAXA, SEGURO_FIXO);
    };

    /**
     * Método para calcular o outros custos do carro chamando o método interno
     */
    protected double calcularOutrosCustos() {
        return calcularAlinhamento();
    }

    /**
     * Método para calcular o outros custos do carro
     */
    private double calcularAlinhamento() {
        return (kmRodados/10000.0) * ALINHAMENTO_VALOR;
    }    

    @Override
    public String toString() {
        return String.format("%s;", Carro.class.getSimpleName())+super.toString();
    }
    //#endregion
}
