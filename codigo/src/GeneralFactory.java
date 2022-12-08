import javax.management.InvalidAttributeValueException;

public class GeneralFactory {
    
    static Veiculo criarVeiculo(String dados) throws InvalidAttributeValueException{
        
        switch (dados.toLowerCase()){
            case "carro": return new Carro(dados);
            case "caminhao": return new Caminhao(dados);
            case "van": return new Utilitario(dados, TUtilitario.VAN ); //concatenar
            case "furgao": return new Utilitario(dados, TUtilitario.FURGAO);
            default: throw new InvalidAttributeValueException("Tipo de veiculo inexistente");
        }
    }   
}

