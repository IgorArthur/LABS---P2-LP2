package ControleDeAlunos;

import java.util.HashMap;
import java.util.Locale;

/**
 * Classe que aloca todos os grupos criados. Possui um HashMap que contem os grupos e os indentifica por seu nome.
 */
public class GrupoRepositorio {

        private HashMap<String, Grupo> gruposAlunos = new HashMap<>();

        /**
         * Informa se existe o grupo de nome informado.
         * @param nomeGrupo nome do grupo;
         * @return true se o grupo existe, false se não existe.
         */
        public boolean existeGrupo(String nomeGrupo) {
                if (this.gruposAlunos.containsKey(nomeGrupo)) {
                        return true;
                } else {
                        return false;
                }
        }

        /**
         * Informa se existe vaga livre no grupo.
         * @param nomeGrupo nome do grupo;
         * @return true se existe vaga livre, false se não existe.
         */
        public boolean vagaLivre(String nomeGrupo) {

                return gruposAlunos.get(nomeGrupo).vagaLivre();

        }

        /**
         * Informa o grupo contem o aluno de matricula informada.
         * @param matricula matricula do aluno;
         * @param nomeGrupo nome do grupo;
         * @return true se o grupo contem o aluno, false se nao contem.
         */
        public boolean contemAluno(String matricula, String nomeGrupo) {

                return gruposAlunos.get(nomeGrupo).contemAluno(matricula);

        }

        /**
         * Cadastra um grupo com o nome e tamanho especificados.
         * @param nomeGrupo nome do grupo;
         * @param tamanho tamanho do grupo.
         */
        public void cadastrarGrupoTamanho(String nomeGrupo, int tamanho) {

                Grupo grupo = new Grupo(nomeGrupo, tamanho);
                gruposAlunos.put(nomeGrupo, grupo);

        }

        /**
         * Cadastra um grupo com o nome especificado.
         * @param nomeGrupo nome do grupo.
         */
        public void cadastrarGrupo(String nomeGrupo) {

                Grupo grupo = new Grupo(nomeGrupo);
                gruposAlunos.put(nomeGrupo, grupo);

        }

        /**
         * Aloca um aluno de matricula especificada no grupo de nome especificado.
         * @param matricula matricula do aluno;
         * @param nomeGrupo nome do grupo.
         */
        public void alocarAluno(String matricula, String nomeGrupo) {

                gruposAlunos.get(nomeGrupo).adicionaAluno(matricula);

        }

        /**
         * Verifica os grupos que o Aluno pertence.
         * @param matricula matricula do aluno;
         * @return os grupos que o aluno pertence.
         */
        public String verificaGruposAluno(String matricula) {

                String retorno = "Grupos:\n";
                for(Grupo grupo: gruposAlunos.values()) {
                        if (grupo.contemAluno(matricula) == true) {
                                retorno += grupo.getNome() + "\n";
                        }
                }

                return retorno;

        }
}
