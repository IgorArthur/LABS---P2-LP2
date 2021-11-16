package Tests;

import BibliTex.clean;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class cleanTest {

    private clean cl = new clean();

    @Test
    void transforma() {
        assertEquals("oi como vc ta", cl.transforma("oi. como vc ta?"));
    }

    @Test
    void getNome() {
        assertEquals("clean", cl.getNome());
    }
}