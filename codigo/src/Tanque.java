import org.junit.validator.PublicClassValidator;

public class Tanque {
    
    private double capacidadeMax;
    private double combustivelAtual;
    private TCombustivel tCombustivel;
    private static final double COMBUSTIVEL_INICIAL = 0.0;
 

    public Tanque(double capacidadeMax, TCombustivel tCombustivel) {
        this.capacidadeMax = capacidadeMax;
        this.combustivelAtual = COMBUSTIVEL_INICIAL;
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

    public double combustivelAdd() {
        return this.capacidadeMax - this.combustivelAtual;
    }

    public double valorAbastecimento() {
        return combustivelAdd() * this.tCombustivel.getPreco();
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

    public double getCapMaxima(){
        return this.capacidadeMax;
    }

    public TCombustivel getTCombustivel() {
        return tCombustivel;
    }

    public void setTCombustivel(TCombustivel tCombustivel) {
        this.tCombustivel = tCombustivel;
    }

    

}
