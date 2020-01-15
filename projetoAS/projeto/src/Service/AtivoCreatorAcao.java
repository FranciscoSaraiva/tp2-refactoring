package Service;

import Models.Acao;
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

public class AtivoCreatorAcao extends AtivoCreator {

    private final String NAMEJSONARRAY = "companiesPriceList";

    public AtivoCreatorAcao() {
        super();
    }

    public List<Acao> createAtivos() {

        String File = "";
        APIConexaoAcao apiAcao = new APIConexaoAcao();
        File = apiAcao.getDados();

        try {
            List<Acao> Acoes = new ArrayList<Acao>();
            Object obj = new JSONParser().parse(new FileReader(File));
            JSONObject json = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) json.get(NAMEJSONARRAY);
            Iterator itr2 = jsonArray.iterator();

            while (itr2.hasNext()) {
                JSONObject jsonObject = (JSONObject) itr2.next();
                String nome = (String) jsonObject.get("ticker");
                double valorVenda = (Double) jsonObject.get("price");
                double valorCompra = valorVenda + this.getCOTACAO();
                Acao acao = new Acao(nome, valorCompra, valorVenda);
                Acoes.add(acao);
            }
            return Acoes;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
