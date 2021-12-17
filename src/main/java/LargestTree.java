import java.util.LinkedList;
import java.util.Vector;
import java.util.*;
public class LargestTree {
    public static void addEdge(LinkedList<Integer> adj[], int u, int v) {
        //TO-DO:
        adj[u].add(v);
        adj[v].add(u);

    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited) {
        visited.add(u, true);

        int size = 1;

//        for (int i : adj.get(u))
        Iterator<Integer> iterator = adj[u].listIterator();
        while (iterator.hasNext()) {
            int tempU = iterator.next();
            if (!visited.get(tempU))
                size += DFS(tempU, adj, visited);
        }
        return size;

    }

    public int largestTree(LinkedList<Integer> adj[], int V) {
        //TO-DO:
        Vector<Boolean> visited = new Vector<>();
        for(int i = 0; i < V; i++)
        {
            visited.add(false);
        }
        int size = 0;

        for (int i = 0; i < V; i++)
        {
            if (visited.get(i) == false)
            {
                size = Math.max(size,DFS(i, adj, visited));
            }
        }
        return size;
    }
}

