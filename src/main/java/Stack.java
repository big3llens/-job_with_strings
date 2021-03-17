import java.util.Arrays;

public class Stack {
    private int size;
    private char[] stack;
    private int top;

    public Stack(int size) {
        this.size = size;
        stack = new char[size];
        top = -1;
    }

    public void add(char ch){
        top++;
        stack[top] = ch;
    }

    public char delete(){
        return stack[top--];
    }

    public boolean isEmpty(){
        if(top == -1) return true;
        return false;
    }

    public char showTop(){
        return stack[top];
    }

    public int getSize() {
        return size;
    }

    public char[] getStack() {
        return stack;
    }

    public int getTop() {
        return top;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}