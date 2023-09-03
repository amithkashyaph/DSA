package problems.graphs;

import java.util.ArrayList;

public class DFS {

    public static void dfs(int src, ArrayList<ArrayList<Integer>> adjacencyList, ArrayList<Integer> nodes, boolean[] visited) {
        visited[src] = true;
        nodes.add(src);

        for(Integer i : adjacencyList.get(src)) {
            if(!visited[i]) {
                dfs(i, adjacencyList, nodes, visited);
            }
        }
    }

    public static ArrayList<Integer> dfsUtil(ArrayList<ArrayList<Integer>> adjacencyList, int n) {
        boolean[] visited = new boolean[n];
        ArrayList<Integer> nodes = new ArrayList<>();
        dfs(0, adjacencyList, nodes, visited);

        return nodes;

    }
}
