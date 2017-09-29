package com.epam.university.java.core.task003;

/**
 * Created by Vadim on 15.09.2017.
 */
public class StringTest {
    public static String map(String source) {
        StringBuffer buffer = new StringBuffer(source);
        String output;
        output = buffer.reverse().toString();
        return output;
    }
    public static String[] join(String[] first, String[] second) {

        for (String element: first) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
        for (String element: second) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
        int lengthFirst = first.length;
        int lengthSecond = second.length;
        int lengthNew = lengthFirst + lengthSecond;

        String[] newArray = new String[lengthNew];

        System.arraycopy(first, 0, newArray, 0, lengthFirst);
        System.arraycopy(second, 0, newArray, lengthFirst, lengthSecond );
        return newArray;
    }
    public static boolean isElementsEquals(String one, String two){
        return one.equals(two);
    }


    public static String[] removeElements(String[] source, String[] toRemote) {
        for (String element: source) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
        for (String element: toRemote) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
        int listlength = source.length - toRemote.length;
        String[] list = new String[listlength];
        int index = 0;
        for (int i = 0; i < source.length; i++){
            boolean check = false;
            for (int j = 0; j < toRemote.length; j++){
                if (isElementsEquals(source[i], toRemote[j])){
                    check = true;
                }
            }
            if (!check) {
                list[index] = source[i];
                index++;
            }
        }

        return list;
    }
    public static String[] flatMap(String source) {
        int[] countArr = new int[11];
        int length = 0;
        for (int i = 1; i < 11; i++){
            String s = i + "";
            if (source.contains(s)){
                countArr[i] = i;
                length++;
            }
        }
        String[] output = new String[length];
        int index = 0;
        for (int element: countArr) {
            if (element != 0){
                output[index] = element + "";
                index++;
            }
        }
        return output;
    }
    static boolean isArrayEmpty(String[] array) {
        return array.length == 0;
    }
    public static String[] invert(String[] source) {
        int nElements = source.length;
        String[] invertArray = new String[nElements];
        if (!isArrayEmpty(source)){
            for (int i = 0; i < nElements; i++) {
                invertArray[nElements - 1 - i] = source[i];
            }
        }
        return invertArray;
    }
    public static String[] flatMapp(String[] source) {
        String[] array = new String[0];
        for (int i = 0; i < source.length; i++){
            array = join(array, flatMap(source[i]));
        }
        String[] newArray = new String[10];
        int index = 0;
        newArray[index] = array[0];
        for (int i = 1; i < array.length; i++){
            if (!newArray[i - 1].equals(array[i])){
                index++;
                newArray[index] = array[i];
            }
        }
        return invert(newArray);
    }

    public static void main(String[] args) {
        /*System.out.println(map("Four"));
        final String[] first = {
                "One",
                "Two"
        };
        final String[] second = {
                "Three",
                "Four"
        };
        for (String element: join(first, second)) {
            System.out.println(element);
        }
        final String[] one = {
                "One",
                "Two",
                "Three",
                "Four"
        };
        final String[] two = {
                "Two",
                "Four"
        };
        for (String element: removeElements(one, two)) {
            System.out.println(element);
        }*/
        final String[] source = {
                "1, 2,     3, 4   , 5",
                "1, 2, 6,      7, 7, 7, 8",
                "10, 9"
        };
        for (String element: flatMap("10, 9")) {
            System.out.println(element);
        }
        String[] array = new String[0];
        for (int i = 0; i < source.length; i++){
            array = join(array, flatMap(source[i]));
        }
        for (String element: array) {
            System.out.print(element + "_");
        }

    }
}
