package ControleDeAlunos;

import java.util.ArrayList;

/**
 * Classe que aloca todos os alunos que responderam em um Array.
 */
public class RespostaRepositorio {

    private ArrayList<Aluno> respostas = new ArrayList<>();

    /**
     * Cadasta a resposta do aluno.
     * @param aluno aluno a ser cadastrado.
     */
    public void cadastrarRespostaAluno(Aluno aluno) {

        respostas.add(aluno);

    }

    /**
     * Retorna a lista de alunos que responderam.
     * @return lista de alunos que responderam.
     */
    public String toString() {

        String retorno = "";
        for (int c = 0; c < respostas.size(); c++) {
            retorno += respostas.get(c).toString() + "\n";
        }

        return retorno;

    }
}
