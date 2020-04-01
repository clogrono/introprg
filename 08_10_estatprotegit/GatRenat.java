public class GatRenat {
   
    GatEstat gatEstat = GatEstat.ESTIRAT;
    int vides = 7;
    

    public String aixecat(){
        if(gatEstat != gatEstat.DRET){
            this.gatEstat = gatEstat.DRET;
            return "m'aixeco";
        }
        else return"no faig res";
    }

    public String seu(){
        if(gatEstat != GatEstat.ASSEGUT){
            this.gatEstat = GatEstat.ASSEGUT;
            return "m'assec";
        }
        else return"no faig res";
    }

    public String estirat(){
        if(gatEstat != GatEstat.ESTIRAT){
            this.gatEstat = GatEstat.ESTIRAT;
            return "m'estiro";
        }
        else return"no faig res";
    }

    public boolean estaViu(){
        return vides > 0 ? true : false ;
    }

    public boolean estaDret(){
        return gatEstat == gatEstat.DRET ? true : false ;
    }

    public boolean estaAssegut(){
        return gatEstat == GatEstat.ASSEGUT ? true : false ;
    }

    public boolean estaEstirat(){
        return gatEstat == GatEstat.ESTIRAT ? true : false ;
    }
    
    public GatEstat getEstat() { 
        return gatEstat;
    }

    public String getEstatComString() { 
        String estat="";
        if(gatEstat == gatEstat.DRET)estat="dret";
        if(gatEstat == GatEstat.ASSEGUT)estat="assegut";
        if(gatEstat == GatEstat.ESTIRAT)estat="estirat";
        return estat;
    }


    public void setEstat(String estat) {
         if (estat =="dret"){
            this.gatEstat = gatEstat.DRET;
         }
         if(estat =="assegut"){
            this.gatEstat = gatEstat.ASSEGUT;
         }
         if(estat =="estirat") {
            this.gatEstat = gatEstat.ESTIRAT;
         }
     }

    public void setEstat(GatEstat gatEstat) {
        if (gatEstat == gatEstat.DRET ||gatEstat == GatEstat.ASSEGUT ||gatEstat == GatEstat.ESTIRAT) {
            this.gatEstat = gatEstat; 
             
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
        // System.out.println("Al gat Renat li queden " + renat.vides + " vides y esta "+renat.getEstat());
        
        System.out.println(renat.aixecat());
       
        System.out.println(renat.seu());
     
        System.out.println(renat.estirat());
        
     }
}

