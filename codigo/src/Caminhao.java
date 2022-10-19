import java.rmi.server.RemoteStub;

import javax.print.attribute.standard.RequestingUserName;

public class Caminhao extends Veiculo{

    private static final int tanque = 250;    
    private static final double ipva = 0.01;
    private static final double seguroTaxa = 0.02;
    private static final double seguroFixo = 2000;
    private static final double MANUTENCAO_VALOR = 1000;    
    private static final double VISTORIA_VALOR = 1000;

    public Caminhao(String placa, double valorDeVenda, int kmRodados) {
        super(placa, valorDeVenda, kmRodados);
    }

    public double calcularIPVA(){
        return valorDeVenda * ipva;
    };

    public double calcularSeguro() {
        return (this.valorDeVenda * seguroTaxa) + seguroFixo;
    };

    public void calcularGastosTotais() {

    };

    private void calcularManutencao() {

    };

    private void calcularVistoria() {

    };


}
