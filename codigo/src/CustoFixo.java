public class CustoFixo {

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
    
    public double retornaCustoFixo(double valorVenda, double kmRodados) {
        return (double) calcularIPVA(valorVenda) + calcularSeguro(valorVenda) + calcularOutrosCustos(kmRodados);
    }

    private double calcularIPVA(double valorVenda) {
        return (double) valorVenda * tpVeiculo.getIPVA().getTaxaIPVA();
    };

    private double calcularSeguro(double valorVenda) {
        return (double) (valorVenda * tpVeiculo.getSeguro().getSeguroTaxa()) + tpVeiculo.getSeguro().getSeguroFixo();
    }

    private double calcularOutrosCustos(double kmRodados) {
        return (double) calcularAlinhamento(kmRodados) + calcularVistoria(kmRodados) + calcularManutencao(kmRodados);
    }

    private double calcularAlinhamento(double kmRodados) {
        return (double) (kmRodados/tpVeiculo.getControleKm().getKmAlinhamento()) * tpVeiculo.getOutrosCustos().getAlinhamento();
    };
    
    private double calcularVistoria(double kmRodados) {
        return (double) (kmRodados/tpVeiculo.getControleKm().getKmVistoria()) * tpVeiculo.getOutrosCustos().getVistoria();
    };

    private double calcularManutencao(double kmRodados) {
        return (double) (kmRodados/tpVeiculo.getControleKm().getKmManutencao()) * tpVeiculo.getOutrosCustos().getManutencao();
    };

}
