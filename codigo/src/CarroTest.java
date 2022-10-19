import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

    /*
     * PLANO DE TESTES DA CLASSE CARRO
     * - Calculo de IPVA ✔️
     * - Calculo de seguro ✔️
     */

public class CarroTest {
    
    static Carro novoCarro;
    static String placa = "XXX0X00";
    static double valorDeVenda = 30000.00;
    static int kmRodados = 1000;
    
    @BeforeEach
    public void init() {
        novoCarro = new Carro(placa, valorDeVenda, kmRodados);
    }

    @Test
    public void calcularIpvaDoCarro() {
        assertEquals(1200, novoCarro.calcularIPVA());
    }

    @Test
    public void calcularSeguroDoCarro(){
        assertEquals(1800, novoCarro.calcularSeguro());
    }

}
