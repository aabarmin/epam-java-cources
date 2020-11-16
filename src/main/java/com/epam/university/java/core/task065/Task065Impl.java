package com.epam.university.java.core.task065;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Task065Impl implements Task065 {
    @Override
    public WayTable getWayTable(String filepath) {

        if (filepath == null || filepath.isEmpty() || filepath.isBlank()) {
            throw new IllegalArgumentException();
        }
        Map<LocalDate, Double> trips = new HashMap<>();
        double totalDist = 0;
        int amountOfTrips = 0;
        File file = new File(filepath);
        try {
            Document page = Jsoup.parse(file, "UTF-8");

            Elements select = page.select("table[class=sort]");
            Element tableToSort = select.get(3);

            Elements dist = tableToSort.select("td");

            LocalDate localDate = null;
            double distance = 0;
            int index = 0;
            for (Element element : dist) {
                if (!element.hasAttr("width")
                        && !element.hasAttr("align")) {
                    if (index == 3) {
                        String date = element.text();
                        if (date.isBlank()) {
                            break;
                        }
                        String[] dateParts = date.split("\\.");
                        int year = 2000 + Integer.parseInt(dateParts[2]);
                        int month = Integer.parseInt(dateParts[1]);
                        int day = Integer.parseInt(dateParts[0]);
                        localDate = LocalDate.of(year, month, day);
                    }
                    if (index == 6) {
                        String strDistance = element.text();
                        distance = Double.parseDouble(strDistance);
                    }
                    if (index == 8) {
                        if (!element.text().isBlank()) {
                            distance = getDistanceFromComment(element.text());
                        }
                    }
                    index++;
                }
                if (index == 9) {
                    if (trips.containsKey(localDate)) {
                        double value = trips.get(localDate);
                        value += distance;
                        trips.put(localDate, value);
                    } else {
                        trips.put(localDate, distance);
                    }

                    totalDist += distance;
                    amountOfTrips++;


                    index = 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<LocalDate, Integer> tripsInInt = new HashMap<>();
        for (Map.Entry<LocalDate, Double> entry : trips.entrySet()) {
            LocalDate key = entry.getKey();
            Double value = entry.getValue();
            int intValue = (int) Math.round(value);
            tripsInInt.put(key, intValue);
        }

        WayTable table = new WayTableImpl(tripsInInt, (int) Math.round(totalDist), amountOfTrips);

        return table;
    }

    private double getDistanceFromComment(String text) {
        StringBuilder builder = new StringBuilder();

        for (Character c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                builder.append(c);
            }
        }

        return Double.parseDouble(builder.toString());
    }
}
