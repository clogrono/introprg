/*
*Implementació d'un entorn intermedi que fa de intermediari entre gatRenat i el usuari 
*/
public class EntornOperatiu{
    GatRenat renat;

    public EntornOperatiu(){
        renat = new GatRenat();
        renat.setEstat("dret");
    }
    public EntornOperatiu(GatRenat renat){
        renat.setEstat("dret");
        this.renat = renat;


    }

    public String processaEntrada(String entrada){
       
        
        
        if(entrada.equals("com estàs?")){
            return "estic "+renat.getEstatComString();
        }
        
        if (entrada.equals("aixeca't")) {
            return renat.aixecat();
        }
        if(entrada.equals("seu")){
            return renat.seu();
        }

        if(entrada.equals("estira't")){
            return renat.estirat();
        }
        else{
            if(entrada.toLowerCase().equals("adéu")){
                return "adéu";
            }
            else{
                return "no t'entenc";
            }
        }
        
    }

    public boolean demanaSortir(String entrada){

        return entrada == "adéu" ? true : false;
    }
    public static void main(String[] args) {


        String pregunta = "com estàs?";
        EntornOperatiu entorn = new EntornOperatiu();
        System.out.print("\n[Renat] "+entorn.processaEntrada(pregunta));
        System.out.print("\n[Renat] "+entorn.processaEntrada("seu"));
        System.out.print("\n[Renat] "+entorn.processaEntrada("adéu"));
       
        System.out.print("\n[Renat] "+entorn.processaEntrada("AdéU"));




    }

}