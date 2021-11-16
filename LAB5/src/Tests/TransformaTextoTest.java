package Tests;

import BibliTex.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransformaTextoTest {

    private TransformaTexto tt = new TransformaTexto();

    @Test
    void transformaInvalidoTest() throws Exception {
        assertEquals("TRANSFORMAÇÃO INVÁLIDA!", tt.transforma("igão", "igor arthur"));
    }

    @Test
    void transformaCaMeLcAsEfYTest() throws Exception {
        assertEquals("IgOr aRtHuR", tt.transforma("CaMeLcAsEfY", "igor arthur"));
    }

    @Test
    void transformacleanTest() throws Exception {
        assertEquals("oi como vc ta", tt.transforma("clean", "oi, como vc ta?"));
    }

    @Test
    void transformacleanSpacesTest() throws Exception {
        assertEquals("oi,comovcta?", tt.transforma("cleanSpaces", "oi, como vc ta?"));
    }

    @Test
    void transformaInterrogaPraPontosTest() throws Exception {
        assertEquals("oi, como vc ta.", tt.transforma("InterrogaPraPontos", "oi, como vc ta."));
    }

    @Test
    void trasnformaupperCaseTest() throws Exception {
        assertEquals("OI, COMO VC TA?", tt.transforma("upperCase", "oi, como vc ta?"));
    }

    @Test
    void contaTransformacaoTest() throws Exception {
        tt.transforma("clean", "oi. como vc ta?");
        tt.transforma("CaMeLcAsEfY", "igor arthur");
        tt.transforma("InterrogaPraPontos", "oi, como vc ta?");
        assertEquals(3, tt.contaTransformacao());
        tt.transforma("cleanSpaces", "igor arthur");
        tt.transforma("upperCase", "oi, como vc ta?");
        assertEquals(5, tt.contaTransformacao());
    }

    @Test
    void historicoTest() throws Exception {
        tt.transforma("clean", "oi. como vc ta?");
        assertEquals("oi. como vc ta? -> clean -> oi como vc ta", tt.historico(0));
    }

    @Test
    void listarOriginaisTest() throws Exception {
        tt.transforma("clean", "oi. como vc ta?");
        tt.transforma("clean", "oi. como vc ta?");
        tt.transforma("clean", "Oi. como vc ta?");
        tt.transforma("cleanSpaces", "igor arthur");
        tt.transforma("upperCase", "oi, como vc ta?");
        assertEquals("oi. como vc ta?\n" + "Oi. como vc ta?\n" + "igor arthur\n" +
                "oi, como vc ta?\n", tt.listarOriginais());
    }

    @Test
    void listarTransformacoesTest() {
        assertEquals("CaMeLcAsEfY\n" + "InterrogaPraPontos\n" + "clean\n" +
                "cleanSpaces\n" + "upperCase\n", tt.listarTransformacoes());
    }
}