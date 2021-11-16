/**
* Laboratório de Programação 2 - Lab 1
* 
* @Igor Arthur Ferreira Ramos - 120210059
*/

import java.util.*;

public interface Resultados_da_prova {
    
    public static void main(String[] args) {
            
        Scanner sc = new Scanner(System.in);
        List<String> notas = new ArrayList<String>();
        
        while (true) {

            String entrada = sc.nextLine();

            if (entrada.equals("-")) {
                break;
            } else {
                String[] aluno = entrada.split(" ");
                notas.add(aluno[1]);
            }
            
        }

        sc.close(); 
        System.out.println(calculate(notas));
        
    }

    public static String calculate(List<String> n) {

        int total = 0;
        int media = 0;
        int maior = 0;
        int menor = 0;
        int acima = 0;
        int abaixo = 0;

        
        for (int count = 0; count < n.size(); count++ ) {

            total += Integer.parseInt(n.get(count));
            media = total / n.size();

            if (Integer.parseInt(n.get(count)) < 700.0) {
                abaixo++;
            } else {
                acima++;
            }

            if (count == 0) {
                maior = Integer.parseInt(n.get(count));
                menor = Integer.parseInt(n.get(count));
            } else {
                if (Integer.parseInt(n.get(count)) > maior) {
                    maior = Integer.parseInt(n.get(count));
                } if (Integer.parseInt(n.get(count)) < menor) {
                    menor = Integer.parseInt(n.get(count));
                }
            }
        }

        return "maior: " + maior + 
               "\nmenor: " + menor + 
               "\nmedia: " + media + 
               "\nacima: " + acima +
               "\nabaixo: " + abaixo;
                
    }
}