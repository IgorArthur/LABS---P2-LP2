package Teste;

import ControleDeAlunos.Aluno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    Aluno Igor = new Aluno("100859", "Igor", "Computação");

    @Test
    void testEqualsMesmaMatricula() {
        Aluno Juca = new Aluno("100859", "Juca", "Computação");
        assertEquals(true, Juca.equals(Igor));
    }

    @Test
    void testEqualsOutraMatricula() {
        Aluno Juca = new Aluno("100850", "Juca", "Computação");
        assertEquals(false, Juca.equals(Igor));
    }
}