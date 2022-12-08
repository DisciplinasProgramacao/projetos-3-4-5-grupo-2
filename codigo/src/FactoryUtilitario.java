public class FactoryUtilitario implements IFactory{

    @Override
    public Veiculo create(String dadosVeiculo) {
        return new Utilitario(dadosVeiculo);
    }
}
