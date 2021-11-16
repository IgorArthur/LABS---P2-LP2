package ControleDeAlunos;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Controle controle = new Controle();

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, controle, scanner);
        }

    }

    private static String menu(Scanner scanner) {
        System.out.print(
                "\n---\nMENU\n" +
                        "(C)adastrar Aluno\n" +
                        "(E)xibir Aluno\n" +
                        "(N)ovo Grupo\n" +
                        "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
                        "(R)egistrar Aluno que Respondeu\n" +
                        "(I)mprimir Alunos que Responderam\n" +
                        "(O)lhaí quais Grupos o Aluno Tá\n" +
                        "(S)im, quero Fechar o Programa!\n" +
                        "\n" +
                        "Opção> ");
        return scanner.nextLine().toUpperCase().trim();
    }


    private static void comando(String opcao, Controle controle, Scanner scanner) {
        switch (opcao) {
            case "C":
                cadastrarAluno(controle, scanner);
                break;
            case "E":
                exibirAluno(controle, scanner);
                break;
            case "N":
                cadastrarGrupo(controle,scanner);
                break;
            case "A":
                alunoGrupo(controle, scanner);
                break;
            case "R":
                registrarAlunoResposta(controle, scanner);
                break;
            case "I":
                imprimirAlunoResposta(controle);
                break;
            case "O":
                verificaGruposAluno(controle, scanner);
                break;
            case "S":
                sair();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");
        }
    }

    private static void cadastrarAluno(Controle controle, Scanner scanner) {

        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine().trim();

        System.out.print("\nNome: ");
        String nome = scanner.nextLine();

        System.out.print("\nCurso: ");
        String curso = scanner.nextLine();

        System.out.println(controle.cadastrarAluno(matricula, nome, curso));

    }

    private static void exibirAluno(Controle controle, Scanner scanner) {

        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine().trim();
        System.out.println(controle.exibirAluno(matricula));

    }

    private static void cadastrarGrupo(Controle controle, Scanner scanner) {

        System.out.print("\nGrupo: ");
        String nomeGrupo = scanner.nextLine().toUpperCase();

        System.out.print("\nTamanho:: ");
        String sTamanho = scanner.nextLine().trim();

        if (sTamanho.equals(null)) {
            System.out.println((controle.cadastrarGrupo(nomeGrupo)));
        } else {
            System.out.println(controle.cadastrarGrupoTamanho(nomeGrupo, sTamanho));
        }


    }

    private static void alunoGrupo(Controle controle, Scanner scanner) {

        System.out.print("(A)locar Aluno ou (P)ertinência a Grupo? \n");
        String opcao = scanner.nextLine().toUpperCase().trim();

        switch (opcao) {
            case "A":
                alocarAluno(controle, scanner);
                break;
            case "P":
                pertinenciaAluno(controle, scanner);
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA!");

        }
    }

    private static void alocarAluno(Controle controle, Scanner scanner) {

            System.out.print("\nMatrícula: ");
            String matricula = scanner.nextLine().trim();

            System.out.print("\nGrupo: ");
            String nomeGrupo = scanner.nextLine().toUpperCase().trim();

            System.out.println(controle.alocarAluno(matricula, nomeGrupo));

    }

    private static void pertinenciaAluno(Controle controle, Scanner scanner) {

        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine().trim();

        System.out.print("\nGrupo: ");
        String nomeGrupo = scanner.nextLine().toUpperCase().trim();

        System.out.println(controle.pertinenciaAluno(matricula, nomeGrupo));

    }

    private static void registrarAlunoResposta(Controle controle, Scanner scanner) {

        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine().trim();

        System.out.println(controle.registrarAlunoResposta(matricula));

    }

    private static void imprimirAlunoResposta(Controle controle) {

        System.out.println(controle.imprimirAlunoResposta());

    }

    private static void verificaGruposAluno(Controle controle, Scanner scanner) {

        System.out.print("\nMatrícula: ");
        String matricula = scanner.nextLine().trim();

        System.out.println(controle.verificaGruposAluno(matricula));

    }

    private static void sair() {

        System.out.println("\nObrigado por utilizar nosso serviço. Volte Sempre!");
        System.exit(0);

    }


}
