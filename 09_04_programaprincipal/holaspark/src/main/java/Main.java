/*
 * Demostració bàsica d'ús de spark
 *
 * El resultat és una única ruta que retorna 
 * un missatge de salutació
 */
import static spark.Spark.get;

public class Main {

    static String composaSalutacio() {
        return "Hola món des de Spark";
    }

    public static void main(String[] args) {
        get("/holaspark", (rq, rs) -> composaSalutacio());
    }
}
