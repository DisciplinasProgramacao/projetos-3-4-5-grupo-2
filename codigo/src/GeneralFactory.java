import javax.management.InvalidAttributeValueException;

public class GeneralFactory {
    
    static Veiculo criarVeiculo(String dados) throws InvalidAttributeValueException{
        
        switch (dados.toLowerCase()){
            case "carro": return new Carro(dados);
            case "caminhao": return new Caminhao(dados);
            case "utilitario": return new Utilitario(dados); //concatenar
            default: throw new InvalidAttributeValueException("Tipo de comida inexistente");
        }
    }   
}
    
    
}
