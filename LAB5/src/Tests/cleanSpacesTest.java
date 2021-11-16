package Tests;

import BibliTex.cleanSpaces;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class cleanSpacesTest {

    private cleanSpaces cleanSpaces = new cleanSpaces();

    @Test
    void transforma() {
        assertEquals("Tudobemcomvc?", cleanSpaces.transforma("Tudo bem com vc?"));
    }

    @Test
    void getNome() {
        assertEquals("cleanSpaces", cleanSpaces.getNome());
    }
}