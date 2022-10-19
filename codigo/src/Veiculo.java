public abstract class Veiculo {

    protected String placa;
    protected double valorDeVenda;
    protected int kmRodados;
    protected String chassi;
    protected String anoFabricacao;
    protected String cor;

    public Veiculo(String placa, double valorDeVenda, int kmRodados) {
        this.placa = placa;
        this.valorDeVenda = valorDeVenda;
        this.kmRodados = kmRodados;
    }

    protected abstract double calcularIPVA();

    protected abstract double calcularSeguro();

    protected abstract void calcularGastosTotais();

    protected void verificarKmRodados() {

    };
 
}
