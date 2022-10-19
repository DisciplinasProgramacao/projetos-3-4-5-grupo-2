import java.rmi.server.RemoteStub;

import javax.print.attribute.standard.RequestingUserName;

public class Caminhao extends Veiculo{


    //#region - Atributos
    private static final int tanque = 250;    
    private static final double ipva = 0.01;
    private static final double seguroTaxa = 0.02;
    private static final double seguroFixo = 2000;
    private static final double MANUTENCAO_VALOR = 1000;    
    private static final double VISTORIA_VALOR = 1000;
    //#endregion

    //#region - Construtores
    public Caminhao(String[] vetDados) {
        super(vetDados);
    }
    //#endregion

    //#region - Métodos

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

    @Override
    public String toString() {
        return String.format("%s;", Caminhao.class.getSimpleName())+super.toString();
    }
    //#endregion

}
