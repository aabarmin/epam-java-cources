package com.epam.university.java.core.task008;

import java.util.ArrayList;

class Stack {
        char symbol;
        int index;
        ArrayList<Character> stack = new ArrayList<>();
        public void setElement(char element){
            stack.add(element);
        }
        public char getElement() {
            char temp = '0';
            if (!stack.isEmpty()) {
                index = stack.size() - 1;
                temp = stack.get(index);
                stack.remove(index);

            }
            return temp;
        }
}
