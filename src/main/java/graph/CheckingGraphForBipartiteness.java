package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Проверка графа на двудольность
 */
public class CheckingGraphForBipartiteness {
    int V; // Количество вершин
    List<List<Integer>> adj; // Списки смежности

    CheckingGraphForBipartiteness(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new LinkedList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v); // Для неориентированного графа
    }

    // 0 - не посещена, 1 - цвет 1, 2 - цвет 2
    boolean isBipartite(int src, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 1; // Красим стартовую вершину в 1

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (color[v] == 0) { // Если сосед не покрашен
                    color[v] = 3 - color[u]; // Красим в противоположный цвет
                    q.add(v);
                } else if (color[v] == color[u]) { // Если сосед того же цвета
                    return false; // Не двудольный
                }
            }
        }
        return true;
    }

    // Основная функция для проверки двудольности всего графа
    boolean checkBipartite() {
        int[] color = new int[V]; // Инициализация всех цветов как 0

        // Проверка для всех компоненты связности
        for (int i = 0; i < V; i++) {
            if (color[i] == 0) {
                if (!isBipartite(i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckingGraphForBipartiteness g1 = new CheckingGraphForBipartiteness(4);
        g1.addEdge(0, 1);
        g1.addEdge(0, 3);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        System.out.println("Граф 1 двудольный? " + g1.checkBipartite()); // true

        CheckingGraphForBipartiteness g2 = new CheckingGraphForBipartiteness(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 0);
        System.out.println("Граф 2 двудольный? " + g2.checkBipartite()); // false (треугольник)
    }
}
