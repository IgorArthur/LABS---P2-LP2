package Tests;

import BibliTex.upperCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class upperCaseTest {

    private upperCase upperCase = new upperCase();

    @Test
    void transforma() {
        assertEquals("IGOR ARTHUR", upperCase.transforma("igor arthur"));
    }

    @Test
    void getNome() {
        assertEquals("upperCase", upperCase.getNome());
    }
}