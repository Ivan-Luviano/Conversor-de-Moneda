package Servicios;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCambio {
    private static final String API_KEY = "d207218118f816de25525f3e";

    public static double obtenerTasa(String base, String destino) {

        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/"
                    + API_KEY + "/latest/" + base;

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder json = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                json.append(linea);
            }

            JsonObject obj = JsonParser.parseString(json.toString()).getAsJsonObject();
            return obj.getAsJsonObject("conversion_rates")
                    .get(destino).getAsDouble();

        } catch (Exception e) {
            System.out.println("Error al consultar API");
            return 0;
        }
    }
}
