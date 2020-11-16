package com.epam.university.java.core.task065;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class WayTableImpl implements WayTable{

    private Map<LocalDate, Integer> distanceByDate;
    private int totalDist;
    private int countWays;

    public WayTableImpl(Map<LocalDate, Integer> distanceByDate, int totalDist, int countWays) {
        this.distanceByDate = distanceByDate;
        this.totalDist = totalDist;
        this.countWays = countWays;
    }

    @Override
    public int getDistOfDate(LocalDate localDate) {
        return distanceByDate.get(localDate);
    }

    @Override
    public int getAllDistance() {
        return totalDist;
    }

    @Override
    public int getCountWays() {
        return countWays;
    }
}
