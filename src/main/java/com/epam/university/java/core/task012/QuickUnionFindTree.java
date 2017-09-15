package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ilya on 14.09.17.
 */
public class QuickUnionFindTree<T> {
    private Node<T> root;

    private static class Node<T>{
        private Node<T> root;
        private List<Node<T>> childs = new ArrayList<>();
        private int size;

        public void setRoot(Node<T> root) {
            this.root = root;
        }

        public void addChild(Node<T> child){
            childs.add(child);
            size++;
        }

        public void addChilds(Collection<T> elements){
            childs = elements.stream().map(e -> new Node<T>())
            size = elements.size();
        }

        public boolean hasChild(){
            return size != 0;
        }

    }

    public QuickUnionFindTree(Collection<T> elements) {
        this.root = root;
    }
}
