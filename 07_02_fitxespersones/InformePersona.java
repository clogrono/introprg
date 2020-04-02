/*
*Ampliare l'utilització de metodes i el seu potencial
*pasan en aquest cas per parametre arrays per tal de fer
*mes dinàmic el nostre programa, guardanr una infinat de valor 
*que despres podem accedir aun un sol for i no repetint codi 
 */
import java.util.Scanner;
public class InformePersona {
    
    static String composaFitxa(String nom,String cognoms , int edat) {
        return String.format(
            "Fitxa\n=====\nNom: %s %s\nEdat: %d %s\n",
                nom,
                cognoms, 
                edat,
                edat > 1 ? "anys" : "any"
        );
    }
    static String composaFitxes(String[] noms, String[] cognoms, int[] edats){
	String resultat = "";
        for (int i=0; i < noms.length; i++) {
            resultat = String.format("%s%s", resultat, composaFitxa(noms[i],cognoms[i], edats[i]));
        }
        return resultat;
    }

    public static void main(String[] args) {
        //  String nom;
        //  String cognoms;
        //  int edat;
        //  Scanner dadesIntro =new Scanner(System.in);
        //  System.out.println("Quin és el teu nom?");
        //  nom=dadesIntro.nextLine();
        //  System.out.println("Quins són els teus cognoms?");
        //  cognoms=dadesIntro.nextLine();
        //  System.out.println("Quina és la teva edat?");
        //  edat=dadesIntro.nextInt();
     
        String[] noms = {"Laia"};
        String[] cognoms = {"Sànchez d'Àrgent"};
        int[] edats = {19};

        String missatge  = composaFitxes(noms,cognoms, edats);
        System.out.println(missatge);
    }
}
