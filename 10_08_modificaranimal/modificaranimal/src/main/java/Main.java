
/*
*Impplementem el metode de mostrar categories que ens facilitara la feina de mostar laes categories
*Ara fegirem el nou metode de mostrar animals que sera mlt semblant al de mostrar caregories
*
*/import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    //CATEGORIES
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
    //ANIMALS
        public static void mostraAnimals(Zoo zoo) throws SQLException {
        System.out.print("Recupera els animals: ");
        List<Animal> animals = zoo.recuperaAnimals();
        if (animals.size() == 0) {
            System.out.println("cap animal trobada");
        } else {
            System.out.println("Nombre de animals trobats = " + animals.size());
            for (Animal animal: animals) {
                System.out.println("\t" + animal);
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
            new Categoria("rèptil"),
            new Categoria("ocell"),
            new Categoria("mamifer")
        );

        System.out.print("Inserim més categories: ");
        System.out.println(zoo.afegeixCategories(novesCategories));

        mostraCategories(zoo);
//ANIMALS
        System.out.print("Creem la taula ANIMALS: ");
        System.out.println(zoo.creaTaulaAnimals());

        Categoria mamifer = zoo.recuperaCategoriaPerNom("mamifer");
        Categoria ocell = zoo.recuperaCategoriaPerNom("ocell");
        Categoria peix = zoo.recuperaCategoriaPerNom("peix");
        Categoria reptil = zoo.recuperaCategoriaPerNom("rèptil");

        Animal canari = new Animal("Canari", ocell);
        System.out.print("Inserim " + canari + "; ");
        System.out.println(zoo.afegeixAnimal(canari));
        mostraAnimals(zoo);
        List<Animal> nousAnimals = Arrays.asList(
                new Animal("estruç", ocell),
                new Animal("kiwi", ocell),
                new Animal("gos", mamifer),
                new Animal("bacallà", peix),
                new Animal("dofí", peix),
                new Animal("gecko", reptil)
        );
        System.out.print("Inserim més animals: ");
        System.out.println(zoo.afegeixAnimals(nousAnimals));

        Animal dofi = new Animal("dofí", mamifer);
        System.out.print("Corregim " + dofi + ": ");
        System.out.println(zoo.modificaCategoriaAnimal(dofi));

        mostraAnimals(zoo);
        System.out.print("Finalment tanquem la connexió amb la base de dades: ");
        System.out.println(zoo.desconnecta());


    }
}