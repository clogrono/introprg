/*
*Provem els nous metodes de la clase Zoo ens conectem primer
*després creem la taula i un cop fet tot el pocés tanquemm la taula
*
*
 */
import java.sql.SQLException;

public class Main {
    public static void main( String args[]) throws SQLException {
        Zoo zoo = new Zoo();

        System.out.print("Primer connectem amb la base de dades: ");
        System.out.println(zoo.connecta());

        System.out.print("Creem la taula CATEGORIES: ");
        System.out.println(zoo.creaTaulaCategories());


        System.out.print("Finalment tanquem la connexió amb la base de dades: ");
        System.out.println(zoo.desconnecta());

       
    }
}