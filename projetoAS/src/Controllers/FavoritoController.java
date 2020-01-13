package Controllers;

import Models.Ativo;
import Models.Favorito;
import Models.Utilizador;

public class FavoritoController {

    public void calcularVariacao(Ativo a){
        //TODO - CALCULAR A VARIAÇÃO
        throw new UnsupportedOperationException();
    }

    public Favorito getFavoritos(Utilizador u){
        return u.getFavorito();
    }

    public void apagarFavorito(Utilizador u, Ativo a){
        u.getFavorito().apagaFavorito(a);
    }

}
