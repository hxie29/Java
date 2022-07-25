package c28_Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class UnweightedGraphNonrecursive<V> extends UnweightedGraph<V>{

    public UnweightedGraphNonrecursive(){
        super();
    }
    public UnweightedGraphNonrecursive(V[] vertices, int[][] edges) {
        super(vertices,edges);
    }
    @Override
    public UnweightedGraph<V>.SearchTree dfs(int v) {
        ArrayList<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        Arrays.fill(parent, -1);
        boolean[] isVisited = new boolean[vertices.size()];

        //use a stack to store have not visited parent and it's children
        Stack<Integer> stack = new Stack<>();
        //push the argument in the stack
        stack.push(v);
        //operation finishes when stack is empty
        while (!stack.isEmpty()) {
            // pop out the top of the stack
            int current = stack.pop();
            //visit the element
            if (!isVisited[current]) {
                searchOrder.add(current);
                isVisited[current] = true;
            }
            //for all its neighbors, if not visited, push to the stack
            // meaning one neighbor's neighbors will be visited before other neighbors, depth first)
            for (Edge e: neighbors.get(current)) {
                if (!isVisited[e.v]){
                    parent[e.v] = current;
                    stack.push(e.v);
                }
            }
        }
        return new SearchTree(v, parent, searchOrder);
    }
}
