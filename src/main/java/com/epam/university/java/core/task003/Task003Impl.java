package com.epam.university.java.core.task003;

/**
 * Created by Вера on 06.09.2017.
 */
public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }

        String[] invertString = new String[source.length];

        for (int i = 0; i < source.length; i++) {
            invertString[i] = source[source.length - i - 1];
        }
        return invertString;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        String[] joinBoth = new String[first.length + second.length];

        for (int i = 0; i < first.length; i++) {
            joinBoth[i] = first[i];
        }

        for (int i = first.length; i < joinBoth.length; i++) {
            joinBoth[i] = second[i - first.length];
        }

        return joinBoth;
    }

    @Override
    public int findMax(int[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }

        int max = source[0];

        for (int i = 0; i < source.length; i++) {
            if (max < source[i]) {
                max = source[i];
            }
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        if (source == null || condition == null) {
            throw new IllegalArgumentException();
        }
        String result = "";

        for (int i = 0; i < source.length; i++) {
            if (condition.isValid(source[i])) {
                result = result + source[i] + " ";
            }
        }
        return result.split(" ");
    }


    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        if (source == null || toRemote == null) {
            throw new IllegalArgumentException();
        }

        //посчитаю количество элементов массива которые надо удалить

        int countToDelete = 0;

        for (int i = 0; i < toRemote.length; i++) {
            for (int j = 0; j < source.length; j++) {
                if (source[j].equals(toRemote[i])) {
                    countToDelete++;
                }
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
                if (source[i].equals(toRemote[j])) {
                    indicator = 1;
                }
            }
            if (indicator == 0) {
                result[k] = source[i];
                k++;
            }
        }

        return result;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        if (source == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < source.length; i++) {
            source[i] = operation.map(source[i]);
        }
        return source;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }

        int dlinaLastMassiv = 0;
        int maxReservSymbols = 0;
        //максимальное кол-во элементов полного массива - т.е. хочу слить source в один массив
        for (int i = 0; i < source.length; i++) {
            maxReservSymbols += operation.flatMap(source[i]).length;
        }

        int[] generalArray = new int[maxReservSymbols];
        // сливаю всё в один массив типа int
        for (int i = 0; i < source.length; i++) {
            String[] temporaryArray = operation.flatMap(source[i]);

            for (int j = 0; j < temporaryArray.length; j++) {
                generalArray[j + dlinaLastMassiv] = Integer.parseInt(temporaryArray[j]);
            }
            dlinaLastMassiv += temporaryArray.length;
        }
        // cортирую массив по убыванию пузырьком
        // int max = generalArray[0];
        int minHelp = 0;
        for (int i = generalArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (generalArray[j] < generalArray[j + 1]) {
                    minHelp = generalArray[j + 1];
                    generalArray[j + 1] = generalArray[j];
                    generalArray[j] = minHelp;
                }
            }
        }

        //
        String resultString = "";
        for (int i = 0; i < generalArray.length - 1; i++) {
            if ((generalArray[i] != generalArray[i + 1]) || (i == generalArray.length - 2)) {
                resultString = resultString + generalArray[i] + " ";
            }
        }

        String[] resultArray = resultString.split(" ");

        return resultArray;
    }
}
