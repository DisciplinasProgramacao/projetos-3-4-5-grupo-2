import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
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
    public static void carregarDadosVeiculo(String caminhoArquivo) {
        try{        
            Path path = Paths.get(caminhoArquivo);
            Scanner sc = new Scanner(path,"UTF-8");
            while(sc.hasNextLine()){
                String linha = sc.nextLine();
               
                criarVeiculo(linha);
            }
            sc.close();}
        catch(IOException io)
        {
            System.out.println("Erro ao abrir arquivo");
        }
    }

    private static void criarVeiculo(String linha) {
        String[] vetLinha = linha.split(";");
        Veiculo newVeiculo = null;

        if(vetLinha[0].equals("Carro")){
            newVeiculo = new Carro(linha);
        }
        else if (vetLinha[0].equals("Caminhao")){
           newVeiculo = new Caminhao(linha);
        } 
        else if (vetLinha[0].equals("Utilitario")){
            newVeiculo = new Utilitario(linha, 0);
        }

        listaVeiculos.add(newVeiculo);
    }

    public void salvar(String caminhoArquivo) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo));
        Veiculo[] veiculo = new Veiculo[listaVeiculos.size()];

        for(int i = 0; i < listaVeiculos.size(); i++) {
            bw.write(veiculo[i].toString());
            bw.newLine();    
        }

        bw.close();
    }

    public static void main(String[] args) throws Exception {
        String caminho = "C:\\Users\\bruno\\OneDrive\\Documentos\\folder\\projetos-3-4-5-grupo-2\\Veiculos.txt";
        
        carregarDadosVeiculo(caminho);    
        System.out.println(localizarVeiculo("GYE-9781").dadosVeiculo());
        
    }
}
