/*
 * Implementació de la classe Zoo
 *
 * Encapsula una col·lecció d'animals guardats a una base de dades
 *
 *En aquesta part del programa afegirem les la clase animal tambe els metodes Afegir animal 
 *Eliminar animal, que sera cuasi bé el mateix que amb la taule categories
 *amb la diferencia que em de afegir eliminarAnimals a Elimiar categories
 *Pero la foreing key que porta la taula de animals y diferents metodes per fer les
 *consultes a la base de dades. També afegim animals a la taula pertinent.
 *Tambe afegim els nous metodes de recuperar animals, Aquest cop afegirem la funcinalitat
 * de de afegir animals que sera practicament semblant que el de categories.
 *Per implementar obteIdAnimal, tambe s'hna de crear modificaranimal,recuperaAnimalsAmbSQL
 *per tal d'obtenir l'id de l'animal ja que quan ens pasa aquest animal no te cap id i l'em de 
 *buscar a la base de dades. Aquesta vegada crearem obtenIdCategoria per tal de poder elimiar primer
 *l'animal amb l'id de la categoria i la categoria amb l'id. Hem creat dos nous metodes per tal d'eliminar.
 *eliminaAnimalsDeIdCategoria,eliminaCategoriaPerId.
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public class Zoo {
    private static final String NOM_BASE_DE_DADES = "animals.bd";
    private static final String CADENA_DE_CONNEXIO = "jdbc:sqlite:" + NOM_BASE_DE_DADES;
    private Connection conn = null;

    public String connecta() throws SQLException {
        if (conn != null) {
            return "Ja connectat";
        }
        conn = DriverManager.getConnection(CADENA_DE_CONNEXIO);
        return "Connectat a " + NOM_BASE_DE_DADES;
    }

    public String desconnecta() throws SQLException {
        if (conn == null) {
            return "Ja desconnectat";
        }
        conn.close();
        return "Desconnectat";
    }


//CATEGORIES

    public String creaTaulaCategories() throws SQLException {
        String sql = "CREATE TABLE  CATEGORIES (" +
            "                id     INTEGER PRIMARY KEY AUTOINCREMENT," +
            "                nom    VARCHAR(40))";
        eliminaTaulaCategories(); // eliminem si ja existia
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
            return "Creada taula CATEGORIES";
        }
    }


    public String eliminaTaulaCategories() throws SQLException{
        eliminaTaulaAnimals();
        String sql="DROP TABLE IF EXISTS CATEGORIES";
         try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
            return "Esborrada taula CATEGORIES";
        }
    }

    public String afegeixCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO CATEGORIES (nom) VALUES ('"
            + categoria.getNom()
            + "')";
        try (Statement st = conn.createStatement()) {
            int num = st.executeUpdate(sql);
            return "Nombre de categories afegides: " + num;
        }
    }

    // public List<Categoria> recuperaCategories() throws SQLException {
    //     String sql = "SELECT * FROM CATEGORIES ORDER BY nom";
    //     try (Statement st = conn.createStatement()) {
    //         ResultSet rs = st.executeQuery(sql);
    //         List<Categoria> categories = new ArrayList<>();
    //         while (rs.next()) {
    //             int bdId = rs.getInt("id");
    //             String nom = rs.getString("nom");
    //             Categoria categoria = new Categoria(bdId, nom);
    //             categories.add(categoria);
    //         }
    //         rs.close();
    //         return categories;
    //     }
    // }

    public String afegeixCategories(List<Categoria> categories) throws SQLException {
        String sql = "INSERT INTO CATEGORIES (nom) values (?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // obté l'estat anterior de l'autocommit.
            boolean anteriorAutoCommit = conn.getAutoCommit();
            // fem que no faci autocommit a cada execució
            conn.setAutoCommit(false);
            try {
                // afegeix cada categoria de la llista
                for (Categoria categoria: categories) {
                    ps.setString(1, categoria.getNom());
                    ps.executeUpdate();
                }
                // si no hi ha problemes accepta tot
                conn.commit();
                return "Nombre de categories afegides: " + categories.size();
            } catch (SQLException e) {
                // trobat problemes amb la inserció: tot enrere
                conn.rollback();
                throw e;
            } finally {
                // tornem l'estat de autocomit tal i com estava
                conn.setAutoCommit(anteriorAutoCommit);
            }
        }
    }

//ANIMALS

    public String creaTaulaAnimals() throws SQLException {
        String sql = "CREATE TABLE ANIMALS (" +
            "                id        INTEGER PRIMARY KEY AUTOINCREMENT," +
            "                nom    VARCHAR(40),"+
            "                categoria INTEGER,"+
            "FOREIGN KEY(categoria) REFERENCES CATEGORIES(id))";

        eliminaTaulaAnimals(); // eliminem si ja existia
        try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
            return "Creada taula ANIMALS";
        }
    }

    public String eliminaTaulaAnimals() throws SQLException{
        String sql="DROP TABLE IF EXISTS ANIMALS";
         try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
            return "Esborrada taula ANIMALS";
        }
    }

     public String afegeixAnimal(Animal animal) throws SQLException {
        int idCategoria = obteIdCategoriaAnimal(animal);
        String sql = "INSERT INTO ANIMALS (nom, categoria) VALUES ('" +
            animal.getNom() +
            "', " +
            idCategoria +
            ")";
        try (Statement st = conn.createStatement()) {
            int num = st.executeUpdate(sql);
            return "Nombre d'animals afegits: " + num;
        }
    }

    private int obteIdCategoriaAnimal(Animal animal) throws SQLException {
        Categoria categoria = animal.getCategoria();
        if (categoria.idIndefinit()) {
            return recuperaCategoriaPerNom(categoria.getNom()).getId();
        } else {
            return categoria.getId();
        }
    }

    public List<Categoria> recuperaCategories() throws SQLException {
        String sql = "SELECT * FROM CATEGORIES ORDER BY nom";
        return recuperaCategoriesAmbSQL(sql);
    }

    public Categoria recuperaCategoriaPerNom(String nom) throws SQLException {
        String sql = "SELECT * FROM CATEGORIES WHERE nom = '" + nom + "'";
        List<Categoria> categories = recuperaCategoriesAmbSQL(sql);
        if (categories.size() != 1) {
            throw new IllegalArgumentException("El nombre de categories amb el nom " +
                    nom + " és " + categories.size() + " i hauria de ser 1");
        }
        return categories.get(0);
    }

    public List<Categoria> recuperaCategoriesAmbSQL(String sql) throws SQLException {
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            List<Categoria> categories = new ArrayList<>();
            while (rs.next()) {
                int bdId = rs.getInt("id");
                String nom = rs.getString("nom");
                Categoria categoria = new Categoria(bdId, nom);
                categories.add(categoria);
            }
            rs.close();
            return categories;
        }
    }

    public List<Animal> recuperaAnimals() throws SQLException {
        String sql = "SELECT * FROM ANIMALS ORDER BY nom";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            List<Animal> animals = new ArrayList<>();
            while (rs.next()) {
                int bdId = rs.getInt("id");
                String nom = rs.getString("nom");
                Categoria categoria = recuperaCategoriaPerId(rs.getInt("categoria"));
                Animal animal = new Animal(bdId, nom, categoria);
                animals.add(animal);
            }
            rs.close();
            return animals;
        }
    }

    private Categoria recuperaCategoriaPerId(int bdId) throws SQLException {
        String sql = "SELECT * FROM CATEGORIES WHERE id = " + bdId;
        List<Categoria> categories = recuperaCategoriesAmbSQL(sql);
        if (categories.size() != 1) {
            throw new IllegalArgumentException("El nombre de categories amb id " +
                    bdId + " és " + categories.size() + " i hauria de ser 1");
        }
        return categories.get(0);
    }

  public String afegeixAnimals(List<Animal> animals) throws SQLException {
        String sql = "INSERT INTO ANIMALS (nom, categoria) values (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // obté l'estat anterior de l'autocommit.
            boolean anteriorAutoCommit = conn.getAutoCommit();
            // fem que no faci autocommit a cada execució
            conn.setAutoCommit(false);
            try {
                // afegeix cada animal de la llista
                for (Animal animal: animals) {
                    ps.setString(1, animal.getNom());
                    ps.setInt(2, obteIdCategoriaAnimal(animal));
                    ps.executeUpdate();
                }
                // si no hi ha problemes accepta tot
                conn.commit();
                return "Nombre de animals afegits: " + animals.size();
            } catch (SQLException e) {
                // trobat problemes amb la inserció: tot enrere
                conn.rollback();
                throw e;
            } finally {
                // tornem l'estat de autocomit tal i com estava
                conn.setAutoCommit(anteriorAutoCommit);
            }
        }
    }


    public String modificaCategoriaAnimal(Animal animal) throws SQLException {
        String sql = "UPDATE Animals set categoria = " +
            obteIdCategoriaAnimal(animal) +
            " WHERE id = " +
            obteIdAnimal(animal);
        try (Statement st = conn.createStatement()) {
            int num = st.executeUpdate(sql);
            return "Nombre d'animals modificats: " + num;
        }
    }

    private int obteIdAnimal(Animal animal) throws SQLException {
        if (animal.idIndefinit()) {
            return recuperaAnimalPerNom(animal.getNom()).getId();
        } else {
            return animal.getId();
        }
    }

    public Animal recuperaAnimalPerNom(String nom) throws SQLException {
        String sql = "SELECT * FROM ANIMALS WHERE nom = '" + nom + "'";
        List<Animal> animals = recuperaAnimalsAmbSQL(sql);
        if (animals.size() != 1) {
            throw new IllegalArgumentException("El nombre de'animals'amb el nom " +
                    nom + " és " + animals.size() + " i hauria de ser 1");
        }
        return animals.get(0);
    }

   public List<Animal> recuperaAnimalsAmbSQL(String sql) throws SQLException {
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            List<Animal> animals = new ArrayList<>();
            while (rs.next()) {
                int bdId = rs.getInt("id");
                String nom = rs.getString("nom");
                int ctgId = rs.getInt("categoria");
                Categoria categoria = recuperaCategoriaPerId(ctgId);
                Animal animal = new Animal(bdId,nom,categoria);
                animals.add(animal);
            }
            rs.close();
            return animals;
        }
    }

    public String eliminaCategoria(Categoria categoria) throws SQLException {
        int idCategoria = obteIdCategoria(categoria);
        int quantsAnimalsEliminats = eliminaAnimalsDeIdCategoria(idCategoria);
        int quantesCategoriesEliminades = eliminaCategoriaPerId(idCategoria);
        return "Animals eliminats: " + quantsAnimalsEliminats +
            ". Categories eliminades: " + quantesCategoriesEliminades;
    }
  

    private int obteIdCategoria(Categoria categoria) throws SQLException {
            if (categoria.idIndefinit()) {
                return recuperaCategoriaPerNom(categoria.getNom()).getId();
            } else {
                return categoria.getId();
            }
    }

     public int eliminaAnimalsDeIdCategoria(int id) throws SQLException{
        String sql="DELETE FROM ANIMALS WHERE categoria="+id;
         try (Statement st = conn.createStatement()) {
           int num =  st.executeUpdate(sql);
            return num;
        }
    }

    public int eliminaCategoriaPerId(int id) throws SQLException{
        String sql="DELETE FROM CATEGORIES WHERE id="+id;
         try (Statement st = conn.createStatement()) {
           int num =  st.executeUpdate(sql);
            return num;
        }
    }

}
