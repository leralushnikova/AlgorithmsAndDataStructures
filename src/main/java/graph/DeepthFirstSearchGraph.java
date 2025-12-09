package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Поиск в глубину (рекурсивная реализация)
 */
public class DeepthFirstSearchGraph {
    private final LinkedList<Integer>[] adjLists;
    private final boolean[] visited;

    // Создание графа
    DeepthFirstSearchGraph(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<>();
    }

    // Добавление ребер
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // Алгоритм
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> ite = adjLists[vertex].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj])
                DFS(adj);
        }
    }

    public static void main(String[] args) {

        DeepthFirstSearchGraph graph = new DeepthFirstSearchGraph(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 8);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(7, 9);

        System.out.println("Following is Depth First Traversal");

        graph.DFS(0);

    }
}
