package Service;

import java.io.*;
import java.net.URL;

public class APIConexaoIndice extends APIConexao {

    public APIConexaoIndice(){
        super();
    }

    String URL = "https://financialmodelingprep.com/api/v3/majors-indexes";

    String getDados(){
        try {
            String CryptoJson = "";
            URL url = new URL(URL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            for (String line; (line = reader.readLine()) != null; ) {
                CryptoJson = CryptoJson.concat(line + "\n");
            }

            FileWriter fw = new FileWriter(new File("index.json"));
            fw.write(CryptoJson);
            fw.close();

            return "index.json";

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index.json";
    }
}
