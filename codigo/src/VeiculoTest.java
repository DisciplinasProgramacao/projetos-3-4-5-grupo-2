import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class VeiculoTest {

    /*
    * PLANO DE TESTES DA CLASSE VEÍCULO
    * - Calculo de IPVA ✔️
    * - Calculo de seguro ✔️
    * - Calculo de outros custos ✔️
    * - Calculo de gastos totais ✔️
    */
        
    static Veiculo novoVeiculo;
    static String dados = "Carro;GYE-9781;90000;75000";

    @BeforeEach
    public void init() {
        novoVeiculo = new Carro(dados);
    }

    @Test
    public void calcularIpvaDoVeiculo() {
        assertEquals(3600, novoVeiculo.calcularIPVA());
    }

    @Test
    public void calcularSeguroDoVeiculo(){
        assertEquals(4800, novoVeiculo.calcularSeguro());
    }

    @Test
    public void calcularOutrosCustos(){
        assertEquals(600, novoVeiculo.calcularOutrosCustos());
    }

    @Test
    public void calcularGastosTotais(){
        assertEquals(9000, novoVeiculo.calcularGastosTotais());
    }

}