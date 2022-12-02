public class FactoryUtilitario implements IFactory{

    @Override
    public Veiculo create(String dadosVeiculo, TUtilitario tipoUtilitario) {
        return new Utilitario(dadosVeiculo, tipoUtilitario);
    }
}
