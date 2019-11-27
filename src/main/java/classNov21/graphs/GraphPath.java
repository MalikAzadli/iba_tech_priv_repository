package classNov21.graphs;

import java.util.*;

public class GraphPath {
    private final XGraph g;

    public GraphPath(XGraph g) {
        this.g = g;
    }

    List<Integer> path(int from, int to, Set<Integer> visited) {
        if (from == to) return new ArrayList<>(Arrays.asList(from));
        ArrayList<Integer> path = new ArrayList<>();
        visited.add(from);

        for (Integer i : g.get(from)) {
            if (!visited.contains(i)) {
                List<Integer> returned = path(i, to, visited);
                if (!returned.isEmpty()) {
                    path.add(from);
                    path.addAll(returned);
                    break;
                }
            }
        }
        return path;
    }

    List<Integer> path(int from, int to) {
        return path(from, to, new LinkedHashSet<>());
    }
}
