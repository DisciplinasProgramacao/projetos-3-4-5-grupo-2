public class Tanque {
    
    private double capacidadeMax;
    private double combustivelAtual;
    private TCombustivel tCombustivel;

    public Tanque(double capacidadeMax, double combustivelAtual, TCombustivel tCombustivel) {
        this.capacidadeMax = capacidadeMax;
        this.combustivelAtual = combustivelAtual;
        this.tCombustivel = tCombustivel;
    }

    public double kmPercorridosCombustivelAtual(){
        return this.combustivelAtual * tCombustivel.getConsumoMedio();
    }

    public double kmPercorridosCombustivelTotal(){
        return this.capacidadeMax * tCombustivel.getConsumoMedio();
    }

    public void completarTanque() {
        this.combustivelAtual = this.capacidadeMax;
        
    }

    public void reduzirConsumoDaRota(double kmRota) {
        this.combustivelAtual -= kmRota/tCombustivel.getConsumoMedio();
    }

    public void verificarCombustivelParaRota(double kmRota) {
        if (kmPercorridosCombustivelAtual() < kmRota){
            completarTanque();
        }
    }
    
    public double getCombustivelAtual(){
        return this.combustivelAtual;
    }

    public TCombustivel gettCombustivel() {
        return tCombustivel;
    }

}
