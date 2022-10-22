import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class UtilitarioTest {

        /*
     * PLANO DE TESTES DA CLASSE UTILITÁRIO
     * - Calculo de IPVA ✔️
     * - Calculo de seguro ✔️
     */
        
    static Utilitario novoUtilitario;
    static String dados = "Utilitario;GYE-9781;40k A7JsLJ AT Bv0967;90000;1000;2010;Azul";
    static int tanque = 80;

    @BeforeEach
    public void init() {
        novoUtilitario = new Utilitario(dados, tanque);
    }

    @Test
    public void calcularIpvaDoUtilitario() {
        assertEquals(2700, novoUtilitario.calcularIPVA());
    }

    @Test
    public void calcularSeguroDoUtilitario(){
        assertEquals(2700, novoUtilitario.calcularSeguro());
    }

}
