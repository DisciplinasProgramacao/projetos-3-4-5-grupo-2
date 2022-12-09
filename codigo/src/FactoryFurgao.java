public class FactoryFurgao implements IFactory{
    /**
     * Sobreescrita do método create de IFactory para a criação de Furgão
     * @param Dados do Veículo
     * @return Um objeto do tipo Furgão
     */
    @Override
    public Veiculo create(String dadosVeiculo) {
        return new Utilitario(dadosVeiculo, TUtilitario.FURGAO);
    }
}