import java.util.*;

public class GraphSorting {
    public static void main(String[] args) {
        int[][] links = {{0,1},{1,2},{2,3},{2,4},{4,5},{6,1}};
        int V = 7;
        int E = links.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //adjacency list
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u = links[i][0];
            int v = links[i][1];
            graph.get(u).add(v);
        }
        printTopologicalSort(graph, V);
        System.out.println();
        khansAlgo(graph, V);
    }

    static void printTopologicalSort(ArrayList<ArrayList<Integer>> graph, int V){
        boolean[] vis = new boolean[V];
        Stack<Integer> ans = new Stack<>();
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                topologicalSort(graph, i, vis, ans);
            }
        }
        while(!ans.isEmpty()){
            System.out.print(ans.pop()+" ");
        }
    }


    static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int v, boolean[] vis, Stack<Integer> ans){
        vis[v] = true;

        for(int i: graph.get(v)){
            if(!vis[i]){
                topologicalSort(graph, i, vis, ans);
            }
        }

        ans.push(v);
    }

    static void khansAlgo(ArrayList<ArrayList<Integer>> graph, int V){
        int[] indegree = new int[V];
        for(ArrayList<Integer> l: graph){
            for(int i: l){
                indegree[i]++;
            }
        }
        bfs(graph, V, indegree);
    }

    private static void bfs(ArrayList<ArrayList<Integer>> graph, int V, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i:graph.get(curr)){
                if(--indegree[i] == 0){
                    q.add(i);
                }
            }
        }
    }
}
