/**
 * Afegint nous metodes a la Clase gat renar per tal de dinamitzar
 * la classe i donant-li funcions a acada metode que retornen una resposta
 * adient a la crida de la classe
 */
public class GatRenat {
    int vides = 7;
    String estat = "estirat";

    public boolean estaViu(){
        return vides > 0 ? true : false ;
    }

    public boolean estaDret(){
        return estat == "dret" ? true : false ;
    }

    public boolean estaAssegut(){
        return estat == "assegut" ? true : false ;
    }

    public boolean estaEstirat(){
        return estat == "estirat" ? true : false ;
    }
    

    public String getEstat() { 
        return estat;
    }
    public void setEstat(String estat) {
        if (estat =="dret"||estat =="assegut"||estat =="estirat") {
            this.estat = estat;   
        }
    }

    public int getVides(){ 
        return vides;
    }
    public void setVides(int vides) {
        if (vides >= 0) {
            this.vides = vides;  
        }
    }

    public static void main(String[] args) {
        GatRenat renat = new GatRenat();  
        System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.getEstat());
        
        System.out.println(renat.estaAssegut());
        renat.setEstat("dret");
        System.out.println(renat.estaDret());
        renat.setEstat("estirat");
        System.out.println(renat.estaEstirat());
        renat.setEstat("assegut");
        System.out.println(renat.estaAssegut());
        renat.setVides(0);
        System.out.println(renat.estaViu());
     }
}

