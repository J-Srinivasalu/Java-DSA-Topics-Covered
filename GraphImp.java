import java.util.*;

public class GraphImp {
    public static void main(String[] args) {
        int[][] links = {{0,1},{1,2},{2,3},{3,4},{2,0},{2,4}};
        int V = 5;
        int E = links.length;
        buildGraph(links, V, E);
    }

    static void buildGraph(int[][] links, int V, int E){
        int[][] graph1 = new int[V][V];  // Adjacency matrix
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>(); //adjacency list
        for(int i=0;i<V;i++){
            graph2.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u = links[i][0];
            int v = links[i][1];
            graph1[u][v] =  1;
            graph1[v][u] =  1;
            graph2.get(u).add(v);
            graph2.get(v).add(u);
        }

        System.out.println(Arrays.deepToString(graph1));
        for(ArrayList<Integer> l: graph2){
            System.out.println(l);
        }

    }

}
