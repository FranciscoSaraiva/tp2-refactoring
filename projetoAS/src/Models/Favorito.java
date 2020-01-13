package Models;

import Persistance.FavoritoDAO;

import java.util.ArrayList;
import java.util.List;

public class Favorito implements Observer {

    private List<Ativo> favoritos;
    private double percentagemVariacao;

    private FavoritoDAO fDAO;

    public Favorito(){
        this.favoritos = new ArrayList<Ativo>();
        this.fDAO = new FavoritoDAO();
        this.percentagemVariacao = 15.00;
    }

    public List<Ativo> getFavoritos() {
        return favoritos;
    }

    public void apagaFavorito(Ativo a){
        this.getFavoritos().remove(a);
        fDAO.delete(a);
    }

    public void setFavoritos(List<Ativo> favoritos) {
        this.favoritos = favoritos;
    }

    public double getPercentagemVariacao() {
        return percentagemVariacao;
    }

    public void setPercentagemVariacao(double percentagemVariacao) {
        this.percentagemVariacao = percentagemVariacao;
    }


    public Ativo getAtivo(String nome){
        for(int i = 0; i <= favoritos.size(); i++){
            if(favoritos.get(i).getNome().compareTo(nome) == 0){
                return favoritos.get(i);
            }
        }
        return null;
    }

    @Override
    public void update() {

    }
}
