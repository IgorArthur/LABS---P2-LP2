package ControleDeAlunos;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Classe que aloca todos os alunos criados. Possui um HashMap que contem os alunos e os indentifica por sua matricula.
 */
public class AlunoRepositorio {

    private HashMap<String, Aluno> mapaMatriculaAlunos = new HashMap<>();

    /**
     * Informa se existe o aluno de matricula informada.
     * @param matricula matricula do aluno;
     * @return true caso o aluno exista, false caso não exista.
     */
    public boolean existeAluno(String matricula) {
        if (this.mapaMatriculaAlunos.containsKey(matricula)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retorna o objeto aluno.
     * @param matricula matricula do aluno a ser retornado;
     * @return aluno.
     */
    public Aluno retornaAluno(String matricula) {

        return mapaMatriculaAlunos.get(matricula);
    }

    /**
     * Cadastra um aluno com matricula, nome e curso.
     * @param matricula matricula do aluno a ser cadastrado;
     * @param nome nome do aluno a ser cadastrado;
     * @param curso curso do aluno a ser cadastrado.
     */
    public void cadastrarAluno(String matricula, String nome, String curso) {

        Aluno aluno = new Aluno(matricula, nome, curso);
        mapaMatriculaAlunos.put(matricula, aluno);

    }

    /**
     * Retorna as informações do aluno que possui a matricula informada.
     * @param matricula matricula do aluno;
     * @return informações do aluno.
     */
    public String exibirAluno(String matricula) {

        return mapaMatriculaAlunos.get(matricula).toString();

    }

}
