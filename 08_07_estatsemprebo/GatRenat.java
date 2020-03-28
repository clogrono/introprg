public class GatRenat {
    int vides = 7;
    String estat = "estirat";

    public String getEstat() { 
        return estat;
    }
    public void setEstat(String estat) {
        // modifica el nombre de vides del gat si el paràmetre vides conté un valor vàlid
        if (estat =="dret"||estat =="assegut"||estat =="estirat") {
            this.estat = estat;   
        }
    }
}

