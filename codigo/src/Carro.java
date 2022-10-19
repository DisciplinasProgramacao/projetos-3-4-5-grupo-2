public class Carro extends Veiculo{
    
    private static final int tanque = 50;
    private static final double ipva = 0.04;
    private static final double seguroTaxa = 0.05;
    private static final double seguroFixo = 300;
    private static final double ALINHAMENTO_VALOR = 80;

    public Carro(String placa, double valorDeVenda, int kmRodados) {
        super(placa, valorDeVenda, kmRodados);
    }

    public double calcularIPVA(){
        return this.valorDeVenda * ipva;
    };

    public double calcularSeguro() {
        return (this.valorDeVenda * seguroTaxa) + seguroFixo;
    };

    public void calcularGastosTotais() {
        
    };

    private void calcularAlinhamento() {

    }    
}
