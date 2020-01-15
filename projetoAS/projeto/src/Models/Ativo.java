package Models;

public abstract class Ativo {

	private String nome;
	private double valorCompra;
	private double valorVenda;

	public Ativo(String nome, double valorCompra, double valorVenda) {
		this.nome = nome;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public void getState() {
		throw new UnsupportedOperationException();
	}

	public void setState() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		String head = ">> Ativo <<\n";
		String nome = "Nome: "+getNome()+"\n";
		String valorCompra = "Valor Compra: "+getValorCompra()+"\n";
		String valorVenda = "Valor Venda: "+getValorVenda()+"\n";
		String ativo = head+nome+valorCompra+valorVenda;
		return ativo;
	}
}