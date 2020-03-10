/*
 * Unit testing methods for an exercise
 */

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class TestExercise {

    @Test
    public void testRenatNeixEstirat() {
        assertEquals("estirat", new GatRenat().getEstat());
    }
    @Test
    public void testRenatPotEstarDret() {
        GatRenat renat = new GatRenat();
        renat.setEstat("dret");
        assertEquals("dret", renat.getEstat());
    }
    @Test
    public void testRenatPotEstarAssegut() {
        GatRenat renat = new GatRenat();
        renat.setEstat("assegut");
        assertEquals("assegut", renat.getEstat());
    }
    @Test
    public void testRenatPotEstirarse() {
        GatRenat renat = new GatRenat();
        renat.setEstat("assegut");
        renat.setEstat("estirat");
        assertEquals("estirat", renat.getEstat());
    }
    @Test
    public void testRenaNoPotCorrer() {
        GatRenat renat = new GatRenat();
        renat.setEstat("corrent");
        assertEquals("estirat", renat.getEstat());
    }
    @Test
    public void testRenatSetEstatPotRebreNull() {
        GatRenat renat = new GatRenat();
        renat.setEstat(null);
        assertEquals("estirat", renat.getEstat());
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

}
