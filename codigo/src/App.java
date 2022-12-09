import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.management.InvalidAttributeValueException;

public class App {

    // #region variáveis auxiliares
    private static Scanner teclado = new Scanner(System.in, "UTF-8");
    private static String caminho = "C:/Users/bruno/OneDrive/Documentos/folder/projetos-3-4-5-grupo-2";
    // #endregion

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in, "UTF-8");

        carregarDadosVeiculo(caminho);

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
                    buscarRotasPorData();
                    break;
                case 5:
                    PeNaEstrada.totalKmAvgRotas();
                    break;
                case 6:
                    PeNaEstrada.listarVeiculosPorCusto();
                    break;
            }
            pausa();
        } while (opcao != 0);
        teclado.close();

    }
    
    /**
     * Método para carregar os veículos do arquivo de texto
     * 
     * @param nomeArquivo - Nome do arquivo que será lido os dados referentes aos
     *                    veículos
     * @throws InvalidAttributeValueException
     */
    public static void carregarDadosVeiculo(String caminho) throws InvalidAttributeValueException {
        try {
            Path path = Paths.get(caminho.concat("/Veiculos.txt"));
            Scanner sc = new Scanner(path, "UTF-8");
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                Veiculo newVeiculo = GeneralFactory.criarVeiculo(linha);
                PeNaEstrada.adicionaVeiculo(newVeiculo);
            }
            sc.close();
        } catch (IOException io) {
            System.out.println("Erro ao abrir arquivo");
        }
    }

    /**
     * Método para salvar os veículos
     * 
     * @param caminhoArquivo Caminho do arquivo de texto onde os objetos serão
     *                       salvos
     * @throws IOException
     */
    public void salvar(String caminhoArquivo) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo));
        Veiculo[] veiculo = new Veiculo[PeNaEstrada.getListaVeiculos().size()];

        for (int i = 0; i < PeNaEstrada.getListaVeiculos().size(); i++) {
            bw.write(veiculo[i].toString());
            bw.newLine();
        }

        bw.close();
    }
    /**
     * Menu para abastecimento do veículo
     * @param placaVeiculo placa do Veículo
     */
    private static void menuAbastecimento(String placaVeiculo) {
        TCombustivel tpCombustivel = null;
        
        System.out.println("\nInforme o combustível para abastecimento");
        System.out.println("1 - Gasolina");
        System.out.println("2 - Etanol");
        System.out.println("3 - Disel");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");
        int opcao;

        try {
            opcao = teclado.nextInt();
            teclado.nextLine();

        } catch (InputMismatchException ie) {
            opcao = 0;
        }

        switch (opcao) {
            case 1:
                tpCombustivel = TCombustivel.GASOLINA;
                break;
            case 2:
                tpCombustivel = TCombustivel.ETANOL;
                break;
            case 3:
                tpCombustivel = TCombustivel.DIESEL;
                break;
        }
        PeNaEstrada.abastecerVeiculo(PeNaEstrada.localizarVeiculo(placaVeiculo), tpCombustivel);
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
        System.out.println("\n PéNaEstrada - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Seja bem vindo ao app! O que você gostaria de fazer?");
        System.out.println("1 - Informações de um veículo");
        System.out.println("2 - Adicionar novo veículo");
        System.out.println("3 - Top três - Veículos com mais rotas realizadas");
        System.out.println("4 - Buscar rotas por data");
        System.out.println("5 - Média da quilometragem de todas as rotas");
        System.out.println("6 - Lista de veículos ordenada decrescentemente por custos gerados");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");
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
        System.out.println("\n PéNaEstrada - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Bem vindo a tela de veículos, o que gostaria de fazer?");
        System.out.println("1 - Visualizar informações básicas");
        System.out.println("2 - Adicionar nova rota");
        System.out.println("3 - Adicionar manutenção não programada");
        System.out.println("4 - Abastecer veículo");
        System.out.println("5 - Calcular gastos totais");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");
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

        System.out.println("\n PéNaEstrada - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Selecione o tipo de veículo que deseja adicionar");
        System.out.println("1 - Carro");
        System.out.println("2 - Utilitário");
        System.out.println("3 - Caminhão");
        System.out.println("0 - Sair");
        System.out.print("\nDigite sua opção: ");
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
     * Método para pegar os dados do usuário
     * @return o valor ou null caso haja uma exeção
     */
    public static String digitarDados() {
        System.out.println();
        try {
            String valor = teclado.nextLine();
            return valor;
        } catch (InputMismatchException ie) {
            return null;
        }
    }
    // #endregion

    // #region métodos menu
    // SEGUNDO MENU
    private static void informacoesVeiculo() throws ParseException {
        limparTela();
        System.out.println(" PéNaEstrada - O seu administrador de veículos");
        System.out.println("===============================================");
        System.out.println("Digite a placa do veículo:");
        String placaVeiculo = digitarDados();
        int opcaoVeiculo = menuVeiculos();

        switch (opcaoVeiculo) {
            case 1:
                buscarVeiculo(placaVeiculo);
            break;
            case 2:
                addRota(placaVeiculo);
            break;
            case 3:
                addCusto(placaVeiculo);
                break;
            case 4:
                menuAbastecimento(placaVeiculo);
            break;
            case 5:
                custosTotais(placaVeiculo); 
            break;
        }
    }

    /**
     * Método para mopstar os custos totais 
     * @param placa Placa do veículo
     */
    private static void custosTotais(String placa) {
        PeNaEstrada.localizarVeiculo(placa).tipoDeCusto();

        System.out.println("Custos totais do veículo:");
        System.out.println("R$" + PeNaEstrada.localizarVeiculo(placa).getCustosGerados());
    }

    /**
     * Método para buscar um veículo
     * @param placa Placa do veículo
     */
    private static void buscarVeiculo(String placa) {
        System.out.println(PeNaEstrada.localizarVeiculo(placa).dadosVeiculo());
    }

    /**
     * Método para adicionar um veículo a frota
     * @throws InvalidAttributeValueException
     */
    private static void addVeiculo() throws InvalidAttributeValueException {
        int veiculoEscolhido = menuSelecaoVeiculo();
        System.out.println(" PéNaEstrada - O seu administrador de veículos");
        System.out.println("========================================");
        System.out.println("Digite a placa do veículo:");
        String placaVeiculo = digitarDados();
        System.out.println("\nAgora escolha o valor de venda do veículo:\n");
        String valorDeVenda = digitarDados();
        System.out.println("\nInsira a quantidade de km rodados do veículo:\n");
        String valorKmRodados = digitarDados();
        String dadosNovoVeiculo = PeNaEstrada.gerarString(veiculoEscolhido, placaVeiculo, valorDeVenda, valorKmRodados);
        Veiculo addVeiculo = GeneralFactory.criarVeiculo(dadosNovoVeiculo);
        PeNaEstrada.adicionaVeiculo(addVeiculo);
        System.out.println("Veiculo criado com sucesso:"+ PeNaEstrada.localizarVeiculo(placaVeiculo).dadosVeiculo());
    }

    /**
     * Método para buscar rotas por data
     */
    private static void buscarRotasPorData() {
        Date data = capturarData("Digite a data para a busca. (Digite no formato dd/MM/AAAA)");
        PeNaEstrada.listaRotasPorData(data);
    }

    /**
     * Método para adicionar rota
     * @param placaVeiculo Placa do veículo
     */
    private static void addRota(String placaVeiculo) {
        Date date = capturarData("\nEm qual data a rota será executada? (Digite no formato dd/MM/AAAA)");
        System.out.println("\nQuantos quilômetros de rota?");
        
        try {
            double km = teclado.nextDouble();
            PeNaEstrada.addRota(date, PeNaEstrada.localizarVeiculo(placaVeiculo), km);
        } catch (InputMismatchException ime) {
            System.out.println("Valor dos quilometros deve ser decimal.");
            
        } 
    }

    /**
     * Método para adicionar custos a um veículo da frota
     * @param placaVeiculo Placa do veículo
     */
    private static void addCusto(String placaVeiculo) {
        System.out.println("\nDigite a descrição do custo");
        String descricao = teclado.nextLine();
        System.out.println("\nDigite o valor do custo");
        
        try {
            double valor = teclado.nextDouble();
            PeNaEstrada.addCusto(PeNaEstrada.localizarVeiculo(placaVeiculo), descricao, valor);
        } catch (InputMismatchException ime) {
            System.out.println("Valor do custo deve ser decimal.");
        }
    }
    /**
     * Método para capturar a data
     * @param mensagem Mensagem a ser registrada
     * @return data formatada dd/mm/yyyyy
     */
    private static Date capturarData(String mensagem)  {
        System.out.println(mensagem);
        String data = teclado.nextLine();;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = null;

        try {
            dataFormatada = formatter.parse(data);
        } catch (ParseException pe) {
            System.out.println("Formato de data invalida.");
            capturarData(mensagem);
        }

        return dataFormatada;
    }
    // #endregion

}
