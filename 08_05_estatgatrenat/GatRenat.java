/*
*Implementacio del gat renat donant-li valor predefinits d'inici
*i accedint aquests
 */
public class GatRenat {
    int vides = 7;
    String estat = "estirat";                // vides disponibles del gat Renat
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();  
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.estat);
        renat.estat="assegut";
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.estat);
    }
}

