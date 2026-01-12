package Calculos;

import Servicios.ApiCambio;

public class Convertidor {
    public static double convertir(String base, String destino, double monto) {
        double tasa = ApiCambio.obtenerTasa(base, destino);
        return monto * tasa;
    }
}
