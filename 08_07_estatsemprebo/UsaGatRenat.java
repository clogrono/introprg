public class UsaGatRenat {
    public static void main(String[] args) {
        GatRenat renat = new GatRenat();  
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.getStat());
        renat.setEstat("dret");
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.getStat());
     }
}