package ControleDeAlunos;

import java.util.HashMap;
import java.util.HashSet;


/**
 * Controle que exerce todas as funções do código com a ajuda de classes auxiliares. Possui as funções: Cadastrar Aluno,
 * Exibir Aluno, Cadastrar Grupo, Alocar Aluno em Grupo, Checar Pertinência do Aluno em Grupo, Registrar um Aluno que
 * Respondeu, Exibir Alunos que Responderam e Checar Grupos que o Aluno está. Possui um repositório de alunos, um de
 * grupos e um de respostas.
 */
public class Controle {

    private AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
    private GrupoRepositorio grupoRepositorio = new GrupoRepositorio();
    private RespostaRepositorio respostaRepositorio = new RespostaRepositorio();

    /**
     * Cadastra um aluno no repositório. Recebe a matricula, o nome e o curso do aluno e informa ao usuário caso a
     * matricula ja esteja cadastrada. Lança uma Exceção caso qualquer uma das entradas seja nula.
     * @param matricula matricula do aluno;
     * @param nome nome do aluno;
     * @param curso curso do aluno;
     * @return CADASTRO REALIZADO caso tenha suceso, MATRICULA JA CADASTRADA casoa matricula ja tenha sido cadastrada.
     */
    public String cadastrarAluno(String matricula, String nome, String curso) {

        if (matricula.equals("") || nome.equals("") || curso.equals("")) {
            throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        } if (alunoRepositorio.existeAluno(matricula)) {
            return "MATRÍCULA JÁ CADASTRADA!";
        }

        alunoRepositorio.cadastrarAluno(matricula, nome, curso);
        return "CADASTRO REALIZADO!";

    }

    /**
     * Exibe o aluno referente à matricula informada. Lança uma Exceção caso a entrada seja nula.
     * @param matricula matricula do aluno;
     * @return as informações do aluno.
     */
    public String exibirAluno(String matricula) {

        if (matricula.equals(null)) {
            throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        } if (alunoRepositorio.existeAluno(matricula) == false) {
            return "ALUNO NÃO CADASTRADO!";
        }

        return "Aluno: " + alunoRepositorio.exibirAluno(matricula);

    }

    /**
     * Cadastra um grupo com o nome informado. Não difere minusculas e maiusculas. Lança uma Exceção caso a entrada
     * seja nula.
     * @param nomeGrupo nome do grupo a ser cadastrado;
     * @return GRUPO CADSATRADO caso tenha sucesso, GRUPO CADASTRADO caso nome já tenha sido cadastrado.
     */
    public String cadastrarGrupo(String nomeGrupo) {

        if (nomeGrupo.equals(null)) {
            throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        } if (grupoRepositorio.existeGrupo(nomeGrupo)) {
            return "GRUPO JÁ CADASTRADO!";
        }

        grupoRepositorio.cadastrarGrupo(nomeGrupo);
        return "GRUPO CADASTRADO!";

    }

    /**
     * Cadastra um grupo com o nome e tamanho informado. Não difere minusculas e maiusculas. Lança uma Exceção caso
     * qualquer uma das entradas seja nula.
     * @param nomeGrupo nome do grupo a ser cadastrado;
     * @param sTamanho tamanho do grupo a ser cadastrado;
     * @return RUPO CADSATRADO caso tenha sucesso, GRUPO CADASTRADO caso nome já tenha sido cadastrado.
     */
    public String cadastrarGrupoTamanho(String nomeGrupo, String sTamanho) {

        if (sTamanho.equals("") || nomeGrupo.equals("")) {
            throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        } if (sTamanho.equals(null)) {
            grupoRepositorio.cadastrarGrupo(nomeGrupo);
            return "GRUPO CADASTRADO!";
        } if (grupoRepositorio.existeGrupo(nomeGrupo)) {
            return "GRUPO JÁ CADASTRADO!";
        }

        int tamanho = Integer.valueOf(sTamanho);
        grupoRepositorio.cadastrarGrupoTamanho(nomeGrupo, tamanho);
        return "GRUPO CADASTRADO!";

    }

    /**
     * Aloca o aluno com a matricula fornecida no grupo com o nome fornecido.  Lança uma Exceção caso qualquer uma das
     * entradas seja nula.
     * @param matricula matricula do aluno a ser alocado;
     * @param nomeGrupo grupo que o aluno será alocado;
     * @return ALUNO ALOCADO caso tenha sucesso, GRUPO NÃO CADASTRADO caso grupo nao tenha sido cadastrado, ALUNO NÃO
     * CADASTRADO caso aluno nao tenha sido cadastrado e GRUPO CHEIO caso o grupo tenha excedido o limite.
     */
    public String alocarAluno(String matricula, String nomeGrupo) {

        if (nomeGrupo.equals(null) || matricula.equals(null)) {
            throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
        } if (grupoRepositorio.existeGrupo(nomeGrupo) == false) {
            return "GRUPO NÃO CADASTRADO!";
        } if (alunoRepositorio.existeAluno(matricula) == false) {
            return "ALUNO NÃO CADASTRADO!";
        } if (grupoRepositorio.vagaLivre(nomeGrupo) == false) {
            return "GRUPO CHEIO!";
        }
        grupoRepositorio.alocarAluno(matricula, nomeGrupo);

        return "ALUNO ALOCADO!";

    }

    /**
     * Checa a pertinencia do aluno com a matricula informada no grupo com o nome informado.
     * @param matricula matricula do aluno a ser checado;
     * @param nomeGrupo nome do grupo a ser checado.
     * @return PERTENCE AO GRUPO caso aluno pertença ao grupo, NÃO PERTENCE AO GRUPO caso aluno não pertença ao grupo,
     * GRUPO NÃO CADASTRADO caso grupo nao tenha sido cadastrado, ALUNO NÃO CADASTRADO caso aluno nao tenha sido
     * cadastrado.
     */
    public String pertinenciaAluno(String matricula, String nomeGrupo) {

        if (grupoRepositorio.existeGrupo(nomeGrupo) == false) {
            return "GRUPO NÃO CADASTRADO!";
        } if (alunoRepositorio.existeAluno(matricula) == false) {
            return "ALUNO NÃO CADASTRADO!";
        } else {
            if (grupoRepositorio.contemAluno(matricula, nomeGrupo)) {
                return "PERTENCE AO GRUPO!";
            } else {
                return "NÃO PERTENCE AO GRUPO!";
            }
        }

    }

    /**
     * Registra o aluno de matricula informada que respondeu a uma pergunta.
     * @param matricula matricula do aluno a ser registrado.
     * @return ALUNO REGISTRADO em caso de sucesso, ALUNO NÃO CADASTRADO em caso do aluno nao ter sido cadastrado.
     */
    public String registrarAlunoResposta(String matricula) {

        if (alunoRepositorio.existeAluno(matricula) == false) {
            return "ALUNO NÃO CADASTRADO!";
        } else {
            Aluno aluno = alunoRepositorio.retornaAluno(matricula);
            respostaRepositorio.cadastrarRespostaAluno(aluno);
            return "ALUNO REGISTRADO!";
        }

    }

    /**
     * Retorna uma lista dos alunos que responderam perguntas.
     * @return lista de alunos que responderam.
     */
    public String imprimirAlunoResposta() {

        return "Alunos: " + "\n" + respostaRepositorio.toString();

    }

    /**
     * Verifica os grupos que o aluno de matricula informada participa.
     * @param matricula matricula do aluno a ser verificado;
     * @return lista de grupos aos quais o aluno informado pertence.
     */
    public String verificaGruposAluno(String matricula) {

        if (alunoRepositorio.existeAluno(matricula) == false) {
            return "ALUNO NÃO CADASTRADO!";
        } else {
            return grupoRepositorio.verificaGruposAluno(matricula);
        }

    }
}
