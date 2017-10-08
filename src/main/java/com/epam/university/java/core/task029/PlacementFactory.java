package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ilya on 08.10.17.
 */
public class PlacementFactory {

    /**
     * Produce placements from rows collection.
     *
     * @param rows collection of rows
     * @return list of Placements
     */
    public List<Placement> getPlacements(Collection<String> rows) {
        List<Placement> placements = findPlacement(rows);
        findLinks(placements);

        return placements;
    }


    private List<Placement> findPlacement(Collection<String> rows) {
        List<List<String>> stringRows = rows.stream().map(s -> Arrays.asList(s.split("")))
            .collect(Collectors.toList());

        List<Placement> placements = new ArrayList<>();

        //find horizontal placements
        for (int j = 0; j < stringRows.size(); j++) {
            for (int i = 0; i < stringRows.get(j).size(); i++) {
                if ("-".equals(stringRows.get(j).get(i))) {
                    List<Cell> placementable = new ArrayList<>();
                    placementable.add(new Cell(j, i));
                    i++;
                    while (i < stringRows.get(j).size() && "-".equals(stringRows.get(j).get(i))) {
                        placementable.add(new Cell(j, i));
                        i++;
                    }
                    if (placementable.size() > 1) {
                        placements.add(new Placement(placementable));
                    }
                }
            }
        }
        //find vertical placements
        for (int j = 0; j < stringRows.get(0).size(); j++) {
            for (int i = 0; i < stringRows.size(); i++) {
                if ("-".equals(stringRows.get(i).get(j))) {
                    List<Cell> placementable = new ArrayList<>();
                    placementable.add(new Cell(i, j));
                    i++;
                    while (i < stringRows.size() && "-".equals(stringRows.get(i).get(j))) {
                        placementable.add(new Cell(i, j));
                        i++;
                    }
                    if (placementable.size() > 1) {
                        placements.add(new Placement(placementable));
                    }
                }
            }
        }
        return placements;
    }

    private void findLinks(List<Placement> placements) {
        for (Placement firstPlacement :
            placements) {
            for (Cell firstCell :
                firstPlacement.getCells()) {
                for (Placement second :
                    placements) {
                    for (Cell secondCell :
                        second.getCells()) {
                        if (secondCell != firstCell && secondCell.equals(firstCell)) {
                            firstCell.setLink(secondCell);
                            secondCell.setLink(firstCell);
                        }
                    }
                }
            }
        }
    }


}
