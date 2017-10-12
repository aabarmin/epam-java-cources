package com.epam.university.java.core.task016;

import com.epam.university.java.core.utils.common.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class implements <code>Task016</code>.
 */
public class Task016Impl implements Task016 {
    int coordinatesMultiplier = 2;

    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        Validator.validateNotNegative(radius, Validator.MESSAGE_IF_NEGATIVE);
        List<Coordinate> coordinates = new ArrayList<>();
        int coordinatesAdapter = radius * coordinatesMultiplier;
        for (int i = -coordinatesAdapter; i <= coordinatesAdapter; i++) {
            if (i == 0) {
                continue;
            }
            for (int j = -coordinatesAdapter; j <= coordinatesAdapter; j++) {
                if (j == 0) {
                    continue;
                }
                if (i * i + j * j < coordinatesAdapter * coordinatesAdapter) {
                    coordinates.add(new CoordinateImpl(i, j));
                }
            }
        }
        return coordinates;
    }
}