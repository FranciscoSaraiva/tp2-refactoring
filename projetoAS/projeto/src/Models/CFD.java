package Models;

public class CFD implements Observer {

	private Ativo ativo;
	private Utilizador utilizador;
	private double quantidade;
	private double stopLoss;
	private double takeProfit;
	private boolean isCompra;
	private double valorAbertura;

	public CFD(){
	}

	public CFD(Ativo ativo, Utilizador utilizador, double quantidade, double stopLoss, double takeProfit, boolean isCompra, double valorAbertura) {
		this.ativo = ativo;
		this.utilizador = utilizador;
		this.quantidade = quantidade;
		this.stopLoss = stopLoss;
		this.takeProfit = takeProfit;
		this.isCompra = isCompra;
		this.valorAbertura = valorAbertura;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getStopLoss() {
		return stopLoss;
	}

	public void setStopLoss(double stopLoss) {
		this.stopLoss = stopLoss;
	}

	public double getTakeProfit() {
		return takeProfit;
	}

	public void setTakeProfit(double takeProfit) {
		this.takeProfit = takeProfit;
	}

	public boolean isCompra() {
		return isCompra;
	}

	public void setCompra(boolean compra) {
		isCompra = compra;
	}

	public double getValorAbertura() {
		return valorAbertura;
	}

	public void setValorAbertura(double valorAbertura) {
		this.valorAbertura = valorAbertura;
	}

	public void update() {
		throw new UnsupportedOperationException();
	}

}