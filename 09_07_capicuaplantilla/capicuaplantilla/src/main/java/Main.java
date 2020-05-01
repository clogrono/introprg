/*
 * EM inserit una plantilla hml per mostrar al navegador, 
 *es pasara un parametre gracies a l'estructura de tipus Map
 * que retorna el valor de composaSalutacio que es el valor que 
 * espera i es agafat ${nom}.a la plantilla html i amb modelanViews
 *ho enviem a capicuca.html
 */
 import java.util.HashMap;
import java.util.Map;
import static spark.Spark.get;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;


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
        return nom;
        //return "La paraula capicua es <b>"+nom+"</b>";
    }

    public static void main(String[] args) {
        get("/capicua", 
             (rq, rs) -> {
                String nom = composaSalutacio(rq.queryParams("nom"));
                Map<String, Object> params = new HashMap<>();
                params.put("nom", nom);
                return new ModelAndView(params, "capicua.html");
        }, new FreeMarkerEngine());
    }
}
