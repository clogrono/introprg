import java.util.Scanner;
public class InformePersona {
    
    static String mostrarResultat(String nom,String cognom , int edat) {
        return String.format(
            "\nFitxa\n=====\nNom: %s %s\nEdat: %d anys",
                nom,
                cognom, 
                edat
        );
    }

    public static void main(String[] args) {
        String nom;
        String cognom;
        int edat;
        Scanner dadesIntro =new Scanner(System.in);
        System.out.println("Quin és el teu nom?");
        nom=dadesIntro.nextLine();
        System.out.println("Quins són els teus cognoms?");
        cognom=dadesIntro.nextLine();
        System.out.println("Quina és la teva edat?");
        edat=dadesIntro.nextInt();
        String missatge  = mostrarResultat( nom,cognom, edat );
        System.out.println(missatge);
    }
}
