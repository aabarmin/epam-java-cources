package com.epam.university.java.core.task029;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Author Dmitry Novikov 20-Sep-20.
 */
class Crossword {
    List<String> myList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    private int height;
    private int width;
    private char[] board;
    private Set<String> words;

    private final Map<Point, Integer> vertical = new HashMap<>();
    private final Map<Point, Integer> horizontal = new HashMap<>();

    public Crossword(Collection<String> rows, Collection<String> words) {
        crossWordResolv(preProcess(rows, words));
    }

    public List<String> getMyList() {
        return myList;
    }

    List<String> preProcess(Collection<String> rows, Collection<String> words) {
        int countRows = rows.size();
        int countLettersInRow = rows.iterator().next().length();
        int countWords = words.size();
        String firstString = countRows + " " + countLettersInRow + " " + countWords;
        List<String> myList = new ArrayList<>();
        myList.add(firstString);
        for (String s : rows
        ) {
            myList.add(s);
        }

        for (String s : words
        ) {
            myList.add(s);
        }
        return myList;
    }

    private void result(char a) {
        char b = a;
        if (b == '#') {
            b = '+';
        }
        if (sb.length() < 10) {
            sb.append(b);
        }
        if (sb.length() == 10) {
            myList.add(sb.toString());
            sb.delete(0, 10);
        }
        return;
    }

    private String indent = "";

    void crossWordResolv(List<String> lines) {
        final int[] sizes = Stream.of(lines.get(0).split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        width = sizes[0];
        height = sizes[1];
        board = String.join("", lines.subList(1, height + 1)).toCharArray();
        words = new HashSet<>(lines.subList(height + 1, lines.size()));
        for (int y = 0, size; y < height; y++) {
            for (int x = 0; x < width - 1; x++) {
                if (isSpace(x, y) && isSpace(x + 1, y)) {
                    for (size = 2; x + size < width && isSpace(x + size, y); size++) {
                    }
                    horizontal.put(new Point(x, y), size);
                    x += size;
                }
            }
        }
        for (int x = 0, size; x < width; x++) {
            for (int y = 0; y < height - 1; y++) {
                if (isSpace(x, y) && isSpace(x, y + 1)) {
                    for (size = 2; y + size < height && isSpace(x, y + size); size++) {
                    }
                    vertical.put(new Point(x, y), size);
                    y += size;
                }
            }
        }

        final boolean solved = solveHorizontal();
        for (int i = 0; i < board.length; i++) {
            if (i % width == 0) {
                System.out.println();
            }
            result(board[i]);
        }
    }

    private char get(int x, int y) {
        return board[y * width + x];
    }

    private void set(int x, int y, char character) {
        board[y * width + x] = character;
    }

    private boolean isSpace(int x, int y) {
        return get(x, y) == '-';
    }

    private boolean solveHorizontal() {
        return solve(horizontal, this::fitHorizontal, "horizontally", this::solveVertical);
    }

    private boolean solveVertical() {
        return solve(vertical, this::fitVertical, "vertically", () -> true);
    }

    private boolean solve(Map<Point, Integer> slot, BiFunction<Point,
            String, Boolean> fill, String dir, Supplier<Boolean> next) {
        if (slot.isEmpty()) {
            return next.get();
        }
        final Point pos = slot.keySet().iterator().next();
        final int size = slot.remove(pos);
        final char[] state = board.clone();
        indent += "  ";
        for (String word : words) {
            if (word.length() != size) {
                continue;
            }
            if (fill.apply(pos, word) && solve(slot, fill, dir, next)) {
                return true;
            }
            System.arraycopy(state, 0, board, 0, board.length);
        }
        indent = indent.substring(0, indent.length() - 2);
        slot.put(pos, size);
        return false;
    }

    private boolean fitHorizontal(Point pos, String word) {
        final int x = pos.x;
        final int y = pos.y;
        for (int i = 0; i < word.length(); i++) {
            if (!isSpace(x + i, y) && get(x + i, y) != word.charAt(i)) {
                return false;
            }
            set(x + i, y, word.charAt(i));
        }
        return true;
    }

    private boolean fitVertical(Point pos, String word) {
        final int x = pos.x;
        final int y = pos.y;
        for (int i = 0; i < word.length(); i++) {
            if (!isSpace(x, y + i) && get(x, y + i) != word.charAt(i)) {
                return false;
            }
            set(x, y + i, word.charAt(i));
        }
        return true;
    }
}
