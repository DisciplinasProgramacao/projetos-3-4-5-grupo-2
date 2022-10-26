public class Carro extends Veiculo{

    //#region - Atributos
    private static final int TANQUE = 50;
    private static final double IPVA = 0.04;
    private static final double SEGURO_TAXA = 0.05;
    private static final double SEGURO_FIXO = 300;
    private static final double ALINHAMENTO_VALOR = 80;
    //#endregion

    //#region - Construtores
    public Carro(String linha) {
        super(linha);
    }

    //#endregion
    public double calcularIPVA(){
        return super.calcularIPVA(IPVA);
    };

    //#region - Métodos
    public double calcularSeguro() {
        return super.calcularSeguro(SEGURO_TAXA, SEGURO_FIXO);
    };

    public void calcularGastosTotais() {
        
    };

    private void calcularAlinhamento() {

    }    

    @Override
    public String toString() {
        return String.format("%s;", Carro.class.getSimpleName())+super.toString();
    }
    //#endregion
}
