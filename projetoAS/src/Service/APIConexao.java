package Service;

import java.io.*;
import java.net.URL;

public class APIConexao {

    public APIConexao(){
    }

    public String getDados(String tipo) {
        switch(tipo) {
            case "Moedas":
                return moedas();
            case "Ações":
                return acoes();
            case "Index":
                return index();
            default:
                return "";
        }
    }

    private String moedas() {

        try {
            String CryptoJson = "";
            URL url = new URL("https://financialmodelingprep.com/api/v3/cryptocurrencies");
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

    private String index() {

        try {
            String CryptoJson = "";
            URL url = new URL("https://financialmodelingprep.com/api/v3/majors-indexes");
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

    private String acoes() {

        try {
            String CryptoJson = "";
            URL url = new URL("https://financialmodelingprep.com/api/v3/stock/real-time-price/AAPL,FB,GOOG,INTC,HPQ,F,AMD,MU,GDX,MSFT,CX");
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

