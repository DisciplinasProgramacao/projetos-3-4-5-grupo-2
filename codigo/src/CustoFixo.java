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
        return calcularIPVA(valorVenda) + calcularSeguro(valorVenda) + calcularOutrosCustos(kmRodados);
    }

    private double calcularIPVA(double valorVenda) {
        return valorVenda * tpVeiculo.getIPVA().getTaxaIPVA();
    };

    private double calcularSeguro(double valorVenda) {
        return (valorVenda * tpVeiculo.getSeguro().getSeguroTaxa()) + tpVeiculo.getSeguro().getSeguroFixo();
    }

    private double calcularOutrosCustos(double kmRodados) {
        return calcularAlinhamento(kmRodados) + calcularVistoria(kmRodados) + calcularManutencao(kmRodados);
    }

    private double calcularAlinhamento(double kmRodados) {
        return (kmRodados/tpVeiculo.getControleKm().getKmAlinhamento()) * tpVeiculo.getOutrosCustos().getAlinhamento();
    };
    
    private double calcularVistoria(double kmRodados) {
        return (kmRodados/tpVeiculo.getControleKm().getKmVistoria()) * tpVeiculo.getOutrosCustos().getVistoria();
    };

    private double calcularManutencao(double kmRodados) {
        return (kmRodados/tpVeiculo.getControleKm().getKmManutencao()) * tpVeiculo.getOutrosCustos().getManutencao();
    };

}
