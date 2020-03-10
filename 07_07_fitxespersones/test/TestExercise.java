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

    @Nested
    @DisplayName("Tests del mètodes composaFitxes()")
    class TestMetodeComposaFitxes {
        @Test
        public void unSolEstudiant() {
            Persona[] persones = new Persona[1];
            persones[0] = new Persona();
            persones[0].nom = "Laia";
            persones[0].cognoms = "Sànchez d'Àrgent";
            persones[0].edat = 19;
            String esperada = "Fitxa\n=====\nNom: Laia Sànchez d'Àrgent\nEdat: 19 anys\n";
            String trobada = InformePersona.composaFitxes(persones);
            assertEquals(esperada, trobada);
        }

        @Test
        public void tresEstudiants() {
            Persona[] persones = new Persona[3];
            persones[0] = new Persona();
            persones[0].nom = "Laia";
            persones[0].cognoms = "Sànchez d'Àrgent";
            persones[0].edat = 19;
            persones[1] = new Persona();
            persones[1].nom = "Mark";
            persones[1].cognoms = "Twain";
            persones[1].edat = 1;
            persones[2] = new Persona();
            persones[2].nom = "Lin";
            persones[2].cognoms = "Chi";
            persones[2].edat = 24;
            String esperada = "Fitxa\n=====\nNom: Laia Sànchez d'Àrgent\nEdat: 19 anys\n" +
                "Fitxa\n=====\nNom: Mark Twain\nEdat: 1 any\n" +
                "Fitxa\n=====\nNom: Lin Chi\nEdat: 24 anys\n" ;
            String trobada = InformePersona.composaFitxes(persones);
            assertEquals(esperada, trobada);
        }

    }

}
