package agenda;

import java.util.Scanner;

public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	private static String menu(Scanner scanner) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar favoritos\n" +
						"(T)ags\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}

	
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			System.out.println(cadastraContato(agenda, scanner));
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			favoritos(agenda);
			break;
		case "A":
			System.out.println(favoritaContato(agenda, scanner));
			break;
		case "T":
			System.out.println(tag(agenda, scanner));
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	
	private static String tag(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato a receber tag> ");
		String sposicaoCon = scanner.nextLine();
		if (sposicaoCon.equals("") || Integer.valueOf(sposicaoCon) > 100) {
			return "POSIÇÃO INVÁLIDA";
		}
		System.out.print("\nTag> ");
		String tag = scanner.nextLine();
		System.out.print("\nPosição da tag> ");
		String sposicaoTag = scanner.nextLine();
		if (sposicaoTag.equals("") || Integer.valueOf(sposicaoTag) > 5) {
			return "POSIÇÃO INVÁLIDA";
		}

		int posicaoTag = Integer.parseInt(sposicaoTag);
		int posicaoCon = Integer.parseInt(sposicaoCon);
		agenda.adicionaTag(posicaoCon, tag, posicaoTag);

		return "TAG ADIOCIONADA";
	}
	
	
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i].getNome() != null) {
				System.out.println(i + " " + contatos[i].getNome() + " " + contatos[i].getSobrenome());
			}
		}
	}

	
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato exibir> ");
		String sposicao = scanner.nextLine();
		int posicao = Integer.valueOf(sposicao);
		String contato = agenda.getContato(posicao);
		System.out.println("Dados do contato:\n" + contato);
	}


	private static String cadastraContato(Agenda agenda, Scanner scanner) {
		
		System.out.print("\nPosição a ser cadastrado> ");
		String sposicao = scanner.nextLine();
		int posicao = Integer.valueOf(sposicao);

		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();

		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		

		agenda.cadastraContato(posicao, nome, sobrenome, telefone);
		
		return "CADASTRO REALIZADO";
	}

	private static void favoritos(Agenda agenda) {

		System.out.println(agenda.getFavoritos());
	}

	private static String favoritaContato(Agenda agenda, Scanner scanner) {
		
		System.out.print("\nContato a ser favoritado> ");
		String sposicaoCon = scanner.nextLine();
		if (sposicaoCon.equals("") || Integer.valueOf(sposicaoCon) > 10) {
			return "POSIÇÃO INVÁLIDA";
		}
		
		System.out.print("\nPosição nos Favoritos> ");
		String sposicaoFav = scanner.nextLine();
		if (sposicaoFav.equals("") || Integer.valueOf(sposicaoFav) > 100) {
			return "POSIÇÃO INVÁLIDA";
		}

		int posicaoFav = Integer.parseInt(sposicaoFav);
		int posicaoCon = Integer.parseInt(sposicaoCon);
		agenda.favoritaContato(posicaoCon, posicaoFav);

		return "CONTATO FAVORITADO";
	}

	
	private static void sai() {
		System.out.println("\nObrigado por utilizar nosso serviço. Volte Sempre!");
		System.exit(0);
	}
}
