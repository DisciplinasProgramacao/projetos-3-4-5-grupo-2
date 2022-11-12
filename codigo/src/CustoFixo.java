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
        // TODO Auto-generated method stub
        return 0;
    }

    public double calcularIPVA(double valorVenda) {
        return valorVenda * tpVeiculo.getIPVA().getTaxaIPVA();
    };

}
