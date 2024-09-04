import java.util.*;

public class Main {
    public static class Edge {
        int src;
        int neighbour;
        int weight; // needed only for weighted graphs

        Edge(int src, int neighbour, int weight) {
            this.src = src;
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }

    // Function to print the graph
    public static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + "--> ");
            for (Edge edge : graph[i]) {
                System.out.print("(" + edge.src + " -> " + edge.neighbour + " @ " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Function to print all paths from src to dest
    public static void printingpaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String pathtillnow) {
        if (src == dest) {
            System.out.println(pathtillnow);
            return;
        }

        visited[src] = true;
        for (Edge edge : graph[src]) {
            int newsrc = edge.neighbour;
            if (!visited[newsrc]) {
                printingpaths(graph, newsrc, dest, visited, pathtillnow + newsrc);
            }
        }
        visited[src] = false;
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2, 10));
        graph[1].add(new Edge(1, 2, 10));
        graph[2].add(new Edge(2, 0, 10));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, 10));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 10));
        graph[3].add(new Edge(3, 5, 10));
        graph[4].add(new Edge(4, 3, 10));
        graph[4].add(new Edge(4, 5, 10));
        graph[5].add(new Edge(5, 3, 10));
        graph[5].add(new Edge(5, 4, 10));
        graph[5].add(new Edge(5, 6, 10));
        graph[6].add(new Edge(6, 5, 10));

        // Print the graph structure
        printGraph(graph);

        boolean[] visited1 = new boolean[vertices];
        // Print all paths from node 0 to node 6
        printingpaths(graph, 0, 6, visited1, 0 + "");
    }
}
