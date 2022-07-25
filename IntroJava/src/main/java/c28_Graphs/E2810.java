package c28_Graphs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E2810 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        File file = new File(input.nextLine());
        System.out.println("Enter the two vertices (integer indexes): ");
        int start = input.nextInt();
        int end = input.nextInt();

        try {
            Graph<Integer> graph = readGraph(file);
            UnweightedGraph<Integer>.SearchTree tree = graph.dfs(end);
            System.out.println("The number of vertices is " + graph.getSize());
            graph.printEdges();
            System.out.print("The path ");
            List<Integer> path = tree.getPath(start);
            path.forEach(e -> System.out.print(e + " "));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static Graph<Integer> readGraph(File file) throws IOException {
        try (Scanner in = new Scanner(file)) {
            int numberOfVertices = Integer.parseInt(in.nextLine());
            List<Edge> edges = new ArrayList<>();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] numbers = line.split("[\\s+]");
                int u = Integer.parseInt(numbers[0]);
                for (int i = 1; i < numbers.length; i++)
                    edges.add(new Edge(u, Integer.parseInt(numbers[i])));
            }
            return new UnweightedGraph<>(edges, numberOfVertices);
        }
    }
}
