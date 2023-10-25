package crack.interview.notes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphMap<T> {

    private Map<T, List<T>> map = new HashMap<>();

    public void addVertex(T s) {
        map.put(s, new LinkedList<>());
    }

    //this is wrong
    public void addEdge(T source, T destination, boolean bidirectional) {

        if(!map.containsKey(source)) {
            addVertex(source);
        }
        if(!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(destination);
        if(bidirectional) {
            map.get(destination).add(source);
        }
    }

    public int getVertexCount() {
        return map.keySet().size();
    }

    public int getEdgesCount(boolean bidirectional) {
        int count = 0;
        for (T v: map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirectional) {
            count = count / 2;
        }
        return count;
    }

    public boolean hasVertex(T s) {
        return map.containsKey(s);
    }

    public boolean hasEdge(T s, T d) {
        return map.get(s).contains(d);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T s: map.keySet()) {
            sb.append(s.toString() + " : ");
            for (T t: map.get(s)) {
                sb.append(t.toString() + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
