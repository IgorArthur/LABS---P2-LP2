package agenda;


public class Agenda {
	
	private Contato[] contatos;
	private Contato[] favoritos;

	public Agenda() {

		this.contatos = new Contato[100];
		
		for (int c = 0; c < 100; c++) {
			this.contatos[c] = new Contato();
		}

		this.favoritos = new Contato[10];
	}

	
	public Contato[] getContatos() {
		return this.contatos.clone();
	}


	public String getContato(int posicao) {
		if (this.contatos[posicao].getNome().equals("")) {
			return "CONTATO NÃO ENCONTRADO";
		}
		for (int count = 0; count < 10; count++) {
			if (this.contatos[posicao].equals(this.favoritos[count])) {
				return "❤️" + this.contatos[posicao].getContato();
			}
		}

		return this.contatos[posicao].getContato();
	}


	public void adicionaTag(int posicao, String tag, int posTag) {
		this.contatos[posicao].adicionaTag(tag, posTag);
	}

	
	public String favoritaContato(int posicaoCon, int posicaoFav) {
		if (this.contatos[posicaoCon].getNome().equals("")) {
			return "CONTATO NÃO ENCONTRADO";
		}
		this.favoritos[posicaoFav] = this.contatos[posicaoCon];
		return "CONTATO FAVORITADO";
	}
	
	public String getFavoritos() {
		
		String retornaFavoritos = "";
		for (int c = 0; c < 10; c++) {
			if (this.favoritos[c] != null) {
				retornaFavoritos += "❤️" + this.favoritos[c].getContato() + "\n";
			}
		}
			

		if (retornaFavoritos.equals("")) {
			return "NENHUM FAVORITO ENCONTRADO";
		} else {
			return "CONTATOS FAVORITOS: " + "\n" + retornaFavoritos;
		}
	}


	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao == 0 || posicao > 100) {
			return "POSIÇÃO INVÁLIDA";
		}
		if (nome.equals("")) {
			return "CONTATO INVÁLIDO";
		}
		for (int i = 0; i < 100; i++) {
			if (contatos[i].getNome() != null && contatos[i].getNome() != null) {
				if (contatos[i].getNome().equals(nome) && contatos[i].getSobrenome().equals(sobrenome)) {
					return "CONTATO JÁ CADASTRADO";
				}
			}
		}
		if (telefone.equals("")) {
			return "CONTATO INVÁLIDO";
		}
	    this.contatos[posicao] = new Contato(posicao, nome, sobrenome, telefone);

		return "CADASTRO REALIZADO";
	}
}
