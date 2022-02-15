package aprendercucumber.steps;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import aprendercucumber.entities.Filme;
import aprendercucumber.entities.NotaDeAluguel;
import aprendercucumber.entities.TipoAluguel;
import aprendercucumber.services.AlguelService;
import aprendercucumber.utils.CalendarUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AlugarFilmeSteps {

	private Filme filme;
	private AlguelService aluguelService = new AlguelService();
	private NotaDeAluguel notaDeAluguel;
	private String erro;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

	@Given("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int estoque) {
		filme = new Filme();
		filme.setEstoque(estoque);
	}

	@Given("^que o preco de alugel seja R\\$ (\\d+)$")
	public void queOPrecoDeAlugelSejaR$(int precoAluguel) {
		filme.setAluguel(precoAluguel);
	}

	@When("^alugar$")
	public void alugar() {
		try {
			notaDeAluguel = aluguelService.alugar(filme, tipoAluguel);
		} catch (RuntimeException e) {
			erro = e.getMessage();
		}
	}

	@Then("^o preco do aluguel sera R\\$ (\\d+)$")
	public void oPrecoDoAluguelSeraR$(int precoAluguel) {
		assertEquals(precoAluguel, notaDeAluguel.getPreco());
	}

	@Then("^o estoque do filme sera (\\d+) unidade$")
	public void oEstoqueDoFilmeSeraUnidade(int estoqueFilme) {
		assertEquals(estoqueFilme, filme.getEstoque());
	}

	@Then("^nao sera possivel por falta de estoque$")
	public void naoSeraPossivelPorFaltaDeEstoque() {
		assertEquals("Filme sem estoque", erro);
	}

	@Given("^que o tipo do aluguel seja (.*)$")
	public void queOTipoDoAluguelSejaExtendido(String tipo) {
		tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL
				: tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
	}

	@Then("^data de entrega sera em (\\d+) dias?$")
	public void dataDeEntregaSeraEmDias(int dias) {
		Date dataEsperada = CalendarUtil.obterDataDiferencaDias(dias);
		Date dataReal = notaDeAluguel.getDataEntrega();

		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Then("^pontuacao recebida sera de (\\d+) pontos?$")
	public void pontuacaoRecebidaSeraDePontos(int pontuacao) {

		assertEquals(pontuacao, notaDeAluguel.getPontuacao());
	}

//	@Then("^data de entrega sera no dia seguinte$")
//	public void dataDeEntregaSeraNoDiaSeguinte() {
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_MONTH, 1);
//
//		Date dataRetorno = notaDeAluguel.getDataEntrega();
//		Calendar calRetorno = Calendar.getInstance();
//		calRetorno.setTime(dataRetorno);
//
//		assertEquals(cal.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
//		assertEquals(cal.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
//		assertEquals(cal.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
//	}

}
