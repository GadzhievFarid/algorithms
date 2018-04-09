import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AdjacencyListGraph implements Graph {
    private List<List<Integer>> adjLists;
    private int vertexNumber;
    private int edgeNumber;

    AdjacencyListGraph(int vertexNumber) {
        this.vertexNumber = vertexNumber;
        adjLists = new ArrayList<>(vertexNumber);
        for (int i = 0; i < vertexNumber; i++) {
            adjLists.add(new LinkedList<>());
        }
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public Iterable<Integer> getAdjList(int v) {
        return adjLists.get(v);
    }

    @Override
    public int getVertexNumber() {
        return vertexNumber;
    }

    @Override
    public void addEdge(int v, int w) {
        List<Integer> list = adjLists.get(v);
        if (!list.contains(v)) {
            list.add(w);
        }
        List<Integer> list2 = adjLists.get(w);
        if (!list2.contains(w)) {
            list2.add(v);
        }
        edgeNumber++;
    }

    @Override
    public void removeEdge(int v, int w) {
        adjLists.get(v).removeIf(a -> a == w);
        adjLists.get(w).removeIf(a -> a == v);
        edgeNumber--;
    }

    @Override
    public void addVertex() {
        adjLists.add(new LinkedList<>());
        vertexNumber++;
    }

    @Override
    public void removeVertex(int v) {
        adjLists.remove(v);
        adjLists.forEach(a -> a.removeIf(b -> b == v));
        for (int i = 0; i < adjLists.size(); i++) {
            adjLists.set(i, adjLists.get(i).stream().map(b -> b > v ? --b : b).collect(Collectors.toList()));
        }
        vertexNumber--;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < adjLists.size(); i++) {
            List<Integer> adjList = adjLists.get(i);
            stringBuilder.append(i).append(": ");
            for (Integer integer : adjList) {
                stringBuilder.append(integer).append(" ");
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
