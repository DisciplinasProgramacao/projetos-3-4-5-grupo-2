public class Carro extends Veiculo{

    private static final double CAPACIDADE_TANQUE = 50;

    //#region - Construtores
    /**
     * Método construtor do carro o método construtor da classe veículo
     */
    public Carro(String dadosCarro) {
        super(dadosCarro, CAPACIDADE_TANQUE, TCombustivel.GASOLINA);
    }
    //#endregion
    
    //#region - Métodos
    /**
     * Método para calcular o outros custos do carro chamando o método interno
     */
    @Override
    protected double calcularOutrosCustos() {
        return calcularAlinhamento();
    }

    /**
     * Método para calcular o outros custos do carro
     */
    private double calcularAlinhamento() {
        return (kmRodados/10000.0) * TCustosFixos.CARRO.getAlinhamento();
    }    
    //#endregion
}
