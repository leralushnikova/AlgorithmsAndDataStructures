package graph;

import java.util.Arrays;

/**
 * Алгоритм Дейкстры в ненаправленном графе. Нахождение кратчайшего расстояния
 */
public class DijkstraAlgorithmUndirectedGraph {
    public static void main(String[] args) {
        int numOfVertices = 6;
        int[][] adjMat = new int[6][6];
        Graph graph = new Graph(adjMat, numOfVertices);

        // добавляем ребра в граф
        graph.addEdge(0, 4, 21);
        graph.addEdge(0, 3, 18);
        graph.addEdge(2, 1, 7);
        graph.addEdge(1, 4, 6);
        graph.addEdge(4, 5, 10);
        graph.addEdge(4, 3, 11);
        graph.addEdge(5, 3, 7);

        // вызываем алгоритм Дейкстры, чтобы найти кратчайшее расстояние
        int[] dist = dijkstrasShortestPath(graph, 0);
        System.out.print(Arrays.toString(dist));
    }

    public static int getClosestVertex(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < min)
                if (!visited[i]) {
                    min = distance[i];
                    minIdx = i;
                }
        }
        return minIdx;
    }

    public static int[] dijkstrasShortestPath(Graph g, int src) {
        // финальный массив с кратчайшими расстояниями
        int[] distance = new int[g.numOfvertices];
        // массив, показывающий, найдено ли кратчайшее расстояние для вершины
        boolean[] visited = new boolean[g.numOfvertices];

        // инициализация массивов
        for (int i = 0; i < g.numOfvertices; i++) {
            distance[i] = Integer.MAX_VALUE; // начальное расстояние - бесконечность
            visited[i] = false; // кратчайшее расстояние для любой вершины еще не найдено
        }
        distance[src] = 0;

        for (int i = 0; i < g.numOfvertices; i++) {
            int closestVertex = getClosestVertex(distance, visited); // получаем ближайшую вершину
            if (closestVertex == Integer.MAX_VALUE) // если ближайшая вершина находится на бесконечном расстоянии, это означает, что никакая другая вершина не может быть достигнута. Поэтому возвращаем
                return distance;

            visited[closestVertex] = true;
            for (int j = 0; j < g.numOfvertices; j++) {
                if (!visited[j]) // кратчайшее расстояние для вершины j не должно быть окончательно определено
                {
                    if (g.adjMatrix[closestVertex][j] != 0) {
                        int d = distance[closestVertex] + g.adjMatrix[closestVertex][j];
                        if (d < distance[j]) // расстояние через closestVertex меньше начального расстояния
                            distance[j] = d;
                    }
                }
            }
        }
        return distance;
    }

    static class Graph {
        int[][] adjMatrix; // матрица смежности для представления ребер
        int numOfvertices;

        Graph(int[][] mat, int v) {
            this.adjMatrix = mat;
            this.numOfvertices = v;
        }

        void addEdge(int src, int dest, int edgeWeight) {
            adjMatrix[src][dest] = edgeWeight;
            adjMatrix[dest][src] = edgeWeight;
        }
    }
}
