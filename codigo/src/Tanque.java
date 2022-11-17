public class Tanque {
    
    private double capacidadeMax;
    private double combustivelAtual;
    private TCombustivel tCombustivel;

    public Tanque(double capacidadeMax, double combustivelAtual, TCombustivel tCombustivel) {
        this.capacidadeMax = capacidadeMax;
        this.combustivelAtual = combustivelAtual;
        this.tCombustivel = tCombustivel;
    }

    public void verificarTanque() {
        
    }
    
    double quantoAndo(){
        return this.combustivelAtual*tCombustivel.kmPorLitro();
    }

    public void completarTanque() {
        this.combustivelAtual = this.capacidadeMax;
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
