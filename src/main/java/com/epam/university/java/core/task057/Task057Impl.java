package com.epam.university.java.core.task057;

public class Task057Impl implements Task057 {
    @Override
    public Window getWindowForDelivery(int level, int entrances, int numberOfFlat) {

        if (level == 0|| entrances == 0 || numberOfFlat == 0){
            throw new IllegalArgumentException();
        }

        House house = new House(level, entrances);
        house.fillInEntrances();
        if (numberOfFlat > house.amountOfFlats){
            throw new IllegalArgumentException();
        }

        int numberOfEntrance = house.findEntranceByFlat(numberOfFlat);
        Entrance entranceOfTheFlat = house.entrances[numberOfEntrance - 1];

        int floorOfTheFlat = house.getFloorInEntrance(numberOfFlat, entranceOfTheFlat);
        SideType side;
        if (floorOfTheFlat % 2 == 0) {
            side = SideType.FRONT_SIDE;
        } else {
            side = SideType.BACK_SIDE;
        }

        int levelOfWindow = floorOfTheFlat / 2 + 1;
        int numberOfWindow;
        if (side.equals(SideType.FRONT_SIDE)) {
            numberOfWindow = getNumberOfWindowFrontSide(floorOfTheFlat, entranceOfTheFlat, numberOfEntrance, numberOfFlat);
        } else {
            numberOfWindow = getNumberOfWindowBackSide(floorOfTheFlat, entranceOfTheFlat, numberOfEntrance, numberOfFlat, entrances);
        }
        return new WindowImpl(levelOfWindow, numberOfWindow, side);

    }

    private int getNumberOfWindowBackSide(int floorOfTheFlat, Entrance entranceOfTheFlat, int numberOfEntrance, int numberOfFlat, int totalEntrances) {
        int[][] flatsOfTheEntrance = entranceOfTheFlat.flats;
        int numberOfWindow;
        int numberOfFlatInSection = 0;
        int amountOfPreviousEntranceWindows = 0;

        amountOfPreviousEntranceWindows = (totalEntrances - numberOfEntrance) * 8;
        for (int i = 3; i >= 0; i--) {
            if (flatsOfTheEntrance[floorOfTheFlat][i] == numberOfFlat) {
                numberOfFlatInSection = 4 - i;
            }
        }
        numberOfFlatInSection *= 2;

        numberOfWindow = numberOfFlatInSection + amountOfPreviousEntranceWindows;

        return numberOfWindow;

    }

    private int getNumberOfWindowFrontSide(int floorOfTheFlat, Entrance entranceOfTheFlat, int numberOfEntrance, int numberOfFlat) {
        int[][] flatsOfTheEntrance = entranceOfTheFlat.flats;
        int numberOfWindow;
        int numberOfFlatInSection = 0;
        int amountOfPreviousEntranceWindows = 0;

        amountOfPreviousEntranceWindows = (numberOfEntrance - 1) * 8;
        for (int i = 0; i < 4; i++) {
            if (flatsOfTheEntrance[floorOfTheFlat][i] == numberOfFlat) {
                numberOfFlatInSection = i + 1;
            }
        }
        numberOfFlatInSection *= 2;
        numberOfWindow = numberOfFlatInSection + amountOfPreviousEntranceWindows;
        return numberOfWindow;
    }


    private class House {
        private final Entrance[] entrances;
        private final int amountOfEntrances;
        private final int amountOfLevels;
        private final int amountOfFlats;


        public House(int levels, int entrances) {
            this.entrances = new Entrance[entrances];
            this.amountOfFlats = levels * entrances * 8;
            this.amountOfEntrances = entrances;
            this.amountOfLevels = levels;
        }

        public void fillInEntrances() {
            int startNumber = 0;
            for (int i = 0; i < this.entrances.length; i++) {
                this.entrances[i] = new Entrance(amountOfLevels * 2);
            }
            for (Entrance entrance : entrances) {
                entrance.fillInFlats(startNumber);
                startNumber += amountOfLevels * 8;
            }
        }


        public int findEntranceByFlat(int numberOfFlat) {
            int numberOfEntrance = 0;
            for (Entrance value : entrances) {
                numberOfEntrance++;
                int[][] flats = value.flats;
                int min = flats[0][2];
                int max = flats.length * 4 + min;

                if (numberOfFlat >= min
                        && numberOfFlat < max) {
                    break;
                }

            }
            return numberOfEntrance;
        }

        public int getFloorInEntrance(int numberOfFlat, Entrance entranceOfTheFlat) {
            int[][] flats = entranceOfTheFlat.flats;

            for (int i = 0; i < flats.length; i++) {
                for (int j = 0; j < 4; j++) {
                    if (flats[i][j] == numberOfFlat) {
                        return i;
                    }
                }
            }

            return 0;
        }
    }

    private class Entrance {
        private int[][] flats;

        public Entrance(int floors) {
            flats = new int[floors][4];
        }

        private void fillInFlats(int startNumber) {
            for (int i = 0; i < flats.length; i++) {
                if (i % 2 == 0) {
                    flats[i][0] = 7 + 8 * i / 2 + startNumber;
                    flats[i][1] = 8 + 8 * i / 2 + startNumber;
                    flats[i][2] = 1 + 8 * i / 2 + startNumber;
                    flats[i][3] = 2 + 8 * i / 2 + startNumber;
                } else {
                    flats[i][0] = 6 + 8 * (i - 1) / 2 + startNumber;
                    flats[i][1] = 5 + 8 * (i - 1) / 2 + startNumber;
                    flats[i][2] = 4 + 8 * (i - 1) / 2 + startNumber;
                    flats[i][3] = 3 + 8 * (i - 1) / 2 + startNumber;
                }

//                if (i % 2 == 0) {
//                    for (int j = 0; j < 4; j++) {
//                        flats[i][j] = startNumber;
//                        startNumber++;
//                    }
//                } else {
//                    for (int j = 3; j >= 0; j--) {
//                        flats[i][j] = startNumber;
//                        startNumber++;
//                    }
//            }
            }
        }
    }
}
