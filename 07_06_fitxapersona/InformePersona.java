import java.util.Scanner;
public class InformePersona {

   
    
    static String composaFitxa(Persona persona) {
        return String.format(
            "Fitxa\n=====\nNom: %s %s\nEdat: %d %s\n",
                persona.nom,
                persona.cognoms, 
                persona.edat,
                persona.edat > 1 ? "anys" : "any"
        );
    }

    public static void main(String[] args) {

        Persona persona = new Persona();
        Scanner dadesIntro =new Scanner(System.in);
        System.out.println("Quin és el teu nom?");
        persona.nom=dadesIntro.nextLine();
        System.out.println("Quins són els teus cognoms?");
        persona.cognoms=dadesIntro.nextLine();
        System.out.println("Quina és la teva edat?");
        persona.edat=dadesIntro.nextInt();
        String missatge  = composaFitxa(persona);
        System.out.println(missatge);
    }
}


