package aprendercucumber.steps;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import aprendercucumber.utils.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LearnCucumberSteps {

	// Cenario criação de arquivo
	@Given("^criei o arquivo corretamente$")
	public void crieiOArquivoCorretamente() {
		System.out.println("Criado arquivo cucumber");
	}

	@When("^Executa-lo$")
	public void executaLo() {
		System.out.println("Executado arquivo cucumber");
	}

	@Then("^Especificacao finalizar com sucesso$")
	public void especificacaoFinalizarComSucesso() {
		System.out.println("Arquivo executado com sucesso");
	}

	// Cenario contador
	private int contador = 0;

	@Given("^que o valor do contador e (\\d+)$")
	public void queOValorDoContadorE(int arg1) {
		contador = arg1;
	}

	@When("^se implementar em (\\d+)$")
	public void seImplementarEm(int arg1) {
		contador = contador + arg1;
	}

	@Then("^o valor do contador sera (\\d+)$")
	public void oValorDoContadorSera(int arg1) {
		assertEquals(arg1, contador);
	}

	// Cenario Atraso de dia
	private Date entrega = new Date();

	@Given("^entrega dia (.*)$")
	public void entregaDia(@Transform(DateConverter.class) Date data) {
		entrega = data;
	}

	@When("^entrega atrasar (\\d+) (dia|dias|mes|meses)$")
	public void entregaAtrasarDias(int arg1, String tempo) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);

		if (tempo.equalsIgnoreCase("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, arg1);
		} else {
			cal.add(Calendar.MONTH, arg1);
		}

		entrega = cal.getTime();
	}

	@Then("^entrega sera efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void entregaSeraEfetuadaEm(String data) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormat = format.format(entrega);
		assertEquals(data, dateFormat);
	}

	// 
	@Given("^o ticket( especial)? e A.(\\d{3})$")
	public void oTicketEAF(String tipo, String arg1) {
	}

	@Given("^o valor da passagem e R\\$ (.*)$")
	public void oValorDaPassagemER$(double valor) {
	}

	@Given("^o nome do passageiro e \"(.{5,20})\"$")
	public void oNomeDoPassageiroE(String arg1) {
	}

	@Given("^o telefone do passageiro e (9\\d{3}-\\d+)$")
	public void oTelefoneDoPassageiroE(String telefone) {
	}

	@When("^criar os steps$")
	public void criarOsSteps() {
	}

	@Then("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() {
	}

}