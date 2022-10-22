import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CaminhaoTest {

    /*
     * PLANO DE TESTES DA CLASSE CAMINHAO
     * - Calculo de IPVA ✔️
     * - Calculo de seguro ✔️
     */
    
    static Caminhao novoCaminhao;
    static String dados = "Caminhao;HIB-2593;7b7 2sNmnt 52 A81817; 600000;1000;2010;Azul";
    
    
    @BeforeEach
    public void init() {
        novoCaminhao = new Caminhao(dados);
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
