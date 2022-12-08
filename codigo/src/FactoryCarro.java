public class FactoryCarro implements IFactory {
    
    @Override
    public Veiculo create(String dadosVeiculo) {
        return new Carro(dadosVeiculo);
    }
}
