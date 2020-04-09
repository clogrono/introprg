/*
*Afegint més metodes a la Classe GatRenat per tal de dinamitza 
*la seves respostes, metodes que el fan seure, aixecar-se, estirarse
*que fa que l'experiencia de l'usuari sigui mes ralista la resposta
*del gat es com si fos amb un a gat real.
*/
public class GatRenat {
    int vides = 7;
    String estat = "estirat";

    public String aixecat(){
        if(estat != "dret"){
            this.estat = "dret";
            return "m'aixeco";
        }
        else return"no faig res";
    }

    public String seu(){
        if(estat != "assegut"){
            this.estat = "assegut";
            return "m'assec";
        }
        else return"no faig res";
    }

    public String estirat(){
        if(estat != "estirat"){
            this.estat = "estirat";
            return "m'estiro";
        }
        else return"no faig res";
    }

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
        
        System.out.println(renat.aixecat());
       
        System.out.println(renat.seu());
     
        System.out.println(renat.estirat());
        
     }
}

