Exercici 17:
Metode de classe: es quell metode que no depende de cap instancia
per poder-lo fer servir.

f (Hora.esValida(14, 12, 21)) {
    Hora hora = new Hora(14, 12, 21);
}

Metode de instacia es quell metode que si depent de insinstancia per
poder-lo fer servir.

public int getHores(){
        return hora;
    }

    En aquest cas em de fer instancia:
    Hora h = new Hora();
    per poder accedir al valor de hora.

Exercici 18:
Quan una variable de una propietat de clase es a dir estatica 
el seu valor es compartit per tots els usuaris es a dir entre 
totes les instancies de l'objecte es com si fos una variable 
global.

//Constructor 
public GatRenat() {

        // Per accedir al la propietat ho fem igual que als metoder Class.popietat.
        
        GatRenat.numInstancies++;

        this.id=GatRenat.numInstancies; 
        System.out.println("Creat un nou gat Renat. Ja van " + numInstancies);
    }

Exercici 19:
 Final es una paraula clau a java que ens permet inicialitza una variables un sol cop 
 el prodriem fer servir com una constant, es aquest cas com id ens interesa que nomes tingui un valor 
 i no es pugui modificar al intentar introiduir el metode setId-> Ens indica que no tenim acces a id per
 modificarla ja que es porta final.

 private final int id;

 //Ens indica que no tenim acces a id per modificarla ja que es porta final 
    // public void setId(int num){
    //     this.id=num;
    // }
