/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @Igor Arthur Ferreira Ramos - 120210059
 */

 import java.util.Scanner;

public class Expressoes {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.printf("dobro: %s, triplo: %s", num * 2, num * 3);
    }
}
