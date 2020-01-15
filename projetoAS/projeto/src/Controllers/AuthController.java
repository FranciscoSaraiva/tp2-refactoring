package Controllers;

import Models.Conta;
import Models.Utilizador;

public class AuthController {

	private Conta conta;

	public Boolean logIn(String email, String password) {
		mensagemLogin(email, password);
		return email.equals("admin") && password.equals("admin");
	}

	public void registar(String nome, String email, String password, double fundos) {
		Utilizador u1 = new Utilizador(nome, email, password, fundos);
	}

	public void mensagemLogin(String email, String password){
		System.out.println("Recebi os dados: ");
		System.out.println("User: " + email);
		System.out.println("Pass: " + password);
	}

	public void logout() {
		System.out.println("Logout feito com sucesso");
		System.out.println("A sair .... ");
		System.exit(0);
	}

}