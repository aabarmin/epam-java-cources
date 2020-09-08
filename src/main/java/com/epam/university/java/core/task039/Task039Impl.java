package com.epam.university.java.core.task039;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Task039Impl implements Task039 {
    private Queue<Node> tmpQueue;
    private Node rootTmp;

    @Override
    public Map<Character, String> getEncoding(Map<Character, Integer> charFrequencies) {
        Queue<Node> queue = new PriorityQueue<>(
                    charFrequencies.size(), new NodeEqualComparator());

        for (Map.Entry<Character, Integer> entry : charFrequencies.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        List<Node> nodes = new LinkedList<>(queue);

        while (queue.size() > 1) {
            Node first = queue.poll();
            Node second = queue.poll();

            Node node = new Node(null, first.getValue() + second.getValue());
            node.setLeft(first);
            node.setRight(second);

            queue.add(node);
            nodes.add(node);
        }

        Node left = queue.poll();
        Node right = queue.poll();

        Node root = null;
        if (left != null && right != null) {
            root = new Node(null, left.getValue() + right.getValue());
            root.setLeft(left);
            root.setRight(right);
        } else if (left == null) {
            root = right;
        } else if (right == null) {
            root = left;
        }

        nodes.add(root);

        Collections.sort(nodes, (o1, o2) -> o2.getValue() - o1.getValue());

        List<Character> characters = new ArrayList<>(charFrequencies.keySet());
        Map<Character, String> result = new HashMap<>();
        for (Character ch : characters) {
            result.putAll(getStringFromTree(characters, root, ""));
        }

        return result;
    }

    /**
     * Overrided method with option to use comparator.
     * @param charFrequencies map of chars and their frequencies.
     * @param comparator comparator.
     * @return map of chars and their codes.
     */
    public Map<Character, String> getEncoding(Map<Character, Integer> charFrequencies,
                                              Comparator<Node> comparator) {
        Queue<Node> queue = new PriorityQueue<>(
                    charFrequencies.size(), comparator);


        tmpQueue = new PriorityQueue<>(charFrequencies.size(), comparator);

        for (Map.Entry<Character, Integer> entry : charFrequencies.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        List<Node> nodes = new LinkedList<>(queue);

        while (fullOfNull(queue)) {
            Node first = queue.poll();
            Node second = queue.poll();

            Node node = new Node(null, first.getValue() + second.getValue());
            node.setLeft(first);
            node.setRight(second);

            queue.add(node);
            nodes.add(node);
        }

        Node left = queue.poll();
        Node right = queue.poll();

        Node root = null;
        if (left != null && right != null) {
            root = new Node(null, left.getValue() + right.getValue());
            root.setLeft(left);
            root.setRight(right);
        } else if (left == null) {
            root = right;
        } else if (right == null) {
            root = left;
        }

        nodes.add(root);
        rootTmp = root;
        tmpQueue.addAll(nodes);

        Collections.sort(nodes, (o1, o2) -> o2.getValue() - o1.getValue());

        List<Character> characters = new ArrayList<>(charFrequencies.keySet());

        Map<Character, String> result = new HashMap<>();
        for (Character ch : characters) {
            result.putAll(getStringFromTree(characters, root, ""));
        }

        return result;
    }

    private Map<Character, String> getStringFromTree(List<Character> characters,
                                                     Node root, String s) {
        StringBuilder code = new StringBuilder(s);
        if (root.getLeft() == null
                && root.getRight() == null
                && characters.contains(root.getValueChar())) {

            Map<Character, String> map = new HashMap<>();
            map.put(root.getValueChar(), code.toString());
            return map;
        }

        Map<Character, String> res = new HashMap<>();
        res.putAll(getStringFromTree(characters, root.getLeft(), s + "0"));
        res.putAll(getStringFromTree(characters, root.getRight(), s + "1"));
        return res;
    }

    @Override
    public String getEncodedString(Map<Character, Integer> charFrequencies, String string) {
        Map<Character, String> stringMap = getEncoding(charFrequencies,
                new NodeNotEqualComparator());
        char[] encoded = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : encoded) {
            sb.append(stringMap.get(Character.valueOf(c)));
        }
        return sb.toString();
    }

    @Override
    public String getDecodedString(Map<Character, Integer> charFrequencies, String encodedString) {
        Map<Character, String> stringMap = getEncoding(charFrequencies,
                new NodeNotEqualComparator());
        String decoded = "";

        Node curr = rootTmp;

        for (int i = 0; i < encodedString.length(); i++) {
            if (encodedString.charAt(i) == '0') {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
            // reached leaf node
            Node left = curr.getLeft();
            Node right = curr.getRight();
            if (left == null && right == null) {
                decoded += curr.getValueChar();
                curr = rootTmp;
            }
        }

        return decoded;
    }

    private boolean fullOfNull(Queue<Node> queue) {
        int counter = 0;
        for (Node node : queue) {
            if (node.getValueChar() == null) {
                counter++;
            }
        }

        if (counter == queue.size()) {
            return false;
        } else {
            return true;
        }
    }
}
