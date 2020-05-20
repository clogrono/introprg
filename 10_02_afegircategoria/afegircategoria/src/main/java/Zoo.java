/*
 * Implementació de la classe Zoo
 *
 * Encapsula una col·lecció d'animals guardats a una base de dades
 *
 * En aquesta versió, s'implementen els mètodes de
 * connexió i desconnexió.
 *També creem la taula Cartegories i també l'eliminem ara fem 
 * un insert tambe en la taula per aixo preparem una nova sentencia sql per
 *tal de aconseguir-ho
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

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

    public String eliminaTaulaCategories() throws SQLException{
        String sql="DROP TABLE IF EXISTS CATEGORIES";
         try (Statement st = conn.createStatement()) {
            st.executeUpdate(sql);
            return "Esborrada taula CATEGORIES";
        }
    }

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

    public String afegeixCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO CATEGORIES (nom) VALUES ('"
            + categoria.getNom()
            + "')";
        try (Statement st = conn.createStatement()) {
            int num = st.executeUpdate(sql);
            return "Nombre de categories afegides: " + num;
        }
    }
}
