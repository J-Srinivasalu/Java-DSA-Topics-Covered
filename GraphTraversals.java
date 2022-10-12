import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversals {
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
        
        dfsTraversal(graph, vis, V);
        System.out.println();
        vis = new boolean[V];
        bfsTraversal(graph, vis, V);

    }

    static void dfsTraversal(ArrayList<ArrayList<Integer>> graph,boolean[] vis, int V){
        for(int i=0;i<V;i++){
            if(!vis[i])
                dfs(graph, vis, i);
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis, int v){
        
        vis[v] = true;
        System.out.print(v+" ");

        for(int i : graph.get(v)){
            if(!vis[i]){
                dfs(graph, vis, i);
            }
        }
    }

    static void bfsTraversal(ArrayList<ArrayList<Integer>> graph,boolean[] vis, int V){
        for(int i=0;i<V;i++){
            if(!vis[i])
                bfs(graph, vis, i);
        }
    }
    static void bfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis, int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        vis[v] = true;
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i:graph.get(curr)){
                if(!vis[i]){
                    q.add(i);
                    vis[i] = true;
                } 
            }
        }
    }

}
