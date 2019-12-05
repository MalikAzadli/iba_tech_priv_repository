package _practice.algorithms.graph;


import java.util.List;
import java.util.stream.IntStream;

public class GraphOp {

    public static Graph create(int height, int width) {
        Graph graph = new Graph();

        IntStream.range(1, height).forEach(i -> {
            IntStream.range(1, width).forEach(j -> {
                Vertex vertex = new Vertex(String.format("%d:%d", j, i));
                graph.addVertex(vertex);
            });
        });

        IntStream.range(1, height).forEach(i -> {
            IntStream.range(1, width).forEach(j -> {
                Vertex vertex1 = graph.getVertex(new Vertex(String.format("%d:%d", j, i)));
                if (j == width - 1 && i == height - 1) {

                } else if (i == height - 1) {
                    Vertex vertex2 = graph.getVertex(new Vertex(String.format("%d:%d", j + 1, i)));
                    graph.addEdge(vertex1, vertex2);
                } else if (j == width - 1) {
                    Vertex vertex2 = graph.getVertex(new Vertex(String.format("%d:%d", j, i + 1)));
                    graph.addEdge(vertex1, vertex2);
                } else {
                    Vertex vertex2 = graph.getVertex(new Vertex(String.format("%d:%d", j, i + 1)));
                    Vertex vertex3 = graph.getVertex(new Vertex(String.format("%d:%d", j + 1, i)));
                    graph.addEdge(vertex1, vertex2);
                    graph.addEdge(vertex1, vertex3);
                }
            });
        });

        return graph;
    }

    public static void refresh(Graph graph) {
        graph = create(14, 14);
    }

    public static void removeVertices(List<Vertex> vertexList, Graph graph) {
        vertexList.forEach(p -> {
            Vertex vertex = graph.getVertex(p);
            graph.removeVertex(vertex);
        });
    }
}
