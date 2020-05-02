
/**
*En Aquesta par del programa introduirem el coneixements abans asolits
*enrutament, get del form, aquesta vegada afegirem estil i modificarem
*l'html a fi de donar forma al gatRenat
*
 */
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFiles;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
public class Main {

    public static void main(String[] args) {

        staticFiles.location("/");

        EntornOperatiu entorn = new EntornOperatiu();
        get("/renat", 
            (rq, rs) -> {
                String comanda = rq.queryParams("comanda");
                if (comanda == null) {
                    comanda = "";
                }
                String resultat = entorn.processaEntrada(comanda);
                Map<String, Object> params = new HashMap<>();
                params.put("resultat", resultat);
                return new ModelAndView(params, "gatrenat.html");
                //return resultat;
        },new FreeMarkerEngine());


    }

}