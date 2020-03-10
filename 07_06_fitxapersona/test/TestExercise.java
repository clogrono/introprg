/*
 * Unit testing methods for an exercise
 */

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;

public class TestExercise {

    @Nested
    @DisplayName("Tests del mètodes composaFitxa()")
    class TestMetodeComposaFitxa {
        @Test
        public void laia() {
            Persona persona = new Persona();
            persona.nom = "Laia";
            persona.cognoms = "Sànchez d'Àrgent";
            persona.edat = 19;
            String esperada = "Fitxa\n=====\nNom: Laia Sànchez d'Àrgent\nEdat: 19 anys\n";
            String trobada = InformePersona.composaFitxa(persona);
            assertEquals(esperada, trobada);
        }

        @Test
        public void mark() {
            Persona persona = new Persona();
            persona.nom = "Mark";
            persona.cognoms = "Twain";
            persona.edat = 1;
            String esperada = "Fitxa\n=====\nNom: Mark Twain\nEdat: 1 any\n";
            String trobada = InformePersona.composaFitxa(persona);
            assertEquals(esperada, trobada);
        }
    }

}
