/*
 * Unit testing methods for an exercise
 */

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class TestExercise {
    @Test
    public void testGatRenatImplementaIds() {
        // Aquest test comprova una propietat estàtica i, per aquesta raó,
        // requereix ser executat en un únic mètode. 

        // comprovació del primer id assignat
        GatRenat renat1 = new GatRenat();
        assertEquals("El primer gat ha de tenir id 1.", 1, renat1.getId());

        // comprovació del segon id assignat
        GatRenat renat2 = new GatRenat();
        assertEquals("El segon gat ha de tenir id 2.", 2, renat2.getId());

        // comprovació de que el primer gat continua mantenint l'id
        assertEquals("El primer gat ha de mantenir id.", 1, renat1.getId());

        // comprovació del retorn adequat per toString()
        assertEquals("Gat Renat (2) amb 7 vides", renat2.toString());
    }

}
