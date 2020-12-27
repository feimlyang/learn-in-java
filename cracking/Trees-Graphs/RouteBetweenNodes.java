import java.util.LinkedList;

/**
 * RouteBetweenNodes: Given a directed graph, design an algorithm to find out whether there is a
route between two nodes.
 */

public class RouteBetweenNodes {

    public static boolean searchRouteBFS(Graph G, int start, int end){
        boolean[] isVisited = new boolean[G.getNumOfVertices()];
        LinkedList<Integer> queue = new LinkedList<>();
        if (start == end) return true;
        isVisited[start] = true;
        queue.add(start);
        int v;
        while(!queue.isEmpty()){
            v = queue.removeFirst();
            if (v == end) return true;
            G.getAdj(v).forEach(i -> {
                if (!isVisited[i]){
                    queue.add(i);
                    isVisited[i] = true;
                }
            });
        }
        return false;
    }


    public static boolean searchRouteDFS(Graph G, int start, int end){
        boolean[] isVisited = new boolean[G.getNumOfVertices()];
        return dfs(G, start, end, isVisited);
    }
    private static boolean dfs(Graph G, int v, int end, boolean[] isVisited){
        isVisited[v] = true;
        if (v == end) return true;
        for (int i : G.getAdj(v)){
            if (!isVisited[i]){
                boolean isFound = false;
                isFound = dfs(G, i, end, isVisited);
                if (isFound) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Graph G = new Graph(10);
        G.addEdge(1, 2);
        G.addEdge(2, 4);
        G.addEdge(0, 2);
        G.addEdge(4, 1);
        G.addEdge(3, 7);
        G.addEdge(7, 8);
        G.addEdge(7, 2);
        G.printGraph();
        System.out.println(searchRouteBFS(G, 1, 4) == true);
        System.out.println(searchRouteBFS(G, 0, 3) == true);
        System.out.println(searchRouteBFS(G, 0, 0) == true);
        System.out.println(searchRouteBFS(G, 3, 2) == true);
        System.out.println(searchRouteBFS(G, 3, 5) == false);
        System.out.println(searchRouteBFS(G, 6, 5) == false);

        System.out.println(searchRouteDFS(G, 1, 4) == true);
        System.out.println(searchRouteDFS(G, 0, 3) == true);
        System.out.println(searchRouteDFS(G, 0, 0) == true);
        System.out.println(searchRouteDFS(G, 3, 2) == true);
        System.out.println(searchRouteDFS(G, 3, 5) == false);
        System.out.println(searchRouteDFS(G, 6, 5) == false);
    }

    
}