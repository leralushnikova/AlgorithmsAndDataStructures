package graph;

import java.util.*;

/**
 * Алгоритм Краскала. Нахождением минимального остовного дерева графа
 */
public class KruskalAlgorithm {
    // Структура для представления рёбер
    static class Edge implements Comparable<Edge> {
        int src;    // Источник
        int dest;   // Получатель
        int weight; // Вес ребра

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight); // Сортируем по весу
        }
    }

    // Подкласс для Union-Find структуры
    static class Subset {
        int parent;
        int rank;
    }

    // Функция для объединения двух компонент
    void union(Subset subsets[], int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // Нахождение корня компонента
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent); // Патология сжатия пути
        }
        return subsets[i].parent;
    }

    // Основной метод для нахождения минимального остовного дерева
    List<Edge> kruskalMST(List<Edge> edges, int V) {
        Collections.sort(edges); // Сортируем рёбра по весу

        List<Edge> result = new ArrayList<>();
        Subset[] subsets = new Subset[V];

        // Инициализация структур для каждого узла
        for (int v = 0; v < V; ++v) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        // Проходим по каждому ребру
        for (Edge edge : edges) {
            int x = find(subsets, edge.src);
            int y = find(subsets, edge.dest);

            // Если компоненты различны, объединяем их и добавляем ребро
            if (x != y) {
                result.add(edge);
                union(subsets, x, y);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Пример графа с четырьмя вершинами и пятью рёбрами
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 1),
            new Edge(0, 2, 4),
            new Edge(1, 2, 2),
            new Edge(1, 3, 5),
            new Edge(2, 3, 1)
        );

        KruskalAlgorithm ka = new KruskalAlgorithm();
        List<Edge> mst = ka.kruskalMST(edges, 4);

        System.out.println("Минимальное остовное дерево:");
        for (Edge edge : mst) {
            System.out.printf("%d - %d (%d)\\n", edge.src, edge.dest, edge.weight);
        }
    }
}
