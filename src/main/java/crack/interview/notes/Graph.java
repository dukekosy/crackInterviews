package crack.interview.notes;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Graph {

    private class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(label, vertex.label);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label);
        }
        // equals hashcode
    }

    private Map<Vertex, List<Vertex>> map;

    public void addVertex(String label) {
        Vertex v = new Vertex(label);
        if (!map.containsKey(v)) {
            map.put(v, new LinkedList<Vertex>());
        }
    }

    public void removeVertex(String label) {
        Vertex v = new Vertex(label);
        map.values().stream().filter(x -> x.equals(v)).map(x -> x.remove(v));
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        map.get(v1).add(v2);
        map.get(v2).add(v1);
    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        if (map.containsKey(v1)) {
            map.get(v1).remove(v2);
        }
        if (map.containsKey(v2)) {
            map.get(v2).remove(v1);
        }
    }

    Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        return graph;
    }
}
