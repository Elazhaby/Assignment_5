package company;

import java.util.HashSet;
import java.util.Set;

public class IExpressionEvaluator_Implementation implements IExpressionEvaluator {
    /**
     * @param expression
     * Takes the infix Expression and Convert it to postfix Expression
     * The Expression could be including numbers or alphabets or the Arithmetic symbols or parentheses
     * The Expression shouldn't be containing spaces
     * If the Expression had some strange Characters it throws an Exception
     * @return null if The Expression was Empty or null
     * @return postfix Expression otherwise
     */
    @Override
    public String infixToPostfix(String expression) {
        if(expression.length()==0 || expression==null)    return null;
        symbols.add('+');
        symbols.add('-');
        symbols.add('*');
        symbols.add('/');
        symbols.add('(');
        symbols.add(')');
        for (int j = 0; j < expression.length(); j++) {
            if(!(Character.isDigit(expression.charAt(j))||Character.isAlphabetic(expression.charAt(j))||symbols.contains(expression.charAt(j)))){
                throw new IllegalArgumentException();
            }
        }
        String postfixExpression = "";
        String operand = "";
        IStack_Implementation S = new IStack_Implementation();
        while (i < expression.length()){
           operand = getOperand(expression);
           if(operand != ""){
               postfixExpression += operand + " ";
               continue;
           }
           else if(symbols.contains(expression.charAt(i)) && expression.charAt(i)!='(' && expression.charAt(i)!=')'){
               while (!S.isEmpty() && hasHigherPrecedence((char)S.peek(),expression.charAt(i))){
                   postfixExpression += S.pop() + " ";
               }
               S.push(expression.charAt(i));
           }
           else if(expression.charAt(i)=='(')    S.push(expression.charAt(i));
           else if(expression.charAt(i)==')'){
               while (!S.isEmpty() && (char)S.peek()!='(')   postfixExpression += S.pop() + " ";
               Object x = S.pop();
           }
           i++;
        }
        while (!S.isEmpty())    postfixExpression += S.pop() + " ";
        return postfixExpression;
    }

    /**
     * @param expression
     * If The Expression was wrong it throws an Exception
     * If the Expression had an operation of dividing by 0 it throws an Exception
     * @return 0 if the Expression was null
     * @return The expected value of The Expression otherwise
     */
    @Override
    public int evaluate(String expression) {
        if(expression == null)     return 0;
        float value = 0 , number1 = 0 , number2 = 0;
        i = 0;
        String operand = "";
        IStack_Implementation S = new IStack_Implementation();
        while (i < expression.length()-1){
            if(expression.charAt(i)=='!' || Character.isDigit(expression.charAt(i))) {
                operand += expression.charAt(i);
                if(expression.charAt(i+1)==' ' && operand.charAt(0)!='!'){
                    S.push(Float.parseFloat(operand));
                    operand = "";
                }
                else if(expression.charAt(i+1)==' '){
                    operand = operand.replace("!","");
                    S.push(Integer.parseInt(operand) * -1);
                    operand = "";
                }
            }
            else if(symbols.contains(expression.charAt(i))){
                number1 = (float)S.pop();
                number2 = (float)S.pop();
                if(expression.charAt(i)=='+')   value += number2 + number1;
                else if(expression.charAt(i)=='-')    value = number2 - number1;
                else if(expression.charAt(i)=='*')    value = number2 * number1;
                else if(expression.charAt(i)=='/'){
                    if(number1 == 0)   throw new RuntimeException();
                    if(number2 == 0)   return 0;
                    value = number2 / number1;
                }
                S.push(value);
                value = 0;
            }
            i++;
        }
        value = (float)S.pop();
        if(!S.isEmpty())   throw new IllegalArgumentException();
        return (int)value;
    }
    /**
     * Initializing a Counter for The Expressions
     */
    public int i = 0;
    /**
     * Initializing a Set containing the only valid symbols
     */
    public Set<Character> symbols = new HashSet<Character>();
    /**
     * @param expression
     * @return A String representing The operand
     * If the Operand was negative we add ! before it to distinguish between the '-' unary operator and the binary operator
     * @return An Empty String otherwise
     */
    private String getOperand(String expression){
        String operand = "";
        while (i < expression.length()) {
            if(expression.charAt(i)=='-' && (i==0 || symbols.contains(expression.charAt(i-1)) && expression.charAt(i-1)!=')'))
                operand += '!';
            else if(Character.isDigit(expression.charAt(i)) || Character.isAlphabetic(expression.charAt(i)))
                operand += expression.charAt(i);
            else break;
            i++;
        }
        return operand;
    }
    /**
     * @param a The top element of the Stack
     * @param b The operator represented into the infix Expression
     * @return true if a has higher Precedence than b or having the same Precedence
     * @return false Otherwise
     */
    private boolean hasHigherPrecedence(char a , char b){
        Set<Character> low = new HashSet<Character>();
        low.add('+');
        low.add('-');
        Set<Character> high = new HashSet<Character>();
        high.add('*');
        high.add('/');
        if(high.contains(a)&&low.contains(b) || low.contains(a)&&low.contains(b) || high.contains(a)&&high.contains(b)){
            return true;
        }
        return false;
    }
}
