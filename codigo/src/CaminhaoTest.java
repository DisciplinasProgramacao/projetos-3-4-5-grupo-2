import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CaminhaoTest {
    
    static Caminhao novoCaminhao;
    static String placa = "XXX0X00";
    static double valorDeVenda = 600000.00;
    static int kmRodados = 1000;
    
    @BeforeEach
    public void init() {
        novoCaminhao = new Caminhao(placa, valorDeVenda, kmRodados);
    }

    @Test
    public void calcularIpvaDoCarro() {
        assertEquals(6000, novoCaminhao.calcularIPVA());
    }

    @Test
    public void calcularSeguroDoCarro(){
        assertEquals(14000, novoCaminhao.calcularSeguro());
    }    
}
