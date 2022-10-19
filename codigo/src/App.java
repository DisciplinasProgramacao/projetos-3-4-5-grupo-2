import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

    private LinkedList<Veiculo> listaVeiculos = new LinkedList<Veiculo>();
    private Carro novoCarro;

    public Veiculo localizarVeiculo(String placa) {
        
        Veiculo veiculoProcurado = null;

        for (int i = 0; i < listaVeiculos.size(); i++) {   
            if(listaVeiculos.get(i).placa.equals(placa)) {
                veiculoProcurado = listaVeiculos.get(i);  
            }
        }

        return veiculoProcurado;
    }
    /**
     * 
     * @param nomeArquivo - Nome do arquivo que será lido os dados referentes aos veículos
     */

    public void carregarDadosVeiculo(String nomeArquivo) {
        try{        
            Path path = Paths.get(nomeArquivo);
            String[] vetLinha;
            Scanner scanner = new Scanner(path,"UTF-8");
            while(scanner.hasNextLine()){
                String linha = scanner.nextLine();
                vetLinha=linha.split(";");
                if(vetLinha[0].equals("Carro")){
                    // Verificar se o construtor recebera a linha do arquivo ou se há uma forma melhor
                    // de fazer isso
                    novoCarro = new Carro("TESTE", 35.000,3000);
                    listaVeiculos.add(novoCarro);
                } 
            }
            scanner.close();}
        catch(IOException io)
        {
            System.out.println("Erro ao abrir arquivo");
        }
    }

    /**
     * Busca o caminho da pasta atual
     * @return caminho da pasta
     */
    private String getCurrentDirectory(){
        return this.getClass().getClassLoader().getResource("Veiculos.txt").getHost();
    }


    public static void main(String[] args) throws Exception {
        
        
        
    }
}
