import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    private static Scanner teclado = new Scanner(System.in, "UTF-8");
    private static LinkedList<Veiculo> listaVeiculos = new LinkedList<Veiculo>();
   
     // #region - Utilidades
    /**
     * "Limpa" a tela (códigos de terminal VT-100)
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Pausa para leitura de mensagens em console
     */
    static void pausa() {
        System.out.println("\nEnter para continuar.");
        teclado.nextLine();
    }

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
    // #endregion

    // #region - Menus
    /**
     * Menu principal para o App de Veículos
     * 
     * @return Opção do usuário (int)
     */
    public static int menu() {

        System.out.println();
        System.out.println();
        //Pensar num outro nome depois
        System.out.println(" XXXXX - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Seja bem vindo ao app! O que você gostaria de fazer?");
        System.out.println("1 - Informações de um veículo");
        System.out.println("2 - Adicionar novo veículo");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        try {
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }

    /**
     * Permite o usuario digitar a placa de um veículo
     * @return - placa do veículo
     */
    public static String digitarPlaca() {
        limparTela();
        System.out.println();
        System.out.println();

        System.out.println(" XXXXX - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Escolha a placa do veículo que deseja buscar");
        try {
            String placa = teclado.nextLine();
            return placa;
        } catch (InputMismatchException ie) {
            return null;
        }
    }

    /**
     * Menu com acesso as opções relacionadas aos veículos
     * @return  Opção do usuário (int)
     */
    public static int menuVeículos() {
        limparTela();
        System.out.println();
        System.out.println();

        System.out.println(" XXXXX - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Bem vindo a tela de veículos, o que gostaria de fazer?");
        System.out.println("1 - Localizar um veículo");
        System.out.println("2 - Calcular IPVA");
        System.out.println("3 - Calcular seguro do veículo");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        try {
            int opcao = teclado.nextInt();
            teclado.nextLine();
            return opcao;
        } catch (InputMismatchException ie) {
            return -1;
        }
    }

    // #endregion

    public static void main(String[] args) throws Exception {
        String caminho = "C:\\Users\\bruno\\OneDrive\\Documentos\\folder\\projetos-3-4-5-grupo-2\\Veiculos.txt";
        Scanner teclado = new Scanner(System.in, "UTF-8");

        carregarDadosVeiculo(caminho);    
        
        int opcao;

            do {
                limparTela();
                opcao = menu();
                switch (opcao) {
                    case 1:
                    int opcaoVeiculo = menuVeículos();
                    switch(opcaoVeiculo){
                        case 1: 
                            String placaVeiculoCase1 = digitarPlaca();
                            System.out.println(localizarVeiculo(placaVeiculoCase1).dadosVeiculo());
                            break;
                    }
                    break;
                }
                pausa();
            } while (opcao != 0);
            teclado.close();
        
    }
        
    
}
