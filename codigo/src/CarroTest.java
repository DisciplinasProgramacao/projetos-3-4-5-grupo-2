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
    static String dados = "Carro;GYE-9781;40k A7JsLJ AT Bv0967;30000;1000;2010;Azul";

    
    @BeforeEach
    public void init() {
        novoCarro = new Carro(dados);
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
