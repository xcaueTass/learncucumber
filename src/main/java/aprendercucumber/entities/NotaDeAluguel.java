package aprendercucumber.entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotaDeAluguel {

	private int preco;
	private Date dataEntrega;
	private int pontuacao;
}
