package Service;

import Models.Indice;
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

public class AtivoCreatorIndice extends AtivoCreator {

    private final String NAMEJSONARRAY = "majorIndexesList";

    public AtivoCreatorIndice(){
        super();
    }

    public List<Indice> createAtivos() {

        String File = "";
        APIConexaoIndice apiIndice = new APIConexaoIndice();
        File = apiIndice.getDados();

        try{
            List<Indice> Indices = new ArrayList<Indice>();
            Object obj = new JSONParser().parse(new FileReader(File));
            JSONObject json = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) json.get(NAMEJSONARRAY);
            Iterator itr2 = jsonArray.iterator();

            while(itr2.hasNext()){
                JSONObject jsonObject = (JSONObject) itr2.next();
                String nome = (String) jsonObject.get("ticker");
                double valorVenda = (Double) jsonObject.get("price");
                double valorCompra = valorVenda + this.getCOTACAO();
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
}
