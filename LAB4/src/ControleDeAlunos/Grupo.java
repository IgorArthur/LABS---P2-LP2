package ControleDeAlunos;

import java.util.HashSet;

/**
 * Classe que representa um grupo. Possui um nome, um tamanho e um HashSet com os integrantes.
 */
public class Grupo {

    private String nomeGrupo;
    private int tamanho;
    private HashSet<String> integrantes = new HashSet<>();

    /**
     * Cria um grupo com nome e tamanho especificados.
     * @param nomeGrupo nome do grupo;
     * @param tamanho tamanho do grupo.
     */
    public Grupo(String nomeGrupo, int tamanho) {

        this.nomeGrupo = nomeGrupo;
        this.tamanho = tamanho;

    }

    /**
     * Cria um grupo com nome especificado.
     * @param nomeGrupo nome do grupo.
     */
    public Grupo(String nomeGrupo) {

        this.nomeGrupo = nomeGrupo;

    }

    /**
     * Verifica se dois grupos fornecidos são iguais, ou seja, o mesmo grupo.
     * @param grupo grupo a ser comparado;
     * @return true, caso sejam iguais, false, caso não.
     */
    public boolean equals(Grupo grupo) {
        if (this == grupo)
            return true;
        if (grupo == null)
            return false;
        if (!(grupo instanceof Grupo))
            return false;
        Grupo other = (Grupo) grupo;
        if (nomeGrupo == null) {
            if (other.nomeGrupo != null)
                return false;
        } else if (!nomeGrupo.equals(other.nomeGrupo))
            return false;
        return true;
    }

    /**
     * Retorna o nome do grupo.
     * @return nome do grupo.
     */
    public String getNome() {

        return this.nomeGrupo;

    }

    /**
     * Informa se existe vaga livre no grupo.
     * @return true se existe vaga livre, false se não existe.
     */
    public boolean vagaLivre() {

        if (tamanho != 0 && integrantes.size() == tamanho) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * Informa se o grupo contém aluno com a matricula especificada.
     * @param matricula matricula do aluno;
     * @return true se contém aluno, false se não contém.
     */
    public boolean contemAluno(String matricula) {

        if (this.integrantes.contains(matricula)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Adiciona o aluno da matricula especificada ao grupo.
     * @param matricula matricula do aluno.
     */
    public void adicionaAluno(String matricula) {

        this.integrantes.add(matricula);

    }

}
