public class CustoFixo implements ICusto {

    private double ipva;
    private double seguroTaxa;
    private int seguroFixo;
    private int alinhamento;
    private int manutencao;
    private int vistoria;
    private TVeiculo tpVeiculo;

    public CustoFixo(TVeiculo tpVeiculo){
        this.tpVeiculo = tpVeiculo;
    }
    
    @Override
    public double retornaCusto() {
        return 0;
    }


    // protected double calcularGastosTotais() {
    //     return calcularIPVA() + calcularSeguro() + calcularOutrosCustos();
    // }


    private double calcularIPVA(double valorVenda) {
        return valorVenda * tpVeiculo.getIPVA().getTaxaIPVA();
    };

    private double calcularSeguro(double valorVenda) {
        return (valorVenda * tpVeiculo.getSeguro().getSeguroTaxa()) + tpVeiculo.getSeguro().getSeguroFixo();
    }

    private double calcularOutrosCustos() {

    }

    private double calcularAlinhamento() {
        return (kmRodados/10000.0) * ALINHAMENTO_VALOR;
    };
    
    private double calcularVistoria() {
        return (kmRodados/10000.0) * VISTORIA_VALOR;
    };

}
