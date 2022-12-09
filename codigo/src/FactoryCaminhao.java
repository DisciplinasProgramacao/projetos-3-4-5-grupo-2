public class FactoryCaminhao implements IFactory{

    /**
     * Sobreescrita do método create de IFactory para a criação de Caminhão
     * @param Dados do Veículo
     * @return Um objeto do tipo Caminhão
     */
    @Override
    public Veiculo create(String dadosVeiculo) {
        return new Caminhao(dadosVeiculo);
    }
}
