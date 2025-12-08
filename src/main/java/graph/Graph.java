package graph;

import java.util.*;

/**
 * Список смежности
 */
public class Graph {
    private final Map<String, List<String>> graph = new HashMap<>();

    public void addVertex(String vertex) {
        graph.putIfAbsent(vertex, new ArrayList<>());
    }


    public void addEdge(String vertexOne, String vertexTwo) {
        graph.get(vertexOne).add(vertexTwo);
        graph.get(vertexTwo).add(vertexOne);
    }

    public List<String> getDependencies(String vertex) {
        return graph.get(vertex);
    }

    public void search(String startVertex) {
        Set<String> visited = new HashSet<>();
        searchHelper(startVertex, visited);
    }

    private void searchHelper(String vertex, Set<String> visited) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            System.out.println(vertex);
            for (String vertexD : getDependencies(vertex)) {
                searchHelper(vertexD, visited);
            }
        }
    }
}
