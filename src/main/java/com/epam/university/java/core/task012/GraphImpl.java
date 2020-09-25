package com.epam.university.java.core.task012;

import javax.imageio.metadata.IIOMetadataNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class GraphImpl implements Graph {

    private HashMap<Integer, ArrayList<Integer>> map;
    private int size;

    public GraphImpl(int id) {
        map = new HashMap<>();
        for (int i = 0; i <= id; i++) {
            map.put(i, new ArrayList<>());
        }
        size = id;
    }

    @Override
    public void createEdge(int from, int to) {

        try {
            ArrayList<Integer> tmp = map.get(from);
            tmp.add(to);
            map.put(from, tmp);

            tmp = map.get(to);
            tmp.add(from);
            map.put(to, tmp);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean edgeExists(int from, int to) {
        return map.get(from).contains(to) || map.get(to).contains(from);
    }

    @Override
    public void removeEdge(int from, int to) {
        try {
            ArrayList<Integer> tmp = map.get(from);
            int index = tmp.indexOf(to);
            if (edgeExists(from, to)) {
                tmp.remove(index);
                map.put(from, tmp);
                tmp = map.get(to);
                index = tmp.indexOf(from);
                tmp.remove(index);
                map.put(to, tmp);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException | IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        return map.get(from);
    }
}
