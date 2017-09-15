package com.epam.university.java.core.task012;

import java.util.Collection;

/**
 * Created by ilya on 15.09.17.
 */
public class QuickUnionFindTreeFactory {
    public static QuickUnionFindTree<Integer> getTree(Collection<Integer> elements, Collection<Edge<Integer>> connections){
        QuickUnionFindTree<Integer> tree = new QuickUnionFindTree<>(elements);
        connections.stream().forEach(e -> tree.connect(e.getPointOne(), e.getPointTwo()));
        return tree;
    }

}
