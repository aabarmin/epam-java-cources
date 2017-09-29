package com.epam.university.java.core.task008;

import com.sun.javafx.util.Utils;



public class Task008Impl implements Task008 {


        @Override
        public boolean isValid(String sourceString)  {
            Stack var = new Stack();
            char temp;
            boolean result = false;
            if (sourceString.isEmpty()){
                return true;
            }
            for (int i = 0; i < sourceString.length(); i++){
                char symbol = sourceString.charAt(i);
                if (symbol == '(' || symbol == '[' || symbol == '{'){
                    var.setElement(symbol);
                }
                if (symbol == ')'){
                    temp = var.getElement();
                    if (temp == '('){
                        result = true;
                    }
                }
                if (symbol == ']'){
                    temp = var.getElement();
                    if (temp == '['){
                        result = true;
                    }
                }
                if (symbol == '}'){
                    temp = var.getElement();
                    if (temp == '{'){
                        result = true;
                    }

                }
            }
            return result;
        }
    }


