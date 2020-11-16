package com.epam.university.java.core.task057;

public class Task057Impl implements Task057 {
    @Override
    public Window getWindowForDelivery(int level, int entrances, int numberOfFlat) {

        House house = new House(level, entrances);
        house.fillInEntrances();

        return null;
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
            int startNumber = 1;
            for (int i = 0; i < this.entrances.length; i++) {
                this.entrances[i] = new Entrance(amountOfLevels * 2);
            }
            for (Entrance entrance : entrances) {
                entrance.fillInFlats(startNumber);
                startNumber += amountOfLevels * 8;
            }
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
                    for (int j = 0; j < 4; j++) {
                        flats[i][j] = startNumber;
                        startNumber++;
                    }
                } else {
                    for (int j = 3; j >= 0; j--) {
                        flats[i][j] = startNumber;
                        startNumber++;
                    }
                }
            }
        }
    }
}
