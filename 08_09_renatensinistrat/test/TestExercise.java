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
}
