package graph;

import java.util.*;

/**
 * Поиск в глубину (нерекурсивная реализация)
 */
public class GraphDFSNonRecursive {
    
    public static void main(String[] args) {
        int verticesCount = 4; // Количество вершин
        
        // Представление графа: каждое число — индекс вершины,
        // а список рядом с ним — её соседи
        List<List<Integer>> adjacencyList = new ArrayList<>();
        
        for (int i = 0; i < verticesCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        // Допустим, наш граф выглядит так:
        // 0 -> 1, 2
        // 1 -> 3
        // 2 -> 3
        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(2);
        adjacencyList.get(1).add(3);
        adjacencyList.get(2).add(3);
        
        System.out.println("Обход в глубину:");
        dfs(adjacencyList, verticesCount, 0); // Обходим граф, начиная с вершины 0
    }

    /**
     * Нерекурсивная реализация поиска в глубину (DFS)
     */
    private static void dfs(List<List<Integer>> graph, int vertexCount, int startVertex) {
        boolean[] visited = new boolean[vertexCount]; // Массив посещённых вершин
        Stack<Integer> stack = new Stack<>(); // Стек для обхода
        
        stack.push(startVertex); // Начальная вершина
        visited[startVertex] = true;
        
        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            
            System.out.print(currentVertex + " "); // Посещённая вершина
            
            // Перебираем соседей текущей вершины
            for (int neighbor : graph.get(currentVertex)) {
                if (!visited[neighbor]) { // Если сосед ещё не посещался
                    visited[neighbor] = true;
                    stack.push(neighbor); // Кладём в стек, чтобы позже обработать
                }
            }
        }
    }
}
