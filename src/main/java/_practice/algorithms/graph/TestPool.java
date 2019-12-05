package _practice.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPool {
    public static void main(String[] args) {
        App app = new App();

        Graph graph = GraphOp.create(4, 4);
        ArrayList<Vertex> vertices = new ArrayList<>(Arrays.asList(new Vertex("2:2"), new Vertex("3:1")));
        GraphOp.removeVertices(vertices, graph);

//        Graph graph = new Graph();
//        graph.addVertex(new Vertex("1:1"));
//        graph.addVertex(new Vertex("1:2"));
//        graph.addVertex(new Vertex("1:3"));
//        graph.addVertex(new Vertex("2:1"));
//        graph.addVertex(new Vertex("2:2"));
//        graph.addVertex(new Vertex("2:3"));
//        graph.addVertex(new Vertex("3:1"));
//        graph.addVertex(new Vertex("3:2"));
//        graph.addVertex(new Vertex("3:3"));

        Vertex g = graph.getVertex(new Vertex("1:1"));
        Vertex c = graph.getVertex(new Vertex("3:3"));

        List<Vertex> path = app.path(graph, g, c);
        System.out.println(graph.printGraph());
        System.out.println(path);
    }
}
