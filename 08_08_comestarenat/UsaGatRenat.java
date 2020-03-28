public class UsaGatRenat {
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();  
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.getStat());
        
        System.out.println(renat.estaAssegut());
        renat.setEstat("dret");
        System.out.println(renat.estaDret());
        renat.setEstat("estirat");
        System.out.println(renat.etaEstirat());
        renat.setEstat("assegut");
        System.out.println(renat.estaAssegut());
        reant.setVides(0);
        System.out.println(reant.estaViu());
     }
}