public class FactoryCarro implements IFactory {
    /**
     * Sobreescrita do método create de IFactory para a criação de Carro
     * @param Dados do Veículo
     * @return Um objeto do tipo Carro
     */
    @Override
    public Veiculo create(String dadosVeiculo) {
        return new Carro(dadosVeiculo);
    }
}
