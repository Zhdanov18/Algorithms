package lesson7;

import java.util.*;
import java.util.stream.Stream;

public class Graph {
    private final List<Vertex> vertexList = new ArrayList<>();
    private boolean[][] adjMat;
    private  int size;

    public Graph(int maxVertexCount) {
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public void addEdge(String start, String end) {
        if (!find(start) || !find(end)) {
            throw new IllegalArgumentException(String.format("Invalid label for vertex: [%s, %s]", start, end));
        }
        int startIndex = indexOf(start);
        int endIndex = indexOf(end);
        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;
    }

    public void addEdges(String start, String... others) {
        if (!areAllExist(start, others)) {
            throw new IllegalArgumentException("Invalid params");
        }

        int startIndex = indexOf(start);
        for (int i = 0; i < others.length; i++) {
            int finishIndex = indexOf(others[i]);
            adjMat[startIndex][finishIndex] = true;
            adjMat[finishIndex][startIndex] = true;
        }
    }

    private boolean areAllExist(String... labels) {
        return Stream.of(labels).allMatch(this::find);
    }

    private boolean areAllExist(String start, String... labels) {
        String[] allLabels = Arrays.copyOf(labels, labels.length + 1);
        allLabels[allLabels.length - 1] = start;
        return areAllExist(allLabels);
    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    private boolean find(String label) {
        return indexOf(label) != -1;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.println(" -> " + vertexList.get(i));
                }
            }
            System.out.println();
        }
    }

    public void dfs(String label) {
        if (!find(label)) {
            throw new IllegalArgumentException("Invalid label: " + label);
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(indexOf(label));
        visitVertex(stack, vertex);
        while (!stack.empty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex == null) {
                stack.pop();
                continue;
            }
            visitVertex(stack, vertex);
        }
    }

    public void bfs(String label) {
        if ( !find(label) ) {
            throw new IllegalArgumentException("Invalid startLabel: " + label);
        }
        resetState();
        bfs(null, true, label, null);
    }

    public void showPath(String start, String end) {
        if ( !find(start) || !find(end)) {
            throw new IllegalArgumentException("Invalid params");
        }
        resetState();
        Stack<String> path = new Stack<>();
        bfs(path, false, start, end);
        while (!path.isEmpty())
            System.out.print(path.pop() + " ");
        System.out.println();
    }

    private String bfs(Stack<String> path, boolean needToDisplay, String start, String end) {
        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(indexOf(start));
        visitVertex(queue, vertex, needToDisplay);
        while ( !queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex == null) {
                queue.remove();
                continue;
            }
            visitVertex(queue, vertex, needToDisplay);

            if (path != null && vertex.getLabel().equals(end)) {
                path.push(vertex.getLabel());
                if (queue.peek().getLabel().equals(start)) {
                    return start;
                }
                resetState();
                String result = bfs(path, needToDisplay, start, queue.peek().getLabel());
                if (result != null)
                    path.push(result);
                break;
            }
        }
        return null;
    }

    private void resetState() {
        for (Vertex v: vertexList) v.resetState();
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int vertexIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < size; i++) {
            if (adjMat[vertexIndex][i] && !vertexList.get(i).isWasVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }
    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        displayVertex(vertex);
        stack.push(vertex);
        vertex.markAsVisited();
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex, boolean needToDisplay) {
        if (needToDisplay) displayVertex(vertex);
        stack.add(vertex);
        vertex.markAsVisited();
    }

    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }
}
