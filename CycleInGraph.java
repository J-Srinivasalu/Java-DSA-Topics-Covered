import java.util.*;
public class CycleInGraph {
    public static void main(String[] args) {
        int[][] links = {{0,3},{1,2},{1,3},{3,4},{5,6},{2,0}};
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
        System.out.println(hasCycle(graph, V, vis));
        System.out.println(hasCycleDirected(graph, V, vis));
    }

    static boolean hasCycle(ArrayList<ArrayList<Integer>> graph, int V, boolean[] vis){
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(graph, vis, i, i)) return true;
            }
        }
        return false;
    }
    static boolean hasCycleDirected(ArrayList<ArrayList<Integer>> graph, int V, boolean[] vis){
        for(int i=0;i<V;i++){
            boolean[] recStack = new boolean[V];
            if(!vis[i]){
                if(dfs(graph, vis, i, recStack)) return true;
            }
        }
        return false;
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis, int v, int p){
        vis[v] = true;
        boolean hasCycle = false;
        for(int i : graph.get(v)){
            if(!vis[i]){
                hasCycle |= dfs(graph, vis, i, v);
            }
            else if(i != p) return true;
        }

        return hasCycle;
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> graph,boolean[] vis, int v, boolean[] recStack){
        vis[v] = true;
        boolean hasCycle = false;
        recStack[v] = true;
        for(int i : graph.get(v)){
            if(!vis[i]){
                hasCycle |= dfs(graph, vis, i, v);
            }
            else if(recStack[i]) return true;
        }
        recStack[v] = false;
        return hasCycle;
    }

}
