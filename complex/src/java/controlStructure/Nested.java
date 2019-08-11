package controlStructure;

import java.util.HashMap;

public class Nested {
    private HashMap<Integer, Integer> hm;
    Stack stack = new Stack();
    private int value = 0;


    public void add(){
        stack.push("{");
    }

    public void remove(){
        stack.pop();
        value++;
    }

    public int getCNC(){
        return value;
    }
}
