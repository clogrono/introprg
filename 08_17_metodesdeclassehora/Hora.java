/**
 * Implementarem metodes estatics que son accesible desde la propia mateixa clase
 * als cuals no haurem d'instancia per poder-los fer servir.
 * Directament accedirem aquests metodes nombran a la classe y cridant al metode
 * en questió, em creat esValid en versio estatica que implementarem al constructo 
 * amb parametres per comprovar la validesa de hora, el mateix amb compareTo i duplica
 */
public class Hora {

    private int hora;
    private int minut;
    private int segon;

    public Hora(){
        this.hora=0;
        this.minut=0;
        this.segon=0;
    }

    public Hora(int hores, int minuts, int segons){
        if(Hora.esValida(hores, minuts, segons)){
            this.hora=hores;
            this.minut=minuts;
            this.segon=segons;
        }else{
            this.hora=0;
            this.minut=0;
            this.segon=0;
        }   
    }
    
    public void incrementa(){

        int h = hora;
        int m = minut;
        int s = segon;
        s = s + 1;
        if(s>59){
            this.segon = s % 60;
            m = m + 1;
            if(m>59){
                this.minut = m % 60;
                h = h + 1;
                if(h>23){
                    this.hora = h % 24;
                }
                else{
                    this.hora = h;
                }
            }else{
                this.minut = m;
            }

        }else{
            this.segon = s;
        }

    }

    public void incrementa(int num){

        int h = hora;
        int m = minut;
        int s = segon;

        int horAux=num/3600;
        int hor = horAux%24;
        int min=(num-(3600*horAux))/60;
        int seg=num-((horAux*3600)+(min*60));

        
        s = s + seg;
        if(s>59){
            this.segon = s % 60;
            m = m + 1;
        }else{
            this.segon = s;
        }

        m = m + min;
        if(m>59){
            this.minut = m % 60;
            h = h + 1;
            
        }else{
            this.minut = m;
        }

        h = h +hor;
        if(h>23){
            this.hora = h % 24;
        }
        else{
            this.hora = h;
        }

    }

    public void decrementa(){

        int h = hora;
        int m = minut;
        int s = segon;
        s = s - 1;
        if(s<0){
            this.segon = 59;
            m = m - 1;
            if(m<0){
                this.minut = 59;
                h = h - 1;
                if(h<0){
                    this.hora = 23;
                }
                else{
                    this.hora = h;
                }
            }else{
                this.minut = m;
            }

        }else{
            this.segon = s;
        }

    }

    public void decrementa(int num){

        int h = hora;
        int m = minut;
        int s = segon;

        int horAux=num/3600;
        int hor = horAux%24;
        int min=(num-(3600*horAux))/60;
        int seg=num-((horAux*3600)+(min*60));

        
        s = s - seg;
        if(s<0){
            this.segon = 60 + s;
            m = m - 1;
        }else{
            this.segon = s;
        }

        m = m - min;
        if(m<0){
            this.minut = 60 + m;
            h = h - 1;
            
        }else{
            this.minut = m;
        }

        h = h - hor;
        if(h<0){
            this.hora = 24 + h;
        }
        else{
            this.hora = h;
        }

    }

    public static boolean esValida(int hores, int minuts, int segons){

        if((hores >= 0 && hores<=23)&&(minuts >= 0 && minuts<=59)&&(segons >= 0 && segons<=59)){
            return true;
        }else{
            return false;
        }


    }

    public static Hora duplica(Hora h){
        Hora h1 = new Hora(h.getHores(),h.getMinuts(),h.getSegons());
        return h1;
    }


    public int getHores(){
        return hora;
    }

    public void setHores(int hora){
        this.hora = hora;
    }

    public int getMinuts(){
        return minut;
    }

    public void setMinuts(int minut){
        this.minut = minut;
    }

    public int getSegons(){
        return segon;
    }

    public void setSegons(int segon){
        this.segon = segon;
    }
    
    public int compareTo(Hora h){
        
        if((hora == h.getHores())&&(minut == h.getMinuts())&&(segon == h.getSegons())){
            return 0;
        }else{
            if((hora >= h.getHores())&&(minut >= h.getMinuts())&&(segon > h.getSegons())
            ||(hora >= h.getHores())&&(minut > h.getMinuts())&&(segon >= h.getSegons())
            ||(hora > h.getHores())&&(minut >= h.getMinuts())&&(segon >= h.getSegons())){
                return 1;
            }
            else{
                return -1;
            }

        }

    }

    public static int compareTo(Hora h1, Hora h2){
        
        if((h1.getHores() == h2.getHores())&&(h1.getMinuts() == h2.getMinuts())&&(h1.getSegons() == h2.getSegons())){
            return 0;
        }else{
            if((h1.getHores() >= h2.getHores())&&(h1.getMinuts() >= h2.getMinuts())&&(h1.getSegons() > h2.getSegons())
            ||(h1.getHores() >= h2.getHores())&&(h1.getMinuts() > h2.getMinuts())&&(h1.getSegons() >= h2.getSegons())
            ||(h1.getHores() > h2.getHores())&&(h1.getMinuts() >= h2.getMinuts())&&(h1.getSegons() >= h2.getSegons())){
                return 1;
            }
            else{
                return -1;
            }

        }

    }


    public String toString(){
        
        return String.format("%d:%02d:%02d",
        hora,
        minut,
        segon
        );
    }

    public static void main(String[] args) {
        Hora h = new Hora(1,2,25);

        System.out.println(h.getHores()+":"+h.getMinuts()+":"+h.getSegons());
        // h.incrementa(-1);
        // System.out.println(h.getHores()+":"+h.getMinuts()+":"+h.getSegons());
        h.decrementa(86399);
        System.out.println(h.toString());
        System.out.println(Hora.esValida(h.getHores(), h.getMinuts(),h.getSegons()));
        System.out.println(h.compareTo(new Hora(3,2,26)));
        System.out.println(Hora.duplica(h).toString());


       
    }

}