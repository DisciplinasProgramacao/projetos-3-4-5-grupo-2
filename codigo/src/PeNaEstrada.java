import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PeNaEstrada {

    //#region Atributos
    private static LinkedList<Veiculo> listaVeiculos = new LinkedList<Veiculo>();
    //#endregion


    //#region - Construtor
    public PeNaEstrada() {
        
    }

    //#endregion

    
    /**
     * Método para localizar um veículo
     * @param placa Dados da placa
     * @return Retorna o veículo desejado, se ele existir
     */
    public static Veiculo localizarVeiculo(String placa) {
        
        Veiculo veiculoProcurado = null;

        for (int i = 0; i < listaVeiculos.size(); i++) {   
            if(listaVeiculos.get(i).placa.equals(placa)) {
                veiculoProcurado = listaVeiculos.get(i);
                break;  
            }
        }
        return veiculoProcurado;
    }
    
    /**
     * Método para carregar os veículos do arquivo de texto
     * @param nomeArquivo - Nome do arquivo que será lido os dados referentes aos veículos
     */
    public static void carregarDadosVeiculo(String caminho) {
        try{        
            Path path = Paths.get(caminho.concat("/Veiculos.txt"));
            Scanner sc = new Scanner(path,"UTF-8");
            while(sc.hasNextLine()){
                String linha = sc.nextLine();
               
                adicionaVeiculo(linha);
            }
            sc.close();}
        catch(IOException io)
        {
            System.out.println("Erro ao abrir arquivo");
        }
    }

    /**
     * Método para salvar os veículos
     * @param caminhoArquivo Caminho do arquivo de texto onde os objetos serão salvos
     * @throws IOException
     */
    public void salvar(String caminhoArquivo) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo));
        Veiculo[] veiculo = new Veiculo[listaVeiculos.size()];

        for(int i = 0; i < listaVeiculos.size(); i++) {
            bw.write(veiculo[i].toString());
            bw.newLine();    
        }

        bw.close();
    }

    /**
     * Override do método toString() para adequar a classe Veiculo
     */
    public static String gerarString(int tipoVeiculo, String placa, String precoVenda, String kmRodados){
        String tipoVeiculoString = converteParaStringVeiculo(tipoVeiculo);
        StringBuilder dadosVeiculo = new StringBuilder(tipoVeiculoString+";"+placa+";"+precoVenda+";"+kmRodados);
        return dadosVeiculo.toString();
    }

    /**
     * Método para transformar em texto 
     * @param input Tipo de veículo
     * @return
     */
    private static String converteParaStringVeiculo(int input){
        String tipoVeiculo=null;

        switch(input){
            case 1:
                tipoVeiculo = "Carro";
            break;
            case 2:
                tipoVeiculo = "Utilitario";
            break;
            case 3:
                tipoVeiculo = "Caminhao";
            break;
        }

        return tipoVeiculo;
    }
    // #endregion

    /**
     * Método para criar os diferentes tipos de veículos 
     * @param linha Linha de dados do arquivo
     */
    public static void adicionaVeiculo(String linha) {
        Veiculo newVeiculo = new Veiculo(linha);
        listaVeiculos.add(newVeiculo); 
    }

    public static void addRota(Date data, Veiculo veiculo, double kmRota) {
        veiculo.incluirRota(data, kmRota); 
    }

    public static void topTresRotas() {
        System.out.println("3 veículos com mais rotas realizadas: ");
        listaVeiculos.stream()
                .sorted()
                .limit(3)
                .forEach(p -> System.out.println(p.placa));
    }

    public void adicionarCusto() {

    }

    public Veiculo localizarVeiculo() {

        return null ;
    }

    public void kmAvgRotas() {

    }

    public void listarVeiculosPorCusto() {
        System.out.println("Lista de veículos com custos gerados em ordem decrescente: ");
        
        Collections.reverse(listaVeiculos
                .stream()
                .sorted((Comparator.comparingDouble(Veiculo::getCustosGerados)))
                .collect(Collectors.toList()));


        // listaVeiculos.stream().sorted((o1, o2) -> o1.getCustosGerados()
        //         .compareTo(o2.getCustosGerados()))
        //         .forEach(p -> System.out.println(p.placa));
    }


    public void buscarRotasPorDatas() {

    }


}
