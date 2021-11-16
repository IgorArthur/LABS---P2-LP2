package Teste;

import ControleDeAlunos.Aluno;
import ControleDeAlunos.Grupo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {

    Grupo CC = new Grupo("Computação", 1);

    @Test
    void testEqualsTrue() {
        Grupo EE = new Grupo("Computação");
        assertEquals(true, EE.equals(CC));
    }

    @Test
    void testEqualsFalse() {
        Grupo EE = new Grupo("Engenharia Eletrica");
        assertEquals(false, EE.equals(CC));
    }

    @Test
    void getNome() {
        assertEquals("Computação", CC.getNome());
    }

    @Test
    void vagaLivreTrue() {
        assertEquals(true, CC.vagaLivre());
    }

    @Test
    void vagaLivreFalse() {
        Aluno Igor = new Aluno("100859", "Igor", "Computação");
        CC.adicionaAluno("100859");
        assertEquals(false, CC.vagaLivre());
    }

    @Test
    void contemAlunoTrue() {
        Aluno Igor = new Aluno("100859", "Igor", "Computação");
        CC.adicionaAluno("100859");
        assertEquals(true, CC.contemAluno("100859"));
    }

    @Test
    void contemAlunoFalse() {
        assertEquals(false, CC.contemAluno("100859"));
    }
}