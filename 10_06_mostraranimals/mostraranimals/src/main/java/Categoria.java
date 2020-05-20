public class Categoria {
    private final int bdId;         // identificador a la base de dades
    private final String nom;       // nom de la categoria

    public Categoria(String nom) {
        bdId = -1; //-1 indica que el id no esta definit
        this.nom = nom;
    }

    public Categoria(int bdId, String nom) {
        if (bdId < 0) {
            throw new IllegalArgumentException("L'identificador ha de ser positiu");
        }
        this.bdId = bdId;
        this.nom = nom;
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

    @Override
    public String toString() {
        return "Categoria(id:" +
            (bdId < 0 ? "indefinit" : bdId) +
            ", " + 
            nom +
            ")";
    }
}