package Models;

import java.util.List;

public class Mercado {

	private List<Indice> indices;
	private List<Acao> acoes;
	private List<Moeda> moedas;

	public Mercado(List<Indice> indices, List<Acao> acoes, List<Moeda> moedas) {
		this.indices = indices;
		this.acoes = acoes;
		this.moedas = moedas;
	}

	public List<Indice> getIndices() {
		return indices;
	}

	public void setIndices(List<Indice> indices) {
		this.indices = indices;
	}

	public List<Acao> getAcoes() {
		return acoes;
	}

	public void setAcoes(List<Acao> acoes) {
		this.acoes = acoes;
	}

	public List<Moeda> getMoedas() {
		return moedas;
	}

	public void setMoedas(List<Moeda> moedas) {
		this.moedas = moedas;
	}

    public Ativo getAtivoPorNome(String nomeAtivo) {
		Ativo indice = getIndicePorNome(nomeAtivo);
		if(indice!=null)
			return indice;
		Ativo acao = getAcaoPorNome(nomeAtivo);
		if(acao!=null)
			return acao;
		Ativo moeda = getMoedaPorNome(nomeAtivo);
		if(moeda!=null)
			return moeda;
		return null;
    }

    public Ativo getIndicePorNome(String nome){
		for(Indice indice: indices){
			if(indice.getNome().equals(nome))
				return indice;
		}
		return null;
	}

	public Ativo getAcaoPorNome(String nome){
		for(Acao acao: acoes){
			if(acao.getNome().equals(nome))
				return acao;
		}
		return null;
	}

	public Ativo getMoedaPorNome(String nome){
		for(Moeda moeda: moedas){
			if(moeda.getNome().equals(nome))
				return moeda;
		}
		return null;
	}
}