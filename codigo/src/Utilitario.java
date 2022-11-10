public class Utilitario extends Veiculo{

    //#region - Atributos
    private double tanqueMax;
    private static final double IPVA = 0.03;
    private static final double SEGURO_TAXA = 0.03;
    private static final double ALINHAMENTO_VALOR = 120;
    private static final double VISTORIA_VALOR = 500;
    //#endregion
    // public void init(String placa, double valorDeVenda, int kmRodados, int tanque) {
    //     if(verificarTanque(tanque) == true) {

    //     } else {
    //         System.out.println("Este veículo não é um utilitário");
    //     }
    // }

    public Utilitario(String dados, int tanque) {
        super(dados);
        this.tanqueMax = tanque;
    }

    private boolean verificarTanque(int tanque) {
        return ((tanque == 60 || tanque == 80) ? true : false);
    }

    public double calcularIPVA(){
        return super.calcularIPVA(IPVA);
    };

    //#region - Métodos
    public double calcularSeguro() {
        return super.calcularSeguro(SEGURO_TAXA, 0);
    };

    protected double calcularOutrosCustos() {
        return calcularAlinhamento() + calcularVistoria();
    }

    private double calcularAlinhamento() {
        return (kmRodados/10000.0) * ALINHAMENTO_VALOR;
    };
    
    private double calcularVistoria() {
        return (kmRodados/10000.0) * VISTORIA_VALOR;
    };

    @Override
    public String toString() {
        return String.format("%s;", Utilitario.class.getSimpleName())+super.toString();
    }
}
