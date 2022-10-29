import java.util.Date;

public class Rota {

    //#region - Atributos
    private Date data;
    private double distancia_total;
    //#endregion

    //#region - Construtores
    /**
     * Método construtor rota
     * @param data Data da rota
     * @param distancia_total Distância da rota
     */
    public Rota(Date data, double distancia_total) {
        this.data = data;
        this.distancia_total = distancia_total;
    }
    //#endregion

    //#region - Métodos

    /**
     * Método para adicionar rotas
     * @param km Distância da rota 
     * @param veiculo Veículo que realizará a rota.
     */
    public void addRota(double km, Veiculo veiculo) {
        
    }
    //#endregion
}
