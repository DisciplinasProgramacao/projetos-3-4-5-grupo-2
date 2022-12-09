# Projeto 4 - Gestão de Frota (parte 2)

## Nota: 15

## Comentários
	- Pessoal, cadê o diagrama de vocês? Acho que o projeto da Frota não teve ele em nenhum checkout meu.
	- tipoDeCusto() em carro deve ser privado. Não vejo função pública para ela. X
	
## Correção

### Modelagem: 0/2   
	- Modularização de tanque e combustível
	
### Requisitos dos veículos, de acordo com a modelagem: 6/9  
	- Restrição de combustível: 1,5/3 -- está lá, mas cada veículo só tem 1 opção fixa no construtor
	- Abastecimento e autonomia: 2/3 -- pode recusar a rota pela autonomia | abastece mas não registra o custo? X
	- Custos fixos e variáveis: 2,5/3  -- não registrou um custo variável em um novo caminhão X
	
### Requisitos da empresa no programa principal: 9/9 
	- Quilometragem média das rotas da empresa: 3/3 
	- Filtro para busca de rotas por data: 3/3  
	- Um dos dois abaixo: 3/3
		- Os 3 veículos que mais fizeram rotas 
		- Lista de veículos ordenada decrescentemente por custos gerados 

