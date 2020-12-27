
import java.util.HashSet;
import java.util.Set;
/**
 * Graph
 */
public class Graph {
    private Set<Integer>[] adjs;
    private final int numOfVertices;
    private int numOfEdges;
    
    public Graph(int numOfVertices){
        this.numOfVertices = numOfVertices;
        this.numOfEdges = 0;
        this.adjs = (HashSet<Integer>[]) new HashSet[numOfVertices];
        for (int i = 0; i < numOfVertices; i++){
            adjs[i] = new HashSet<Integer>();
        }
    }

    public int getNumOfVertices(){
        return numOfVertices;
    }
    public int getNumOfEdges(){
        return numOfEdges;
    }
    
    public void addEdge(int v, int w){
        adjs[v].add(w);
        adjs[w].add(v);
        numOfEdges++;
    }
    
    public Iterable<Integer> getAdj(int v){
        return adjs[v];
    }

    public void printGraph(){
        for (int i = 0; i < numOfVertices; i++){
            System.out.print(i + ": " );
            Object[] adjToArray = adjs[i].toArray();
            for (int j = 0; j < adjToArray.length; j++){
                System.out.print(adjToArray[j] + ", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Graph G = new Graph(5);
        G.addEdge(1, 2);
        G.addEdge(2, 4);
        G.addEdge(0, 2);
        System.out.println(G.getAdj(2));
        G.printGraph();
    }
    
}