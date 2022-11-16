public class Tanque {
    
    private double capacidade;
    private double combustivelAtual;
    private double consumoMedio;
    private double preco;

    public void verificarTanque() {
        
    }

    public void completarTanque() {
        this.combustivelAtual = this.capacidade;
    }

    public void reduzirConsumoDaRota(double kmRota) {
        this.combustivelAtual -= kmRota/this.consumoMedio;
    }

    public void verificarCombustivelParaRota(double kmRota) {
        if ((this.combustivelAtual * this.consumoMedio) < kmRota){
            completarTanque();
        }
    }
    
    public double getCombustivelAtual(){
        return this.combustivelAtual;
    }

    public void setConsumoMedio(double consumo){
        this.consumoMedio = consumo;
    }
}
