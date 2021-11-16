/**
* Laboratório de Programação 2 - Lab 1
* 
* @Igor Arthur Ferreira Ramos - 120210059
*/
import java.util.Scanner;

public class Calculadora_com_opcao {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String operator = sc.nextLine();
        sc.close();

        String possible = "+-*/";
        float res = 0;

        if (possible.contains(operator)) {
            float num1 = sc.nextFloat();
            float num2 = sc.nextFloat();

            if (operator.equals("+")) {
                res = num1 + num2;
                System.out.println("RESULTADO: " + res);
            } else if (operator.equals("-")) {
                res = num1 - num2;
                System.out.println("RESULTADO: " + res);
            } else if (operator.equals("*")) {
                res = num1 * num2;
                System.out.println("RESULTADO: " + res);
            } else {
                if (num2 == 0) {
                     System.out.println("ERRO");
                } else {
                    res = num1 / num2;
                     System.out.println("RESULTADO: " + res);
                }
            }

        } else {
             System.out.println("ENTRADA INVALIDA");
        }
    }
}