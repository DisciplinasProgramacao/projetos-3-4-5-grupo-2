import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static LinkedList<Veiculo> listaVeiculos = new LinkedList<Veiculo>();

    public static Veiculo localizarVeiculo(String placa) {
        
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

    public static void carregarDadosVeiculo(String nomeArquivo) {
        try{        
            Path path = Paths.get("C:/Users/Cliente Vip Infomac/Desktop/PUC/PM/LPM/projetos-3-4-5-grupo-2/" + nomeArquivo);
            String[] vetLinha;
            Scanner scanner = new Scanner(path,"UTF-8");
            while(scanner.hasNextLine()){
                String linha = scanner.nextLine();
                vetLinha = linha.split(";");
                criarVeiculo(vetLinha);
            }
            scanner.close();}
        catch(IOException io)
        {
            System.out.println("Erro ao abrir arquivo");
        }
    }

    private static void criarVeiculo(String[] vetLinha) {
        Veiculo newVeiculo = null;

        if(vetLinha[0].equals("Carro")){
            newVeiculo = new Carro(vetLinha);
        }
        else if (vetLinha[0].equals("Caminhao")){
           newVeiculo = new Caminhao(vetLinha);
        } 
        else if (vetLinha[0].equals("Utilitario")){
            newVeiculo = new Utilitario(vetLinha, 0);
        }

        listaVeiculos.add(newVeiculo);
    }

    public static void main(String[] args) throws Exception {
        
        carregarDadosVeiculo("Veiculos.txt");    
        System.out.println(localizarVeiculo("GYE-9781").valorDeVenda);
        
    }
}
