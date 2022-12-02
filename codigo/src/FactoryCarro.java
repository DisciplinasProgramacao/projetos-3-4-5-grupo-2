public class FactoryCarro implements IFactory {
    
    @Override
    public Veiculo create(String dadosVeiculo, TUtilitario tipoUtilitario) {
        return new Carro(dadosVeiculo);
    }
}
