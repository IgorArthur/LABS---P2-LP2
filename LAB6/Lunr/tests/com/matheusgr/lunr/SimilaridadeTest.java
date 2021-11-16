package com.matheusgr.lunr;

import com.matheusgr.lunr.documento.DocumentoController;
import com.matheusgr.similaridade.SimilaridadeController;
import com.matheusgr.similaridade.SimilaridadeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SimilaridadeTest extends BaseTest {

    public static final String TEXTO3_ID = "123";
    public static final String TEXTO4_ID = "CBA";
    public static final String TEXTO5_ID = "987";
    public static final String TEXTO6_ID = "ZXY";

    @Test
    void similaridadeDocsCompletamenteEAbsurdamenteDiferentesNadaAVerUmComOOutroTest() {
        this.documentoController.adicionaDocumentoTxt(TEXTO5_ID, "Avante, atitude altruísta abranda a alma além.\r\n.");
        this.documentoController.adicionaDocumentoTxt(TEXTO6_ID, "Amor ainda avisto .\r\nacredite amigo Amem!.");
        assertEquals(0.0, this.similaridadeController.similaridade(TEXTO5_ID, TEXTO6_ID));
    }

    @Test
    void similaridadeDocsDiferentesTest() {
        assertEquals(0.5, this.similaridadeController.similaridade(TEXTO1_ID, TEXTO2_ID));
    }

    @Test
    void similaridadeDocsIguaisTest() {
        this.documentoController.adicionaDocumentoTxt(TEXTO3_ID, "um arquivo! texto simples.\r\nigual a um outro arquivo.");
        this.documentoController.adicionaDocumentoTxt(TEXTO4_ID, "um arquivo! texto simples.\r\nigual a um outro arquivo.");
        assertEquals(1.0, this.similaridadeController.similaridade(TEXTO3_ID, TEXTO4_ID));
    }

}