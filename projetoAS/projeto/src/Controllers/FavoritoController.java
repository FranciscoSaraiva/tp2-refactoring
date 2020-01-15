package Controllers;

import Models.Ativo;
import Models.Favorito;
import Models.Utilizador;

public class FavoritoController {

    public void calcularVariacao(Ativo a){
        throw new UnsupportedOperationException();
    }

    public Favorito getFavoritos(Utilizador utilizador){
        return utilizador.getFavorito();
    }

    public void apagarFavorito(Utilizador utilizador, Ativo ativo){
        Favorito favorito = utilizador.getFavorito();
        favorito.apagaFavorito(ativo);
    }

}
