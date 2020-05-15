import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void mostraCategories(Zoo zoo) throws SQLException {
        System.out.print("Recupera les categories: ");
        List<Categoria> categories = zoo.recuperaCategories();
        if (categories.size() == 0) {
            System.out.println("cap categoria trobada");
        } else {
            System.out.println("Nombre de categories trobades = " + categories.size());
            for (Categoria categoria: categories) {
                System.out.println("\t" + categoria);
            }
        }
    }
    public static void main( String args[]) throws SQLException {
        Zoo zoo = new Zoo();

        System.out.print("Primer connectem amb la base de dades: ");
        System.out.println(zoo.connecta());

//CATEGORIES
        System.out.print("Creem la taula CATEGORIES: ");
        System.out.println(zoo.creaTaulaCategories());

        List<Categoria> novesCategories = Arrays.asList(
            new Categoria("peix"),
            new Categoria("rèptil")
        );

        System.out.print("Inserim més categories: ");
        System.out.println(zoo.afegeixCategories(novesCategories));

        Categoria ocell = new Categoria("ocell");
        System.out.print("Inserim " + ocell + ": ");
        System.out.println(zoo.afegeixCategoria(ocell));

        mostraCategories(zoo);
//ANIMALS
        System.out.print("Creem la taula ANIMALS: ");
        System.out.println(zoo.creaTaulaAnimals());

        Animal canari = new Animal("Canari", ocell);
        System.out.print("Inserim " + canari + "; ");
        System.out.println(zoo.afegeixAnimal(canari));

        System.out.print("Finalment tanquem la connexió amb la base de dades: ");
        System.out.println(zoo.desconnecta());
    }
}