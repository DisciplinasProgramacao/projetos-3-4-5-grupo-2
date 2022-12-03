import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class PeNaEstrada {

    // #region Atributos
    private static LinkedList<Veiculo> listaVeiculos = new LinkedList<Veiculo>();
    // #endregion

    /**
     * Método para localizar um veículo
     * 
     * @param placa Dados da placa
     * @return Retorna o veículo desejado, se ele existir
     */
    public static Veiculo localizarVeiculo(String placa) {

        Veiculo veiculoProcurado = null;

        for (int i = 0; i < listaVeiculos.size(); i++) {
            if (listaVeiculos.get(i).getPlaca().equals(placa)) {
                veiculoProcurado = listaVeiculos.get(i);
                break;
            }
        }
        return veiculoProcurado;
    }

    /**
     * Método para carregar os veículos do arquivo de texto
     * 
     * @param nomeArquivo - Nome do arquivo que será lido os dados referentes aos
     *                    veículos
     */
    public static void carregarDadosVeiculo(String caminho) {
        try {
            Path path = Paths.get(caminho.concat("/Veiculos.txt"));
            Scanner sc = new Scanner(path, "UTF-8");
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();

                adicionaVeiculo(linha);
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
        Veiculo[] veiculo = new Veiculo[listaVeiculos.size()];

        for (int i = 0; i < listaVeiculos.size(); i++) {
            bw.write(veiculo[i].toString());
            bw.newLine();
        }

        bw.close();
    }

    /**
     * Override do método toString() para adequar a classe Veiculo
     */
    public static String gerarString(int tipoVeiculo, String placa, String precoVenda, String kmRodados) {
        String tipoVeiculoString = converteParaStringVeiculo(tipoVeiculo);
        StringBuilder dadosVeiculo = new StringBuilder(
                tipoVeiculoString + ";" + placa + ";" + precoVenda + ";" + kmRodados);
        return dadosVeiculo.toString();
    }

    /**
     * Método para transformar em texto
     * 
     * @param input Tipo de veículo
     * @return
     */
    private static String converteParaStringVeiculo(int input) {
        String tipoVeiculo = null;

        switch (input) {
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

    /**
     * Método para criar os diferentes tipos de veículos
     * 
     * @param dadosVeiculo Linha de dados do arquivo
     */
    public static void adicionaVeiculo(String dadosVeiculo) {

        Veiculo newVeiculo = null;

        if (dadosVeiculo.contains("Carro")) {

            FactoryCarro addCarro = null;
            newVeiculo = addCarro.create(dadosVeiculo, null);

        } else if (dadosVeiculo.contains("Caminhao")) {
            FactoryCaminhao addCaminhao = null;
            newVeiculo = addCaminhao.create(dadosVeiculo, null);

        } else {
            FactoryUtilitario addUtilitario = null;

            if (dadosVeiculo.contains("Van")) {
                newVeiculo = addUtilitario.create(dadosVeiculo, TUtilitario.VAN);
            } else {
                newVeiculo = addUtilitario.create(dadosVeiculo, TUtilitario.FURGAO);
            }
        }
        listaVeiculos.add(newVeiculo);

        // Veiculo newVeiculo = null;

        // if (dadosVeiculo.contains("Carro")) {
        // newVeiculo = new Carro(dadosVeiculo);
        // } else if (dadosVeiculo.contains("Caminhao")) {
        // newVeiculo = new Caminhao(dadosVeiculo);
        // } else if (dadosVeiculo.contains("Van")) {
        // newVeiculo = new Utilitario(dadosVeiculo, TUtilitario.VAN);
        // } else
        // newVeiculo = new Utilitario(dadosVeiculo, TUtilitario.FURGAO);

        // listaVeiculos.add(newVeiculo);
    }

    /**
     * Método para adicionar a rota ao veículo
     * 
     * @param data    A data do tipo data
     * @param veiculo O veículo que terá a rota incluída
     * @param kmRota  A distância total da rota em KM
     */
    public static void addRota(Date data, Veiculo veiculo, double kmRota) {
        if (data != null && veiculo != null && kmRota > 0.0) {
            veiculo.incluirRota(data, kmRota);
            System.out.println(String.format("\nRota incluida com sucesso. \nData: %td \nQuilometros da rota: %.2f",
                    data, kmRota));
        } else {
            System.out.println("\nNão foi possível adicionar a rota");
        }
    }

    /**
     * Método para adicionar custo a um veículo
     * 
     * @param veiculo   o veiculo que terá o custo adicionado
     * @param descricao descrição do custo
     * @param valor     valor do custo
     */
    public static void addCusto(Veiculo veiculo, String descricao, double valor) {
        veiculo.incluirCusto(descricao, valor);
        System.out.println(
                String.format("\nNovo custo adicionado no veículo. \nDescrição: %s \nValor: %.2f", descricao, valor));
    }

    /**
     * Metodo retorna os três veículos com mais rotas feitas
     */
    public static void topTresRotas() {
        System.out.println("\n3 veículos com mais rotas realizadas: ");
        listaVeiculos.stream()
                .sorted((v1, v2) -> v1.maiorQuantRotas(v2))
                .limit(3)
                .forEach(p -> System.out.println("\n------------" +
                        "\nPlaca: " + p.getPlaca() +
                        "\nQuantidade de rotas: " + p.getRotas().size() +
                        "\n------------"));
    }

    /**
     * Método retorna as rotas pela data
     * 
     * @param data A data desejada para buscar nas rotas
     */
    public static void listaRotasPorData(Date data) {
        listaVeiculos.stream()
                .forEach(v -> v.getRotas().stream()
                        .filter(r -> r.getDate().equals(data))
                        .forEach(r -> System.out.println("\n------------" +
                                "\nVeiculo: " + v.getPlaca() +
                                "\nKM da rota: " + r.getKmRota() +
                                "\nData: " + r.getDate() +
                                "\n------------")));
    }

    /**
     * Método de média geral de todas as rotas feitas
     */
    public static void totalKmAvgRotas() {
        double mediaRotas = listaVeiculos.stream()
                .mapToDouble(Veiculo::totalRotas)
                .average()
                .getAsDouble();

        System.out.println("\nMédia de rotas realizadas pela empresa em km " + mediaRotas);
    }

    /**
     * Método para listar os veículos da frota por custo
     */
    public static void listarVeiculosPorCusto() {

        System.out.println("Lista de veículos com custos gerados em ordem decrescente: ");

        listaVeiculos.stream()
                .sorted(Comparator.comparingDouble(Veiculo::getCustosGerados).reversed()) //// X1 should be class name
                .filter(v -> v.getCustosGerados() >= 1)
                .forEach(v -> System.out.println("\n------------" +
                        "\nVeiculo: " + v.getPlaca() +
                        "\nCusto Gerado: " + v.getCustosGerados() +
                        "\n------------"));
    }

    /**
     * Método para abaster o veículo
     * 
     * @param veiculo       Veiculo deseja para abastecer
     * @param tpCombustivel Tipo do combustivel para abastecer
     */
    public static void abastecerVeiculo(Veiculo veiculo, TCombustivel tpCombustivel) {
        try {
            if (validaCombustivelVeiculo(veiculo, tpCombustivel)) {
                veiculo.tanque.completarTanque();
                System.out.println("\nTanque completo" +
                        "\nTipo de combustivel:" + veiculo.tanque.getTCombustivel() +
                        "\nQuantidade adicionada:" + veiculo.tanque.combustivelAdd() +
                        "\nValor do abastecimento:" + veiculo.tanque.valorAbastecimento() +
                        "\nQuilometros totais percorríveis com o tanque cheio: "
                        + veiculo.tanque.kmPercorridosCombustivelTotal());
            }
        } catch (CombustivelException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean validaCombustivelVeiculo(Veiculo v, TCombustivel tpCombustivel) throws Exception {
        boolean valido = false;
        if (v.retornaCombustivelVeiculo().indexOf(tpCombustivel) == -1)
            throw new CombustivelException("Combustível inválido para o tipo de veículo.");
        else
            valido = true;

        return valido;
    }

}