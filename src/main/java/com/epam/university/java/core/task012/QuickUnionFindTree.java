package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ilya on 14.09.17.
 */
public class QuickUnionFindTree<T> {

    private List<Node<T>> nodes;
    private List<Node<T>> roots;

    public QuickUnionFindTree(Collection<T> elements) {
        nodes = elements.stream().map(e -> new Node<T>(e)).collect(Collectors.toList());
        roots = new ArrayList<>();
        nodes.stream().forEach(e -> roots.add(e));
    }

    public void connect(T first, T second) {
        if (isConnected(first, second)) {
            return;
        }

        Node<T> firstRoot = getRoot(first);
        Node<T> secondRoot = getRoot(second);
        if (firstRoot.size() >= secondRoot.size()) {
            firstRoot.addChild(secondRoot);
            secondRoot.setRoot(firstRoot);
            roots.remove(secondRoot);
        } else {
            secondRoot.addChild(firstRoot);
            firstRoot.setRoot(secondRoot);
            roots.remove(firstRoot);
        }
    }

    public boolean isConnected(T first, T second) {
        Node<T> firstRoot = getRoot(first);
        Node<T> secondRoot = getRoot(second);

        if (firstRoot.equals(secondRoot)) {
            return true;
        }

        return false;
    }

    public void remove(T first, T second) {
        if (!isConnected(first, second)) {
            throw new IllegalArgumentException("Connection doesn't exist");
        }
        Node<T> firstNode = getNode(first);
        Node<T> secondNode = getNode(second);
        if (firstNode.hasRoot()&&firstNode.getRoot().equals(secondNode)) {
            firstNode.setRoot(null);
            secondNode.removeChild(firstNode);
            roots.add(firstNode);
        } else if (secondNode.hasRoot()&&secondNode.getRoot().equals(firstNode)) {
            secondNode.setRoot(null);
            firstNode.removeChild(secondNode);
            roots.add(secondNode);
        }

    }

    private Node<T> getNode(T element) {
        Node<T> node = new Node<T>(element);

        final Node<T> finalNode = node;
        node = nodes.stream().filter(n -> n.equals(finalNode)).findFirst().get();
        return node;
    }

    private Node<T> getRoot(T element) {
        return findRoot(getNode(element));
    }

    private Node<T> findRoot(Node<T> element) {
        while (element.hasRoot()) {
            element = element.getRoot();
        }

        return element;
    }

    private static class Node<T> {

        private final T value;
        private Node<T> root;
        private List<Node<T>> childs = new ArrayList<>();
        private int size;

        public Node(T value) {
            this.value = value;
            size++;
        }

        public void addChild(Node<T> child) {
            childs.add(child);
            size++;
        }

        public int size() {
            return size;
        }

        public boolean hasChild() {
            return size != 0;
        }

        public boolean hasRoot() {
            return root != null;
        }

        public void removeChild(Node<T> child) {
            childs.remove(child);
            size -= child.size;
        }

        public Node<T> getRoot() {
            return root;
        }

        public void setRoot(Node<T> root) {
            this.root = root;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node<?> node = (Node<?>) o;

            return value.equals(node.value);
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }
}
