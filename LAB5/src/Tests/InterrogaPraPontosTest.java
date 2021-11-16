package Tests;

import BibliTex.InterrogaPraPontos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterrogaPraPontosTest {

    private InterrogaPraPontos interroga = new InterrogaPraPontos();

    @Test
    void transformaTest() {
        assertEquals("Tudo bem.", interroga.transforma("Tudo bem?"));
    }

    @Test
    void getNomeTest() {
        assertEquals("InterrogaPraPontos", interroga.getNome());
    }
}