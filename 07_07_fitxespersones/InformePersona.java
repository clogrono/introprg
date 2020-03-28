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
    static String composaFitxes(Persona persones[]){
	String resultat = "";
        for (int i=0; i < persones.length; i++) {
            resultat = String.format("%s%s", resultat, composaFitxa(persones[i]));
        }
        return resultat;
    }

    public static void main(String[] args) {
        Persona persones[] = new Persona[1];
        Persona persona = new Persona();
        persona.nom = "Laia";
        persona.cognoms = "Sànchez d'Àrgent";
        persona.edat =19;
        persones[0]=persona;

        String missatge  = composaFitxes(persones);
        System.out.println(missatge);
    }
}
