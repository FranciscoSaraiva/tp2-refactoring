package Controllers;

import Models.*;
import Service.AtivoCreator;

import java.util.ArrayList;
import java.util.List;

public class MercadoController {

	private Mercado m;

	public MercadoController(Mercado m) {
		this.m = m;
	}

	public Mercado getM() {
		return m;
	}
	public Ativo getAtivo(String nome) {
		return m.getAtivoPorNome(nome);
	}

	public List<Acao> listarAcoes() {
		return m.getAcoes();
	}

	public List<Moeda> listarMoedas() {
		return m.getMoedas();
	}

	public List<Indice> listarIndices() {
		return m.getIndices();
	}

	/**
	 * método bootstrap para popular a plataforma
	 */
	public List<Ativo> getMercadoCompleto() {

		List <Ativo> mercado = new ArrayList<>();

		mercado.addAll(m.getIndices());
		mercado.addAll(m.getAcoes());
		mercado.addAll(m.getMoedas());

		return mercado;
	}

}