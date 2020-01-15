package Service;

import Models.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AtivoCreator {

	public Mercado createAtivos() {
		List<Moeda> Moedas;
		List<Acao> Acoes;
		List<Indice> Indices;

		APIConexaoMoeda apiMoeda = new APIConexaoMoeda();
		APIConexaoAcao apiAcao = new APIConexaoAcao();
		APIConexaoIndice apiIndice = new APIConexaoIndice();
		String file = "";

		file = apiMoeda.getDados();
		Moedas = readJSONFileMoedas(file, "cryptocurrenciesList");

		file = apiIndice.getDados();
		Indices = readJSONFileIndex(file, "majorIndexesList");

		file = apiAcao.getDados();
		Acoes = readJSONFileAcoes(file, "companiesPriceList");

		return new Mercado(Indices, Acoes, Moedas);
	}


	private List<Moeda> readJSONFileMoedas(String File, String nameJsonArray) {
		try{

			List<Moeda> Moedas = new ArrayList<Moeda>();

			Object obj = new JSONParser().parse(new FileReader(File));

			JSONObject json = (JSONObject) obj;

			JSONArray jsonArray = (JSONArray) json.get(nameJsonArray);

			Iterator itr2 = jsonArray.iterator();


			while(itr2.hasNext()){
				JSONObject jsonObject = (JSONObject) itr2.next();
				String nome = (String) jsonObject.get("ticker");
				double valorVenda = (Double) jsonObject.get("price");
				double valorCompra = valorVenda + 0.02;
				Moeda moeda = new Moeda(nome, valorCompra, valorVenda);
				Moedas.add(moeda);
			}
			return Moedas;
		}catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Indice> readJSONFileIndex(String File, String nameJsonArray) {
		try{
			List<Indice> Indices = new ArrayList<>();

			Object obj = new JSONParser().parse(new FileReader(File));

			JSONObject json = (JSONObject) obj;

			JSONArray jsonArray = (JSONArray) json.get(nameJsonArray);

			Iterator itr2 = jsonArray.iterator();


			while(itr2.hasNext()){
				JSONObject jsonObject = (JSONObject) itr2.next();
				String nome = (String) jsonObject.get("ticker");
				double valorVenda = (Double) jsonObject.get("price");
				double valorCompra = valorVenda + 0.02;
				Indice indice = new Indice(nome, valorCompra, valorVenda);
				Indices.add(indice);
			}
			return Indices;
		}catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<Acao> readJSONFileAcoes(String File, String nameJsonArray) {
		try{
			List<Acao> Acoes = new ArrayList<>();

			Object obj = new JSONParser().parse(new FileReader(File));

			JSONObject json = (JSONObject) obj;

			JSONArray jsonArray = (JSONArray) json.get(nameJsonArray);

			Iterator itr2 = jsonArray.iterator();


			while(itr2.hasNext()){
				JSONObject jsonObject = (JSONObject) itr2.next();
				String nome = (String) jsonObject.get("symbol");
				double valorVenda = (Double) jsonObject.get("price");
				double valorCompra = valorVenda + 0.02;
				Acao acao = new Acao(nome, valorCompra, valorVenda);
				Acoes.add(acao);
			}
			return Acoes;
		}catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}