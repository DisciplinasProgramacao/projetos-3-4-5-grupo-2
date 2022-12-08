public class FactoryCaminhao implements IFactory{

    @Override
    public Veiculo create(String dadosVeiculo) {
        return new Caminhao(dadosVeiculo);
    }
}
