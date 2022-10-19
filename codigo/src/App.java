import java.util.LinkedList;

public class App {

    private LinkedList<Veiculo> listaVeiculos = new LinkedList<Veiculo>();

    public Veiculo localizarVeiculo(String placa) {
        
        Veiculo veiculoProcurado = null;

        for (int i = 0; i < listaVeiculos.size(); i++) {   
            if(listaVeiculos.get(i).placa.equals(placa)) {
                veiculoProcurado = listaVeiculos.get(i);  
            }
        }

        return veiculoProcurado;
    }    


    public static void main(String[] args) throws Exception {
        
        
        
    }
}
