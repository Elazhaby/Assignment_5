package company;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class IStack_ImplementationTest {

    @Test
    void pop1() {
        IStack_Implementation S = new IStack_Implementation();
        S.push(3);
        S.push(7);
        S.push(5);
        assertEquals(5,S.pop());
    }
    @Test
    void pop2() {
        IStack_Implementation S = new IStack_Implementation();
        try {
            Object result = S.pop();
            fail();
        }
        catch (EmptyStackException ex) {
            assertEquals(null, ex.getMessage());
        }
    }
    @Test
    void peek() {
        IStack_Implementation S = new IStack_Implementation();
        S.push(12);
        S.push(4);
        S.push(9);
        assertEquals(9,S.peek());
    }
    @Test
    void isEmpty1() {
        IStack_Implementation S = new IStack_Implementation();
        S.push(12);
        S.push(4);
        assertEquals(false,S.isEmpty());
    }
    @Test
    void isEmpty2() {
        IStack_Implementation S = new IStack_Implementation();
        assertEquals(true,S.isEmpty());
    }
    @Test
    void size1() {
        IStack_Implementation S = new IStack_Implementation();
        S.push(12);
        S.push(4);
        S.push(9);
        assertEquals(3,S.size());
    }
    @Test
    void size2() {
        IStack_Implementation S = new IStack_Implementation();
        assertEquals(0,S.size());
    }
}