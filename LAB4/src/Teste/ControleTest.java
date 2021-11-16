package Teste;

import ControleDeAlunos.Controle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControleTest {

    Controle controle = new Controle();

    @BeforeEach
    void alunosBase() {
        controle.cadastrarAluno("250", "Gabriel Reyes", "Computação");
        controle.cadastrarAluno("200", "Lili Camposh", "Computação");
        controle.cadastrarAluno("202", "Angela Ziegler", "Medicina");
        controle.cadastrarAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
    }

    @Test
    void cadastrarAlunoJáCadastrado() {
        assertEquals("MATRÍCULA JÁ CADASTRADA!", controle.cadastrarAluno("250", "Igor Arthur", "Computação"));
    }

    @Test
    void exibirAlunoTeste() {
        assertEquals("Aluno: 250 - Gabriel Reyes - Computação", controle.exibirAluno("250"));
    }

    @Test
    void exibirAlunoNãoCadastradoTeste() {
        assertEquals("ALUNO NÃO CADASTRADO!", controle.exibirAluno("666"));
    }

    @Test
    void cadastrarGrupoTeste() {
        assertEquals("GRUPO CADASTRADO!", controle.cadastrarGrupo("Programação OO"));
    }

    @Test
    void cadastrarGrupoTamanhoTeste() {
        assertEquals("GRUPO CADASTRADO!", controle.cadastrarGrupoTamanho("Listas", "10"));
    }

    @Test
    void cadastrarGrupoExistenteTeste() {
        controle.cadastrarGrupo("Listas");
        assertEquals("GRUPO JÁ CADASTRADO!", controle.cadastrarGrupoTamanho("Listas", "10"));
    }

    @Test
    void alocarAlunoTeste() {
        controle.cadastrarGrupo("Programação OO");
        assertEquals("ALUNO ALOCADO!", controle.alocarAluno("200", "Programação OO"));
        assertEquals("ALUNO ALOCADO!", controle.alocarAluno("202", "Programação OO"));
    }

    @Test
    void alocarAlunoJaAlocadoTeste() {
        controle.cadastrarGrupo("Programação OO");
        assertEquals("ALUNO ALOCADO!", controle.alocarAluno("200", "Programação OO"));
        assertEquals("ALUNO ALOCADO!", controle.alocarAluno("202", "Programação OO"));
        assertEquals("ALUNO ALOCADO!", controle.alocarAluno("200", "Programação OO"));
    }

    @Test
    void alocarAlunoNaoExiste() {
        controle.cadastrarGrupo("Programação OO");
        assertEquals("ALUNO NÃO CADASTRADO!", controle.alocarAluno("100", "Programação OO"));
    }

    @Test
    void alocarAlunoGrupoNaoExiste() {
        assertEquals("GRUPO NÃO CADASTRADO!", controle.alocarAluno("200", "Anatomia"));
    }

    @Test
    void alocarAlunoResticaoTamanho() {
        controle.cadastrarGrupoTamanho("Listas", "1");
        assertEquals("ALUNO ALOCADO!", controle.alocarAluno("250", "Listas"));
        assertEquals("GRUPO CHEIO!", controle.alocarAluno("202", "Listas"));
    }

    @Test
    void pertinenciaAlunoTeste() {
        controle.cadastrarGrupo("Listas");
        controle.alocarAluno("250", "Listas");
        assertEquals("PERTENCE AO GRUPO!", controle.pertinenciaAluno("250", "Listas"));
        assertEquals("NÃO PERTENCE AO GRUPO!", controle.pertinenciaAluno("202", "Listas"));
    }

    @Test
    void pertinenciaAlunoGrupoNaoExisteTeste() {
        assertEquals("GRUPO NÃO CADASTRADO!", controle.pertinenciaAluno("200", "Anatomia"));
    }

    @Test
    void pertinenciaAlunoNaoExisteTeste() {
        controle.cadastrarGrupo("Programação OO");
        assertEquals("ALUNO NÃO CADASTRADO!", controle.pertinenciaAluno("100", "Programação OO"));
    }

    @Test
    void registrarAlunoRespostaTeste() {
        assertEquals("ALUNO REGISTRADO!", controle.registrarAlunoResposta("250"));
    }

    @Test
    void registrarAlunoNãoCadastradoRespostaTeste() {
        assertEquals("ALUNO NÃO CADASTRADO!", controle.registrarAlunoResposta("100"));
    }

    @Test
    void imprimirAlunoResposta() {
        controle.registrarAlunoResposta("250");
        controle.registrarAlunoResposta("200");
        assertEquals("Alunos: \n250 - Gabriel Reyes - Computação\n200 - Lili Camposh - Computação\n", controle.imprimirAlunoResposta());
    }

    @Test
    void verificaGruposAlunoSemGruposTeste() {
        assertEquals("Grupos:\n", controle.verificaGruposAluno("202"));
    }

    @Test
    void verificaGruposAlunoComGruposTeste() {
        controle.cadastrarGrupo("Programação OO");
        controle.cadastrarGrupo("Listas");
        controle.alocarAluno("250", "Listas");
        controle.alocarAluno("250", "Programação OO");
        assertEquals("Grupos:\nProgramação OO\nListas\n", controle.verificaGruposAluno("250"));
    }

    @Test
    void verificaGruposAlunoNaoExisteTeste() {

        assertEquals("ALUNO NÃO CADASTRADO!", controle.verificaGruposAluno("666"));

    }

}