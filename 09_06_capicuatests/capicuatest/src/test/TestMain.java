/*
*En aqest tes comprovarem que ens retorna els valors que 
*s'esperem, provem amb paraules que ja son capicua
*amb paraules que no ho so i es converteixen al retornar
*i quan no s'envia res, ens retorna anna o si esta buit.
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMain{
    @Test
    public void paraulaTururut() {
        String paraula = "tururut";
        String esperat = "La paraula capicua es <b>tururut</b>";
        String obtingut = Main.composaSalutacio(paraula);
        assertEquals(esperat, obtingut);
    }
    @Test
    public void paraulaRoma() {
        String paraula = "roma";
        String esperat = "La paraula capicua es <b>roma</b>";
        String obtingut = Main.composaSalutacio(paraula);
        assertEquals(esperat, obtingut);
    }
    @Test
    public void quanLiPassoNull() {
        String nom = null;
        String esperat = "La paraula capicua es <b>anna</b>";
        String obtingut = Main.composaSalutacio(nom);
        assertEquals(esperat, obtingut);
    }

    @Test
    public void quanLiPassoBuit() {
        String nom = "";
        String esperat = "La paraula capicua es <b>anna</b>";
        String obtingut = Main.composaSalutacio(nom);
        assertEquals(esperat, obtingut);
    }
}