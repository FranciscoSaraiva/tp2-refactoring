package Models;

public class Utilizador {

    private String nome;
    private String email;
    private String password;
    private double fundos;
    private Portfolio portfolio;
    private Favorito favorito;

    public Utilizador() {
        this.portfolio = new Portfolio();
        this.favorito = new Favorito();
    }

    public Utilizador(String email, String password) {
        this.email = email;
        this.password = password;
        this.portfolio = new Portfolio();
    }

    public Utilizador(String nome, String email, String password, double fundos){
        this.nome=nome;
        this.email=email;
        this.password=password;
        this.fundos=fundos;
    }

    public Favorito getFavorito() {
        return favorito;
    }

    public void setFavorito(Favorito favorito) {
        this.favorito = favorito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getFundos() {
        return fundos;
    }

    public void setFundos(double fundos) {
        this.fundos = fundos;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}