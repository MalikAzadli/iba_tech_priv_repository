package _practice.algorithms.graph;

import java.util.Objects;

public class Vertex {
    private String label;
    private Integer lowestCost = -1;

    public Vertex(String label) {
        this.label = label;
    }

    public void setLowestCost(int lowestCost) {
        this.lowestCost = lowestCost;
    }

    public Integer getLowestCost() {
        return lowestCost;
    }

    public String getLabel() {
        return label;
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

    @Override
    public String toString() {
        return label;
    }
}
