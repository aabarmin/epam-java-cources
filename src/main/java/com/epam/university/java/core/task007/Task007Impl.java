package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Александр on 06.09.2017.
 */
public class Task007Impl implements Task007 {
    /**
     * Multiply polynomials. Each collection contains coefficients near i-th member, ex:
     * <p>
     * 3x^3 + 2x^2 - 5x corresponds to collection [3, 2, -5, 0]
     * </p>
     * <p>
     * Task is to multiply two polynomials: ex:
     * </p>
     * <p>
     * (3x^3 + 2x^2 - 5x) * (4x^4 + 2x^2) == multiplyPolynomial([3, 2, -5, 0], [4, 0, 2, 0, 0])
     * </p>
     * <p>
     * If polynomial is degenerating to zero, return [0]
     * </p>
     *
     * @param first  collection with coefficients near-th member of first polynomial
     * @param second collection with coefficients near-th member of second polynomial
     * @return collection of members in multiplied polynomials
     */
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {
        ArrayList<Integer> firstArray = new ArrayList<>(first);
        ArrayList<Integer> secondArray = new ArrayList<>(second);

        ArrayList<Integer> result = new ArrayList<>();
        int capacity = firstArray.size() + secondArray.size();
        for(int i = 0; i<capacity; i++){
            result.add(0);
        }

        for(int i = 0; i < firstArray.size(); i++){
            for(int j = 0; j < secondArray.size(); j++){
                int position = i + j;
                result.set(position,
                        result.get(position)
                        + (firstArray.get(i) * secondArray.get(j))
                );
            }
        }

        for(int i = result.size()-1; i>0; i--){
            if(result.get(i) == 0){
                result.remove(i);
            }
            else {
                break;
            }
        }

        return result;
    }
}
