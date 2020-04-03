package company;

import java.util.EmptyStackException;

public class IStack_Implementation implements IStack{
    /**
     * Create a subclass Node for the Stack based Linked list Implementation
     * It has 2 fields element representing data stored and next for the next element
     */
    public class Node {
        /**
         * Create an Object to Store The data
         */
        private Object element;
        /**
         * Create an Object to Point to the next Node in the list
         */
        private Node next;
        /**
         * Initialize an Empty Node
         */
        public Node(){
            this.element = null;
            this.next = null;
        }
        /**
         * Initialize a Node with The Following parameters
         * @param obj
         * @param n
         */
        public Node(Object obj , Node n){
            element = obj;
            next = n;
        }
        /**
         * @return The element stored in the Node
         */
        public Object getElement(){return element;}
        /**
         * @return The Object pointing to the next Node
         */
        public Node getNext(){return next;}
        /**
         * @param Elem
         * Set a new element in a Node
         */
        public void setElement(Object Elem){this.element = Elem;}
        /**
         * @param Next
         * Set a new Node next to the current One
         */
        public void setNext(Node Next){this.next = Next;}
    }

    /**
     * Create a node representing The top of the Stack
     */
    private Node peek;
    /**
     * Create a Counter for the elements of the Stack
     */
    private int size;
    /**
     * Initializing an Empty Stack
     */
    public IStack_Implementation(){
        peek = null;
        size = 0;
    }
    /**
     * Throws an Exception If the Stack was Empty
     * @return the top element of the Stack and delete it
     */
    @Override
    public Object pop() {
        if(isEmpty())   throw new EmptyStackException();
        Object temp = peek.getElement();
        peek = peek.getNext();
        size--;
        return temp;
    }
    /**
     * Throws an Exception If the Stack was Empty
     * @return the top element of the Stack without deleting it
     */
    @Override
    public Object peek() {
        if(isEmpty())   throw new EmptyStackException();
        return peek.getElement();
    }
    /**
     * @param element the data to be stored in the Stack
     */
    @Override
    public void push(Object element) {
        Node v = new Node(element,peek);
        peek = v;
        size++;
    }
    /**
     * Checks if The Stack is Empty or not
     * @return true if it is Empty
     * @return false otherwise
     */
    @Override
    public boolean isEmpty() {return (peek == null);}
    /**
     * @return the size of the Stack
     */
    @Override
    public int size() {return size;}
}
