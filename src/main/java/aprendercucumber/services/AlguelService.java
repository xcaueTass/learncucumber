package aprendercucumber.services;

import aprendercucumber.entities.Filme;
import aprendercucumber.entities.NotaDeAluguel;
import aprendercucumber.entities.TipoAluguel;
import aprendercucumber.utils.CalendarUtil;

public class AlguelService {

	public NotaDeAluguel alugar(Filme filme, TipoAluguel tipoAluguel) {
		NotaDeAluguel nota = new NotaDeAluguel();

		if (filme.getEstoque() == 0) {
			throw new RuntimeException("Filme sem estoque");
		}

		switch (tipoAluguel) {
		
		case COMUM:
			nota.setPreco(filme.getAluguel());
			nota.setDataEntrega(CalendarUtil.obterDataDiferencaDias(1));
			nota.setPontuacao(1);
			break;
			
		case EXTENDIDO:
			nota.setPreco(filme.getAluguel() * 2);
			nota.setDataEntrega(CalendarUtil.obterDataDiferencaDias(3));
			nota.setPontuacao(2);
			break;
			
		case SEMANAL:
			nota.setPreco(filme.getAluguel() * 3);
			nota.setDataEntrega(CalendarUtil.obterDataDiferencaDias(7));
			nota.setPontuacao(2);
			break;

		}

		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
	}

}
