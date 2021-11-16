/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @Igor Arthur Ferreira Ramos - 120210059
 */

import java.util.Scanner;

public class Onde_esta_Wally {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        while (true) {

            String entrada = sc.nextLine();
            if (entrada.contains("wally")) {
                break;
            } else {
                String[] nomes = entrada.split(" ");
                System.out.println(find_wally(nomes));
            }
        } 

        sc.close();
    }

    public static String find_wally(String[] array) {

        String possivel = "";

                for (int cont = 0; cont < array.length; cont++) {
                    if (array[cont].length() == 5) {
                        possivel = array[cont];
                    } 
                }

                if (possivel == "") {
                    possivel = "?";
                }

                return possivel;

    }
}
