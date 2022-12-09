public class FactoryVan implements IFactory{
    @Override
    public Veiculo create(String dadosVeiculo) {
        return new Utilitario(dadosVeiculo, TUtilitario.VAN);
    }
}