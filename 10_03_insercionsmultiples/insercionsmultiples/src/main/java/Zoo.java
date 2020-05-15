/*
 * Implementació de la classe Zoo
 *
 * Encapsula una col·lecció d'animals guardats a una base de dades
 *
 * En aquesta versió, s'implementen els mètodes de
 * connexió i desconnexió.
 *
 * Aquesta vegada farem us de l'arraylist i list les llibrerires que ens faran fer
 * més ràpid la feina de afegir categories, primer creem un objecte list de tipus categoria
 * on guardem les categories y despres les inserim amb  el nou metode afegir categories
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

    public List<Categoria> recuperaCategories() throws SQLException {
        String sql = "SELECT * FROM CATEGORIES ORDER BY nom";
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


}
