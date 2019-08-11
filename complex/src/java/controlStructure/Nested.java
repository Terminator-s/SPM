package controlStructure;

import java.util.HashMap;

public class Nested {
    private HashMap<Integer, Integer> hm;
    Stack stack = new Stack();
    private int value = 0;
    int count = 0;


    public void add(){
        stack.push("{");
        count = stack.getStackSize();
        value+=count;
    }

    public void remove(){
        stack.pop();
    }

    public int getCNC(){
        return value;
    }
}
