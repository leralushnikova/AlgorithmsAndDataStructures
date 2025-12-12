package graph;

import java.util.*;

/**
 * Алгоритм Прима. Нахождением минимального остовного дерева графа
 */
public class PrimAlgorithm {
    // Класс Edge для хранения рёбер графа
    static class Edge implements Comparable<Edge> {
        int toVertex;   // Конечная вершина
        int weight;     // Вес ребра

        public Edge(int toVertex, int weight) {
            this.toVertex = toVertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    // Основная функция, реализующая алгоритм Прима
    public List<int[]> findMinSpanningTree(List<List<Edge>> adjList) {
        int n = adjList.size();              // Количество вершин
        boolean[] visited = new boolean[n];  // Массив посещенных вершин
        PriorityQueue<Edge> pq = new PriorityQueue<>();  // Очередь с приоритетами
        List<int[]> mstEdges = new ArrayList<>();       // Итоговые рёбра остова

        // Начинаем с первой вершины
        visited[0] = true;
        addAllEdges(adjList.get(0), pq);      // Добавляем начальные рёбра

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            // Проверяем, была ли эта вершина ранее посещена
            if (visited[edge.toVertex]) continue;

            // Добавляем новое ребро в остов
            mstEdges.add(new int[]{edge.toVertex, edge.weight});
            visited[edge.toVertex] = true;

            // Добавляем новые рёбра в очередь
            addAllEdges(adjList.get(edge.toVertex), pq);
        }

        return mstEdges;
    }

    private void addAllEdges(List<Edge> edges, PriorityQueue<Edge> pq) {
        for (Edge e : edges) {
            pq.offer(e);
        }
    }

    public static void main(String[] args) {
        // Пример графа представлен списком смежности
        List<List<Edge>> adjList = new ArrayList<>();
        int verticesCount = 4;

        for (int i = 0; i < verticesCount; ++i) {
            adjList.add(new ArrayList<>());
        }

        // Добавление рёбер вручную
        adjList.get(0).add(new Edge(1, 1));
        adjList.get(0).add(new Edge(2, 4));
        adjList.get(1).add(new Edge(0, 1));
        adjList.get(1).add(new Edge(2, 2));
        adjList.get(1).add(new Edge(3, 5));
        adjList.get(2).add(new Edge(0, 4));
        adjList.get(2).add(new Edge(1, 2));
        adjList.get(2).add(new Edge(3, 1));
        adjList.get(3).add(new Edge(1, 5));
        adjList.get(3).add(new Edge(2, 1));

        PrimAlgorithm pa = new PrimAlgorithm();
        List<int[]> result = pa.findMinSpanningTree(adjList);

        System.out.println("Минимальное остовное дерево:");
        for (int[] edge : result) {
            System.out.printf("Вершина %d с весом %d\\n", edge[0], edge[1]);
        }
    }
}
