package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ilya on 08.10.17.
 */
public class Field {

    public static final String FILLER = "+";
    private final int rows;
    private final int columns;
    private String[][] field;

    /**
     * Filed constructor.
     *
     * @param rows number of rows
     * @param columns number of columns
     */
    public Field(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        fill();

    }

    private void fill() {
        field = new String[rows][columns];

        for (int i = 0; i < field.length; i++) {
            String[] row = field[i];
            for (int j = 0; j < row.length; j++) {
                row[j] = FILLER;
            }
        }
    }

    /**
     * Place words to field.
     *
     * @param placements collection of placements
     * @return itself
     */
    public Field place(List<Placement> placements) {
        for (Placement placement :
            placements) {
            for (Cell cell :
                placement.getCells()) {
                field[cell.getRow()][cell.getColumn()] = String.valueOf(cell.getLetter());
            }
        }

        return this;
    }

    /**
     * Return collection of String rows.
     *
     * @return collection of rows
     */
    public Collection<String> getRows() {
        Collection<String> rows = new ArrayList<>();

        for (String[] row :
            field) {
            StringBuilder stringRow = new StringBuilder();
            for (String s :
                row) {
                stringRow.append(s);
            }
            rows.add(stringRow.toString());
        }

        return rows;
    }

}
