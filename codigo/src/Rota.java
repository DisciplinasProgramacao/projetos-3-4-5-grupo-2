import java.util.Date;

public class Rota {

    //#region - Atributos
    private Date data;
    private double kmRota;
    //#endregion

    //#region - Construtores
    Rota(Date data, double kmRota) {
        this.data = data;
        this.kmRota = kmRota;
    }
    //#endregion

    //#region getters and setters
    public Date getDate(){
        return this.data;
    }
    
    public double getKmRota(){
        return this.kmRota;
    }
    //#endregion

    
    
}
