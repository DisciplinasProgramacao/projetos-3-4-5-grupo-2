public class FactoryFurgao implements IFactory{
    @Override
    public Veiculo create(String dadosVeiculo) {
        return new Utilitario(dadosVeiculo, TUtilitario.FURGAO);
    }
}