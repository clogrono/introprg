/*
 * Unit testing methods for an exercise
 */

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

public class TestExercise {

    @Nested
    @DisplayName("Tests de la classe GatRenat")
    class TestGatRenat {

        @Test
        public void testRenatNeixEstirat() {
            assertEquals("estirat", new GatRenat().getEstatComString());
        }
        @Test
        public void testRenatPotEstarDret() {
            GatRenat renat = new GatRenat();
            renat.setEstat("dret");
            assertEquals("dret", renat.getEstatComString());
        }
        @Test
        public void testRenatPotEstarAssegut() {
            GatRenat renat = new GatRenat();
            renat.setEstat("assegut");
            assertEquals("assegut", renat.getEstatComString());
        }
        @Test
        public void testRenatPotEstirarse() {
            GatRenat renat = new GatRenat();
            renat.setEstat("assegut");
            renat.setEstat("estirat");
            assertEquals("estirat", renat.getEstatComString());
        }
        @Test
        public void testRenaNoPotCorrer() {
            GatRenat renat = new GatRenat();
            renat.setEstat("corrent");
            assertEquals("estirat", renat.getEstatComString());
        }
        @Test
        public void testRenatNeixViu() {
            assertTrue(new GatRenat().estaViu());
        }
        @Test
        public void testRenatNoEstaViuAmbZeroVides() {
            GatRenat renat = new GatRenat();
            renat.setVides(0);
            assertFalse(renat.estaViu());
        }
        @Test
        public void testRenatDiuEstarEstiratEnNeixer() {
            assertTrue(new GatRenat().estaEstirat());
        }
        @Test
        public void testRenatDiuNoEstarEstiratQuanDret() {
            GatRenat renat = new GatRenat();
            renat.setEstat("dret");
            assertFalse(renat.estaEstirat());
        }
        @Test
        public void testRenatDiuEstarAssegutQuanHoEsta() {
            GatRenat renat = new GatRenat();
            renat.setEstat("assegut");
            assertTrue(renat.estaAssegut());
        }
        @Test
        public void testRenatDiuNoEstarAssegutQuanNoHoEsta() {
            assertFalse(new GatRenat().estaAssegut());
        }
        @Test
        public void testRenatDiuEstarDretQuanHoEsta() {
            GatRenat renat = new GatRenat();
            renat.setEstat("dret");
            assertTrue(renat.estaDret());
        }
        @Test
        public void testRenatDiuNoEstarDretQuanNoHoEsta() {
            assertFalse(new GatRenat().estaDret());
        }

        @Test
        public void testRenatSEstira() {
            GatRenat renat = new GatRenat();
            renat.setEstat("dret");
            String resposta = renat.estirat();
            assertTrue(renat.estaEstirat());
            assertEquals("m'estiro", resposta);
        }
        @Test
        public void testRenatSeu() {
            GatRenat renat = new GatRenat();
            String resposta = renat.seu();
            assertTrue(renat.estaAssegut());
            assertEquals("m'assec", resposta);
        }
        @Test
        public void testRenatSAixeca() {
            GatRenat renat = new GatRenat();
            String resposta = renat.aixecat();
            assertTrue(renat.estaDret());
            assertEquals("m'aixeco", resposta);
        }
        @Test
        public void testRenatNoFaResQuanDemanemQueSEstiriIJaHoEstava() {
            GatRenat renat = new GatRenat();
            String resposta = renat.estirat();
            assertEquals("no faig res", resposta);
        }
        @Test
        public void testRenatNoFaResQuanDemanemQueSAsseguiIJaHoEstava() {
            GatRenat renat = new GatRenat();
            renat.seu();
            String resposta = renat.seu();
            assertEquals("no faig res", resposta);
        }

        @Test
        public void testRenatNoFaResQuanDemanemQueSAixequiIJaHoEstava() {
            GatRenat renat = new GatRenat();
            renat.aixecat();
            String resposta = renat.aixecat();
            assertEquals("no faig res", resposta);
        }

        @Test
        public void testRenatCanviaEstatAmbGatEstat() {
            GatRenat renat = new GatRenat();
            renat.setEstat(GatEstat.ESTIRAT);
            renat.setEstat(GatEstat.ASSEGUT);
            renat.setEstat(GatEstat.DRET);
            assertEquals(GatEstat.DRET, renat.getEstat());
        }


        @Test
        public void sensePropietatString() {
            for (java.lang.reflect.Field field: GatRenat.class.getDeclaredFields()) {
                assertFalse("Aquesta versió de GatRenat no necessita el camp de tipus String " +
                        field.getName(),
                        field.getType().isAssignableFrom(String.class));
            }
        }


        @Test
        public void testRenatNeixDret() {
            GatRenat renat = new GatRenat(GatEstat.DRET);
            assertEquals(GatEstat.DRET, renat.getEstat());
        }
    }

    @Nested
    @DisplayName("Tests de la classe EntornOperatiu")
    class TestEntornOperatiu {
        private EntornOperatiu entornAmbGatIntern;
        private EntornOperatiu entornAmbGatExtern;
        private GatRenat renat;

        @BeforeEach
        public void start() {
            entornAmbGatIntern = new EntornOperatiu();
            renat = new GatRenat();
            entornAmbGatExtern = new EntornOperatiu(renat);
        }

        @Test
        public void testEntornOperatiuEsPotCrear() {
            assertEquals("estic dret", entornAmbGatIntern.processaEntrada("com estàs?"));
            assertEquals("dret", renat.getEstatComString());
        }

        @Test
        public void testProcessaAdeu() {
            String resposta = entornAmbGatIntern.processaEntrada("adéu");
            assertEquals("adéu", resposta);
            assertTrue(entornAmbGatIntern.demanaSortir("adéu"));
        }

        @Test
        public void testComandaDesconeguda() {
            String resposta = entornAmbGatIntern.processaEntrada("hola");
            assertEquals("no t'entenc", resposta);
        }

        @Test
        public void testNoConsideraCase() {
            String resposta = entornAmbGatIntern.processaEntrada("AdéU");
            assertEquals("adéu", resposta);
        }

        @Test
        public void testProcessaSeu() {
            String resposta = entornAmbGatIntern.processaEntrada("seu");
            assertEquals("m'assec", resposta);

            entornAmbGatExtern.processaEntrada("seu");
            assertEquals("assegut", renat.getEstatComString());
        }

        @Test
        public void testProcessaAixecat() {
            String resposta = entornAmbGatIntern.processaEntrada("aixeca't");
            assertEquals("no faig res", resposta); // està dret d'inici

            renat.seu();    // perquè no estigui dret
            entornAmbGatExtern.processaEntrada("aixeca't");
            assertEquals("dret", renat.getEstatComString());
        }

        @Test
        public void testProcessaEstirat() {
            String resposta = entornAmbGatIntern.processaEntrada("estira't");
            assertEquals("m'estiro", resposta);

            entornAmbGatExtern.processaEntrada("estira't");
            assertEquals("estirat", renat.getEstatComString());
        }

    }

}
