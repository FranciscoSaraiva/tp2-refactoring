package Models;

import java.util.List;

public class Mercado {

	private List<Indice> indices;
	private List<Acao> acoes;
	private List<Moeda> moedas;
	//private List<Commodity> commodities;

	public Mercado(){
	}

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

		for(int i = 0; i < indices.size(); i++){
			if(nomeAtivo.compareTo(indices.get(i).getNome()) == 0){
				return indices.get(i);
			}
		}

		for(int i = 0; i < acoes.size(); i++){
			if(nomeAtivo.compareTo(acoes.get(i).getNome()) == 0){
				return acoes.get(i);
			}
		}

		for(int i = 0; i < moedas.size(); i++){
			if(nomeAtivo.compareTo(moedas.get(i).getNome()) == 0){
				return moedas.get(i);
			}
		}
		return null;

    }
}