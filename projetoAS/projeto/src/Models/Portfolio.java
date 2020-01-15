package Models;

import Persistance.CFDDAO;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

	private List<CFD> cfds;
	private CFDDAO cfddao;

	public Portfolio() {
		this.cfds = new ArrayList<CFD>();
		this.cfddao = new CFDDAO();
	}

	public List<CFD> getCfds() {
		return cfds;
	}

	public void setCfds(List<CFD> cfds) {
		this.cfds = cfds;
	}

	public void apagaCFD(CFD cfd){
		this.getCfds().remove(cfd);
		cfddao.delete(cfd);
	}

	public CFD getCFD(String nome){
		for(CFD cfd: cfds) {
			return (cfd.getAtivo().getNome().equals(nome) ? cfd : null);
		}
		return null;
	}
}