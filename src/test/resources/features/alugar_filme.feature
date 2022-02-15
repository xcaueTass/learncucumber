#		Como - um usuário
#		Eu Quero - cadastrar alugueis de filmes
#		Para que - Eu possa controlar preços e datas

Feature: Sistema Locadora
	
		Scenario:  Deve alugar um filme com sucesso
			Given um filme com estoque de 2 unidades
			And que o preco de alugel seja R$ 3
			When alugar
			Then o preco do aluguel sera R$ 3
			And data de entrega sera em 1 dia
			And o estoque do filme sera 1 unidade
			
		Scenario: Nao deve alugar um filme sem estoque
			Given um filme com estoque de 0 unidades
			When alugar
			Then nao sera possivel por falta de estoque
			And o estoque do filme sera 0 unidade


Scenario Outline: Deve dar condicoes especiais para categoria extendida
			Given um filme com estoque de 2 unidades
			And que o preco de alugel seja R$ <preco>
			And que o tipo do aluguel seja <tipo>
			When alugar
			Then o preco do aluguel sera R$ <valor>
			And data de entrega sera em <qtdDias> dias
			And pontuacao recebida sera de <pontos> pontos

Examples: 
	| preco | tipo       | valor | qtdDias | pontos |
	|   4	  | extendido  |   8   |    3		 |    2   |
	|   4		| comum      |   4   |    1    |    1   |
	|	  5   | semanal    |  15   |    7    |    2   |