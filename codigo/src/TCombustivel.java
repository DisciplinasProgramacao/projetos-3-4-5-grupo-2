public enum TCombustivel {
    
    GASOLINA(12, 4.80),
    ETANOL(8, 3.65),
    DIESEL(3.5, 6.65);

    private double consumoMedio;
    private double preco;

    private TCombustivel(double consumoMedio, double preco) {
        this.consumoMedio = consumoMedio;
        this.preco = preco;
    }

}