package com.epam.university.java.core.task003;

/**
 * Created by Вера on 07.09.2017.
 * этот файл можно не смотреть. Он чисто для меня.
 */
public class JustTryThis implements  FlatMappingOperation {
  //  private FlatMappingOperation flatMappingOperation;

    public int[] sort(int[] generalArray) {
        int minHelp = 0;
        for (int i = generalArray.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (generalArray[j] < generalArray[j+1]) {
                    minHelp = generalArray[j+1];
                    generalArray[j+1] = generalArray[j];
                    generalArray[j] = minHelp;
                }
            }
        }
        return generalArray;
    }


    @Override
    public String[] flatMap(String source) {
        String[] strSpace = source.split(" ");
        int i = 0;
        String sourceWithoutSpace = "";
        while (i < strSpace.length) {
            if (strSpace[i] != " ")
                sourceWithoutSpace+=strSpace[i];
            i++;
        }

        String[] strComma = sourceWithoutSpace.split(",");

        return strComma;
    }


   // @Override
    public String[] flatMapOsnova(int[] source) {


        String resultString = "";
        for (int i = 0; i < source.length-1; i++) {
            if ((source[i] != source[i+1])||(i == source.length-2))
                resultString = resultString + source[i]+" ";
        }

        String[] resultArray = resultString.split(" ");

        return resultArray;
    }


    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null)
            throw new IllegalArgumentException();

        //посчитаю количество элементов массива которые надо удалить

        int countToDelete = 0;

        for (int i = 0; i < toRemote.length; i++) {
            for (int j = 0; j < source.length; j++) {
                if (source[j].equals(toRemote[i]))
                    countToDelete++;
            }
        }
        //создаю массив элементов с учетом удаленных
        String[] result = new String[source.length - countToDelete];
        //
        //введу инфикатор что элемент подлежит удалению
        int indicator = 0;
        int k = 0;
        for (int i = 0; i < source.length; i++) {
            indicator = 0;
            for (int j = 0; j < toRemote.length; j++) {
                if (source[i].equals(toRemote[j]))
                indicator = 1;
            }
            if (indicator == 0) {
                result[k] = source[i];
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        JustTryThis justTryThis = new JustTryThis();
        String s = "1, 2,     3, 4   , 5";
        String s1 = "1, 2, 6,      7, 7, 7, 8";
        String s2 = "10, 9";
        String[] args1 = justTryThis.flatMap(s);
        String[] args2 = justTryThis.flatMap(s1);
        String[] args3 = justTryThis.flatMap(s2);
        String[] arsgAll = new String[args1.length+args2.length+args3.length];


        for (int i = 0; i < args1.length; i++) {
            arsgAll[i] = args1[i];
        }
        int dlinaLastMassiv = args1.length;
        for (int i = 0; i < args2.length; i++) {
            arsgAll[i+dlinaLastMassiv] = args2[i];
        }
        dlinaLastMassiv+=args2.length;
        for (int i = 0; i < args3.length; i++) {
            arsgAll[i+dlinaLastMassiv] = args3[i];
        }

        int[] sourceAnother = new int[arsgAll.length];

        for (int i = 0; i < arsgAll.length; i++) {
            sourceAnother[i] = Integer.parseInt(arsgAll[i]);
        }



      //  int[] sourceAnother = new int[]{10,10,9,8,7,7,7,6,5,4,3,2,2,1,1};
        justTryThis.sort(sourceAnother);
        justTryThis.flatMapOsnova(sourceAnother);
        int[] sourceToSort = new int[]{1,2,3,4,5,1,2,6,7,7,7,8,10,9};

        String[] sourceOne = {
                "One",
                "Two",
                "Three",
                "Four"
        };
        String[] toRemoveOne = {
                "Two",
                "Four"
        };
        justTryThis.removeElements(sourceOne, toRemoveOne);


    }
}
