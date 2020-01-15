package Service;

import java.io.*;
import java.net.URL;

public class APIConexaoAcao extends APIConexao  {

    private String URL ="https://financialmodelingprep.com/api/v3/stock/real-time-price/AAPL,FB,GOOG,INTC,HPQ,F,AMD,MU,GDX,MSFT,CX";

    public APIConexaoAcao(){
        super();
    }

    public String getDados(){
        try {
            String CryptoJson = "";
            java.net.URL url = new URL(URL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            for (String line; (line = reader.readLine()) != null; ) {
                CryptoJson = CryptoJson.concat(line + "\n");
            }

            FileWriter fw = new FileWriter(new File("acoes.json"));
            fw.write(CryptoJson);
            fw.close();

            return "acoes.json";

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "acoes.json";
    }
}
