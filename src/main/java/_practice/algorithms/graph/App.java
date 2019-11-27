package _practice.algorithms.graph;


import java.util.*;

public class App {
    public static void main(String[] args) {
        App app = new App();
        Graph graph = new Graph();
        {
            graph.addVertex("Bob");
            graph.addVertex("Alice");
            graph.addVertex("Mark");
            graph.addVertex("Rob");
            graph.addVertex("Maria");
            graph.addVertex("Jane");

            graph.addEdge("Jane", "Bob");
            graph.addEdge("Bob", "Rob");
            graph.addEdge("Rob", "Mark");
            graph.addEdge("Rob", "Maria");
            graph.addEdge("Mark", "Maria");
            graph.addEdge("Alice", "Maria");
        }
        Set<String> dfs = app.dfs(graph, "Mark");
        Set<String> bfs = app.bfs(graph, "Mark");
        List<String> path = app.path(graph, "Jane", "Mark");
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
        return getPath(graph, src, des, new LinkedHashSet<>());
    }

    public List<String> getPath(Graph graph, String src, String des, Set<String> visited) {
        if(src.equals(des)) return new ArrayList<>(Arrays.asList(src));
        List<String> path = new ArrayList<>();
        visited.add(src);
        for (Graph.Vertex v : graph.getAdjVertices(src)) {
            if (!visited.contains(v.label)) {
                List<String> returned = getPath(graph, v.label, des, visited);
                if (!returned.isEmpty()) {
                    path.add(src);
                    path.addAll(returned);
                    break;
                }
            }
        }
        return path;
    }
}
