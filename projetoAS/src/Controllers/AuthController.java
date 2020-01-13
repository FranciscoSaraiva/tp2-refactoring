package Controllers;

import Models.Conta;
import Models.Utilizador;

public class AuthController {

	private Conta acc;

	public Boolean logIn(String email, String pass) {
		System.out.println("Recebi os dados: ");
		System.out.println("User: " + email);
		System.out.println("Pass: " + pass);

		if(email.equals("admin") && pass.equals("admin")){
			return true;
		}
		return false;
	}

	public void registar(String nome, String email, String password, double fundos) {

		Utilizador u1 = new Utilizador();
		u1.setNome(nome);
		u1.setEmail(email);
		u1.setPassword(password);
		u1.setFundos(fundos);
	}

	public void logout() {
		System.out.println("Logout feito com sucesso");
		System.out.println("A sair .... ");
		System.exit(0);
	}

}