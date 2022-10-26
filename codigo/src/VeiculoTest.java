import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class VeiculoTest {

    /*
    * PLANO DE TESTES DA CLASSE UTILITÁRIO
    * - Calculo de IPVA ✔️
    * - Calculo de seguro ✔️
    */
        
    static Veiculo novoVeiculo;
    static String dados = "Carro;GYE-9781;40k A7JsLJ AT Bv0967;90000;1000;2010;Azul";

    @BeforeEach
    public void init() {
        novoVeiculo = new Veiculo(dados);
    }

    @Test
    public void calcularIpvaDoVeiculo() {
        assertEquals(2700, novoVeiculo.calcularIPVA());
    }

    @Test
    public void calcularSeguroDoVeiculo(){
        assertEquals(2700, novoVeiculo.calcularSeguro());
    }

}