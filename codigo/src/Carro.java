public class Carro extends Veiculo{

    //#region - Atributos
    
    private static final int TANQUE = 50;
    private static final double IPVA = 0.04;
    private static final double SEGURO_TAXA = 0.05;
    private static final double SEGURO_FIXO = 300;
    private static final double ALINHAMENTO_VALOR = 80;
    //#endregion

    //#region - Construtores

    public Carro(String[] vetDados) {
        //String placa, String chassi, double valorDeVenda, int kmRodados, String anoFab, String cor
        super(vetDados);
    }

    //#endregion

    public double calcularIPVA(){
        return this.valorDeVenda * IPVA;
    };

    //#region - Métodos
    public double calcularSeguro() {
        return (this.valorDeVenda * SEGURO_TAXA) + SEGURO_FIXO;
    };

    public void calcularGastosTotais() {
        
    };

    private void calcularAlinhamento() {

    }    
    //#endregion
}
