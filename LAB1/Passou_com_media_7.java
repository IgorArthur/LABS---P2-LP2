/**
* Laboratório de Programação 2 - Lab 1
* 
* @Igor Arthur Ferreira Ramos - 120210059
*/

import java.util.Scanner;

public class Passou_com_media_7 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        float num1 = sc.nextFloat();
        float num2 = sc.nextFloat();
        sc.close();
        
        if ((num1 + num2) / 2 >= 7) {
            System.out.print("pass: True!");
        } else {
            System.out.print("pass: False!");
        }
    }
}
