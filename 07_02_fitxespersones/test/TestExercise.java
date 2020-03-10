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
            String nom = "Laia";
            String cognoms = "Sànchez d'Àrgent";
            int edat = 19;
            String esperada = "Fitxa\n=====\nNom: Laia Sànchez d'Àrgent\nEdat: 19 anys\n";
            String trobada = InformePersona.composaFitxa(nom, cognoms, edat);
            assertEquals(esperada, trobada);
        }

        @Test
        public void mark() {
            String nom = "Mark";
            String cognoms = "Twain";
            int edat = 1;
            String esperada = "Fitxa\n=====\nNom: Mark Twain\nEdat: 1 any\n";
            String trobada = InformePersona.composaFitxa(nom, cognoms, edat);
            assertEquals(esperada, trobada);
        }
    }

    @Nested
    @DisplayName("Tests del mètodes composaFitxes()")
    class TestMetodeComposaFitxes {
        @Test
        public void unSolEstudiant() {
            String[] noms = {"Laia"};
            String[] cognoms = {"Sànchez d'Àrgent"};
            int[] edats = {19};
            String esperada = "Fitxa\n=====\nNom: Laia Sànchez d'Àrgent\nEdat: 19 anys\n";
            String trobada = InformePersona.composaFitxes(noms, cognoms, edats);
            assertEquals(esperada, trobada);
        }

        @Test
        public void tresEstudiants() {
            String[] noms = {"Laia", "Mark", "Lin"};
            String[] cognoms = {"Sànchez d'Àrgent", "Twain", "Chi"};
            int[] edats = {19, 1, 24};
            String esperada = "Fitxa\n=====\nNom: Laia Sànchez d'Àrgent\nEdat: 19 anys\n" +
                "Fitxa\n=====\nNom: Mark Twain\nEdat: 1 any\n" +
                "Fitxa\n=====\nNom: Lin Chi\nEdat: 24 anys\n" ;
            String trobada = InformePersona.composaFitxes(noms, cognoms, edats);
            assertEquals(esperada, trobada);
        }

    }

}
