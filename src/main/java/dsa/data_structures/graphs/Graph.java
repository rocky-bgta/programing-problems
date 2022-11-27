package dsa.data_structures.graphs;


import java.util.*;

public class Graph {
    int numberOfNodes = 0;
    Map<Integer, ArrayList<Integer>> adjacentList = new HashMap<>();

    public void addVertex(int node) {
        adjacentList.put(node, new ArrayList<>());
        numberOfNodes++;
    }

    public void addEdge(int node1, int node2) {
        adjacentList.get(node1).add(node2);
        adjacentList.get(node2).add(node1);
    }

    public void showConnections() {
        Object[] keys = adjacentList.keySet().toArray();
        for (Object key : keys) {
            System.out.println(key + " ---> " + adjacentList.get(Integer.parseInt(key.toString())));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
//        graph.addVertex(5);
//        graph.addVertex(54);
//        graph.addVertex(44);
//        graph.addEdge(5,54);
//        graph.addEdge(5,44);

        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(4,2);
        graph.addEdge(4,5);
        graph.addEdge(1,2);
        graph.addEdge(1,0);
        graph.addEdge(0,2);
        graph.addEdge(6,5);

        graph.showConnections();
    }
}


