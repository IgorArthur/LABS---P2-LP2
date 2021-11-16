package ControleDeAlunos;

import java.util.HashSet;

/**
 * Classe que representa um aluno. Possui matricula, nome e curso.
 */
public class Aluno {

    private String matricula;
    private String nome;
    private String curso;

    /**
     * Cria um aluno com matricula, nome e curso.
     * @param matricula matricula do aluno;
     * @param nome nome do aluno;
     * @param curso curso do aluno.
     */
    public Aluno(String matricula, String nome, String curso) {

        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;

    }

    /**
     * Verifica se dois alunos fornecidos são iguais, ou seja, o mesmo aluno.
     * @param aluno aluno a ser comparado;
     * @return true, caso sejam iguais, false, caso não.
     */
    public boolean equals(Aluno aluno) {
        if (this == aluno)
            return true;
        if (aluno == null)
            return false;
        if (!(aluno instanceof Aluno))
            return false;
        Aluno other = (Aluno) aluno;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    /**
     * Retorna as informações do aluno.
     * @return informações do aluno.
     */
    public String toString() {

        return this.matricula + " - " +  this.nome + " - " + this.curso;

    }
}
