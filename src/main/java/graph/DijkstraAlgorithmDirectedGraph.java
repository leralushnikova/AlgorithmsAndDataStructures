package graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Алгоритм Дейкстры в ориентированном графе, если ребра нет то он отмечается -1. Нахождение кратчайшего расстояния
 */
public class DijkstraAlgorithmDirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();          // Количество вершин
        int start = sc.nextInt() - 1;  // Индекс начальной вершины (нумерация с 0)
        int finish = sc.nextInt() - 1; // Индекс конечной вершины (нумерация с 0)

        // Создаем массив для хранения матриц смежности
        int[][] matrix = new int[V][V];

        // Заполняем матрицу смежности
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE; // Специальное значение для несуществующих рёбер
                }
            }
        }

        // Выполнение алгоритма Дейкстры
        int[] shortestPaths = dijkstra(matrix, start, V);

        // Получаем расстояние до конечной точки
        int pathLength = shortestPaths[finish];

        // Проверяем наличие пути
        if (pathLength == Integer.MAX_VALUE) {
            System.out.println("-1"); // Пути нет
        } else {
            System.out.println(pathLength); // Расстояне до финальной вершины
        }
    }

    // Реализация алгоритма Дейкстры
    private static int[] dijkstra(int[][] matrix, int start, int V) {
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0; // Начало пути имеет длину 0

        boolean[] visited = new boolean[V];

        // Основной цикл
        for (int count = 0; count < V - 1; count++) {
            // Находим ближайшую необработанную вершину
            int u = minDistance(distances, visited);
            if (u == -1) {
                continue; // Пропускаем, если нет подходящего кандидата
            }
            visited[u] = true;

            // Рассчитываем новые минимальные расстояния
            for (int v = 0; v < V; v++) {
                if (!visited[v]
                        && matrix[u][v] != Integer.MAX_VALUE
                        && distances[u] != Integer.MAX_VALUE
                        && distances[u] + matrix[u][v] < distances[v]) {
                    distances[v] = distances[u] + matrix[u][v];
                }
            }
        }
        return distances;
    }

    // Вспомогательная функция для выбора ближайшей вершины
    private static int minDistance(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] <= min) {
                min = distances[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
