import javax.print.attribute.standard.RequestingUserName;

public class Caminhao extends Veiculo{


    //#region - Atributos
    private static final double TANQUE_MAX = 250;    
    private static final double IPVA = 0.01;
    private static final double SEGURO_TAXA = 0.02;
    private static final double SEGURO_FIXO = 2000;
    private static final double MANUTENCAO_VALOR = 1000;    
    private static final double VISTORIA_VALOR = 1000;
    //#endregion

    //#region - Construtores
    public Caminhao(String linha) {
        super(linha);
    }
    //#endregion

    //#region - Métodos

    public double calcularIPVA(){
        return super.calcularIPVA(IPVA);
    };

    //#region - Métodos
    public double calcularSeguro() {
        return super.calcularSeguro(SEGURO_TAXA, SEGURO_FIXO);
    };

    protected double calcularOutrosCustos() {
        return calcularManutencao() + calcularVistoria();
    }

    private double calcularManutencao() {
        return (kmRodados/20000.0) * MANUTENCAO_VALOR;
    };

    private double calcularVistoria() {
        return (kmRodados/30000.0) * VISTORIA_VALOR;
    };

    @Override
    public String toString() {
        return String.format("%s;", Caminhao.class.getSimpleName())+super.toString();
    }
    //#endregion

}
