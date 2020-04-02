/**
 * Altre main que comprova l'accés al GatRenat
 */
public class UsaGatRenat {
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();  
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.getEstatComString());
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.getEstat());
 
        System.out.println(renat.aixecat());
       
        System.out.println(renat.seu());
     
        System.out.println(renat.estirat()); 

        renat.setEstat(GatEstat.ESTIRAT);
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.getEstat());

        renat.setEstat(GatEstat.ASSEGUT);
        renat.setEstat(GatEstat.DRET);

    
    
    }

        
}