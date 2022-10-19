import javax.naming.InitialContext;

public class Utilitario extends Veiculo{

    //#region - Atributos
    private int tanque;
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

    public Utilitario(String placa, double valorDeVenda, int kmRodados, int tanque) {
        super(placa, valorDeVenda, kmRodados);
        this.tanque = tanque;
    }

    private boolean verificarTanque(int tanque) {
        return ((tanque == 60 || tanque == 80) ? true : false);
    }

    public double calcularIPVA(){
        return valorDeVenda * IPVA;
    };

    public double calcularSeguro() {
        return this.valorDeVenda * SEGURO_TAXA;
    };

    public void calcularGastosTotais() {
        
    };

    private void calcularAlinhamento() {

    };
    
    private void calcularVistoria() {

    };
}
