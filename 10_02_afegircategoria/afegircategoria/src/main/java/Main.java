/*
*
*Ara provem de insertar unes quantes categories dintre de la taula categories
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

        Categoria ocell = new Categoria("ocell");
        System.out.print("Inserim " + ocell + ": ");
        System.out.println(zoo.afegeixCategoria(ocell));

        Categoria mamifer = new Categoria("mamifer");
        System.out.print("Inserim " + mamifer + ": ");
        System.out.println(zoo.afegeixCategoria(mamifer));
        
        System.out.print("Finalment tanquem la connexió amb la base de dades: ");
        System.out.println(zoo.desconnecta());
    }
}