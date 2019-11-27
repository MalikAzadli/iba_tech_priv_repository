package _practice.algorithms.graph;

import java.util.*;

public class App {
    public static void main(String[] args) {
        App app = new App();
        Graph graph = new Graph();
        {
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addVertex("C");
            graph.addVertex("D");
            graph.addVertex("E");
            graph.addVertex("F");
            graph.addVertex("G");
            graph.addVertex("H");

            graph.addEdge("A", "B");
            graph.addEdge("A", "C");
            graph.addEdge("A", "D");
            graph.addEdge("D", "F");
            graph.addEdge("D", "G");
            graph.addEdge("D", "C");
            graph.addEdge("C", "E");
            graph.addEdge("E", "H");
            graph.addEdge("H", "G");
            graph.addEdge("G", "F");
        }
        Set<String> dfs = app.dfs(graph, "A");
        Set<String> bfs = app.bfs(graph, "A");
        List<String> path = app.path(graph, "A", "F");
        System.out.println("DFS:  " + dfs);
        System.out.println("BFS:  " + bfs);
        System.out.println("Path: " + path);
    }

    public Set<String> dfs(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    public Set<String> bfs(Graph graph, String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Graph.Vertex v : graph.getAdjVertices(vertex)) {
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }

    public List<String> path(Graph graph, String src, String des) {
//        return getAnyPath(graph, src, des, new LinkedHashSet<>());
        return getShortestPath(graph, src, des, new LinkedHashSet<>());
    }

    public List<String> getAnyPath(Graph graph, String src, String des, Set<String> visited) {
        if (src.equals(des)) return new ArrayList<>(Arrays.asList(src));
        List<String> path = new ArrayList<>();
        visited.add(src);
        for (Graph.Vertex v : graph.getAdjVertices(src)) {
            if (!visited.contains(v.label)) {
                List<String> returned = getAnyPath(graph, v.label, des, visited);
                if (!returned.isEmpty()) {
                    path.add(src);
                    path.addAll(returned);
                    break;
                }
            }
        }
        return path;
    }

    public List<String> getShortestPath(Graph graph, String src, String des, Set<String> visited) {
        if (src.equals(des)) return new ArrayList<>(Collections.singletonList(src));
        List<List<String>> path = new ArrayList<>();
        visited.add(src);
        for (Graph.Vertex v : graph.getAdjVertices(src)) {
            if (!visited.contains(v.label)) {
                List<String> returned = getShortestPath(graph, v.label, des, visited);
                if (!returned.isEmpty()) {
                    returned.add(0, src);
                    path.add(returned);
                }
            }
        }
        if (path.isEmpty()) return new ArrayList<>();
        return path.stream().min(Comparator.comparingInt(List::size)).get();
    }

}
