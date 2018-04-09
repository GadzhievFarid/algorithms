import java.util.Stack;

public class Cycle {
    private boolean[] passed;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private AdjacencyListGraph graph;

    Cycle(AdjacencyListGraph graph) {
        this.graph = graph;
        this.cycle = new Stack<>();
        passed = new boolean[graph.getVertexNumber()];
        edgeTo = new int[graph.getVertexNumber()];
        for (int v = 0; v < graph.getVertexNumber(); v++) {
            if (!passed[v]) {
                dfs(v);
                if (!cycle.empty()) {
                    break;
                }
            }
        }
    }

    private void dfs(int v) {
        passed[v] = true;
        for (int w : graph.getAdjList(v)) {
            if (!passed[w]) {
                edgeTo[w] = v;
                dfs(w);
                if (!cycle.empty()) {
                    cycle.push(v);
                }
            } else if (w != edgeTo[v]) {
                cycle.push(w);
            }
        }
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "cycle=" + cycle +
                '}';
    }
}
