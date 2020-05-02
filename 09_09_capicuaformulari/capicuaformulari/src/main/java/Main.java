/*
 * Aquest cop afegin fulla de estil y un logo 
 *comprovem on va cada cosa i com es crida cada cosa
 * a html es likeen les url de css i imatge aqui es
 * fa servir la location per dir que el el recusos estan
 *a src/main/resources/
 */
 import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFiles;
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

        staticFiles.location("/");

        get("/capicua", 
             (rq, rs) -> {
                String nom = composaSalutacio(rq.queryParams("nom"));
                Map<String, Object> params = new HashMap<>();
                params.put("nom", nom);
                return new ModelAndView(params, "capicua.html");
        }, new FreeMarkerEngine());
    }
}
