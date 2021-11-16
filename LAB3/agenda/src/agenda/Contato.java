package agenda;

public class Contato {
    
    private int posicao;
    private String nome;
    private String sobrenome;
    private String telefone;

    private String tag1 = "";
    private String tag2 = "";
    private String tag3 = "";
    private String tag4 = "";
    private String tag5 = "";


    public Contato() {

    }


    public Contato(int posicao, String nome, String sobrenome, String telefone){
        this.posicao = posicao;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }


    public String getContato() {
        
        if (this.nome != null) {
            return this.posicao + " " + this.nome + " " + this.sobrenome + " "  + "\n" + this.telefone + "\n" + this.tag1 + " " + this.tag2 + " " + this.tag3 + " " + this.tag4 + " " + this.tag5;
        } else {
            return "CONTATO NÂO ENCONTRADO";
        }
    }


    public String getNome() {
        return this.nome;
    }


    public String getSobrenome() {
        return this.sobrenome;
    }

    public void adicionaTag(String tag, int posTag) {
        switch(posTag) {
        case 1:
            tag1 = tag;
            break;
        case 2:
            tag2 = tag;
            break;
        case 3:
            tag3 = tag;
            break;
        case 4:
            tag4 = tag;
            break;
        case 5:
            tag5 = tag;
            break;
        }
    }
}
