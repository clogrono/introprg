/*
 * Pasem per parametre el nom que l'obtenim amb un request 
 *mitjançant un get per la url accedim al parametre
 * En el cas de no obtenir cap resultat seguirá sent anna
 * Al enrutament /capicua?nom=NOM per link de la aplicacion
 */
import static spark.Spark.get;

public class Main {

    static String composaSalutacio(String nom) {
        if (nom == null || nom.isEmpty()) {
            nom = "anna";
        }else{
            String capicua="";
            for(int x = nom.length() -1; x >= 0; x--) {
                char c = nom.charAt(x);
                capicua=capicua+c;
            }

            if (nom.equals(capicua)){
                nom=capicua;
            }else{
                String aux="";
                for(int i = nom.length() -1; i > 0; i--) {
                    char ch = nom.charAt(i);
                    aux=aux+ch;
                }
                nom=aux+nom;
            }
        }
        return "La paraula capicua es <b>"+nom+"</b>";
    }

    public static void main(String[] args) {
        get("/capicua", (rq, rs) -> composaSalutacio(rq.queryParams("nom")));
    }
}
