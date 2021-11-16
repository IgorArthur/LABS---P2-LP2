package lab2;

public class CoisaBonus {
    
    public static void main(String[] args) {
        descanso();
        System.out.println("-----");
        disciplina();
        System.out.println("-----");
        financas();
    }

    public static void descanso() {
        Descanso descanso = new Descanso();
        System.out.println(descanso.getStatusGeral());
        
        descanso.definirEmoji(":3");
        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(2);
        System.out.println(descanso.getStatusGeral());

        descanso.defineHorasDescanso(30);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());

        descanso.defineHorasDescanso(26);
        descanso.defineNumeroSemanas(1);
        System.out.println(descanso.getStatusGeral());
    }
 
    private static void disciplina() {

        Disciplina prog2 = new Disciplina("INTRODUÇÃO A AGIOTAGEM", 2, new int[]{6, 4});
        prog2.cadastraHoras(4);
        prog2.cadastraNota(1, 10.0);
        prog2.cadastraNota(2, 6.0);
        System.out.println(prog2.aprovado());
        System.out.println(prog2.toString());
    }

    private static void financas() {
        int dinheiroGuardado = 10000;
        int historicoDeGanhos = 4;
        RegistroFinancas minhaFinanca = new RegistroFinancas(dinheiroGuardado, historicoDeGanhos);
 
        minhaFinanca.adicionaGanhos(120000, 1);
        minhaFinanca.adicionaGanhos(72000, 2);
        minhaFinanca.pagaDespesa(20000, "Roupa pirata");
        minhaFinanca.pagaDespesa(20000, "Cigarro");
        minhaFinanca.pagaDespesa(20000, "Racha de rua");
        minhaFinanca.pagaDespesa(20000, "Briga de galo");
        minhaFinanca.pagaDespesa(20000, "Jogo do bicho");
        minhaFinanca.pagaDespesa(20000, "Bebidas");
        System.out.println(minhaFinanca.exibeGanhos());
        System.out.println(minhaFinanca.toString());
        System.out.println(minhaFinanca.listarDetalhes());
 
    }
}