/**
* Laboratório de Programação 2 - Lab 1
* 
* @Igor Arthur Ferreira Ramos - 120210059
*/

import java.util.Scanner;

public class Maior_que_a_media {
    
    public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String array = sc.nextLine();
        sc.close();
        String[] numbers = array.split(" ");

        System.out.println(calcula_media(numbers));

    }

    public static String calcula_media(String[] valor) {

        int total = 0;
        float media = 0;
        String acima = ""; 

        for (int cont = 1; cont < valor.length + 1; cont++) {
            total += Integer.parseInt(valor[cont - 1]);
            media = total / cont;
        }

        for (int cont = 0; cont < valor.length; cont++) {
            if (Integer.parseInt(valor[cont]) > media) {
                acima += valor[cont] + " ";
            }
        }

        return acima;
    }
}
