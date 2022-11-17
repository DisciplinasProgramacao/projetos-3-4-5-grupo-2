public class Carro extends Veiculo{

    //#region - Construtores
    /**
     * Método construtor do carro o método construtor da classe veículo
     */
    public Carro(String dadosCarro) {
        super(dadosCarro);
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

    @Override
    public String toString() {
        return String.format("%s;", Carro.class.getSimpleName())+super.toString();
    }
    //#endregion
}
