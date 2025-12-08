package graph;

/**
 * Матрица смежности
 */
public class AdjacencyMatrix {
    private int V; // Количество вершин
    private int[][] matrix; // Матрица смежности

    public AdjacencyMatrix(int vertices) {
        this.V = vertices;
        matrix = new int[V][V];
        // Инициализация нулями (по умолчанию для int, но можно явно)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    // Метод добавления ребра (для неориентированного)
    public void addEdge(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1; // Для неориентированного
    }

    // Метод добавления взвешенного ребра
    public void addWeightedEdge(int i, int j, int weight) {
        matrix[i][j] = weight;
        matrix[j][i] = weight; // Для неориентированного
    }

    // Метод вывода матрицы
    public void printMatrix() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(4); // Граф с 4 вершинами
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Матрица смежности:");
        graph.printMatrix();
        // Вывод:
        // 0 1 1 0
        // 1 0 1 0
        // 1 1 0 1
        // 0 0 1 0
    }
}
