public interface IFactory {
    /**
     * Método abstrato da interface IFactory as factories de veículos deverão implementar
     * @param dadosVeiculo
     * @return
     */
    public Veiculo create(String dadosVeiculo);
}