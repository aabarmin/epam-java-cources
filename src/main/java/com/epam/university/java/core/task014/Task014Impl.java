package com.epam.university.java.core.task014;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Вера on 19.09.2017.
 */
public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        Collection<VampireNumber> vampireNumberCollection = new HashSet<>();
        // раскладываем четерехзначное число на массив из четырех цифр
        int[] a = new int[4];
        // check - массив различных произведений
        int[] check = new int[12];
        // проверяем что число нулей не больше 1
        // пусть indicator = количество нулей
        int indicator;

        for (int i = 1000; i < 10000; i++) {
            a[3] = i % 10;
            a[2] = (i % 100 - a[3]) / 10;
            a[1] = (i % 1000 - a[2] * 10 - a[3]) / 100;
            a[0] = i / 1000;
            indicator = 0;

            if (a[3] == 0) {
                indicator++;
            }
            if (a[2] == 0) {
                indicator++;
            }
            if (a[1] == 0) {
                indicator++;
            }
            if (a[0] == 0) {
                indicator++;
            }

            if (indicator <= 1) {
                check[0] = (a[0] * 10 + a[1]) * (a[2] * 10 + a[3]);
                check[1] = (a[0] * 10 + a[1]) * (a[3] * 10 + a[2]);
                check[2] = (a[1] * 10 + a[0]) * (a[2] * 10 + a[3]);
                check[3] = (a[1] * 10 + a[0]) * (a[3] * 10 + a[2]);

                check[4] = (a[0] * 10 + a[2]) * (a[1] * 10 + a[3]);
                check[5] = (a[0] * 10 + a[2]) * (a[3] * 10 + a[1]);
                check[6] = (a[2] * 10 + a[0]) * (a[1] * 10 + a[3]);
                check[7] = (a[2] * 10 + a[0]) * (a[3] * 10 + a[1]);

                check[8] = (a[0] * 10 + a[3]) * (a[1] * 10 + a[2]);
                check[9] = (a[0] * 10 + a[3]) * (a[2] * 10 + a[1]);
                check[10] = (a[3] * 10 + a[0]) * (a[1] * 10 + a[2]);
                check[11] = (a[3] * 10 + a[0]) * (a[2] * 10 + a[1]);

                if (check[0] == i || check[1] == i || check[2] == i || check[3] == i
                        || check[4] == i || check[5] == i || check[6] == i || check[7] == i
                        || check[8] == i || check[9] == i || check[10] == i || check[11] == i) {
                    vampireNumberCollection.add(new VampireNumberImpl(i));
                }
            }
        }

        return vampireNumberCollection;
    }
}
