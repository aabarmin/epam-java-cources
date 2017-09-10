
/**
 * Created by Вера on 09.09.2017.
 * Этот файл чисто для меня.
 */
public class Solution2 {
        public static void main(String[] args) {
            Solution2 solution = new Solution2();
//             String[] firstTry = {
//                "",
//                "",
//                "2",
//                "12",
//                "43"
//
//             };
//
//            String[] secondTry = {"2","9","12","2","9","14","2"};
            String[] firstTry = {
                    "",
                    ""
            };
            String[] secondTry = {};
            solution.union23(firstTry, secondTry);

        }

        //функция убирающая дубликаты из массива
        private String[] deleteDublicates(String first[]) {

                // дубликатам из первого массива присваиваю значение первого элемента массива first
                for (int i = 0; i < first.length - 1; i++) {
                    for (int j = i + 1; j < first.length; j++) {
                        if (first[i].equals(first[j])) {
                            first[j] = first[0];
                        }
                    }
                }
                // считаю количество дубликатов в первом массиве
                int numberDublicate = 0;
                for (int i = 1; i < first.length; i++) {
                    if (first[i].equals(first[0])) {
                        numberDublicate++;
                    }
                }

                //создаю массив с элементами из массива first без дубликатов
                String[] firstWithoutDublicates = new String[first.length - numberDublicate];
                int k = 0;
                //копирую туда значения из массива first без дубликатов
                firstWithoutDublicates[k] = first[0];
                k++;
                for (int i = 1; i < first.length; i++) {
                    if (!first[i].equals(first[0])) {
                        firstWithoutDublicates[k] = first[i];
                        k++;
                    }
                }

            return firstWithoutDublicates;
        }

        private String[] unionHelpFunction (String[] firstWithoutDublicates, String[] secondWithoutDublicates) {
            //нахожу количество одинаковых элементов массивов без дубликатов

            int count = 0;
            for (int i = 0; i < firstWithoutDublicates.length; i++) {
                for (int j = 0; j < secondWithoutDublicates.length; j++) {
                    if (firstWithoutDublicates[i].equals(secondWithoutDublicates[j])) {
                        count++;
                    }
                }
            }

            String[] result = new String [firstWithoutDublicates.length + secondWithoutDublicates.length - count];
            //пусть k - счетчик для массива result
            int k = 0;
            //введу индикатор совпадения элементов массивов
            int indicator;

            //добавляем элементы первого массива в массив result без дубликатов
            for (int i = 0; i < firstWithoutDublicates.length; i++) {
                indicator = 0;
                for (int j = 0; j < result.length; j++) {
                    if (firstWithoutDublicates[i].equals(result[j])) {
                        indicator = 1;
                    }
                }
                if (indicator == 0) {
                    result[k] = firstWithoutDublicates[i];
                    k++;
                }
            }

            //добавляем элементы второго массива, которых нет в первом массиве
            for (int i = 0; i < secondWithoutDublicates.length; i++) {
                indicator = 0;
                for (int j = 0; j < result.length; j++) {
                    if (secondWithoutDublicates[i].equals(result[j])) {
                        indicator = 1;
                    }
                }
                if (indicator == 0) {
                    result[k] = secondWithoutDublicates[i];
                    k++;
                }
            }
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
            return result;
        }


        public String[] union23(String[] first, String[] second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException();
            }

            if ((first.length >= 2) && (second.length >= 2)) {
                String[] firstWithoutDublicates = deleteDublicates(first);
                String[] secondWithoutDublicates = deleteDublicates(second);
                return unionHelpFunction(firstWithoutDublicates, secondWithoutDublicates);
            } else if ((first.length >= 2) && (second.length < 2)) {
                String[] firstWithoutDublicates = deleteDublicates(first);
                String[] secondWithoutDublicates = second;
                return unionHelpFunction(firstWithoutDublicates, secondWithoutDublicates);
            } else if ((first.length < 2) && (second.length >= 2)) {
                String[] firstWithoutDublicates = first;
                String[] secondWithoutDublicates = deleteDublicates(second);
                return unionHelpFunction(firstWithoutDublicates, secondWithoutDublicates);
            } else {
                String[] firstWithoutDublicates = first;
                String[] secondWithoutDublicates = second;
                return unionHelpFunction(firstWithoutDublicates, secondWithoutDublicates);
            }
        }
}