/*
 * Aquí has de crear la classe que se't demana
 * Et poso l'esquema per ser la primera
 *
 * Un cop el tinguis, des de la línia de comandes, tecleja
 * bash test/test.sh
 *
 * Segueix les instruccions
 */
public class InformePersona {
    static String mostrarResultat(String nom,String cognom , int edat) {
        return String.format(
                "Fitxa \n=====\nNom: %s %s \nEdat: %d. anys",
                nom,
                cognom,
                edat
        );
    }
    public static void main(String[] args) {
        String missatge  = mostrarResultat( "Laia"," Sánchez d'Àrgent", 19 );
        System.out.println(missatge);
    }
}
