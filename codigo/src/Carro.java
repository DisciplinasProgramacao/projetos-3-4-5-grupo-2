public class Carro extends Veiculo{

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
        return super.calcularIPVA(TCustosFixos.CARRO.getIpva());
    };

    //#region - Métodos
    /**
     * Método para calcular o seguro do carro chamando o método da classe veículo
     */
    public double calcularSeguro() {
        return super.calcularSeguro(TCustosFixos.CARRO.getSeguroTaxa(), TCustosFixos.CARRO.getSeguroFixo());
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
        return (kmRodados/10000.0) * TCustosFixos.CARRO.getAlinhamento();
    }    

    @Override
    public String toString() {
        return String.format("%s;", Carro.class.getSimpleName())+super.toString();
    }
    //#endregion
}
