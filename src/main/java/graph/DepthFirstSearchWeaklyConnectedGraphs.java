package graph;

import java.util.*;

/**
 * Поиск в глубину слабосвязных графов(рекурсивно)
 */
public class DepthFirstSearchWeaklyConnectedGraphs {

    // Метод поиска в глубину (рекурсивный вариант)
    private static void dfs(int v, List<List<Integer>> adj, boolean[] visited) {
        System.out.print(v + " ");
        visited[v] = true;
        
        // Проходим по всем соседям текущей вершины
        for (Integer u : adj.get(v)) {
            if (!visited[u]) {
                dfs(u, adj, visited);
            }
        }
    }

    // Функция для запуска поиска в глубину по всем компонентам слабой связности
    public static void findComponents(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        
        // Перебираем все вершины
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) { // Обрабатываем новую компоненту
                dfs(i, adj, visited); // Запускаем DFS от непройденной вершины
                System.out.println(); // Переход на следующую строку для удобства вывода
            }
        }
    }

    public static void main(String[] args) {
        // Количество вершин
        int V = 8;
        
        // Создание списка смежности
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Добавляем ребра (пример ориентированного графа)
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 0);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);
        addEdge(adj, 6, 7);
        
        // Запускаем поиск в глубину по компонентам слабой связности
        findComponents(adj, V);
    }

    // Вспомогательная функция для добавления направленных рёбер
    private static void addEdge(List<List<Integer>> adj, int src, int dest) {
        adj.get(src).add(dest);
    }
}
