/*
 * Unit testing methods for an exercise
 */

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class TestExercise {

    @Test
    public void testHoraPerDefecte000() {
        Hora hora = new Hora();
        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 0, hora.getMinuts());
        assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstructorEspecific() {
        Hora hora = new Hora(1, 2, 3);
        assertEquals("Respecte a les hores", 1, hora.getHores());
        assertEquals("Respecte als minuts", 2, hora.getMinuts());
        assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixCorrecteQuanValorsAmbLimitSuperior() {
        Hora hora = new Hora(23, 59, 59);

        assertEquals("Respecte a les hores", 23, hora.getHores());
        assertEquals("Respecte als minuts", 59, hora.getMinuts());
        assertEquals("Respecte als segons", 59, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNoValidPerHores() {
        Hora hora = new Hora(24, 2, 3);

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 0, hora.getMinuts());
        assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNegatiuPerHores() {
        Hora hora = new Hora(-24, 2, 3);

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 0, hora.getMinuts());
        assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNoValidPerMinuts() {
        Hora hora = new Hora(1, 60, 3);

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 0, hora.getMinuts());
        assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNegatiuPerMinuts() {
        Hora hora = new Hora(1, -6, 3);

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 0, hora.getMinuts());
        assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNoValidPerSegons() {
        Hora hora = new Hora(1, 2, 60);

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 0, hora.getMinuts());
        assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNegatiuPerSegons() {
        Hora hora = new Hora(1, 2, -1);

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 0, hora.getMinuts());
        assertEquals("Respecte als segons", 0, hora.getSegons());
    }


    @Test
    public void testHoraIncrementaCasEstandard() {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa();

        assertEquals("Respecte a les hores", 1, hora.getHores());
        assertEquals("Respecte als minuts", 2, hora.getMinuts());
        assertEquals("Respecte als segons", 4, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaCasIncrementaMinut() {
        Hora hora = new Hora(1, 2, 59);

        hora.incrementa();

        assertEquals("Respecte a les hores", 1, hora.getHores());
        assertEquals("Respecte als minuts", 3, hora.getMinuts());
        assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaCasIncrementaHora() {
        Hora hora = new Hora(1, 59, 59);

        hora.incrementa();

        assertEquals("Respecte a les hores", 2, hora.getHores());
        assertEquals("Respecte als minuts", 0, hora.getMinuts());
        assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaCasReinicia() {
        Hora hora = new Hora(23, 59, 59);

        hora.incrementa();

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 0, hora.getMinuts());
        assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasEstandard() {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(2);

        assertEquals("Respecte a les hores", 1, hora.getHores());
        assertEquals("Respecte als minuts", 2, hora.getMinuts());
        assertEquals("Respecte als segons", 5, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasIncrementaMinut() {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(59);

        assertEquals("Respecte a les hores", 1, hora.getHores());
        assertEquals("Respecte als minuts", 3, hora.getMinuts());
        assertEquals("Respecte als segons", 2, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasIncrementaHora() {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(3539);

        assertEquals("Respecte a les hores", 2, hora.getHores());
        assertEquals("Respecte als minuts", 1, hora.getMinuts());
        assertEquals("Respecte als segons", 2, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasReinicia() {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(82739);

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 1, hora.getMinuts());
        assertEquals("Respecte als segons", 2, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasGranN() {
        Hora hora = new Hora(0, 0, 0);

        hora.incrementa(172737);

        assertEquals("Respecte a les hores", 23, hora.getHores());
        assertEquals("Respecte als minuts", 58, hora.getMinuts());
        assertEquals("Respecte als segons", 57, hora.getSegons());
    }

    // test compareTo
    @Test
    public void testCompareToReconeixMenorMajor() {
        Hora horaMenor = new Hora(1, 2, 3);
        Hora horaMajor = new Hora(1, 2, 4);

        assertTrue(horaMenor.compareTo(horaMajor)<0);
    }

    @Test
    public void testCompareToReconeixMajorMenor() {
        Hora horaMenor = new Hora(1, 2, 3);
        Hora horaMajor = new Hora(1, 2, 4);

        assertTrue(horaMajor.compareTo(horaMenor)>0);
    }

    @Test
    public void testCompareToReconeixHoresIguals() {
        Hora hora1 = new Hora(1, 2, 3);
        Hora hora2 = new Hora(1, 2, 3);

        assertEquals(0, hora1.compareTo(hora2));
    }

    // Test decrementa
    @Test
    public void testHoraIncrementaSegonsNegatius() {
        Hora hora = new Hora(1, 2, 4);

        hora.incrementa(-1);

        assertEquals("Respecte a les hores", 1, hora.getHores());
        assertEquals("Respecte als minuts", 2, hora.getMinuts());
        assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasEstandard() {
        Hora hora = new Hora(1, 2, 4);

        hora.decrementa();

        assertEquals("Respecte a les hores", 1, hora.getHores());
        assertEquals("Respecte als minuts", 2, hora.getMinuts());
        assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasDecrementaMinut() {
        Hora hora = new Hora(0, 2, 3);


        hora.decrementa(60);
        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 1, hora.getMinuts());
        assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasDecrementaHora() {
        Hora hora = new Hora(1, 2, 3);

        hora.decrementa(3600);

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 2, hora.getMinuts());
        assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasReinicia() {
        Hora hora = new Hora(0, 0, 0);

        hora.decrementa(1);

        assertEquals("Respecte a les hores", 23, hora.getHores());
        assertEquals("Respecte als minuts", 59, hora.getMinuts());
        assertEquals("Respecte als segons", 59, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasEstandard() {
        Hora hora = new Hora(1, 2, 5);

        hora.decrementa(2);

        assertEquals("Respecte a les hores", 1, hora.getHores());
        assertEquals("Respecte als minuts", 2, hora.getMinuts());
        assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasDecrementaMinut() {
        Hora hora = new Hora(3, 2, 4);

        hora.decrementa(60);

        assertEquals("Respecte a les hores", 3, hora.getHores());
        assertEquals("Respecte als minuts", 1, hora.getMinuts());
        assertEquals("Respecte als segons", 4, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasDecrementaHora() {
        Hora hora = new Hora(1, 2, 3);

        hora.decrementa(3600);

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 2, hora.getMinuts());
        assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasReinicia() {
        Hora hora = new Hora(0, 0, 0);

        hora.decrementa(86399);

        assertEquals("Respecte a les hores", 0, hora.getHores());
        assertEquals("Respecte als minuts", 0, hora.getMinuts());
        assertEquals("Respecte als segons", 1, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasGranN() {
        Hora hora = new Hora(0, 0, 0);

        hora.decrementa(432001);

        assertEquals("Respecte a les hores", 23, hora.getHores());
        assertEquals("Respecte als minuts", 59, hora.getMinuts());
        assertEquals("Respecte als segons", 59, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNegatiu() {
        Hora hora = new Hora(1, 2, 3);

        hora.decrementa(-1);

        assertEquals("Respecte a les hores", 1, hora.getHores());
        assertEquals("Respecte als minuts", 2, hora.getMinuts());
        assertEquals("Respecte als segons", 4, hora.getSegons());
    }

    //  test de toString()
    @Test
    public void testHoraToStringGeneral() {
        Hora hora = new Hora(11, 21, 31);
        String expected = "11:21:31";
        assertEquals(expected, hora.toString());
    }

    @Test
    public void testHoraToStringLeadingZeros() {
        Hora hora = new Hora(1, 2, 3);
        String expected = "1:02:03";
        assertEquals(expected, hora.toString());
    }

}
