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

    public static void main(String[] args) {
        String nom;
        String cognoms;
        int edat;
        Scanner dadesIntro =new Scanner(System.in);
        System.out.println("Quin és el teu nom?");
        nom=dadesIntro.nextLine();
        System.out.println("Quins són els teus cognoms?");
        cognoms=dadesIntro.nextLine();
        System.out.println("Quina és la teva edat?");
        edat=dadesIntro.nextInt();
        String missatge  = composaFitxa( nom,cognoms, edat );
        System.out.println(missatge);
    }
}
