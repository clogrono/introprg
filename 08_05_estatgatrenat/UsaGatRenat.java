/*
 *Implementació d'un nou main per tal de comprovar l'acesibilitat a la clase GatRenat
 * 
 *  
 */
public class UsaGatRenat {
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();  
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.estat);
        renat.estat="dret";
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.estat);
     }
}