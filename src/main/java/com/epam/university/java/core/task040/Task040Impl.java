package com.epam.university.java.core.task040;

public class Task040Impl implements Task040 {
    @Override
    public int countScore(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        String[] frames = str.split(" ");

        if (frames.length < 10) {
            throw new IllegalArgumentException();
        }

        int score = 0;
        Roll[] rolls = new Roll[12];

        for (int i = 0; i < 9; i++) {
            rolls[i] = new Roll(frames[i]);
        }
        for (int i = 9; i < rolls.length; i++) {
            rolls[i] = new Roll();
        }
        String lastFrame = frames[frames.length - 1];
        Roll lastRoll;
        if (lastFrame.length() == 2) {
            lastRoll = new Roll(lastFrame);
        } else {
            lastRoll = new Roll(lastFrame, true);
        }
        rolls[9] = lastRoll;

        for (int i = 0; i < rolls.length; i++) {
            if (rolls[i].isLast()) {
                score += rolls[i].getFirst() + rolls[i].getSecond() + rolls[i].getThird();
                break;
            }
            if (rolls[i].isStrike() && rolls[i + 1].isStrike()) {
                int nextNextRoll = 0;
                int currentRoll = rolls[i].getFirst() + rolls[i].getSecond();
                int nextRoll = rolls[i + 1].getFirst() + rolls[i + 1].getSecond();
                if (rolls[i + 2].isStrike) {
                    nextNextRoll = rolls[i + 2].getFirst() + rolls[i + 2].getSecond();
                } else {
                    nextNextRoll = rolls[i + 2].getFirst();
                }

                score += currentRoll + nextRoll + nextNextRoll;
            } else if (rolls[i].isStrike()) {
                int currentRoll = rolls[i].getFirst() + rolls[i].getSecond();
                int nextRoll = rolls[i + 1].getFirst() + rolls[i + 1].getSecond();
                score += currentRoll + nextRoll;
            } else if (rolls[i].isSplit()) {
                int currentRoll = rolls[i].getFirst() + rolls[i].getSecond();
                int nextRoll = rolls[i + 1].getFirst();
                score += currentRoll + nextRoll;
            } else {
                score += rolls[i].getFirst() + rolls[i].getSecond();
            }

        }

        if (score > 300) {
            score = 300;
        }

        return score;
    }

    public static class Roll {
        private int first;
        private int second;
        private int third;
        private boolean isSplit;
        private boolean isStrike;
        private boolean isLast;


        public Roll() {
        }

        /**
         * Roll constructor.
         * @param line frame line
         */
        public Roll(String line) {
            if (!line.contains("X") && !line.contains("/")) {
                this.first = Integer.parseInt(String.valueOf(line.charAt(0)));
                this.second = Integer.parseInt(String.valueOf(line.charAt(1)));
                this.isSplit = false;
                this.isStrike = false;
            } else if (line.contains("/")) {
                this.isStrike = false;
                this.isSplit = true;
                this.first = Integer.parseInt(String.valueOf(line.charAt(0)));
                this.second = 10 - this.first;
            } else {
                this.isStrike = true;
                this.isSplit = false;
                this.first = 10;
                this.second = 0;
            }
            this.isLast = false;
        }

        /**
         * Last roll constructor.
         * @param frame frame of the roll
         * @param isLast is last
         */
        public Roll(String frame, boolean isLast) {
            this.isLast = isLast;

            if (frame.equals("XXX")) {
                this.first = 10;
                this.second = 20;
                this.third = 30;
            } else if (frame.contains("/")) {
                if (frame.charAt(0) == 'X') {
                    this.first = 10;
                    this.second = Integer.parseInt(String.valueOf(frame.charAt(1)));
                    this.third = 10 - this.second;
                }
                if (frame.charAt(1) == '/') {
                    this.first = Integer.parseInt(String.valueOf(frame.charAt(0)));
                    this.second = 10 - this.first;
                    if (Character.isDigit(frame.charAt(2))) {
                        this.third = Integer.parseInt(String.valueOf(frame.charAt(2)));
                    } else {
                        this.third = 10;
                    }
                }
                if (frame.charAt(2) == '/') {
                    this.first = 10;
                    this.second = Integer.parseInt(String.valueOf(frame.charAt(1)));
                    this.third = 10 - this.second;
                }
            } else {
                if (frame.charAt(0) == 'X' && frame.charAt(1) != 'X') {
                    this.first = 10;
                    this.second = Integer.parseInt(String.valueOf(frame.charAt(1)));
                    this.third = Integer.parseInt(String.valueOf(frame.charAt(2)));
                } else if (frame.charAt(0) == 'X' && frame.charAt(1) == 'X') {
                    this.first = 10;
                    this.second = 20;
                    this.third = Integer.parseInt(String.valueOf(frame.charAt(2)));
                }
            }

        }

        public int getThird() {
            return third;
        }

        public void setThird(int third) {
            this.third = third;
        }

        public boolean isLast() {
            return isLast;
        }

        public void setLast(boolean last) {
            isLast = last;
        }

        public boolean isSplit() {
            return isSplit;
        }

        public void setSplit(boolean split) {
            isSplit = split;
        }

        public boolean isStrike() {
            return isStrike;
        }

        public void setStrike(boolean strike) {
            isStrike = strike;
        }


        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }

}
