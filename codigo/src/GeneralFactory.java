import javax.management.InvalidAttributeValueException;

public class GeneralFactory {

    /**
     * Método para chamar as fábricas adquadas dos véiculos
     * @param dados Dados para a criação do veículo
     * @return Veículo do tipo necessário
     * @throws InvalidAttributeValueException
     */
    static Veiculo criarVeiculo(String dados) throws InvalidAttributeValueException{

        String[] splitDados = dados.split(";");
        String tipoVeiculo = splitDados[0];
        
        switch (tipoVeiculo.toLowerCase()) {
            case "carro": return new FactoryCarro().create(dados);
            case "caminhao": return new FactoryCaminhao().create(dados);
            case "van": return new FactoryVan().create(dados); 
            case "furgao": return new FactoryFurgao().create(dados);
            default: throw new InvalidAttributeValueException("Tipo de veiculo inexistente");
        }
    }
}

