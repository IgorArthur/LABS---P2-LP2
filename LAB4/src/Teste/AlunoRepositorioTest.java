package Teste;

import ControleDeAlunos.Aluno;
import ControleDeAlunos.AlunoRepositorio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoRepositorioTest {

    AlunoRepositorio alunoRepositorio = new AlunoRepositorio();

    @Test
    void existeAlunoTrue() {
        alunoRepositorio.cadastrarAluno("100859", "Igor", "Computação");
        assertEquals(true, alunoRepositorio.existeAluno("100859"));
    }

    @Test
    void existeAlunoFalse() {
        assertEquals(false, alunoRepositorio.existeAluno("100859"));
    }

}