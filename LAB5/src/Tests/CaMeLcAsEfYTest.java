package Tests;

import BibliTex.CaMeLcAsEfY;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaMeLcAsEfYTest {

    private CaMeLcAsEfY camel = new CaMeLcAsEfY();

    @Test
    void transformaTest() {
        assertEquals("IgOr aRtHuR", camel.transforma("igor arthur"));
    }

    @Test
    void getNomeTest() {
        assertEquals("CaMeLcAsEfY", camel.getNome());
    }
}