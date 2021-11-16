package com.matheusgr.lunr;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.matheusgr.lunr.documento.DocumentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.matheusgr.lunr.documento.DocumentoDTO;

public class ExtraTest extends BaseTest {

    public static final String TEXTO3_ID = "123";
    public static final String TEXTO4_ID = "CBA";
    public static final String TEXTO5_ID = "987";
    public static final String TEXTO6_ID = "ZXY";


    @Test
    void TotalDocumentoTest() {
        assertEquals(4, this.documentoController.totalDocumentos());
        this.documentoController.adicionaDocumentoTxt(TEXTO3_ID, "um arquivo! texto simples.\r\n" + "igual a um outro arquivo.");
        this.documentoController.adicionaDocumentoTxt(TEXTO4_ID, "um arquivo! texto simples.\r\n" + "igual a um outro arquivo.");
        this.documentoController.adicionaDocumentoTxt(TEXTO5_ID, "Avante, atitude altruísta abranda " + "a alma além.\r\n.");
        this.documentoController.adicionaDocumentoTxt(TEXTO6_ID, "Amor ainda avisto .\r\nacredite amigo Amem!.");
        assertEquals("_MERGE987|ZXY", this.documentoController.concatenaDocumentos(TEXTO5_ID, TEXTO6_ID));
        assertEquals(8, this.documentoController.totalDocumentos());
        assertEquals("", this.documentoController.sumariza(TEXTO1_ID));
    }

}
