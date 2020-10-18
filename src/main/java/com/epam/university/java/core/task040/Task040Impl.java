package com.epam.university.java.core.task040;

import java.util.Arrays;

// TODO: Make the code easier for reading and understanding.
//       Probably, rewrite it at all.

public class Task040Impl implements Task040 {
    private int result;

    @Override
    public int countScore(String str) {
        if (str == null || str.length() < 20) {
            throw new IllegalArgumentException();
        }

        String[] tempFrames = str.trim().split("\\s");
        String[] frames = Arrays.copyOf(tempFrames, 11);
        frames[10] = "00";


        System.out.println(Arrays.toString(frames));

        for (int i = 0; i < frames.length - 2; i++) {
            System.out.println("The iteration" + i + ". " + "The frame is: " + frames[i]);
            char[] shotsOnTheFrame = frames[i].toCharArray();
            if (frames[i].contains("X")) {
                result += countScoreAfterStrike(frames[i + 1], frames[i + 2]);
                System.out.println("Current result after Strike is: " + result);
            } else if (shotsOnTheFrame.length == 2
                    && shotsOnTheFrame[1] == '/') {
                result += countScoreAfterSpare(frames[i + 1]);
                System.out.println("Current result after Spare is: " + result);
            } else {
                int firstShot = Integer.parseInt(String.valueOf(shotsOnTheFrame[0]));
                int secondShot = Integer.parseInt(String.valueOf(shotsOnTheFrame[1]));
                result += firstShot + secondShot;
                System.out.println("Current result after usual shots is: " + result);
            }
        }
        System.out.println("The iteration 9. " + "The frame is: " + frames[9]);
        result += countFinalFrame(frames[9]);
        System.out.println("Current result after usual shots is: " + result);
        return result;
    }

    /**
     * Counting score after spare.
     * @param frame is the frame (2 shots) after the spare.
     * @return score which should be put in the spare frame.
     */
    public int countScoreAfterSpare(String frame) {
        if (frame.contains("X")) {
            return (10 + 10);
        }
        char[] shots = frame.toCharArray();
        int firstShot = Integer.parseInt(String.valueOf(shots[0]));

        return (firstShot + 10);
    }

    /**
     * Counting score after strike.
     * @param firstFrame is the frame (2 shots) next after strike.
     * @param secondFrame is the frame (2 shots) next after the @param firstFrame.
     * @return score which should be put in the strike frame.
     */
    public int countScoreAfterStrike(String firstFrame, String secondFrame) {
        char[] firstFrameShots = firstFrame.toCharArray();
        char[] secondFrameShots = secondFrame.toCharArray();

        if (firstFrameShots.length == 2
                && firstFrameShots[1] == '/') {
            return 20;
        }

        if (firstFrame.contains("X")) {
            if (secondFrame.contains("X")) {
                return 30;
            }
            if (firstFrameShots.length > 1 && firstFrameShots[1] == 'X') {
                return 30;
            }
            int i = Integer.parseInt(String.valueOf(secondFrameShots[0]));
            return (10 + 10 + i);
        }

        int firstShot = Integer.parseInt(String.valueOf(firstFrameShots[0]));
        int secondShot = Integer.parseInt(String.valueOf(firstFrameShots[1]));

        return (firstShot + secondShot + 10);
    }

    /**
     * Counting the last frame score.
     * @param frame is the last frame in the game.
     * @return score which should be put in the last frame in the game.
     */
    public int countFinalFrame(String frame) {
        char[] shots = frame.toCharArray();
        if (frame.length() == 2) {
            int firstShot = Integer.parseInt(String.valueOf(shots[0]));
            int secondShot = Integer.parseInt(String.valueOf(shots[1]));
            return (firstShot + secondShot);
        }

        if (frame.length() == 3) {
            if (shots[1] == '/') {
                return countScoreAfterSpare(String.valueOf(shots[2]));
            }
            return countScoreAfterStrike(String.valueOf(shots[1]) + String.valueOf(shots[2]),
                        String.valueOf(shots[2] + "0"));
        }
        return 0;
    }
}
