/*
 * Implementació de la classe Animal
 *
 * Encapsula un animal
 */

public class Animal {
    private final int bdId;
    private final String nom;
    private Categoria categoria;

    public Animal(int bdId, String nom, Categoria categoria) {
        if (bdId < 0) {
            throw new IllegalArgumentException("L'identificador ha de ser positiu");
        }
        this.bdId = bdId;
        this.nom = nom;
        this.categoria = categoria;
    }

    public Animal(String nom, Categoria categoria) {
        this.bdId = -1;
        this.nom = nom;
        this.categoria = categoria;
    }

    public boolean idIndefinit() {
        return bdId < 0;
    }
    public int getId() {
        return bdId;
    }
    public String getNom() {
        return nom;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Animal(id:" +
            (bdId < 0 ? "indefinit" : bdId) +
            ", " + 
            nom +
            ", " + 
            categoria +
            ")";
    }
}
