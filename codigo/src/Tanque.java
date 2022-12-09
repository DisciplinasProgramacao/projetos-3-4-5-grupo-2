import org.junit.validator.PublicClassValidator;

public class Tanque {
    //#region - Atributos
    private double capacidadeMax;
    private double combustivelAtual;
    private TCombustivel tCombustivel;
    private static final double COMBUSTIVEL_INICIAL = 0.0;
    //#endregion

    //#region - Construtor
    public Tanque(double capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
        this.combustivelAtual = COMBUSTIVEL_INICIAL;
        this.tCombustivel = null;
    }
    //#endregion


    //#region - Métodos
    /**
     * Método calcula a quantidade de kms percorridos com o combustível atual
     * @return A quantidade em kms
     */
    public double kmPercorridosCombustivelAtual(){
        return this.combustivelAtual * tCombustivel.getConsumoMedio();
    }

    /**
     * Método calcula a quantidade de kms percorridos com o combustível total
     * @return A quantidade em kms
     */
    public double kmPercorridosCombustivelTotal(){
        return this.capacidadeMax * tCombustivel.getConsumoMedio();
    }

    /**
     * Método para complementar o tanque 
     * @return Quantidade de máxima de litros
     */
    public void completarTanque() {
        this.combustivelAtual = this.capacidadeMax;
    }

    /**
     * Método adicionar combustível
     * @return A quantidade em litros
     */
    public double combustivelAdd() {
        return this.capacidadeMax - this.combustivelAtual;
    }

     /**
     * Método calcular o preço do abastecimento sendo realizado
     * @return Preço do abastecimento
     */
    public double valorAbastecimento() {
        return combustivelAdd() * this.tCombustivel.getPreco();
    }


    /**
     * Método calcular reduzir o consumo da rota
     * @param Rota Tamanho da rota 
     */
    public void reduzirConsumoDaRota(double kmRota) {
        this.combustivelAtual -= kmRota/tCombustivel.getConsumoMedio();
    }
     /**
     * Método verificar se o veículo tem combustível para realizar a rota
     * @param Rota Tamanho da rota 
     */

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

    //#region

}
