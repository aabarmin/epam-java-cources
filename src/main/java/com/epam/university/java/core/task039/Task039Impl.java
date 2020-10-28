package com.epam.university.java.core.task039;


import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;

public class Task039Impl implements Task039 {

    @Override
    public Map<Character, String> getEncoding(Map<Character, Integer> charFrequencies) {
        TreeMap<Character, Integer> chars = new TreeMap<>(charFrequencies);

        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();

        for (Character c : chars.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, chars.get(c)));
        }

        CodeTreeNode tree = huffman(codeTreeNodes);

        HashMap<Character, String> codes = new HashMap<>();

        for (Character c : chars.keySet()) {
            codes.put(c, tree.getCodeForCharacter(c, ""));
        }


        return codes;
    }

    @Override
    public String getEncodedString(Map<Character, Integer> charFrequencies, String string) {
        StringBuilder encodedString = new StringBuilder();

        TreeMap<Character, String> codes = new TreeMap<>(getEncoding(charFrequencies));

        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            encodedString.append(codes.get(c));
        }

        return encodedString.toString();
    }

    @Override
    public String getDecodedString(Map<Character, Integer> charFrequencies, String encodedString) {
        StringBuilder decodedString = new StringBuilder();

        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : charFrequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, charFrequencies.get(c)));
        }
        CodeTreeNode tree = huffman(codeTreeNodes);
        CodeTreeNode codeTreeNode = tree;

        for (int i = 0; i < encodedString.length(); i++) {
            if (encodedString.charAt(i) == '0') {
                codeTreeNode = codeTreeNode.getLeft();
            } else {
                codeTreeNode = codeTreeNode.getRight();
            }

            if (codeTreeNode.getContent() != null) {
                decodedString.append(codeTreeNode.getContent());
                codeTreeNode = tree;
            }
        }

        return decodedString.toString();
    }

    private static CodeTreeNode huffman(ArrayList<CodeTreeNode> codeTreeNodes) {
        Collections.sort(codeTreeNodes);

        while (codeTreeNodes.size() > 1) {
            Collections.sort(codeTreeNodes);

            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            CodeTreeNode parent = new CodeTreeNode(null, left.getWeight() + right.getWeight(), left, right);

            codeTreeNodes.add(parent);
        }
        return codeTreeNodes.get(0);
    }
}
