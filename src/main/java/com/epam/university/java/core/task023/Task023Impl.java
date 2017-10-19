package com.epam.university.java.core.task023;

/**
 * Created by Вера on 01.10.2017.
 */
public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        if (phoneString.length() < 11) {
            throw new IllegalArgumentException();
        }

        String s1 = phoneString;
        String s2 = "";
        String s3 = "";

        // убираю знак + если он присутствует
        if (phoneString.startsWith("+")) {
            s1 = phoneString.replaceAll("\\+","");
        }
        //System.out.println(s1);
        //убираю из телефонного номера все пробелы
        s2 = s1.replaceAll(" ","");
        //System.out.println("s2 = " + s2);
        //убираю все скобки если они присутствуют
        s3 = s2.replaceAll("[\\( | \\)]","");
        //System.out.println("s3 = " + s3);

        char[] chars = s3.toCharArray();

        String result = "";
        result = "" + chars[1] + chars[2] + chars[3];

        //System.out.println(result);
        return result;
    }

    //public static void main(String[] args) {
    //Task023Impl task023 = new Task023Impl();
    //task023.extract("+7 (912) 345-67-89");
    //}
}
