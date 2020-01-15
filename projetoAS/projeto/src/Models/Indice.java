package Models;

import java.util.ArrayList;
import java.util.List;

public class Indice extends Ativo implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    public Indice(String nome, double valorCompra, double valorVenda) {
        super(nome, valorCompra, valorVenda);
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

    }

}