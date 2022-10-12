import java.util.*;
public class DijktrasAlgo {
    public static void main(String[] args) {
        int[][] links = {
            {0,1,4},
            {0,7,8},
            {1,2,8},
            {1,7,11},
            {2,3,7},
            {2,8,2},
            {2,5,4},
            {3,4,9},
            {3,5,14},
            {4,5,10},
            {5,6,2},
            {6,8,6},
            {6,7,1},
            {7,8,7}
        };
        int V = 9;
        int E = links.length;
        ArrayList<ArrayList<ArrayList<Integer>>> graph = new ArrayList<>(); //adjacency list
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u = links[i][0];
            int v = links[i][1];
            int wt = links[i][2];
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(u);
            list1.add(wt);
            ArrayList<Integer> list2 = new ArrayList<>();
            list2.add(v);
            list2.add(wt);
            graph.get(u).add(list2);
            graph.get(v).add(list1);
        }
        dijktrasAlgo(graph, 0, V);
    }
    static void dijktrasAlgo(ArrayList<ArrayList<ArrayList<Integer>>> graph,int S, int V){
        int[] ans = new int[V];
        boolean[] vis = new boolean[V];
        Arrays.fill(ans, (int)10e7);
        ans[S] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(S, 0));
        while(!q.isEmpty()){
            Pair curr = q.remove();
            int u = curr.v;
            if(!vis[u]){
                vis[u] = true;
                for(ArrayList<Integer> node: graph.get(u)){
                    int v = node.get(0);
                    int wt = node.get(1);
                    if(ans[v] > ans[u]+wt){
                        ans[v] = ans[u]+wt;
                        q.add(new Pair(v, ans[v]));
                    }
                    
                }
            }
        }
        System.out.println(Arrays.toString(ans));
    }

    static class Pair implements Comparable<Pair>{
        int v;
        int wt;
        Pair(int v, int wt){
            this.v = v;
            this.wt = wt;
        }
        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }
}
