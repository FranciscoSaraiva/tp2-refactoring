package Service;

import Models.Moeda;
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

public class AtivoCreatorMoeda extends AtivoCreator {

    private final String NAMEJSONARRAY = "cryptocurrenciesList";

    public AtivoCreatorMoeda(){
        super();
    }

    public List<Moeda> createAtivos() {

        String File = "";
        APIConexaoMoeda apiMoeda = new APIConexaoMoeda();
        File = apiMoeda.getDados();

        try{
            List<Moeda> Moedas = new ArrayList<Moeda>();
            Object obj = new JSONParser().parse(new FileReader(File));
            JSONObject json = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) json.get(NAMEJSONARRAY);
            Iterator itr2 = jsonArray.iterator();

            while(itr2.hasNext()){
                JSONObject jsonObject = (JSONObject) itr2.next();
                String nome = (String) jsonObject.get("ticker");
                double valorVenda = (Double) jsonObject.get("price");
                double valorCompra = valorVenda + this.getCOTACAO();
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
}
