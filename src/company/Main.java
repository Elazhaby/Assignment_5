package company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        IExpressionEvaluator_Implementation S = new IExpressionEvaluator_Implementation();
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Choose The type Of Expression");
                System.out.println("1-To Enter numerical Expression\n" + "2-To Enter alphabetical");
                int decision = input1.nextInt();
                if(decision == 1) {
                    System.out.println("Please Enter the Expression to be evaluated >>>");
                    String infixExpression = input2.nextLine();
                    infixExpression = infixExpression.replaceAll("\\s+", "");
                    String postfixExpression = S.infixToPostfix(infixExpression);
                    System.out.println(postfixExpression);
                    System.out.println("The result is >>>" + "\n" + S.evaluate(postfixExpression));
                }
                else if(decision == 2){
                    System.out.println("Please Enter the Expression >>>");
                    String infixExpression = input2.nextLine();
                    infixExpression = infixExpression.replaceAll("\\s+", "");
                    String postfixExpression = S.infixToPostfix(infixExpression);
                    System.out.println(postfixExpression);
                }
                else  throw new IOException();
                S.i = 0;
            }
            catch (Exception e) {
                System.out.println("An Error Occurred Please Input the Arithmetic Expression using these symbols");
                System.out.println("['digits' , 'alphabets' , '+' , '-' , '*' , '/' , '(' , ')']");
                System.out.println("Try Check your Expression Again");
                System.out.println("Make sure that non Of the operations is Division by 0");
                System.out.println("Try to Enter the Correct asked Inputs");
            }
            finally {
                input1.nextLine();
            }
            System.out.println("=============================");
        }
    }
}
