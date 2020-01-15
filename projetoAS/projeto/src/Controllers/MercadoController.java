package Controllers;

import Models.*;
import Service.AtivoCreator;

import java.util.ArrayList;
import java.util.List;

public class MercadoController {

	private Mercado mercado;

	public MercadoController(Mercado mercado) {
		this.mercado = mercado;
	}

	public Mercado getMercado() {
		return mercado;
	}

	public Ativo getAtivo(String nome) {
		return mercado.getAtivoPorNome(nome);
	}

	public List<Acao> listarAcoes() {
		return mercado.getAcoes();
	}

	public List<Moeda> listarMoedas() {
		return mercado.getMoedas();
	}

	public List<Indice> listarIndices() {
		return mercado.getIndices();
	}

	/**
	 * método bootstrap para popular a plataforma
	 */
	public List<Ativo> getMercadoCompleto() {
		List <Ativo> mercadoNovo = new ArrayList<>();
		adicionarMercados(mercadoNovo);
		return mercadoNovo;
	}

	private void adicionarMercados(List<Ativo> mercadoNovo){
		mercadoNovo.addAll(mercado.getIndices());
		mercadoNovo.addAll(mercado.getAcoes());
		mercadoNovo.addAll(mercado.getMoedas());
	}

}