package Teste;

import ControleDeAlunos.Aluno;
import ControleDeAlunos.AlunoRepositorio;
import ControleDeAlunos.GrupoRepositorio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoRepositorioTest {

    GrupoRepositorio grupoRepositorio = new GrupoRepositorio();
    Aluno Igor = new Aluno("100859", "Igor", "Computação");

    @Test
    void existeGrupoTrue() {
        grupoRepositorio.cadastrarGrupo("Computação");
        assertEquals(true, grupoRepositorio.existeGrupo("Computação"));
    }

    @Test
    void existeGrupoFalse() {
        assertEquals(false, grupoRepositorio.existeGrupo("Computação"));
    }

    @Test
    void vagaLivreTrue() {
        grupoRepositorio.cadastrarGrupoTamanho("Computação", 1);
        assertEquals(true, grupoRepositorio.vagaLivre("Computação"));
    }

    @Test
    void vagaLivreFalse() {
        grupoRepositorio.cadastrarGrupoTamanho("Computação", 1);
        Aluno Igor = new Aluno("100859", "Igor", "Computação");
        grupoRepositorio.alocarAluno("100859", "Computação");
        assertEquals(false, grupoRepositorio.vagaLivre("Computação"));
    }

    @Test
    void contemAlunoTrue() {
        grupoRepositorio.cadastrarGrupo("Computação");
        Aluno Igor = new Aluno("100859", "Igor", "Computação");
        grupoRepositorio.alocarAluno("100859", "Computação");
        assertEquals(true, grupoRepositorio.contemAluno("100859","Computação"));
    }

    @Test
    void contemAlunoFalse() {
        grupoRepositorio.cadastrarGrupo("Computação");
        assertEquals(false, grupoRepositorio.contemAluno("100859", "Computação"));
    }
}