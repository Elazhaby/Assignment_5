package company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IExpressionEvaluator_ImplementationTest {
    @Test
    void infixToPostfix1() {
        IExpressionEvaluator_Implementation S = new IExpressionEvaluator_Implementation();
        String infixExpression = "(5+3)*2/-3";
        assertEquals("5 3 + 2 * !3 / ",S.infixToPostfix(infixExpression));
    }
    @Test
    void infixToPostfix2(){
        IExpressionEvaluator_Implementation S = new IExpressionEvaluator_Implementation();
        String infixExpression = "";
        assertEquals(null,S.infixToPostfix(infixExpression));
    }
    @Test
    void infixToPostfix3(){
        IExpressionEvaluator_Implementation S = new IExpressionEvaluator_Implementation();
        String infixExpression = "-3+2*5-(-3)/4";
        assertEquals("!3 2 5 * + !3 4 / - ",S.infixToPostfix(infixExpression));
    }
    @Test
    void infixToPostfix4(){
        IExpressionEvaluator_Implementation S = new IExpressionEvaluator_Implementation();
        String infixExpression = "(a+b-c)/-5*2";
        assertEquals("a b + c - !5 / 2 * ",S.infixToPostfix(infixExpression));
    }
    @Test
    void evaluate1() {
        IExpressionEvaluator_Implementation S = new IExpressionEvaluator_Implementation();
        String postfixExpression = S.infixToPostfix("-3+2*5-(-3)/4");
        assertEquals(7,S.evaluate(postfixExpression));
    }
    @Test
    void evaluate2() {
        IExpressionEvaluator_Implementation S = new IExpressionEvaluator_Implementation();
        String postfixExpression = S.infixToPostfix("");
        assertEquals(0,S.evaluate(postfixExpression));
    }
}