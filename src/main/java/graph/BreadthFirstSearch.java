package graph;

import java.util.*;

/**
 * Поиск в ширину
 */
public class BreadthFirstSearch {
    private final int V; // Количество вершин
    private final LinkedList<Integer>[] adj; // Список смежности

    // Конструктор графа
    BreadthFirstSearch(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Добавление ребра в граф
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Функция для BFS-обхода
    void BFS(int s) {
        boolean[] visited = new boolean[V]; // Массив помеченных вершин
        Arrays.fill(visited, false); // Изначально все вершины непосещённые

        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true; // Отмечаем стартовую вершину как посещённую
        queue.add(s);      // Кладём её в очередь

        while (!queue.isEmpty()) {   // Пока очередь не пуста
            s = queue.poll();       // Извлекаем первый элемент очереди

            System.out.print(s + " "); // Обрабатываем извлечённый узел

            Iterator<Integer> i = adj[s].listIterator(); // Получаем соседей вершины
            while(i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {     // Если сосед ещё не посещён
                    visited[n] = true; // Отмечаем его как посещённого
                    queue.add(n);     // Кладём в очередь
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch g = new BreadthFirstSearch(4); // Создаем граф с четырьмя вершинами

        g.addEdge(0, 1); // добавляем рёбра
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Обход в ширину начиная с вершины 2:");
        g.BFS(2); // Запускаем алгоритм BFS
    }
}
