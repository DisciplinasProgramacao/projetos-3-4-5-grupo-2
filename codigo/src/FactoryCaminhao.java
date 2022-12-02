public class FactoryCaminhao implements IFactory{

    @Override
    public Veiculo create(String dadosVeiculo, TUtilitario tipoUtilitario) {
        return new Caminhao(dadosVeiculo);
    }
}
