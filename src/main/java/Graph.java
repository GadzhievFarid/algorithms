public interface Graph {
    int getVertexNumber();

    void addEdge(int v, int w);

    void removeEdge(int v, int w);

    void addVertex();

    void removeVertex(int v);
}
