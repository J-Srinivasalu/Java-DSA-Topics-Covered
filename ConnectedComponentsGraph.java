import java.util.*;
public class ConnectedComponentsGraph {
    public static void main(String[] args) {
        int[][] links = {{0,3},{1,2},{1,3},{3,4},{5,6}};
        int V = 8;
        int E = links.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //adjacency list
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u = links[i][0];
            int v = links[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        System.out.println(connectedComponents(graph, V, vis));
    }

    static int connectedComponents(ArrayList<ArrayList<Integer>> graph, int V, boolean[] vis){
        int count = 0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(graph, vis, i);
            }
        }
        return count;
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis, int v){
        
        vis[v] = true;

        for(int i : graph.get(v)){
            if(!vis[i]){
                dfs(graph, vis, i);
            }
        }
    }
}
