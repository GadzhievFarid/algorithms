public class AdjacencyMatrixGraph implements Graph {
    private int vertexNumber;
    private boolean[][] adjMatrix;

    AdjacencyMatrixGraph(int vertexNumber) {
        this.vertexNumber = vertexNumber;
        adjMatrix = new boolean[vertexNumber][vertexNumber];
    }

    public static void main(String[] args) {
        Graph graph = new AdjacencyMatrixGraph(3);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addVertex();
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        System.out.println(graph);

        graph.removeVertex(1);
        System.out.println(graph);
    }

    @Override
    public void addEdge(int v, int w) {
        if (v > vertexNumber || w > vertexNumber) {
            throw new UnsupportedOperationException();
        }
        adjMatrix[v][w] = true;
        adjMatrix[w][v] = true;
    }

    @Override
    public void removeEdge(int v, int w) {
        if (v > vertexNumber || w > vertexNumber) {
            throw new UnsupportedOperationException();
        }
        adjMatrix[v][w] = false;
        adjMatrix[w][v] = false;
    }

    @Override
    public void addVertex() {
        boolean[][] newAdjMatrix = new boolean[vertexNumber + 1][vertexNumber + 1];
        for (int i = 0; i < adjMatrix.length; i++) {
            System.arraycopy(adjMatrix[i], 0, newAdjMatrix[i], 0, adjMatrix.length);
        }
        vertexNumber++;
        adjMatrix = newAdjMatrix;
    }

    @Override
    public void removeVertex(int v) {
        boolean[][] newAdjMatrix = new boolean[vertexNumber - 1][vertexNumber - 1];
        int row = 0;
        for (int i = 0; i < vertexNumber; i++) {
            if (i == v) {
                continue;
            }
            int column = 0;
            for (int j = 0; j < vertexNumber; j++) {
                if (j == v) {
                    continue;
                }
                newAdjMatrix[row][column] = adjMatrix[i][j];
                column++;
            }
            row++;
        }
        vertexNumber--;
        adjMatrix = newAdjMatrix;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < vertexNumber; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                stringBuilder.append(adjMatrix[i][j] ? 1 : 0).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
