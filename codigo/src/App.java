import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // #region variáveis auxiliares
    private static Scanner teclado = new Scanner(System.in, "UTF-8");
    private static String caminho = "C:/Users/danie/OneDrive/Área de Trabalho/PUC/PM/LAB/projetos-3-4-5-grupo-2";
    // #endregion

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in, "UTF-8");

        PeNaEstrada.carregarDadosVeiculo(caminho);

        int opcao;

        do {
            limparTela();
            opcao = menu();
            switch (opcao) {
                case 1:
                    informacoesVeiculo();
                    break;
                case 2:
                    addVeiculo();
                    break;
                case 3:
                    PeNaEstrada.topTresRotas();
                    break;
                case 4:
                    addRota();
                    break;
                case 5:
                    buscarRotasPorData();
                    break;
                case 6:
                    PeNaEstrada.totalKmAvgRotas();
                    break;
                case 7:
                    addCusto();
                    break;
                case 8:
                    menuAbastecimento();
                    break;
            }
            pausa();
        } while (opcao != 0);
        teclado.close();

    }

    private static void menuAbastecimento() {
        String placaVeiculo = digitarPlaca();
        System.out.println("Informe o combustível para abastecimento");
        System.out.println("1 - Gasolina");
        System.out.println("2 - Etanol");
        System.out.println("3 - Disel");
        System.out.println("0 - Sair");
        System.out.print("Digite sua opção: ");
        int opcao;

        try {
            opcao = teclado.nextInt();
            teclado.nextLine();

        } catch (InputMismatchException ie) {
            opcao = 0;
        }        

        switch (opcao) {
            case 1:
                PeNaEstrada.
                break;
            case 2:
                addVeiculo();
                break;
            case 3:
                PeNaEstrada.topTresRotas();
                break;
        }      
        pausa(); 
    }

    // #region - Menus
    /**
     * Menu principal para o App de Veículos
     * 
     * @return Opção do usuário (int)
     */
    public static int menu() {
        System.out.println();
        System.out.println();
        // Pensar num outro nome depois
        System.out.println(" PéNaEstrada - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Seja bem vindo ao app! O que você gostaria de fazer?");
        System.out.println("1 - Informações de um veículo");
        System.out.println("2 - Adicionar novo veículo");
        System.out.println("3 - Top três - Veículos com mais rotas realizadas");
        System.out.println("4 - Adicionar nova rota");
        System.out.println("5 - Buscar rotas por data");
        System.out.println("6 - Média da quilometragem de todas as rotas");
        System.out.println("7 - Adicionar novo custo");
        System.out.println("8 - Abastecer veículo");
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
     * Menu com acesso as opções relacionadas aos veículos
     * 
     * @return Opção do usuário (int)
     */
    public static int menuVeiculos() {
        limparTela();
        System.out.println();
        System.out.println();

        System.out.println(" PéNaEstrada - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Bem vindo a tela de veículos, o que gostaria de fazer?");
        System.out.println("1 - Visualizar informações básicas");
        System.out.println("2 - Calcular IPVA");
        System.out.println("3 - Calcular seguro do veículo");
        System.out.println("4 - Calcular outros custos");
        System.out.println("5 - Calcular gastos totais");
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
     * Menu com acesso as opções relacionadas aos veículos
     * 
     * @return Opção do usuário (int)
     */
    public static int menuSelecaoVeiculo() {
        limparTela();
        System.out.println();
        System.out.println();

        System.out.println(" PéNaEstrada - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Selecione o tipo de veículo que deseja adicionar");
        System.out.println("1 - Carro");
        System.out.println("2 - Utilitário");
        System.out.println("3 - Caminhão");
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

    // #region métodos de tela
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

    /**
     * Permite o usuario digitar o nome de um autor
     * 
     * @return - nome do autor
     */
    public static String digitarAutor() {
        limparTela();
        System.out.println();
        System.out.println();

        System.out.println(" PéNaEstrada - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Digite o nome da placa do veículo");
        try {
            String nome = teclado.nextLine();
            return nome;
        } catch (InputMismatchException ie) {
            return null;
        }
    }

    /**
     * Permite o usuario digitar a placa de um veículo
     * 
     * @return - placa do veículo
     */
    public static String digitarPlaca() {
        limparTela();
        System.out.println();
        System.out.println();

        System.out.println(" PéNaEstrada - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Escolha a placa do veículo que deseja buscar");
        try {
            String placa = teclado.nextLine();
            return placa;
        } catch (InputMismatchException ie) {
            return null;
        }
    }

    public static String digitarValor() {
        limparTela();
        System.out.println();
        System.out.println();

        System.out.println(" PéNaEstrada - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Digite o valor desejado");
        try {
            String placa = teclado.nextLine();
            return placa;
        } catch (InputMismatchException ie) {
            return null;
        }
    }
    // #endregion

    // #region métodos menu
    private static void informacoesVeiculo() {
        int opcaoVeiculo = menuVeiculos();
        switch (opcaoVeiculo) {
            case 1:
                buscarVeiculo();
        }
    }

    private static void buscarVeiculo() {
        String placaVeiculoCase1 = digitarPlaca();
        System.out.println(PeNaEstrada.localizarVeiculo(placaVeiculoCase1).dadosVeiculo());
    }

    private static void addVeiculo() {
        int veiculoEscolhido = menuSelecaoVeiculo();
        String placaVeiculo = digitarPlaca();
        System.out.println("\nAgora escolha o valor de venda do veículo:\n");
        String valorDeVenda = digitarValor();
        System.out.println("\nAgora escolha o valor da quantidade de km rodados:\n");
        String valorKmRodados = digitarValor();
        String dadosNovoVeiculo = PeNaEstrada.gerarString(veiculoEscolhido, placaVeiculo, valorDeVenda, valorKmRodados);
        PeNaEstrada.adicionaVeiculo(dadosNovoVeiculo);
        System.out.println("Veiculo criado com sucesso");
    }

    private static void buscarRotasPorData() throws ParseException {
        Date data = capturarData("Digite a data para a busca. (Digite no formato dd/MM/AAAA)");
        PeNaEstrada.listaRotasPorData(data);
    }

    private static void addRota() throws ParseException {
        String placaVeiculo = digitarPlaca();
        Date date = capturarData("Em qual data a rota será executada? (Digite no formato dd/MM/AAAA)");
        System.out.println("Quantos quilômetros de rota?");
        double km = teclado.nextDouble();
        PeNaEstrada.addRota(date, PeNaEstrada.localizarVeiculo(placaVeiculo), km);
    }

    private static void addCusto() {
        String placaVeiculo = digitarPlaca();
        System.out.println("Digite a descrição do custo");

        String descricao = teclado.nextLine();

        System.out.println("Digite o valor do custo");

        double valor = teclado.nextDouble();

        PeNaEstrada.addCusto(PeNaEstrada.localizarVeiculo(placaVeiculo),descricao, valor);
    }

    private static Date capturarData(String mensagem) throws ParseException{
        System.out.println(mensagem);
        String data = teclado.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return  formatter.parse(data);   
    }
    // #endregion

}
