/*
 * En aquest cas canviem el import static, per capicua 
 * El resultat del return es la paraula cap....
 * Al enrutament /cpicua per link de la aplicacion
 */
import static spark.Spark.get;

public class Main {

    static String composaSalutacio() {
        return "La paraula capicua es anna";
    }

    public static void main(String[] args) {
        get("/capicua", (rq, rs) -> composaSalutacio());
    }
}
