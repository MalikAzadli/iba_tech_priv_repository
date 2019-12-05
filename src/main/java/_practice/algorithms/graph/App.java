package _practice.algorithms.graph;

import java.util.*;

public class App {
    public static void main(String[] args) {
        App app = new App();
        Graph graph = GraphOp.create(30,30);

//        Graph graph = new Graph();
//        Vertex a = new Vertex("A");
//        Vertex b = new Vertex("B");
//        Vertex c = new Vertex("C");
//        Vertex d = new Vertex("D");
//        Vertex e = new Vertex("E");
//        Vertex f = new Vertex("F");
//        Vertex g = new Vertex("G");
//        Vertex h = new Vertex("H");
//        Vertex i = new Vertex("I");
//        graph.addVertex(a);
//        graph.addVertex(b);
//        graph.addVertex(c);
//        graph.addVertex(d);
//        graph.addVertex(e);
//        graph.addVertex(f);
//        graph.addVertex(g);
//        graph.addVertex(h);
//        graph.addVertex(i);

//        Random
//        graph.addEdge(a, b);
//        graph.addEdge(a, c);
//        graph.addEdge(a, d);
//        graph.addEdge(d, f);
//        graph.addEdge(d, g);
//        graph.addEdge(d, c);
//        graph.addEdge(c, e);
//        graph.addEdge(e, h);
//        graph.addEdge(h, g);
//        graph.addEdge(g, f);
//        graph.addEdge(h, i);
//        graph.addEdge(g, i);

//        Square
//        graph.addEdge(a, b);
//        graph.addEdge(b, c);
//        graph.addEdge(a, d);
//        graph.addEdge(d, e);
//        graph.addEdge(e, f);
//        graph.addEdge(b, e);
//        graph.addEdge(f, c);
//        graph.addEdge(d, g);
//        graph.addEdge(g, h);
//        graph.addEdge(h, e);
//        graph.addEdge(h, i);
//        graph.addEdge(i, f);


//        Set<String> dfs = app.dfs(graph, "A");
//        Set<String> bfs = app.bfs(graph, "A");
//        List<String> path = app.path(graph, "A", "F");
//
        Vertex a = graph.getVertex(new Vertex("1:1"));
        Vertex f = graph.getVertex(new Vertex("29:29"));
        graph.removeVertex(graph.getVertex(new Vertex("3:3")));

        List<Vertex> path = app.path(graph, a, f);
        System.out.println(graph.printGraph());
//        System.out.println("DFS:  " + dfs);
//        System.out.println("BFS:  " + bfs);
        System.out.println("Path: " + path);
    }

  /*  public Set<String> dfs(Graph graph, String root) {
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
    }*/

   /* public Set<String> bfs(Graph graph, String root) {
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
    }*/

    public List<Vertex> path(Graph graph, Vertex src, Vertex des) {
//        return getAnyPath(graph, src, des, new LinkedHashSet<>());
//        return getShorterPath(graph, src, des, new LinkedHashSet<>());

        setCost(graph, src, des);
        List<Vertex> shortestPath = getShortestPath(graph, src, des, 0, des.getLowestCost());
        return shortestPath;
    }

    private void setCost(Graph graph, Vertex src, Vertex des) {
        src.setLowestCost(0);
        System.out.println("SRC LOWEST COST : " + src.getLowestCost());
        setPathCost(graph, src, des, 0);
        System.out.println("DES LOWEST COST : " + des.getLowestCost());
    }

   /* public List<String> getAnyPath(Graph graph, String src, String des, Set<String> visited) {
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
    }*/

    public List<Vertex> getShorterPath(Graph graph, Vertex src, Vertex des, Set<Vertex> visited) {
        if (src.equals(des)) return new ArrayList<>(Collections.singletonList(src));
        List<List<Vertex>> path = new ArrayList<>();
        visited.add(src);
        for (Vertex v : graph.getAdjVertices(src)) {
            if (!visited.contains(v)) {
                List<Vertex> returned = getShorterPath(graph, v, des, visited);
                if (!returned.isEmpty()) {
                    returned.add(0, src);
                    path.add(returned);
                }
            }
        }
        if (path.isEmpty()) return new ArrayList<>();
        return path.stream().min(Comparator.comparingInt(List::size)).get();
    }

    //tried to implement Dijkstra cost approach
    public void setPathCost(Graph graph, Vertex src, Vertex des, int costUntilHere) {
        if (src.equals(des)) return;

        costUntilHere++;
        Queue<Vertex> queue = new LinkedList<>();
        for (Vertex v : graph.getAdjVertices(src)) {
            if (v.getLowestCost() == -1 || v.getLowestCost() > costUntilHere) {
                System.out.println("COST of " + v.getLabel() + "("+v.getLowestCost()+") was set to " + costUntilHere);
                v.setLowestCost(costUntilHere);
                queue.add(v);
            }
        }

        Vertex vertex = queue.poll();
        while (vertex != null) {
            setPathCost(graph, vertex, des, costUntilHere);
            vertex = queue.poll();
        }
    }


    public List<Vertex> getShortestPath(Graph graph, Vertex src, Vertex des, int costUntilHere, int optimalCost) {
        if (costUntilHere > optimalCost) return new ArrayList<>();
        if (src.equals(des)) return new ArrayList<>(Arrays.asList(src));

        List<Vertex> adjacents = new ArrayList<>();
        for (Vertex v : graph.getAdjVertices(src)) {
            adjacents.add(v);
        }
        costUntilHere++;
        adjacents.sort(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o2.getLowestCost()-o1.getLowestCost() ;
            }
        });
        List<List<Vertex>> possiblePaths = new ArrayList<>();

//        System.out.println("HURRRAYYAYYAYAYYA");

        for(Vertex vertex : adjacents){
            List<Vertex> path = getShortestPath(graph, vertex, des, costUntilHere, optimalCost);
            if (!path.isEmpty()) {
                path.add(0, src);
                possiblePaths.add(path);
                break;
            }
        }
        Optional<List<Vertex>> min = possiblePaths.stream().min(Comparator.comparingInt(List::size));
        if(min.isPresent()) return min.get();
        return new ArrayList<>();
    }
}
