#		Como - um aluno
#		Eu Quero - Aprender utilizar Cucumber
#		Para que - Eu possa automatizar criterios de aceitacao


Feature: Aprender Cucumber

	Scenario: Deve executar especificacao
		Given criei o arquivo corretamente
		When Executa-lo
		Then Especificacao finalizar com sucesso
		
	Scenario: Deve implementar contador
		Given que o valor do contador e 15
		When se implementar em 3
		Then o valor do contador sera 18
		
	Scenario: Deve implementar contador para reutilizar codigo
		Given que o valor do contador e 123
		When se implementar em 35
		Then o valor do contador sera 158
		
	Scenario: Deve calcular atraso na entrega em dias
		Given entrega dia 05/04/2018
		When entrega atrasar 2 dias
		Then entrega sera efetuada em 07/04/2018
		
	Scenario: Deve calcular atraso na entrega em meses
		Given entrega dia 05/04/2018
		When entrega atrasar 2 meses
		Then entrega sera efetuada em 05/06/2018
	
	Scenario: Deve criar steps genericos para estes passos
		Given o ticket e AF345
		And o valor da passagem e R$ 230,45
		And o nome do passageiro e "Fulano da Silva"
		And o telefone do passageiro e 9999-9999
		When criar os steps
		Then o teste vai funcionar
		
	Scenario: Deve reaproveitar os steps "Dado" do cenario anterior
		Given o ticket e AB167
		Given o ticket especial e AB167
		Given o valor da passagem e R$ 1120,23
		Given o nome do passageiro e "Cicrano de Oliveira"
		Given o telefone do passageiro e 9888-8888
		
	@ignore
	Scenario: Deve negar todos os steps "Dado" do cenario anterior
		Given o ticket e CD123
		Given o ticket especial e AG1234
		Given o valor da passagem e R$ 1.1345,56
		Given o nome do passageiro e "Beltrano Souza Matos de Alcântara Azevedo"
		Given o telefone do passageiro e 1234-5678
		Given o telefone do passageiro e 999-2223
