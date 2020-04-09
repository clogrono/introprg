
/**
 * Implementarem el metode getId que l'aconseguirem inicialitzan dintre del constructor i cada vegada
 * que neixi un gat nou agafara el valor de numInstancia, al ser nomes public i no static el valor 
 * es guarda per a cada gat individualment es com si fesim un setId() pero en lloc de ferho al main
 * es fa al constructor llavors aconseguim els index.
 * També veiem que al imprimir el gat per defecte cruida al metode toString i imprimeix el seu valor
 */
public class GatRenat {

    private static int numInstancies = 0;
    private int id;
    private int vides = 7;
    public GatRenat() {
        // constructor per defecte incrementa el nombre d'instàncies
        
        GatRenat.numInstancies++;
        this.id=GatRenat.numInstancies; 
        System.out.println("Creat un nou gat Renat. Ja van " + numInstancies);
    }
  
    public static int getNumInstancies() {
        // retorna el nombre d'instàncies creades fins el moment
        return numInstancies;
    }

    public int getId(){
        return id;
    }

   
  
    public int getVides() { return vides; }

    public void setVides(int vides) { if (vides>=0) this.vides = vides; }

    public String toString() { return "Gat Renat ("+id+") amb " + vides + " vides"; }

    public static void main(String[] args) {

        System.out.println("Inicialment el nombre d'instàncies és: " +
            GatRenat.getNumInstancies());
        // crea uns quants GatRenat per demostrar l'ús de membres estàtics
        GatRenat[] gats = new GatRenat[10];
        for (int i=0; i < gats.length; i++) {
            gats[i] = new GatRenat();
            gats[i].setVides(i);    // canviem les vides només per distingir-los
            // System.out.println(gats[i] + " amb " +
            //        gats[i].getNumInstancies() +
            //        " germanets");
            System.out.println("Tenim: " + gats[i]+ " amb " +
                gats[i].getNumInstancies() + " germanets");
        }
        // tornem a demanar a cadascun quants germans té
        System.out.println("I si tornem a demanar-los quants germans tenen, ens diuen:");
        for (int i=0; i < gats.length; i++) {
            System.out.println(gats[i].getId()+"->"+gats[i].toString() + " amb " +
                gats[i].getNumInstancies() + " germanets");
        }
    }
}