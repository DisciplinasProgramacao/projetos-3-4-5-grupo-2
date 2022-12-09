public class FactoryVan implements IFactory{
    /**
     * Sobreescrita do método create de IFactory para a criação de Van
     * @param Dados do Veículo
     * @return Um objeto do tipo Van
     */
    @Override
    public Veiculo create(String dadosVeiculo) {
        return new Utilitario(dadosVeiculo, TUtilitario.VAN);
    }
}