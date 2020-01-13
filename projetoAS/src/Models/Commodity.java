package Models;

public class Commodity extends Ativo implements Subject {
    public Commodity(String nome, double valorCompra, double valorVenda) {
        super(nome, valorCompra, valorVenda);
    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }
}