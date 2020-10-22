package com.epam.university.java.core.task042;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class Task042Impl implements Task042 {
    @Override
    public BookingResponse checkAvailability(List<String> schedule, String currentTime) {

        if (schedule == null || currentTime == null) {
            throw new IllegalArgumentException();
        }


        LinkedList<LocalTime> timeTable = new LinkedList<>();
        for (String line : schedule) {
            String[] timeRange = line.split("-");
            for (String hoursAndMinutes : timeRange) {
                String[] hAndM = hoursAndMinutes.split(":");
                LocalTime time = LocalTime.of(Integer.parseInt(hAndM[0]),
                        Integer.parseInt(hAndM[1]));
                timeTable.add(time);
            }
        }

        String[] hAndM = currentTime.split(":");
        LocalTime time = LocalTime.of(Integer.parseInt(hAndM[0]), Integer.parseInt(hAndM[1]));

        if (schedule.isEmpty()) {
            if (time.isAfter(LocalTime.of(9, 0)) && time.isBefore(LocalTime.of(18, 0))) {
                return new AvailableResponse();
            } else if (time.isBefore(LocalTime.of(9, 0))) {
                TimeProposalResponse timeProposalResponse = new TimeProposalResponse();
                timeProposalResponse.setProposedTime("09:00");
                return timeProposalResponse;
            } else if (time.isAfter(LocalTime.of(17, 59))) {
                return new BusyResponse();
            }
        }

        for (int i = 0; i < timeTable.size(); i += 2) {
            if (time.isBefore(LocalTime.of(9, 0))) {
                return findNearestTime(time, timeTable);
            }
            if (time.isAfter(timeTable.get(i)) && time.isBefore(timeTable.get(i + 1))) {
                if (time.isBefore(LocalTime.of(18, 0))) {
                    return findNearestTime(time, timeTable);
                }
            } else if (time.isAfter(timeTable.get(i + 1)) && time.isBefore(timeTable.get(i + 2))) {
                return new AvailableResponse();
            }
        }

        return new BusyResponse();
    }

    private BookingResponse findNearestTime(LocalTime eventTime, LinkedList<LocalTime> timeTable) {
        TimeProposalResponse timeProposalResponse = new TimeProposalResponse();

        if (eventTime.isBefore(LocalTime.of(9, 0))
                && timeTable.get(0).isAfter(LocalTime.of(9, 0))) {
            timeProposalResponse.setProposedTime("09:00");
            return timeProposalResponse;
        }

        for (int i = 0; i < timeTable.size(); i += 2) {
            if (i < timeTable.size() - 2) {
                if (eventTime.isBefore(timeTable.get(i + 1))
                        && eventTime.isBefore(timeTable.get(i + 2))
                        && !timeTable.get(i + 1).equals(timeTable.get(i + 2))) {
                    String time = timeTable.get(i + 1).getHour()
                            + ":" + timeTable.get(i + 1).getMinute();
                    if (time.length() < 5) {
                        time += "0";
                    }
                    timeProposalResponse.setProposedTime(time);
                    return timeProposalResponse;
                }
            } else if (eventTime.isBefore(timeTable.get(i + 1))
                    && timeTable.get(i + 1).isBefore(LocalTime.of(18, 0))) {
                String time = timeTable.get(i + 1).getHour() + ":"
                        + timeTable.get(i + 1).getMinute();
                if (time.length() < 5) {
                    time += "0";
                }
                timeProposalResponse.setProposedTime(time);
                return timeProposalResponse;
            }
        }

        if (timeProposalResponse.getProposedTime() == null
                && timeTable.get(timeTable.size() - 1).isBefore(LocalTime.of(18, 0))) {
            String time = timeTable.get(timeTable.size() - 1).getHour() + ":"
                    + timeTable.get(timeTable.size() - 1).getMinute();
            if (time.length() < 5) {
                time += "0";
            }
            timeProposalResponse.setProposedTime(time);
            return timeProposalResponse;
        }

        return new BusyResponse();
    }
}
