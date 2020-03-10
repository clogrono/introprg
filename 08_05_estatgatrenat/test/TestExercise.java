/*
 * Unit testing methods for an exercise
 */

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class TestExercise {

    @Test
    public void renatNeixEstirat() {
        String esperada = "estirat";
        String trobada = new GatRenat().estat;
        assertEquals(esperada, trobada);
    }
}
