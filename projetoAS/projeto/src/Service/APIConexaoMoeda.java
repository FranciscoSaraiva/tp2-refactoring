package Service;

import java.io.*;
import java.net.URL;

public class APIConexaoMoeda extends APIConexao  {

    private String URL = "https://financialmodelingprep.com/api/v3/cryptocurrencies";

    public APIConexaoMoeda(){
        super();
    }

    public String getDados(){
        try {
            String CryptoJson = "";
            URL url = new URL(URL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            for (String line; (line = reader.readLine()) != null; ) {
                CryptoJson = CryptoJson.concat(line + "\n");
            }

            FileWriter fw = new FileWriter(new File("crypto.json"));
            fw.write(CryptoJson);
            fw.close();

            return "crypto.json";

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "crypto.json";
    }
}
