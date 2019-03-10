package lesson7;

import java.util.Objects;

public class Vertex {
    private final String label;
    private boolean wasVisited;

    public Vertex(String label) {
        this.label = label;
        this.wasVisited = false;
    }

    public String getLabel() {
        return label;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public void markAsVisited() {
        this.wasVisited = true;
    }

    public void resetState() {
        wasVisited = false;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return label.equals(vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
