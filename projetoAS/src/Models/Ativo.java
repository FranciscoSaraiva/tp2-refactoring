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
		// TODO - implement Ativo.getState
		throw new UnsupportedOperationException();
	}

	public void setState() {
		// TODO - implement Ativo.setState
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "Ativo{" +
				"nome='" + nome + '\'' +
				", valorCompra=" + valorCompra +
				", valorVenda=" + valorVenda +
				'}';
	}
}