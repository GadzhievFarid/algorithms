public class Client {
    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph(3);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        System.out.println(graph);

        Cycle cycle = new Cycle(graph);
        System.out.println(cycle);
    }
}
