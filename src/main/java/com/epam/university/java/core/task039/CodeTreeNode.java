package com.epam.university.java.core.task039;

/**
 * Huffman tree node.
 */

public class CodeTreeNode implements Comparable<CodeTreeNode> {

    private Character content;
    private int weight;
    private CodeTreeNode left;
    private CodeTreeNode right;


    public CodeTreeNode(Character content, int weight) {
        this.content = content;
        this.weight = weight;
    }

    /**
     * Code tree node constructor.
     *
     * @param content content of a node
     * @param weight weight of a node
     * @param left left child
     * @param right right child
     */
    public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
        this.content = content;
        this.weight = weight;
        this.left = left;
        this.right = right;
    }

    public Character getContent() {
        return content;
    }

    public void setContent(Character content) {
        this.content = content;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CodeTreeNode getLeft() {
        return left;
    }

    public void setLeft(CodeTreeNode left) {
        this.left = left;
    }

    public CodeTreeNode getRight() {
        return right;
    }

    public void setRight(CodeTreeNode right) {
        this.right = right;
    }

    /**
     * Returns binary string for character.
     *
     * @param ch character
     * @param codePath binaryPath
     * @return string with full binary path if exists else null
     */
    public String getCodeForCharacter(Character ch, String codePath) {
        if (this.getContent() == ch) {
            return codePath;
        } else {
            if (left != null) {
                String path = left.getCodeForCharacter(ch, codePath + "0");
                if (path != null) {
                    return path;
                }
            }
            if (right != null) {
                String path = right.getCodeForCharacter(ch, codePath + "1");
                if (path != null) {
                    return path;
                }
            }
        }
        return null;
    }

    @Override
    public int compareTo(CodeTreeNode o) {
        return o.getWeight() - this.getWeight();
    }
}
