/*
 * Pasem per parametre el nom que l'obtenim amb un request 
 *mitjançant un get per la url accedim al parametre
 * En el cas de no obtenir cap resultat seguirá sent anna
 * Al enrutament /capicua?nom=NOM per link de la aplicacion
 */
import static spark.Spark.get;

public class Main {

    static String composaSalutacio(String nom) {
          if (nom == null) {
            nom = "anna";
        }
        return "La paraula capicua es <b>"+nom+"</b>";
    }

    public static void main(String[] args) {
        get("/capicua", (rq, rs) -> composaSalutacio(rq.queryParams("nom")));
    }
}
