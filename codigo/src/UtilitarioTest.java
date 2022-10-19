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
    static String placa = "XXX0X00";
    static double valorDeVenda = 90000.00;
    static int kmRodados = 1000;
    static int tanque = 80;

    @BeforeEach
    public void init() {
        novoUtilitario = new Utilitario(placa, valorDeVenda, kmRodados, tanque);
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
